package qlviz.model.question;

import qlviz.model.numericExpressions.NumericExpression;

public class MoneyQuestion extends NumericQuestion {

   public MoneyQuestion(String name, String text, QuestionType type, NumericExpression valueExpression) {
        super(name, text, type, valueExpression);
    }

    @Override
    public <T> T accept(QuestionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public void accept(VoidQuestionVisitor visitor) {
        visitor.visit(this);
    }

}

