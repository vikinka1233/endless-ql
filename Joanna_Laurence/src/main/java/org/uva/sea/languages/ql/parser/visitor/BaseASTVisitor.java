package org.uva.sea.languages.ql.parser.visitor;

import org.uva.sea.languages.ql.parser.elements.*;
import org.uva.sea.languages.ql.parser.elements.expressions.*;
import org.uva.sea.languages.ql.parser.elements.expressions.types.*;
import org.uva.sea.languages.ql.parser.nodeTypes.BinaryOperator;
import org.uva.sea.languages.ql.parser.nodeTypes.SingleOperator;

public abstract class BaseASTVisitor<T> implements IASTVisitor<T> {

    public T visit(Addition node) {
        return this.visit((BinaryOperator) node);
    }

    public T visit(And node) {
        return this.visit((BinaryOperator) node);
    }

    public T visit(Division node) {
        return this.visit((BinaryOperator) node);
    }

    public T visit(Equal node) {
        return this.visit((BinaryOperator) node);
    }

    public T visit(GreaterOrEqual node) {
        return this.visit((BinaryOperator) node);
    }

    public T visit(GreaterThan node) {
        return this.visit((BinaryOperator) node);
    }

    public T visit(LessOrEqual node) {
        return this.visit((BinaryOperator) node);
    }

    public T visit(LessThan node) {
        return this.visit((BinaryOperator) node);
    }

    public T visit(Multiplication node) {
        return this.visit((BinaryOperator) node);
    }

    public T visit(Negative node) {
        return this.visit((SingleOperator) node);
    }

    public T visit(NotEqual node) {
        return this.visit((BinaryOperator) node);
    }

    public T visit(Not node) {
        return this.visit((SingleOperator) node);
    }

    public T visit(Or node) {
        return this.visit((BinaryOperator) node);
    }

    public T visit(Positive node) {
        return this.visit((SingleOperator) node);
    }

    public T visit(Subtraction node) {
        return this.visit((BinaryOperator) node);
    }

    public T visit(Bool node) {
        return null;
    }

    public T visit(DateExpr node) {
        return null;
    }

    public T visit(Decimal node) {
        return null;
    }

    public T visit(Money node) {
        return null;
    }

    public T visit(Int node) {
        return null;
    }

    public T visit(Str node) {
        return null;
    }

    public T visit(Type node) {
        return null;
    }

    public T visit(Variable node) {
        return null;
    }

    public T visit(IfStatement node) {
        node.getExpression().accept(this);
        node.getThenBlock().accept(this);
        if (node.getOtherwiseBlock() != null)
            node.getOtherwiseBlock().accept(this);
        return null;
    }

    public T visit(Form node) {
        return node.getStatements().accept(this);
    }

    public T visit(Question node) {
        if (node.getValue() != null)
            node.getValue().accept(this);

        node.getNodeType().accept(this);
        node.getVariable().accept(this);
        return null;
    }


    public T visit(Statements node) {
        for (ASTNode statement : node.getStatementList()) {
            statement.accept(this);
        }
        return null;
    }

    public T visit(BinaryOperator node) {
        node.getLeftHandSide().accept(this);
        node.getRightHandSide().accept(this);
        return null;
    }

    public T visit(SingleOperator node) {
        return node.getValue().accept(this);
    }
}
