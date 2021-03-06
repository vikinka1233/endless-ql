package QLS.parsing.visitors;

import QL.classes.values.BooleanValue;
import QL.classes.values.NumericValue;
import QL.classes.values.StringValue;
import QL.classes.values.Value;
import QLS.parsing.gen.QLSBaseVisitor;
import QLS.parsing.gen.QLSParser;
import gui.widgets.CheckBoxWidget;
import gui.widgets.DropDownWidget;
import gui.widgets.RadioWidget;
import gui.widgets.SliderWidget;
import gui.widgets.SpinBoxWidget;
import gui.widgets.TextWidget;
import gui.widgets.Widget;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;

public class WidgetVisitor extends QLSBaseVisitor {
    private Value currentValue;

    public Widget visitWidget(QLSParser.WidgetContext ctx, Value value) {
        this.currentValue = value;
        return (Widget) super.visitWidgetType(ctx.widgetType());
    }

    @Override
    public CheckBoxWidget visitCheckboxWidget(QLSParser.CheckboxWidgetContext ctx) {

        return new CheckBoxWidget((BooleanValue) currentValue);
    }

    @Override
    public SpinBoxWidget visitSpinboxWidget(QLSParser.SpinboxWidgetContext ctx) {
        return new SpinBoxWidget((NumericValue) currentValue);
    }

    @Override
    public TextWidget visitTextWidget(QLSParser.TextWidgetContext ctx) {
        return new TextWidget((StringValue) currentValue);
    }

    @Override
    public RadioWidget visitRadioWidget(QLSParser.RadioWidgetContext ctx) {
        ArrayList<String> options = new ArrayList<>();

        for (TerminalNode t : ctx.argList().STR()) {
            options.add(t.getText());
        }

        return new RadioWidget(currentValue, options.toArray());
    }


    @Override
    public SliderWidget visitSliderWidget(QLSParser.SliderWidgetContext ctx) {
        int min = Integer.parseInt(ctx.min.getText());
        int max = Integer.parseInt(ctx.max.getText());
        return new SliderWidget((NumericValue) currentValue, min, max);
    }

    @Override
    public DropDownWidget visitDropdownWidget(QLSParser.DropdownWidgetContext ctx) {
        ArrayList<String> options = new ArrayList<>();

        for (TerminalNode t : ctx.argList().STR()) {
            options.add(t.getText());
        }

        return new DropDownWidget(currentValue, options.toArray());
    }
}