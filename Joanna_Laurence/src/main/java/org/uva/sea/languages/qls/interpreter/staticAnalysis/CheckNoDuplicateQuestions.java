package org.uva.sea.languages.qls.interpreter.staticAnalysis;

import org.uva.sea.languages.ql.interpreter.dataObject.MessageTypes;
import org.uva.sea.languages.ql.interpreter.staticAnalysis.helpers.Messages;
import org.uva.sea.languages.ql.parser.elements.Form;
import org.uva.sea.languages.qls.parser.elements.Stylesheet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class CheckNoDuplicateQuestions extends QuestionAnalysis implements IQLSStaticAnalysis {

    private CheckNoDuplicateQuestions() {

    }

    public Messages doCheck(Form form, Stylesheet stylesheet) {
        List<String> qlsQuestions = this.getQlSQuestionNames(stylesheet);
        return this.checkForDuplicateQuestions(qlsQuestions);
    }


    private Messages checkForDuplicateQuestions(Iterable<String> listToCheck) {
        Messages messages = new Messages();
        Collection<String> validationSet = new HashSet();

        for (String name : listToCheck) {
            if (!validationSet.add(name))
                messages.addMessage("duplicate question: " + name, MessageTypes.ERROR);
        }

        return messages;
    }

    public static class Checker implements IQLSStaticAnalysis {
        @Override
        public Messages doCheck(Form form, Stylesheet stylesheet) {
            IQLSStaticAnalysis checker = new CheckNoDuplicateQuestions();
            return checker.doCheck(form, stylesheet);
        }
    }
}
