package gui.widgets;

import javafx.scene.control.TextField;
import ql.model.expression.Expression;
import ql.model.expression.variable.ExpressionVariableDecimal;

public class DecimalWidget extends TextField implements WidgetInterface {

    private final String name;

    public DecimalWidget(String name) {
        this.name = name;
        this.managedProperty().bind(this.visibleProperty());
        this.setTextFormatter(WidgetUtils.createTextFormatter("-?\\d*(\\.\\d*)?"));
    }

    @Override
    public Expression getExpression() {
        return new ExpressionVariableDecimal(null, Double.parseDouble(getText()));
    }

    @Override
    public void setExpression(String value) {
        this.setText(value);
    }
}