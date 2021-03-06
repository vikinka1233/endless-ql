package com.chariotit.uva.sc.qdsl.ast.ql.node;

import com.chariotit.uva.sc.qdsl.ast.common.SourceFilePosition;
import com.chariotit.uva.sc.qdsl.ast.ql.visitor.NodeVisitor;

public class TypeExpression extends AstNode {

    private TypeNode typeNode;
    private Expression expression;

    public TypeExpression(TypeNode typeNode, SourceFilePosition filePosition) {
        super(filePosition);
        this.typeNode = typeNode;
    }


    public TypeNode getTypeNode() {
        return typeNode;
    }

    public void setTypeNode(TypeNode typeNode) {
        this.typeNode = typeNode;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void acceptVisitor(NodeVisitor visitor) {
        typeNode.acceptVisitor(visitor);

        if (expression != null) {
            expression.acceptVisitor(visitor);
        }

        visitor.visitTypeExpression(this);
    }
}
