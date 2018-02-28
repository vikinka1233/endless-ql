package qlviz.model.question;

import qlviz.interpreter.linker.BooleanExpressionVisitor;
import qlviz.model.booleanExpressions.BooleanExpression;

public class BooleanQuestionReference implements BooleanExpression {

    private BooleanQuestion question;
    private final String questionName;


    public BooleanQuestionReference(String questionName) {
        this.questionName = questionName;
    }

    @Override
    public boolean evaluate() {
        if (this.question != null) {
            return this.question.getValue();
        }
        else
        {
            return false;
        }
    }

    @Override
    public void accept(BooleanExpressionVisitor visitor) {
        visitor.visit(this);
    }

    public BooleanQuestion getQuestion() {
        return question;
    }

    public void setQuestion(BooleanQuestion question) {
        this.question = question;
    }

    public String getQuestionName() {
        return questionName;
    }
}


