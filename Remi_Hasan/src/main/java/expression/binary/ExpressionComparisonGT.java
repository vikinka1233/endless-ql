package expression.binary;

import expression.Expression;
import expression.constant.ExpressionVariable;

public class ExpressionComparisonGT extends ExpressionComparison {

    public ExpressionComparisonGT(Expression left, Expression right) {
        super(left, right, ">");
    }

    @Override
    public ExpressionVariable evaluate() {
        ExpressionVariable leftEvaluated = this.left.evaluate();
        ExpressionVariable rightEvaluated = this.right.evaluate();
        return leftEvaluated.gt(rightEvaluated);
    }
}