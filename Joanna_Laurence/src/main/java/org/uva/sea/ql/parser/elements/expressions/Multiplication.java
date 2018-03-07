package org.uva.sea.ql.parser.elements.expressions;

import org.antlr.v4.runtime.Token;
import org.uva.sea.ql.parser.nodeTypes.BinaryOperator;
import org.uva.sea.ql.parser.elements.ASTNode;
import org.uva.sea.ql.parser.elements.types.Type;
import org.uva.sea.ql.parser.visitor.IASTVisitor;

public class Multiplication extends BinaryOperator {
    public Multiplication(Token token, ASTNode leftHandSide, ASTNode rightHandSide) {
        super(token, leftHandSide, rightHandSide);
    }

    public Type getType() {
        return super.getLeftHandSide().getType();
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
