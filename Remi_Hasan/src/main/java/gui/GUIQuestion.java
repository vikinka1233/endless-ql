package gui;

import gui.widgets.*;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ql.analysis.SymbolTable;
import ql.evaluation.ExpressionEvaluator;
import ql.evaluation.value.Value;
import ql.model.Question;

public class GUIQuestion extends VBox {

    GUIQuestion(SymbolTable symbolTable, Question question){
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(symbolTable);

        this.getChildren().add(new Label(question.text));
        switch(question.type){
            case INTEGER:
                IntegerWidget integerWidget = new IntegerWidget(question.name);
                if(question.isComputed()){
                    symbolTable.addListener(question.name, e -> {
                        Value value = expressionEvaluator.visit(symbolTable.getExpression(question.name));
                        System.out.println("set int expr to value: " + value.getIntValue().toString());
                        integerWidget.setExpression(value.getIntValue().toString());
                    });
                } else {
                    integerWidget.textProperty().addListener((ob, oldValue, newValue) -> {
                        symbolTable.setExpression(question.name, integerWidget.getExpression());
                    });
                }

                this.getChildren().add(integerWidget);
                break;
            case STRING:
                StringWidget stringWidget = new StringWidget(question.name);
                if(question.isComputed()) {
                    symbolTable.addListener(question.name, e -> {
                        Value value = expressionEvaluator.visit(symbolTable.getExpression(question.name));
                        stringWidget.setExpression(value.getStringValue());
                    });
                } else {
                    stringWidget.textProperty().addListener((ob, oldValue, newValue) -> {
                        symbolTable.setExpression(question.name, stringWidget.getExpression());
                    });
                }

                this.getChildren().add(stringWidget);
                break;
            case DATE:
                DateWidget dateWidget = new DateWidget(question.name);
                if(question.isComputed()) {
                    symbolTable.addListener(question.name, e -> {
                        Value value = expressionEvaluator.visit(symbolTable.getExpression(question.name));
                        dateWidget.setExpression(value.getDateValue().toString());
                    });
                } else {
                    dateWidget.valueProperty().addListener((ob, oldValue, newValue) -> {
                        symbolTable.setExpression(question.name, dateWidget.getExpression());
                    });
                }

                this.getChildren().add(dateWidget);
                break;
            case DECIMAL:
                DecimalWidget decimalWidget = new DecimalWidget(question.name);

                if(question.isComputed()) {
                    symbolTable.addListener(question.name, e -> {
                        Value value = expressionEvaluator.visit(symbolTable.getExpression(question.name));
                        decimalWidget.setExpression(value.getDecimalValue().toString());
                    });
                } else {
                    decimalWidget.textProperty().addListener((ob, oldValue, newValue) -> {
                        symbolTable.setExpression(question.name, decimalWidget.getExpression());
                    });
                }

                this.getChildren().add(decimalWidget);
                break;
            case MONEY:
                MoneyWidget moneyWidget = new MoneyWidget(question.name);
                if(question.isComputed()) {
                    symbolTable.addListener(question.name, e -> {
                        Value value = expressionEvaluator.visit(symbolTable.getExpression(question.name));
                        moneyWidget.setExpression(value.getMoneyValue().toString());
                    });
                } else {
                    moneyWidget.textProperty().addListener((ob, oldValue, newValue) -> {
                        symbolTable.setExpression(question.name, moneyWidget.getExpression());
                    });
                }

                this.getChildren().add(moneyWidget);
                break;
            case BOOLEAN:
                CheckboxWidget checkboxWidget = new CheckboxWidget(question.name);
                if(question.isComputed()) {
                    symbolTable.addListener(question.name, e -> {
                        Value value = expressionEvaluator.visit(symbolTable.getExpression(question.name));
                        checkboxWidget.setExpression(value.getBooleanValue().toString());
                    });
                } else {
                    checkboxWidget.selectedProperty().addListener((ob, oldValue, newValue) -> {
                        symbolTable.setExpression(question.name, checkboxWidget.getExpression());
                    });
                }

                this.getChildren().add(checkboxWidget);
                break;
            default:
                break;
        }
    }

}
