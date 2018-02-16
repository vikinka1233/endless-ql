package ql.ast.statement;

import ql.ast.expression.Expression;
import ql.ast.expression.Identifier;
import ql.ast.type.Type;
import ql.visitors.interfaces.StatementVisitor;

public class ComputedQuestion extends Question {
    
    private Expression expr;

    public ComputedQuestion(String label, Identifier id, Type type, Expression expr) {
        super(label, id, type);
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "\"" + label.toString() + "\" " + id.toString() + ": " + type.toString() + "( " + expr.toString() + " )";
    }

    @Override
    public void accept(StatementVisitor visitor) {
        visitor.visit(this);
    }
    
    public Expression getExpression() {
        return expr;
    }
}
