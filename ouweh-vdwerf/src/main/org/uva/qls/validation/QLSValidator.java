package org.uva.qls.validation;

import org.uva.ql.ast.Question;
import org.uva.ql.validation.checker.Checker;
import org.uva.qls.ast.Segment.QuestionReference;
import org.uva.qls.ast.Segment.Stylesheet;
import org.uva.qls.collector.StylesheetContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QLSValidator {

    private final Stylesheet stylesheet;
    private final StylesheetContext stylesheetContext;

    private List<Question> qlQuestions;
    private List<Checker> checkers;

    public QLSValidator(List<Question> qlQuestions, Stylesheet stylesheet) {
        this.qlQuestions = qlQuestions;
        this.stylesheet = stylesheet;
        this.stylesheetContext = new StylesheetContext(stylesheet);

        this.checkers = new ArrayList<>();


        initializeCheckers();
    }

    private void initializeCheckers() {
        List<QuestionReference> qlsQuestions = stylesheetContext.getQuestions();
        List<String> qlQuestionIds = qlQuestions.stream().map(Question::getId).collect(Collectors.toList());
        List<String> qlsQuestionIds = qlsQuestions.stream().map(QuestionReference::getId).collect(Collectors.toList());

        checkers.add(new ReferenceChecker(qlQuestionIds, qlsQuestionIds));
        checkers.add(new CompatibilityChecker(qlQuestions, qlsQuestions, this.stylesheetContext));
        // TODO Add default CompatibilityChecker
    }

    public void run() {
        for (Checker checker : checkers) {
            checker.runCheck();
        }
    }
}
