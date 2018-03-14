package Expression;

import Parser.ANTLRTester;
import ql.evaluation.value.Value;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionPrecedenceTest {
    @Test
    public void PlusMultiplyTest() {
        Value evaluatedExpression = ANTLRTester.evaluateExpression("5 + 6 * 3");
        assertEquals(evaluatedExpression.getIntValue(), Integer.valueOf(23));
    }

    @Test
    public void MultiplyPlusTest() {
        Value evaluatedExpression = ANTLRTester.evaluateExpression("6 * 3 + 5");
        assertEquals(evaluatedExpression.getIntValue(), Integer.valueOf(23));
    }

    @Test
    public void MultiplyPlusDivideTest() {
        Value evaluatedExpression = ANTLRTester.evaluateExpression("6 * 3 + 40 / 4");
        assertEquals(evaluatedExpression.getIntValue(), Integer.valueOf(28));
    }

    @Test
    public void MinusDivideTest() {
        Value evaluatedExpression = ANTLRTester.evaluateExpression("11 - 30 / 3");
        assertEquals(evaluatedExpression.getIntValue(), Integer.valueOf(1));
    }

    @Test
    public void DivideMinusTest() {
        Value evaluatedExpression = ANTLRTester.evaluateExpression("30 / 3 - 11");
        assertEquals(evaluatedExpression.getIntValue(), Integer.valueOf(-1));
    }

    @Test
    public void ParenthesesTest() {
        Value evaluatedExpression = ANTLRTester.evaluateExpression("(5 + 6) * 3");
        assertEquals(evaluatedExpression.getIntValue(), Integer.valueOf(33));
    }

    @Test
    public void ExpressionComparisonTest() {
        Value evaluatedExpression = ANTLRTester.evaluateExpression("3 * 4 > 3 * 4 - 1");
        assertEquals(evaluatedExpression.getBooleanValue(), true);
    }

    @Test
    public void ExpressionEqualsTest() {
        Value evaluatedExpression = ANTLRTester.evaluateExpression("3 * 4 == 3 * 4 - 1 + 1");
        assertEquals(evaluatedExpression.getBooleanValue(), true);
    }

    @Test
    public void AndTest() {
        Value evaluatedExpression = ANTLRTester.evaluateExpression("4 > 3 && 8 == 8");
        assertEquals(evaluatedExpression.getBooleanValue(), true);
    }

    @Test
    public void OrAndTrueTest() {
        Value evaluatedExpression = ANTLRTester.evaluateExpression("3 > 4 && 8 == 8 || 4 > 3");
        assertEquals(evaluatedExpression.getBooleanValue(), true);
    }

    @Test
    public void AndOrTrueTest() {
        Value evaluatedExpression = ANTLRTester.evaluateExpression("4 > 3 || 8 == 8 && 3 > 4");
        assertEquals(evaluatedExpression.getBooleanValue(), true);
    }

    @Test
    public void OrAndFalseTest() {
        Value evaluatedExpression = ANTLRTester.evaluateExpression("3 > 4 && 8 == 8 || 3 > 4");
        assertEquals(evaluatedExpression.getBooleanValue(), false);
    }

    @Test
    public void AndOrFalseTest() {
        Value evaluatedExpression = ANTLRTester.evaluateExpression("3 > 4 || 8 == 8 && 3 > 4");
        assertEquals(evaluatedExpression.getBooleanValue(), false);
    }
}