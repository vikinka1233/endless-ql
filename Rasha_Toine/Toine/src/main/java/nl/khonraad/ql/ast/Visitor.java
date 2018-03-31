package nl.khonraad.ql.ast;

import java.util.ArrayList;
import java.util.List;

import nl.khonraad.ql.QLBaseVisitor;
import nl.khonraad.ql.QLParser;
import nl.khonraad.ql.algebra.Identifier;
import nl.khonraad.ql.algebra.Label;
import nl.khonraad.ql.algebra.Value;
import nl.khonraad.ql.algebra.value.Operator;
import nl.khonraad.ql.algebra.value.Type;
import nl.khonraad.ql.ast.data.Question;
import nl.khonraad.ql.ast.data.Questionnaire;

public final class Visitor extends QLBaseVisitor<Value> {

    private Questionnaire questionnaire;

    public Visitor(Questionnaire questionnaire) {
        super();
        this.questionnaire = questionnaire;
    }

    private List<Identifier>    forwardReferences             = new ArrayList<>();

    private static final String REFERENCES_UNDEFINED_QUESTION = "Reference to undefined question: ";

    private String removeQuotes( String text ) {
        return text.substring( 1, text.length() - 1 );
    }

    @Override
    public Value visitForm( QLParser.FormContext ctx ) {

        Value value = visitChildren( ctx );

        if ( !forwardReferences.isEmpty() ) {
            throw new RuntimeException( REFERENCES_UNDEFINED_QUESTION + forwardReferences.get( 0 ) );
        }

        return value;

    }

    @Override
    public Value visitIdentifier( QLParser.IdentifierContext ctx ) {

        Identifier identifier = new Identifier( ctx.Identifier().getText() );

        Question question = questionnaire.findAnswerable( identifier );

        if ( question != null ) {

            forwardReferences.remove( identifier );

            return question.value();

        }

        throw new RuntimeException( REFERENCES_UNDEFINED_QUESTION + identifier );
    }

    @Override
    public Value visitPartAnswerableQuestion( QLParser.PartAnswerableQuestionContext ctx ) {

        Identifier identifier = new Identifier( ctx.Identifier().getText() );
        Label label = new Label( removeQuotes( ctx.QuotedString().getText() ) );

        Type type = Type.type( ctx.type().getText() );

        Question question = questionnaire.findAnswerable( identifier );

        if ( question != null ) {

            throw reportError( ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Duplicate declaration " + ctx.Identifier().getText() );
        }

        return questionnaire.storeAnswerableQuestion( identifier, label, type );

    }

    private IllegalStateException reportError( int l, int c, String message ) {
        return new IllegalStateException( "Line " + l + ":" + c + " "
                + message );
    }

    @Override
    public Value visitPartComputedQuestion( QLParser.PartComputedQuestionContext ctx ) {

        Identifier identifier = new Identifier( ctx.Identifier().getText() );
        Label label = new Label( removeQuotes( ctx.QuotedString().getText() ) );

        Type type = Type.type( ctx.type().getText() );

        forwardReferences.remove( identifier );

        Value value = visit( ctx.expression() );

        if ( !type.equals( value.type() ) ) {
            throw reportError( ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Type error " + ctx.Identifier().getText() );
        }

        return questionnaire.storeComputedQuestion( identifier, label, value );
    }

    @Override
    public Value visitUnaryOperator_Expression( QLParser.UnaryOperator_ExpressionContext ctx ) {

        Value expression = visit( ctx.expression() );
        String operator = ctx.unaryOperator().getText();

        try {
            return expression.apply( Operator.parse( operator ) );
        } catch (Exception e) {
            throw reportError( ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Exception " + ctx.expression().getText() );
        }
    }

    @Override
    public Value visitExpressionQuotedString( QLParser.ExpressionQuotedStringContext ctx ) {

        return new Value( Type.String, removeQuotes( ctx.QuotedString().getText() ) );
    }

    @Override
    public Value visitExpression_MultiplicationOperator_Expression(
            QLParser.Expression_MultiplicationOperator_ExpressionContext ctx ) {

        Value left = visit( ctx.expression( 0 ) );
        Value right = visit( ctx.expression( 1 ) );
        String operator = ctx.multiplicationOperator().getText();

        try {
            return left.apply( Operator.parse( operator ), right );
        } catch (Exception e) {
            throw new RuntimeException( e.getMessage() );
        }

    }

    @Override
    public Value visitExpression_AdditionOperator_Expression(
            QLParser.Expression_AdditionOperator_ExpressionContext ctx ) {

        Value left = visit( ctx.expression( 0 ) );
        Value right = visit( ctx.expression( 1 ) );
        String operator = ctx.additionOperator().getText();

        try {

            return left.apply( Operator.parse( operator ), right );
        } catch (Exception e) {
            throw new RuntimeException( e.getMessage() );
        }

    }

    @Override
    public Value visitExpression_EqualityOperator_Expression(
            QLParser.Expression_EqualityOperator_ExpressionContext ctx ) {

        Value left = visit( ctx.expression( 0 ) );
        Value right = visit( ctx.expression( 1 ) );
        String operator = ctx.equalityOperator().getText();

        try {
            return left.apply( Operator.parse( operator ), right );
        } catch (Exception e) {
            throw new RuntimeException( e.getMessage() );
        }

    }

    @Override
    public Value visitExpression_LogicalOperator_Expression(
            QLParser.Expression_LogicalOperator_ExpressionContext ctx ) {

        Value left = visit( ctx.expression( 0 ) );
        Value right = visit( ctx.expression( 1 ) );
        String operator = ctx.logicalOperator().getText();

        try {
            return left.apply( Operator.parse( operator ), right );
        } catch (Exception e) {
            throw new RuntimeException( e.getMessage() );
        }

    }

    @Override
    public Value visitExpression_OrderingOperator_Expression(
            QLParser.Expression_OrderingOperator_ExpressionContext ctx ) {

        Value left = visit( ctx.expression( 0 ) );
        Value right = visit( ctx.expression( 1 ) );
        String operator = ctx.orderingOperator().getText();

        try {

            return left.apply( Operator.parse( operator ), right );
        } catch (Exception e) {
            throw new RuntimeException( e.getMessage() );
        }

    }

    @Override
    public Value visitExpressionMoneyConstant( QLParser.ExpressionMoneyConstantContext ctx ) {
        return new Value( Type.Money, ctx.MoneyConstant().getText() );
    }

    @Override
    public Value visitExpressionDateConstant( QLParser.ExpressionDateConstantContext ctx ) {
        return new Value( Type.Date, ctx.DateConstant().getText() );
    }

    @Override
    public Value visitExpressionIntegerConstant( QLParser.ExpressionIntegerConstantContext ctx ) {
        return new Value( Type.Integer, ctx.IntegerConstant().getText() );
    }

    @Override
    public Value visitExpressionBooleanConstant( QLParser.ExpressionBooleanConstantContext ctx ) {
        return new Value( Type.Boolean, ctx.BooleanConstant().getText() );
    }

    @Override
    public Value visitExpressionParenthesized( QLParser.ExpressionParenthesizedContext ctx ) {
        return visit( ctx.expression() );
    }

    @Override
    public Value visitPartConditionalBlock( QLParser.PartConditionalBlockContext ctx ) {

        Value value = visit( ctx.expression() );

        if ( value.equals( new Value( true ) ) ) {
            visitChildren( ctx.block() );
        }
        return value;
    }

}
