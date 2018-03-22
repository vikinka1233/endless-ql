package org.uva.sea.gui.qls.widget;

import javafx.scene.Node;
import org.uva.sea.gui.widget.BaseWidget;
import org.uva.sea.languages.ql.interpreter.dataObject.questionData.QuestionData;
import org.uva.sea.languages.ql.interpreter.dataObject.questionData.Style;

public abstract class QLSWidget extends BaseWidget {
    public QLSWidget(QuestionData questionData) {
        super(questionData);
    }

    @Override
    public String drawInContainer() {
        return this.questionData.getStyle().getPage();
    }

    protected void setStyle(Node node) {
        Style style = this.questionData.getStyle();
        if (style == null)
            return;

        style.updateNode(node);
    }
}
