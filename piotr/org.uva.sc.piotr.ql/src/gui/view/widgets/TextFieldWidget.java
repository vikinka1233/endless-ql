package gui.view.widgets;

import ast.model.expressions.Expression;
import gui.model.FormQuestionHolder;
import gui.view.Widget;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextFieldWidget extends Widget {

    private JTextField textField;

    public TextFieldWidget(FormQuestionHolder formQuestionHolder) {

        super(formQuestionHolder);

        JTextField field = new JTextField();
        field.setColumns(20);

        if (formQuestionHolder.getAssignedExpression() != null) {
            textField.setEditable(false);
        }

        field.getDocument().addDocumentListener(new DocumentListener() {

            public void changedUpdate(DocumentEvent e) {
                this.pushEvent();
            }

            public void removeUpdate(DocumentEvent e) {
                this.pushEvent();
            }

            public void insertUpdate(DocumentEvent e) {
                this.pushEvent();
            }

            private void pushEvent() {

                System.out.println("TextFieldWidget new value: " + field.getText());
//                formQuestionHolder.getValueHolder().setStringValue(textField.getText());
//                anchor.evaluate();
//                textField.setVisible(formQuestionHolder.getVisibilityHolder().getBooleanValue());
                formQuestionHolder.changeValue(field.getText());
            }
        });
        this.textField = field;
    }

    @Override
    public JComponent getComponent() {
        return this.textField;
    }

    @Override
    public Expression.DataType getSupportedDataType() {
        return Expression.DataType.STRING;
    }

}