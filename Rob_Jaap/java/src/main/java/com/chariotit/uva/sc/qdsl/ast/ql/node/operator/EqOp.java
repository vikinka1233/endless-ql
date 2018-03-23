package com.chariotit.uva.sc.qdsl.ast.ql.node.operator;

import com.chariotit.uva.sc.qdsl.ast.ExpressionValue;
import com.chariotit.uva.sc.qdsl.ast.common.SourceFilePosition;
import com.chariotit.uva.sc.qdsl.ast.ql.node.Expression;
import com.chariotit.uva.sc.qdsl.ast.ql.visitor.NodeVisitor;

public class EqOp extends Operator implements BinaryOperator, BooleanOperator, MoneyOperator,
        IntegerOperator, StringOperator, BooleanResultOperator {

    public EqOp(SourceFilePosition filePosition) {
        super(filePosition);
    }

    @Override
    public void acceptVisitor(NodeVisitor visitor) {
        visitor.visitEqOp(this);
    }

    @Override
    public ExpressionValue evaluate(Expression leftExpression, Expression rightExpression) {
        return leftExpression.getExpressionValue().equalTo(rightExpression.getExpressionValue());
    }
}
