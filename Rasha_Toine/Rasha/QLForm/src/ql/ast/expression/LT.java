package ql.ast.expression;

import ql.visiting.ExpressionVisitor;

public class LT extends BinaryExpression {

	public LT(Expression left, Expression right) {
		super(left, right);
	}
	
	@Override
	public <T, U> T accept(ExpressionVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
