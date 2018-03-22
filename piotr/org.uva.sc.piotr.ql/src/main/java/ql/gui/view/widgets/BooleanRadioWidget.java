package ql.gui.view.widgets;

import ql.gui.model.QuestionModel;
import ql.gui.view.Widget;

import javax.swing.*;
import java.awt.*;

public class BooleanRadioWidget extends Widget {

    private final JPanel radioPanel;
    private final JRadioButton yesButton;
    private final JRadioButton noButton;

    public BooleanRadioWidget(QuestionModel questionModel) {
        super(questionModel);

        this.yesButton = new JRadioButton("Yes");
        this.noButton = new JRadioButton("No");

        if (questionModel.getAssignedExpression() != null) {
            this.yesButton.setEnabled(false);
            this.noButton.setEnabled(false);
        }

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.yesButton);
        buttonGroup.add(this.noButton);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(1, 2));
        radioPanel.add(this.yesButton);
        radioPanel.add(this.noButton);

        this.yesButton.addActionListener(e -> questionModel.changeValue(true));

        this.noButton.addActionListener(e -> questionModel.changeValue(false));

        this.radioPanel = radioPanel;
    }

    @Override
    public JComponent getComponent() {
        return this.radioPanel;
    }

    @Override
    public void updateValue() {
        this.yesButton.setSelected(this.getQuestionModel().getValue().getBooleanValue());
        this.noButton.setSelected(!this.getQuestionModel().getValue().getBooleanValue());
    }
}