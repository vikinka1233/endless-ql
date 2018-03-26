package org.uva.sea.languages.ql.parser.elements.expressions;

import org.antlr.v4.runtime.Token;
import org.uva.sea.languages.ql.parser.elements.expressions.types.Type;
import org.uva.sea.languages.ql.parser.nodeTypes.SingleNode;
import org.uva.sea.languages.ql.parser.visitor.IASTVisitor;

public class Positive extends SingleNode {
    public Positive(final Token token, final Expression value) {
        super(token, value);
    }

    public final Type getType() {
        return this.getValue().getType();
    }

    @Override
    public final <T> T accept(final IASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
