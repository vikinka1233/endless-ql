package qlviz.typecheker;

import java.util.ArrayList;
import java.util.List;

import qlviz.model.Form;

public class StaticChecker {

    public List<AnalysisResult> checkForDuplicateLabels(Form unlinkedForm) {
        DuplicateLabelChecker duplicateLabelChecker = new DuplicateLabelChecker();
        duplicateLabelChecker.initialize(unlinkedForm);
        return duplicateLabelChecker.analyze();
    }


    public List<AnalysisResult> validate(Form form, boolean containsDuplicates) {
        List<AnalysisResult> staticCheckResults = new ArrayList<>();
        DuplicateQuestionChecker duplicateQuestionChecker = new DuplicateQuestionChecker();
        duplicateQuestionChecker.initialize(form);
        DuplicateLabelChecker duplicateLabelChecker = new DuplicateLabelChecker();
        duplicateLabelChecker.initialize(form);
        staticCheckResults.addAll(duplicateQuestionChecker.analyze());
        staticCheckResults.addAll(duplicateLabelChecker.analyze());
        if (!containsDuplicates) {
            CircularReferenceChecker circularReferenceChecker = new CircularReferenceChecker();
            circularReferenceChecker.initialize(form);
            staticCheckResults.addAll(circularReferenceChecker.analyze());
        }
        return staticCheckResults;
    }
}
