package ql.ast.expressions.literals;

import ql.ast.SourceLocation;
import ql.ast.expressions.Expression;
import ql.ast.visitors.ExpressionVisitor;

public class StringLiteral extends Expression {

    private final String value;

    public StringLiteral(String value, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
