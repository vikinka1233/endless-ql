package qlviz.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import qlviz.QLBaseVisitor;
import qlviz.gui.renderer.javafx.JavafxFormRenderer;
import qlviz.gui.renderer.javafx.JavafxQuestionBlockRenderer;
import qlviz.gui.renderer.javafx.JavafxQuestionRenderer;
import qlviz.gui.viewModel.*;
import qlviz.interpreter.*;
import qlviz.interpreter.linker.QuestionLinkerImpl;
import qlviz.model.booleanExpressions.BooleanExpression;
import qlviz.model.Form;
import qlviz.model.QuestionBlock;

public class QLForm extends Application {
	private JavafxFormRenderer renderer;
	private Form model;

	// Example to add checkboxes to the form

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
		this.renderer = new JavafxFormRenderer(stage, vbox -> new JavafxQuestionBlockRenderer(vbox, JavafxQuestionRenderer::new));

		QLBaseVisitor<BooleanExpression> booleanExpressionVisitor =
				new BooleanExpressionParser(
					new NumericExpressionParser(
							new BinaryNumericOperatorVisitor()
					),
					new BinaryBooleanOperatorVisitor(),
					new NumericComparisonOperatorVisitor());
		QLBaseVisitor<QuestionBlock> questionBlockVisitor =
				new QuestionBlockVisitor(
						new QuestionVisitor(
								new QuestionTypeVisitor(),
								new NumericExpressionParser(new BinaryNumericOperatorVisitor())
						),
						pQuestionBlockVisitor -> new ConditionalBlockVisitor(booleanExpressionVisitor, pQuestionBlockVisitor)
				);
		FormVisitor visitor = new FormVisitor(questionBlockVisitor);
		this.model = new ModelBuilder(visitor, new QuestionLinkerImpl(new TypedQuestionWalker()))
				.createFormFromMarkup(this.getParameters().getRaw().get(0));

		QuestionViewModelFactoryImpl questionViewModelFactory = new QuestionViewModelFactoryImpl();
		QuestionBlockViewModelFactory questionBlockViewModelFactory = new QuestionBlockViewModelFactory(questionViewModelFactory::create);
		FormViewModel viewModel = new FormViewModelImpl(model, renderer, questionBlockViewModelFactory::create);
		this.renderer.render(viewModel);
	}

}