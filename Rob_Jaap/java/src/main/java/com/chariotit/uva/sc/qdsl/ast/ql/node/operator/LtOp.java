package com.chariotit.uva.sc.qdsl.ast.ql.node.operator;

import com.chariotit.uva.sc.qdsl.ast.ql.symboltable.SymbolTable;
import com.chariotit.uva.sc.qdsl.ast.ql.type.ExpressionType;
import com.chariotit.uva.sc.qdsl.ast.ql.type.ExpressionValue;
import com.chariotit.uva.sc.qdsl.ast.common.SourceFilePosition;
import com.chariotit.uva.sc.qdsl.ast.ql.type.NumberExpressionValue;
import com.chariotit.uva.sc.qdsl.ast.ql.node.Expression;
import com.chariotit.uva.sc.qdsl.ast.ql.visitor.NodeVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LtOp extends Operator implements BinaryOperator {

    public LtOp(SourceFilePosition filePosition) {
        super(filePosition);
    }

    @Override
    public void acceptVisitor(NodeVisitor visitor) {
        visitor.visitLtOp(this);
    }

    @Override
    public ExpressionValue evaluate(SymbolTable symbolTable, Expression leftExpression, Expression rightExpression) {

        return ((NumberExpressionValue) leftExpression.getExpressionValue())
                .lessThan(
                        (NumberExpressionValue)rightExpression.getExpressionValue());
    }

    @Override
    protected List<ExpressionType> getValidExpressionTypes() {
        return new ArrayList<>(
                Arrays.asList(
                        ExpressionType.MONEY,
                        ExpressionType.INTEGER
                )
        );
    }

    @Override
    public ExpressionType getResultExpressionType(ExpressionType operandExpressionType) {
        return ExpressionType.BOOLEAN;
    }
}
