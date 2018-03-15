package gui.widgets;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class DoubleWidget extends Widget {

    public DoubleWidget(String name, ChangeListener<? super String> listener) {
        super(name, listener);
    }

    @Override
    public Pane getUI() {
        HBox pane = new HBox();
        pane.setSpacing(20);

        TextField textField = new TextField();
        TextFormatter formatter = createTextFormatter("-?\\d*(\\.\\d*)?");
        textField.setTextFormatter(formatter);
        pane.getChildren().add(new Label(name));
        pane.getChildren().add(textField);

        return pane;
    }
}
