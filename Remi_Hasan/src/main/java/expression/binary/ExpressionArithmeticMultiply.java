package expression.binary;

import astvisitor.BaseASTVisitor;
import astvisitor.NumValue;
import expression.Expression;
import expression.ExpressionBinary;

public class ExpressionArithmeticMultiply extends ExpressionBinary<Number> {

    protected ExpressionArithmeticMultiply(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public NumValue accept(BaseASTVisitor visitor) {
        return visitor.visit(this);
    }
}
