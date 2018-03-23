package gui.widgets.slider;

import ql.analysis.SymbolTable;
import ql.evaluation.value.Value;
import ql.model.expression.Expression;
import ql.model.expression.variable.ExpressionVariableDecimal;
import qls.model.StyleSheet;

public class SliderDecimalWidget extends SliderWidget {
    public SliderDecimalWidget(String identifier, boolean computed, double min, double max) {
        super(identifier, computed, min, max);

        // Display value in label next to slider
        this.slider.valueProperty().addListener((obs, oldVal, newVal) -> valueLabel.setText(newVal.toString()));
    }

    @Override
    public Expression getExpressionValue() {
        return new ExpressionVariableDecimal(null, this.slider.getValue());
    }

    @Override
    public void setValue(Value value) {
        this.slider.setValue(value.getDecimalValue());
    }
}
