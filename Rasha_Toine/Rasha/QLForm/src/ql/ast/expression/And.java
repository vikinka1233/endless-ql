package ql.ast.expression;

import ql.visiting.ExpressionVisitor;

public class And extends BinaryExpression {

	public And(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public <T, U> T accept(ExpressionVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}
}
