package org.uva.sea.ql.value;

import org.uva.sea.ql.QLValueEvaluator;
import org.uva.sea.ql.parser.NodeType;

import java.math.BigDecimal;

public class MoneyValue extends Value {

    private String currency;
    private BigDecimal amount;

    //TODO Add string constructor

    public MoneyValue(String currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public Value add(Value value) throws Exception {
        return value.add(this);
    }

    @Override
    public Value add(IntValue value) {
        return new MoneyValue(this.currency, this.amount.add(new BigDecimal(value.getIntValue())));
    }

    @Override
    public Value add(MoneyValue value) throws Exception {
        if(!this.getCurrency().equals(value.getCurrency()))
            throw new Exception("Currencies mismatch");

        return new MoneyValue(this.currency, this.amount.add(value.getAmount()));
    }

    @Override
    public Value add(DecimalValue value) {
        return new MoneyValue(this.currency, this.amount.add(new BigDecimal(value.getDecimalValue())));
    }

    @Override
    public Value divide(Value value) throws Exception {
        return value.reverseDivide(this);
    }

    @Override
    public Value divide(IntValue value) {
        return new MoneyValue(this.currency, this.amount.divide(new BigDecimal(value.getIntValue())));
    }

    @Override
    public Value divide(MoneyValue value) throws Exception {
        if(!this.getCurrency().equals(value.getCurrency()))
            throw new Exception("Currencies mismatch");

        return new MoneyValue(this.currency, this.amount.divide(value.getAmount()));
    }

    @Override
    public Value divide(DecimalValue value) {
        return new MoneyValue(this.currency, this.amount.divide(new BigDecimal(value.getDecimalValue())));
    }

    @Override
    public Value isEqual(Value value) throws Exception {
        return value.isEqual(this);
    }

    @Override
    public Value isEqual(IntValue value) {
        return new BooleanValue(this.amount.equals(new BigDecimal(value.getIntValue())));
    }

    @Override
    public Value isEqual(MoneyValue value) throws Exception {
        if(this.getCurrency() != value.getCurrency())
            throw new Exception("Currencies mismatch");

        return new BooleanValue(this.amount.equals(value.getAmount()));
    }

    @Override
    public Value isEqual(DecimalValue value) {
        return new BooleanValue(this.amount.equals(new BigDecimal(value.getDecimalValue())));
    }

    @Override
    public Value isGreaterOrEqual(Value value) throws Exception {
        return value.isLessThan(this);
    }

    @Override
    public Value isGreaterOrEqual(IntValue value) {
        return new BooleanValue(this.amount.compareTo(new BigDecimal(value.getIntValue())) >= 0);
    }

    @Override
    public Value isGreaterOrEqual(MoneyValue value) throws Exception {
        if(this.getCurrency() != value.getCurrency())
            throw new Exception("Currencies mismatch");

        return new BooleanValue(this.amount.compareTo(value.getAmount()) >= 0);
    }

    @Override
    public Value isGreaterOrEqual(DecimalValue value) {
        return new BooleanValue(this.amount.compareTo(new BigDecimal(value.getDecimalValue())) >= 0);
    }

    @Override
    public Value isGreaterThan(Value value) throws Exception {
        return value.isLessOrEqual(this);
    }

    @Override
    public Value isGreaterThan(IntValue value) {
        return new BooleanValue(this.amount.compareTo(new BigDecimal(value.getIntValue())) > 0);
    }

    @Override
    public Value isGreaterThan(MoneyValue value) throws Exception {
        if(this.getCurrency() != value.getCurrency())
            throw new Exception("Currencies mismatch");

        return new BooleanValue(this.amount.compareTo(value.getAmount()) > 0);
    }

    @Override
    public Value isGreaterThan(DecimalValue value) {
        return new BooleanValue(this.amount.compareTo(new BigDecimal(value.getDecimalValue())) > 0);
    }

    @Override
    public Value isLessOrEqual(Value value) throws Exception {
        return value.isGreaterThan(this);
    }

    @Override
    public Value isLessOrEqual(IntValue value) {
        return new BooleanValue(this.amount.compareTo(new BigDecimal(value.getIntValue())) <= 0);
    }

    @Override
    public Value isLessOrEqual(MoneyValue value) throws Exception {
        if(this.getCurrency() != value.getCurrency())
            throw new Exception("Currencies mismatch");

        return new BooleanValue(this.amount.compareTo(value.getAmount()) <= 0);
    }

    @Override
    public Value isLessOrEqual(DecimalValue value) {
        return new BooleanValue(this.amount.compareTo(new BigDecimal(value.getDecimalValue())) <= 0);
    }

    @Override
    public Value isLessThan(Value value) throws Exception {
        return value.isGreaterOrEqual(this);
    }

    @Override
    public Value isLessThan(IntValue value) {
        return new BooleanValue(this.amount.compareTo(new BigDecimal(value.getIntValue())) < 0);
    }

    @Override
    public Value isLessThan(MoneyValue value) throws Exception {
        if(this.getCurrency() != value.getCurrency())
            throw new Exception("Currencies mismatch");

        return new BooleanValue(this.amount.compareTo(value.getAmount()) < 0);
    }

    @Override
    public Value isLessThan(DecimalValue value) {
        return new BooleanValue(this.amount.compareTo(new BigDecimal(value.getDecimalValue())) < 0);
    }

    @Override
    public Value multiply(Value value) throws Exception {
        return value.multiply(this);
    }

    @Override
    public Value multiply(IntValue value) {
        return new MoneyValue(this.currency, this.amount.multiply(new BigDecimal(value.getIntValue())));
    }

    @Override
    public Value multiply(MoneyValue value) throws Exception {
        if(this.getCurrency() != value.getCurrency())
            throw new Exception("Currencies mismatch");

        return new MoneyValue(this.currency, this.amount.multiply(value.getAmount()));
    }

    @Override
    public Value multiply(DecimalValue value) {
        return new MoneyValue(this.currency, this.amount.multiply(new BigDecimal(value.getDecimalValue())));
    }

    @Override
    public Value isNotEqual(Value value) throws Exception {
        return value.isNotEqual(this);
    }

    @Override
    public Value isNotEqual(IntValue value) {
        return new BooleanValue(!this.amount.equals(new BigDecimal(value.getIntValue())));
    }

    @Override
    public Value isNotEqual(MoneyValue value) throws Exception {
        if(this.getCurrency() != value.getCurrency())
            throw new Exception("Currencies mismatch");

        return new BooleanValue(!this.amount.equals(value.getAmount()));
    }

    @Override
    public Value isNotEqual(DecimalValue value) {
        return new BooleanValue(!this.amount.equals(new BigDecimal(value.getDecimalValue())));
    }

    @Override
    public Value subtract(Value value) throws Exception {
        return value.reverseSubtract(this);
    }

    @Override
    public Value subtract(IntValue value) {
        return new MoneyValue(this.currency, this.amount.subtract(new BigDecimal(value.getIntValue())));
    }

    @Override
    public Value subtract(MoneyValue value) throws Exception {
        if(this.getCurrency() != value.getCurrency())
            throw new Exception("Currencies mismatch");
        
        return new MoneyValue(this.currency, this.amount.subtract(value.getAmount()));
    }

    @Override
    public Value subtract(DecimalValue value) {
        return new MoneyValue(this.currency, this.amount.subtract(new BigDecimal(value.getDecimalValue())));
    }

    @Override
    public Value reverseSubtract(DecimalValue value) {
        return value.subtract(this);
    }

    @Override
    public Value reverseSubtract(IntValue value) {
        return value.subtract(this);
    }

    @Override
    public Value reverseSubtract(MoneyValue value) throws Exception {
        if(this.getCurrency() != value.getCurrency())
            throw new Exception("Currencies mismatch");
        
        return value.subtract(this);
    }

    @Override
    public Value reverseDivide(DecimalValue value) {
        return value.divide(this);
    }

    @Override
    public Value reverseDivide(IntValue value) {
        return value.divide(this);
    }

    @Override
    public Value reverseDivide(MoneyValue value) throws Exception {
        if(this.getCurrency() != value.getCurrency())
            throw new Exception("Currencies mismatch");
        
        return value.divide(this);
    }

    @Override
    public Value negate() {
        return new MoneyValue(this.currency, this.amount.negate());
    }

    @Override
    public Value positive() {
        return new MoneyValue(this.currency, this.amount);
    }

    @Override
    public <T> T accept(QLValueEvaluator<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public NodeType getType() {
        return NodeType.MONEY;
    }
}
