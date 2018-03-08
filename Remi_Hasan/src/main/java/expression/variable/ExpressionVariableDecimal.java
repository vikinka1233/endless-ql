package expression.variable;

import astvisitor.IASTVisitor;
import expression.ExpressionVariable;
import expression.ReturnType;

public class ExpressionVariableDecimal extends ExpressionVariable<Double> {

    public ExpressionVariableDecimal(Double value) {
        super(value);
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
