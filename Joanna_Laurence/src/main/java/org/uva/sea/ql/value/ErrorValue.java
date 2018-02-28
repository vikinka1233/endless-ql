package org.uva.sea.ql.value;

import org.uva.sea.ql.QLValueEvaluator;
import org.uva.sea.ql.parser.NodeType;

public class ErrorValue extends Value {
    private String error;
    private int line;
    private int colomn;

    public ErrorValue(String error, int line, int colomn) {
        this.error = error;
        this.line = line;
        this.colomn = colomn;
    }

    public String getError() {
        return error;
    }

    @Override
    public <T> T accept(QLValueEvaluator<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Value negate() {
        return this;
    }

    @Override
    public Value not() {
        return this;
    }

    @Override
    public Value positive() {
        return this;
    }

    @Override
    public NodeType getType() {
        return NodeType.UNKNOWN;
    }
}
