package qlviz.gui;

import com.google.inject.*;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import qlviz.QLBaseVisitor;
import qlviz.gui.renderer.ErrorRenderer;
import qlviz.gui.renderer.JavafxErrorRenderer;
import qlviz.gui.renderer.QuestionRenderer;
import qlviz.gui.renderer.javafx.*;
import qlviz.gui.renderer.layout.NaiveQuestionLocator;
import qlviz.gui.viewModel.*;
import qlviz.gui.viewModel.booleanExpressions.BooleanExpressionViewModelFactory;
import qlviz.gui.viewModel.booleanExpressions.BooleanExpressionViewModelFactoryImpl;
import qlviz.gui.viewModel.linker.QuestionViewModelCollectorImpl;
import qlviz.gui.viewModel.linker.QuestionViewModelLinker;
import qlviz.gui.viewModel.linker.QuestionViewModelLinkerImpl;
import qlviz.gui.viewModel.numericExpressions.NumericExpressionViewModelFactory;
import qlviz.gui.viewModel.numericExpressions.NumericExpressionViewModelFactoryImpl;
import qlviz.interpreter.*;
import qlviz.interpreter.QuestionVisitor;
import qlviz.interpreter.linker.QuestionLinkerImpl;
import qlviz.model.booleanExpressions.BooleanExpression;
import qlviz.model.Form;
import qlviz.model.QuestionBlock;
import qlviz.model.style.*;
import qlviz.typecheker.AnalysisResult;
import qlviz.typecheker.Severity;
import qlviz.typecheker.StaticChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class QLForm extends Application {
	private JavafxFormRenderer renderer;
	private Form model;
	private FormViewModel viewModel;
	private boolean containsDuplicates = false;


	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) throws Exception {

		Injector injector = Guice.createInjector(
				new QLSParserModule(),
				new ExpressionParserModule(),
				new QLParserModule());
		StyleModelBuilder styleBuilder = injector.getInstance(StyleModelBuilder.class);


		if (this.getParameters().getRaw().size() > 1) {
			Stylesheet stylesheet = styleBuilder.createFromMarkup(this.getParameters().getRaw().get(1));
			WidgetFinder widgetFinder = new ChainedWidgetFinder(List.of(
					new StylesheetWidgetFinder(new NaiveQuestionLocator(stylesheet)),
					new DefaultWidgetProvider()
			));
			JavafxWidgetFactory javafxWidgetFactory = new JavafxWidgetFactory();

			Function<Pane, QuestionRenderer> questionRendererFactory =
					pane -> new StyledJavafxQuestionRenderer(pane, javafxWidgetFactory, widgetFinder);
			this.renderer =
					new StyledJavafxFormRenderer(
							stage,
							questionRendererFactory,
							stylesheet,
							new NaiveQuestionLocator(stylesheet),
							pane -> new StyledJavafxSectionRenderer(questionRendererFactory, pane));
		}
		else {
			this.renderer = new JavafxFormRenderer(stage, JavafxQuestionRenderer::new);
		}

		List<AnalysisResult> staticCheckResults = new ArrayList<>();
		QLBaseVisitor<Form> visitor = injector.getInstance(Key.get(new TypeLiteral<QLBaseVisitor<Form>>(){}));
		ModelBuilder modelBuilder = new ModelBuilder(visitor, new QuestionLinkerImpl(new TypedQuestionWalker()));

		this.model = modelBuilder.createFormFromMarkup(this.getParameters().getRaw().get(0));


		StaticChecker staticChecker = new StaticChecker();
		List<AnalysisResult> duplicateResults = staticChecker.checkForDuplicateLabels(this.model);
		if (duplicateResults.stream().anyMatch(analysisResult -> analysisResult.getSeverity() == Severity.Error)) {
			staticCheckResults = duplicateResults;
		}
		else
		{
			modelBuilder.linkQuestions(this.model);
            staticCheckResults = staticChecker.validate(this.model, containsDuplicates);
		}

		if (staticCheckResults.stream().anyMatch(analysisResult -> analysisResult.getSeverity() == Severity.Error)) {
			ErrorRenderer errorRenderer = new JavafxErrorRenderer(stage);
			errorRenderer.render(staticCheckResults);
		}
		else
		{
            NumericExpressionViewModelFactory numericExpressionViewModelFactory = new NumericExpressionViewModelFactoryImpl();
            BooleanExpressionViewModelFactory booleanExpressionFactory = new BooleanExpressionViewModelFactoryImpl(numericExpressionViewModelFactory);
			ConditionCollector conditionCollector = new CachingConditionCollector(this.model);
            QuestionViewModelFactoryImpl questionViewModelFactory =
                    new QuestionViewModelFactoryImpl(
                    		numericExpressionViewModelFactory::create,
							booleanExpressionFactory::create,
							conditionCollector::getConditions);

            this.viewModel = new FormViewModelImpl(model, questionViewModelFactory::create);

            QuestionViewModelLinker viewModelLinker = new QuestionViewModelLinkerImpl(new QuestionViewModelCollectorImpl());
            viewModelLinker.linkQuestionStubs(this.viewModel);
            this.renderer.render(this.viewModel);
		}
	}

}
