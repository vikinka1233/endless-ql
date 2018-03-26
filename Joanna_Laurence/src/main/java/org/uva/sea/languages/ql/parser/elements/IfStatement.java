package org.uva.sea.languages.ql.parser.elements;

import org.antlr.v4.runtime.Token;
import org.uva.sea.languages.ql.parser.NodeType;
import org.uva.sea.languages.ql.parser.elements.expressions.Expression;
import org.uva.sea.languages.ql.parser.elements.expressions.types.Type;
import org.uva.sea.languages.ql.parser.visitor.IASTVisitor;

public class IfStatement extends Statement {

    private final Expression expression;

    private final Statements then;
    private final Statements otherwise;

    public IfStatement(Token token, Expression expression, Statements then, Statements otherwise) {
        super(token);
        this.then = then;
        this.expression = expression;
        this.otherwise = otherwise;
    }

    public ASTNode getExpression() {
        return this.expression;
    }

    public Statements getThen() {
        return this.then;
    }

    public Statements getOtherwise() {
        return this.otherwise;
    }

    public Type getType() {
        return new Type(NodeType.UNKNOWN);
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
