package QL.parsing.visitors;

import QL.classes.values.BooleanValue;
import QL.classes.values.DateValue;
import QL.classes.values.DecimalValue;
import QL.classes.values.IntegerValue;
import QL.classes.values.MoneyValue;
import QL.classes.values.StringValue;
import QL.classes.values.Value;
import QL.parsing.gen.QLBaseVisitor;
import QL.parsing.gen.QLParser;

public class TypeVisitor extends QLBaseVisitor {
    public Value visitType(QLParser.TypeContext ctx) {
        return (Value) visit(ctx);
    }

    @Override
    public BooleanValue visitBooltype(QLParser.BooltypeContext ctx) {
        return new BooleanValue();
    }

    @Override
    public StringValue visitStringtype(QLParser.StringtypeContext ctx) {
        return new StringValue();
    }

    @Override
    public IntegerValue visitIntegertype(QLParser.IntegertypeContext ctx) {
        return new IntegerValue();
    }

    @Override
    public MoneyValue visitMoneytype(QLParser.MoneytypeContext ctx) {
        return new MoneyValue();
    }

    @Override
    public DateValue visitDatetype(QLParser.DatetypeContext ctx) {
        return new DateValue();
    }

    @Override
    public DecimalValue visitDecimaltype(QLParser.DecimaltypeContext ctx) {
        return new DecimalValue();
    }

}