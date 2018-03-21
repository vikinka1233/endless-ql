package ql.FormBuilder;

import org.junit.Test;
import ql.Analysis.UnknownIdentifiersTest;
import ql.QLFormBuilder;
import ql.QLTestUtilities;
import ql.analysis.SymbolTable;
import ql.evaluation.ExpressionEvaluator;
import ql.evaluation.value.Value;
import ql.model.Form;
import ql.model.Question;
import ql.model.expression.ReturnType;
import ql.model.expression.variable.ExpressionVariableBoolean;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class FormBuilderTest {

    @Test
    public void simpleForm() throws Exception {
        QLFormBuilder formBuilder = new QLFormBuilder();
        Form form = formBuilder.buildForm(FormBuilderTest.class
                .getResourceAsStream("/ValidForms/SimpleForm.ql"));

        assertEquals(form.identifier, "simpleForm");
        assertEquals(form.questions.size(), 6);
        assertEquals(form.questions.get(0).name, "someInteger");
        assertEquals(form.questions.get(0).text, "Can you give me an integer value?");
        assertEquals(form.questions.get(0).type, ReturnType.INTEGER);
    }

    @Test
    public void conditionFalseForm() throws Exception {
        QLFormBuilder formBuilder = new QLFormBuilder();
        Form form = formBuilder.buildForm(FormBuilderTest.class
                .getResourceAsStream("/ValidForms/ConditionFormFalse.ql"));

        assertEquals(form.questions.size(), 3);

        // Test whether correct questions are visible based on condition
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(formBuilder.getSymbolTable());
        Value ifQuestion = expressionEvaluator.visit(form.questions.get(1).condition);
        assertEquals(ifQuestion.getBooleanValue(), Boolean.FALSE);

        Value elseQuestion = expressionEvaluator.visit(form.questions.get(2).condition);
        assertEquals(elseQuestion.getBooleanValue(), Boolean.TRUE);
    }

    @Test
    public void conditionTrueForm() throws Exception {
        QLFormBuilder formBuilder = new QLFormBuilder();
        Form form = formBuilder.buildForm(FormBuilderTest.class
                .getResourceAsStream("/ValidForms/ConditionFormTrue.ql"));

        assertEquals(form.questions.size(), 3);

        // Test whether correct questions are visible based on condition
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(formBuilder.getSymbolTable());
        Value ifQuestion = expressionEvaluator.visit(form.questions.get(1).condition);
        assertEquals(ifQuestion.getBooleanValue(), Boolean.TRUE);

        Value elseQuestion = expressionEvaluator.visit(form.questions.get(2).condition);
        assertEquals(elseQuestion.getBooleanValue(), Boolean.FALSE);
    }

    @Test
    public void computedForm() throws Exception {
        QLFormBuilder formBuilder = new QLFormBuilder();
        Form form = formBuilder.buildForm(FormBuilderTest.class.
                getResourceAsStream("/ValidForms/ComputedForm.ql"));

        // Test whether computed field is computed correctly based on another field value
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(formBuilder.getSymbolTable());

        Value staticResult = expressionEvaluator.visit(form.questions.get(0).computedAnswer);
        assertEquals(staticResult.getIntValue(), Integer.valueOf(2));

        Value calculationResult = expressionEvaluator.visit(form.questions.get(1).computedAnswer);
        assertEquals(calculationResult.getIntValue(), Integer.valueOf(5));
    }

}
