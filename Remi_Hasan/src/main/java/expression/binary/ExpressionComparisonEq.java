package expression.binary;

import expression.Expression;
import expression.constant.ExpressionVariable;

public class ExpressionComparisonEq extends ExpressionComparison {

    public ExpressionComparisonEq(Expression left, Expression right) {
        super(left, right, "==");
    }

    @Override
    public ExpressionVariable evaluate() {
        ExpressionVariable leftEvaluated = this.left.evaluate();
        ExpressionVariable rightEvaluated = this.right.evaluate();
        return leftEvaluated.equals(rightEvaluated);
    }
}