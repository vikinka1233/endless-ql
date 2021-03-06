package nl.uva.js.qlparser.models.ql.expressions.data;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import nl.uva.js.qlparser.exceptions.TypeMismatchException;
import nl.uva.js.qlparser.helpers.NonNullRun;
import nl.uva.js.qlparser.models.ql.enums.DataType;
import nl.uva.js.qlparser.wrappers.logic.ValueChangeListener;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Variable<T, X extends DataExpression<T>> implements DataExpression<T> {
    @NonNull private DataType dataType;
    @NonNull private String name;
    private X value;
    private final List<ValueChangeListener> valueChangeListeners = new ArrayList<>();

    public void setValue(X value) {
        this.value = value;
        valueChangeListeners.forEach(listener -> listener.onChange(this));
    }

    public DataExpression<T> getValue() {
        return (value != null)
                ? value
                : Value.<T>builder().dataType(dataType).value(((T) dataType.getValueOf().apply(dataType.getEmptyValue()))).build();
    }

    @Override
    public DataType returnCheckedType() {
        NonNullRun.consumer(value, __ -> {
            DataType valueType = value.returnCheckedType();
            if (!dataType.equals(valueType)) throw new TypeMismatchException(dataType, valueType);
        });

        return dataType;
    }

    @Override
    @JsonValue
    public T value() {
        return this.getValue().value();
    }

    @Override
    public void addChangeListener(ValueChangeListener listener) {
        valueChangeListeners.add(listener);
        NonNullRun.consumer(value, val -> val.addChangeListener(listener));
    }
}
