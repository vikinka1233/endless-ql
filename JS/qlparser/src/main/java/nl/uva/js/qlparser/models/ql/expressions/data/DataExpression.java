package nl.uva.js.qlparser.models.ql.expressions.data;

import nl.uva.js.qlparser.models.ql.expressions.Expression;
import nl.uva.js.qlparser.wrappers.logic.ValueChangeListener;

public interface DataExpression<T> extends Expression, Expression.Typed {
    T value();
    void addChangeListener(ValueChangeListener listener);
}
