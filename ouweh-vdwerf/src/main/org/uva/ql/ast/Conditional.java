package org.uva.ql.ast;


import org.uva.ql.ast.expression.Expression;
import org.uva.ql.visitor.StatementVisitor;

import java.util.ArrayList;
import java.util.List;

public class Conditional extends Statement {

    private Expression condition;
    private List<Statement> ifBlock;
    private List<Statement> elseBlock;

    public Conditional(Expression condition, List<Statement> ifBlock, List<Statement> elseBlock) {
        this.condition = condition;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
    }

    public Conditional(Expression condition, List<Statement> ifBlock) {
        this.condition = condition;
        this.ifBlock = ifBlock;
        this.elseBlock = new ArrayList<>();
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getIfBlock() {
        return ifBlock;
    }

    public List<Statement> getElseBlock() {
        return elseBlock;
    }

    @Override
    public String getId() {
        return this.toString();
    }

    @Override
    public <T, C> T accept(StatementVisitor<T, C> visitor, C context) {
        return visitor.visit(this, context);
    }

    @Override
    public String toString() {
        String conditional = String.format("If %s \n", this.condition);
        for (Statement statement : ifBlock) {
            conditional += String.format("\t\t%s\n", statement);
        }
        return conditional;
    }
}
