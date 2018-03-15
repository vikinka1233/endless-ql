package classes.values;

public class MoneyValue extends Value<Double> {
    public MoneyValue(Double value) {
        super(value);
        setType(Value.MONEY);
    }

    public MoneyValue() {
        super(0.0);
    }

}
