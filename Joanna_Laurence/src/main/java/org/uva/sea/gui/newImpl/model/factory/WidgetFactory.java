package org.uva.sea.gui.newImpl.model.factory;

import org.uva.sea.gui.newImpl.IGuiElementUpdateListener;
import org.uva.sea.gui.newImpl.widget.Widget;
import org.uva.sea.languages.ql.interpreter.dataObject.WidgetType;
import org.uva.sea.languages.ql.interpreter.dataObject.questionData.QuestionData;

public class WidgetFactory {

    private QLWidgetFactory qlWidgetFactory = new QLWidgetFactory();

    private QLSWidgetFactory qlsWidgetFactory = new QLSWidgetFactory();

    public Widget createWidget(QuestionData questionData, IGuiElementUpdateListener listener) {
        if( questionData.getWidgetType() == WidgetType.DEFAULT)
            //TODO: create new structure. Only pass useful information
            return this.qlWidgetFactory.createWidget(questionData.getNodeType(), questionData, listener);
        else
            return this.qlsWidgetFactory.createWidget(questionData.getWidgetType(), questionData, listener);
    }

}
