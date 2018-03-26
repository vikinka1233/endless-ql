package org.uva.sea.languages.ql.parser.elements.expressions;

import org.antlr.v4.runtime.Token;
import org.uva.sea.languages.ql.parser.elements.expressions.types.Type;
import org.uva.sea.languages.ql.parser.nodeTypes.BinaryOperator;
import org.uva.sea.languages.ql.parser.visitor.IASTVisitor;

public class Division extends BinaryOperator {
    public Division(Token token, Expression leftHandSide, Expression rightHandSide) {
        super(token, leftHandSide, rightHandSide);
    }

    /**
     * The valueTypes is returned, so the type of LHS
     *
     * @return The type
     */
    public Type getType() {
        return this.getLeftHandSide().getType();
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
