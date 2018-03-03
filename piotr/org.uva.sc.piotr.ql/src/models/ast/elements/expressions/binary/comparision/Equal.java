package models.ast.elements.expressions.binary.comparision;

import models.ast.elements.expressions.Expression;
import models.ast.elements.expressions.binary.BinaryExpression;

public class Equal extends BinaryExpression {
    public Equal(Expression leftSide, Expression rightSide) {
        super(leftSide, rightSide);
    }
}
