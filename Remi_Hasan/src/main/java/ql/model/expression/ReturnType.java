package ql.model.expression;

public enum ReturnType {
    INTEGER, DECIMAL, MONEY, NUMBER, BOOLEAN, STRING, DATE;

    public Boolean isNumber() {
        return this == NUMBER || this == INTEGER || this == DECIMAL || this == MONEY;
    }

    public Boolean isCompatible(ReturnType returnType) {
        return this == returnType || this.isNumber() && returnType.isNumber();
    }
}
