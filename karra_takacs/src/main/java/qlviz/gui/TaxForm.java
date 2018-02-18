package qlviz.gui;

import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.lang3.StringUtils;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import qlviz.ParseBuilder;
import qlviz.QLBaseVisitor;
import qlviz.interpreter.ConditionalBlockVisitor;
import qlviz.interpreter.FormVisitor;
import qlviz.interpreter.QuestionBlockVisitor;
import qlviz.interpreter.QuestionVisitor;
import qlviz.interpreter.TreeToFormConverter;
import qlviz.model.Form;
import qlviz.model.Question;
import qlviz.model.QuestionBlock;
import qlviz.model.QuestionType;

public class TaxForm extends Application {

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

		VBox taxFormFields = new VBox();
		CheckBox buy = new CheckBox("Buy");
		CheckBox sell = new CheckBox("Sell");
		CheckBox loanType = new CheckBox("Loan Type");
		ParseBuilder parseBuilder = new ParseBuilder();
		ParseTree parseTree = parseBuilder.generateParseTree();
		QuestionVisitor questionVisitor = new QuestionVisitor(new QLBaseVisitor<QuestionType>());
		ConditionalBlockVisitor conditionalBlockVisitor = new ConditionalBlockVisitor();
		QuestionBlockVisitor questionBlockVisitor = new QuestionBlockVisitor(questionVisitor, conditionalBlockVisitor);
		QuestionBlock questionBlock = questionBlockVisitor.visit(parseTree);
		for (Question question : questionBlock.getQuestions()) {
			System.out.println(question.getName());
		}

		buy.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				System.out.println(buy.isSelected());
			}
		});

		sell.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				System.out.println(sell.isSelected());
			}
		});
		loanType.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				System.out.println(loanType.isSelected());
			}
		});
		taxFormFields.getChildren().addAll(buy, sell, loanType);
		Scene scene = new Scene(taxFormFields, 550, 250);
		stage.setTitle("Tax form");
		stage.setScene(scene);
		stage.show();
	}

}