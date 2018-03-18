package org.uva.qls.ast.Value;

public class StringValue extends Value {

    private String value;

    public StringValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
