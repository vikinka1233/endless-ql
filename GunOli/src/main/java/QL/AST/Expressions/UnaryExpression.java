package QL.AST.Expressions;

public abstract class UnaryExpression extends Expression{
    private Expression expr;
    private String operator;

    public UnaryExpression(String operator, Expression expr, int lineNumber){
        super(lineNumber);
        setOperator(operator);
        setExpression(expr);
    }

    public Expression getExpression() {
        return expr;
    }

    public void setExpression(Expression expr) {
        this.expr = expr;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString(){
        return this.operator + getExpression().toString();
    }
}
