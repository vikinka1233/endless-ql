package qlviz.model;

import java.math.BigDecimal;

public abstract class NumericQuestion extends Question {

    protected BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public NumericQuestion(String name, String text, QuestionType type) {
        super(name, text, type);
    }
}