package domain.visitor;

import domain.Utilities;
import domain.model.value.ArithmeticExpressionValue;
import domain.model.value.MoneyValue;
import domain.model.variable.BooleanVariable;
import domain.model.variable.MoneyVariable;
import domain.model.variable.StringVariable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tool.ToolController;


public class UIVisitor implements Visitor {
    @Override
    public Node visit(BooleanVariable bv) {
        Boolean bool = bv.getValue().getValue();
        CheckBox cb = new CheckBox();
        cb.setSelected(bool);

        JavaFxObservable
                .valuesOf(cb.selectedProperty())
                .subscribe(bv.getValue());
        return cb;
    }

    @Override
    public Node visit(StringVariable sv) {
        TextField tf = new TextField();
        JavaFxObservable
                .valuesOf(tf.textProperty())
                .subscribe(sv.getValue());
        return tf;
    }

    @Override
    public Node visit(ArithmeticExpressionValue ev) {
        Label lbl = new Label();
        lbl.setText(ev.getValue().toString());
        return lbl;
    }

    @Override
    public Node visit(MoneyVariable mv) {
        TextField tf = new TextField();

        JavaFxObservable
                .valuesOf(tf.textProperty())
                .filter(Utilities::isNumeric)
                .map(Integer::valueOf)
                .subscribe(mv.getValue());

        return tf;
    }
}
