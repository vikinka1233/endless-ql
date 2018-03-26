package ql.gui.controller;

import ql.ast.model.expressions.values.VariableReference;
import ql.gui.model.QuestionModel;
import ql.logic.collectors.CollectReferencesVisitor;
import ql.logic.evaluators.FormModelExpressionEvaluator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class FormController {

    private final List<QuestionModel> questionModels;
    private final FormModelExpressionEvaluator evaluator;
    private final CollectReferencesVisitor collectReferencesVisitor = new CollectReferencesVisitor();

    public FormController(List<QuestionModel> questionModels, FormModelExpressionEvaluator evaluator) {
        this.evaluator = evaluator;

        // initial evaluation
        for (QuestionModel questionModel : questionModels) {
            if (questionModel.getAssignedExpression() != null) {
                questionModel.setQlTypedValue(questionModel.getAssignedExpression().accept(evaluator));
            }
            if (questionModel.getVisibilityCondition() != null) {
                questionModel.setVisibility((Boolean) questionModel.getVisibilityCondition().accept(evaluator).getValue());
            } else {
                questionModel.setVisibility(true);
            }
        }

        this.questionModels = questionModels;

        for (QuestionModel questionModel : questionModels) {
            questionModel.registerController(this);
        }
    }

    private List<QuestionModel> extractQuestionModelsWithAssignedExpressionDirectlyReferencingTo(QuestionModel questionModel) {

        List<QuestionModel> result = new ArrayList<>();

        for (QuestionModel questionModel1 : this.questionModels) {
            if (questionModel1.getAssignedExpression() != null) {

                List<VariableReference> variableReferences = this.collectReferencesVisitor.getVariableReferences(questionModel1.getAssignedExpression());

                for (VariableReference variableReference : variableReferences) {
                    if (variableReference.getName().equals(questionModel.getVariableName())) {
                        result.add(questionModel1);
                    }
                }
            }
        }

        return result;
    }

    private List<QuestionModel> extractQuestionModelsWithVisibilityDirectlyReferencingTo(QuestionModel questionModel) {

        List<QuestionModel> result = new ArrayList<>();

        for (QuestionModel questionModel1 : this.questionModels) {
            if (questionModel1.getVisibilityCondition() != null) {
                List<VariableReference> variableReferences = this.collectReferencesVisitor.getVariableReferences(questionModel1.getVisibilityCondition());
                for (VariableReference variableReference : variableReferences) {
                    if (variableReference.getName().equals(questionModel.getVariableName())) {
                        result.add(questionModel1);
                    }
                }
            }
        }

        return result;
    }

    public void processQuestionModelChange(QuestionModel questionModel) {

        List<QuestionModel> questionsToUpdateValueModel = this.extractQuestionModelsWithAssignedExpressionDirectlyReferencingTo(questionModel);
        if (!questionsToUpdateValueModel.isEmpty()) {
            for (QuestionModel questionModel1 : questionsToUpdateValueModel) {
                // they must (per definition) have assigned expression
                questionModel1.setQlTypedValue(questionModel1.getAssignedExpression().accept(evaluator));
                questionModel1.getPanel().refreshValue();
                this.processQuestionModelChange(questionModel1);
            }
        }

        List<QuestionModel> questionsToUpdateVisibilityModel = this.extractQuestionModelsWithVisibilityDirectlyReferencingTo(questionModel);
        if (!questionsToUpdateVisibilityModel.isEmpty()) {
            for (QuestionModel questionModel1 : questionsToUpdateVisibilityModel) {
                // they must (per definition) have visibility conditions
                questionModel1.setVisibility((Boolean) questionModel1.getVisibilityCondition().accept(evaluator).getValue());
                questionModel1.getPanel().refreshVisibility();
                this.processQuestionModelChange(questionModel1);
            }
        }
    }

    public LinkedHashMap<String, Object> prepareResults() {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        for (QuestionModel questionModel : this.questionModels) {
            if (questionModel.getVisibility()) {
                result.put(questionModel.getVariableName(), questionModel.getJavaTypedValue());
            }
        }
        return result;
    }

}
