package ql.gui.widgets;

import ql.gui.WidgetListener;
import ql.evaluator.values.Value;

import javax.swing.*;

public interface Widget {

    Value getValue();

    void setValue();

    JComponent getComponent();

    void setVisible(boolean visible);

    void registerChangeListener(WidgetListener widgetListener);

}