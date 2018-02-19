package visiting;

import java.util.List;

import ast.Block;
import ast.statement.*;
import ast.literal.*;
import ast.expression.*;
import ast.type.*;


public class MainVisitor<T, U> implements ExpressionVisitor<T, U>, StatementVisitor<T, U>, TypeVisitor<T, U>, LiteralVisitor<T, U>{
	
	/* types & literals - return nothing */
	@Override
	public T visit(DateType type, U ctx){
		return null;
	}

	@Override
	public T visit(BooleanType type, U ctx){
		return null;
	}

	@Override
	public T visit(StringType type, U ctx){
	return null;
	}

	@Override
	public T visit(IntegerType type, U ctx){
		return null;
	}
	
	@Override
	public T visit(MoneyType type, U ctx){
		return null;
	}
	
	@Override
	public T visit(DecimalType type, U ctx) {
		return null;
	}
	
	@Override
	public T visit(BooleanLiteral node, U ctx) {
		return null;
	}
	
	@Override
	public T visit(IntegerLiteral node, U ctx) {
		return null;
	}
	
	@Override
	public T visit(StringLiteral node, U ctx){
		return null;
	}
	
	@Override
	public T visit(MoneyLiteral node, U ctx){
		return null;
	}

	@Override
	public T visit(DecimalLiteral node, U ctx){
		return null;
	}

	@Override
	public T visit(DateLiteral node, U ctx){
		return null;
	}
	
	/* Expressions */
	@Override
	public T visit(LiteralExpression node, U ctx){
		node.getObj().accept(this, ctx);
		return null;
	}
	
	@Override
	public T visit(IdentityExpression node, U ctx) {
		return null;
	}
	
	public T visit(BinaryExpression node, U ctx){
		node.getLeft().accept(this, ctx);
		node.getRight().accept(this, ctx);
		return null;
	}

	public T visit(UnaryExpression node, U ctx){
		node.getExpression().accept(this, ctx);
		return null;
	}
	
	@Override
	public T visit(And node, U ctx){
		return visit((BinaryExpression) node, ctx);
	}
	
	@Override
	public T visit(Or node, U ctx){
		return visit((BinaryExpression) node, ctx);
	}
	
	@Override
	public T visit(Not node, U ctx){
		return visit((UnaryExpression) node, ctx);
	}
	
	@Override
	public T visit(Add node, U ctx){
		return visit((BinaryExpression) node, ctx);
	}
	
	@Override
	public T visit(Sub node, U ctx){
		return visit((BinaryExpression) node, ctx);
	}
	
	
	@Override
	public T visit(Mul node, U ctx){
		return visit((BinaryExpression) node,ctx);
	}
	
	@Override
	public T visit(Div node, U ctx){
		return visit((BinaryExpression) node, ctx);
	}
	
	@Override
	public T visit(Eq node, U ctx) {
		return visit((BinaryExpression) node, ctx);
	}
	
	@Override
	public T visit(NEq node, U ctx){
	return visit((BinaryExpression) node, ctx);
	}
	
	@Override
	public T visit(GEq node, U ctx){
		return visit((BinaryExpression) node, ctx);
	}
	
	@Override
	public T visit(GT node, U ctx) {
	return visit((BinaryExpression) node, ctx);
	}
	
	@Override
	public T visit(LEq node, U ctx){
		return visit((BinaryExpression) node, ctx);
	}
	
	@Override
	public T visit(LT node, U ctx){
		return visit((BinaryExpression) node, ctx);
	}
	
	
	@Override
	public T visit(Pos node, U ctx) {
		return visit((UnaryExpression) node, ctx);
	}
	
	@Override
	public T visit(Neg node, U ctx){
		return visit((UnaryExpression) node, ctx);
	}

	
	@Override
	public T visit(Block node, U ctx){
		List<Statement> stmts = node.getStatements();
		stmts.forEach( it -> 
			it.accept(this, ctx));
		return null;
	}
	
	/* Data-model */
	@Override
	public T visit(IfThenStatement node, U ctx) {
		node.getExpression().accept(this, ctx);
		node.getIfBody().accept(this, ctx);
		return null;
	}
	
	@Override
	public T visit(NormalQuestion node, U ctx){
		node.getType().accept(this,ctx);
		return null;
	}

	@Override
	public T visit(ComputedQuestion node, U ctx){
		node.getType().accept(this, ctx);
		return null;
	}

	@Override
	public T visit(Type type, U ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(ParenthesesExpression parenthesesExpression, U ctx) {
		// TODO Auto-generated method stub
		return null;
	}
}
