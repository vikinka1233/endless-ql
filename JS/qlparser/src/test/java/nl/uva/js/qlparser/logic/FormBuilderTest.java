package nl.uva.js.qlparser.logic;

import nl.uva.js.qlparser.models.ql.enums.ArithOp;
import nl.uva.js.qlparser.models.ql.enums.CompOp;
import nl.uva.js.qlparser.models.ql.enums.DataType;
import nl.uva.js.qlparser.models.ql.expressions.Form;
import nl.uva.js.qlparser.models.ql.expressions.data.Combinator;
import nl.uva.js.qlparser.models.ql.expressions.data.Value;
import nl.uva.js.qlparser.models.ql.expressions.data.Variable;
import nl.uva.js.qlparser.models.ql.expressions.form.FormExpression;
import nl.uva.js.qlparser.models.ql.expressions.form.IfBlock;
import nl.uva.js.qlparser.models.ql.expressions.form.Question;
import nl.uva.js.qlparser.wrappers.arithmetic.CalculatableDouble;
import nl.uva.js.qlparser.wrappers.arithmetic.CalculatableMoney;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class FormBuilderTest {

    private static final String INPUT_BASIC_FILE = "src/test/resources/ql_input.jsql";
    private static final String INPUT_NULL_TEST = "src/test/resources/null_test.jsql";

    @Test
    public void testGetFormFromLocation() throws IOException {
        // Questions
        Question name = Question.builder()
                .variable(Variable.<String, Value<String>>builder()
                        .name("name")
                        .dataType(DataType.STRING)
                        .build())
                .question("What is your name?")
                .build();

        Question age = Question.builder()
                .variable(Variable.<String, Value<String>>builder()
                        .name("age")
                        .dataType(DataType.INTEGER)
                        .build())
                .question("What is your age?")
                .build();

        Question hasSoldHouse = Question.builder()
                .variable(Variable.<Boolean, Value<Boolean>>builder()
                        .name("hasSoldHouse")
                        .dataType(DataType.BOOLEAN)
                        .build())
                .question("Did you sell a house in 2010?")
                .build();

        Question hasBoughtHouse = Question.builder()
                .variable(Variable.<Boolean, Combinator<Boolean>>builder()
                        .name("hasBoughtHouse")
                        .dataType(DataType.BOOLEAN)
                        .value(Combinator.<Boolean>builder()
                                .operator(CompOp.EQ)
                                .left(Value.<Boolean>builder().dataType(DataType.BOOLEAN).value(Boolean.TRUE).build())
                                .right(Value.<Boolean>builder().dataType(DataType.BOOLEAN).value(Boolean.TRUE).build())
                                .build())
                        .build())
                .question("Did you buy a house in 2010?")
                .build();

        Question hasMaintLoan = Question.builder()
                .variable(Variable.builder()
                        .name("hasMaintLoan")
                        .dataType(DataType.BOOLEAN)
                        .value(hasBoughtHouse.getVariable())
                        .build())
                .question("Did you enter a loan?")
                .build();

        // Conditional expressionReferences
        Question sellingDate = Question.builder()
                .variable(Variable.<LocalDate, Value<LocalDate>>builder()
                        .name("sellingDate")
                        .dataType(DataType.DATE)
                        .build())
                .question("When was the house sold?")
                .build();

        Question sellingPrice = Question.builder()
                .variable(Variable.<CalculatableMoney, Value<CalculatableMoney>>builder()
                        .name("sellingPrice")
                        .dataType(DataType.MONEY)
                        .value(Value.<CalculatableMoney>builder()
                                .dataType(DataType.MONEY)
                                .value(new CalculatableMoney("EUR3000.00"))
                                .build())
                        .build())
                .question("What was the selling price?")
                .build();

        Question privateDebt = Question.builder()
                .variable(Variable.<CalculatableMoney, Value<CalculatableMoney>>builder()
                        .name("privateDebt")
                        .dataType(DataType.MONEY)
                        .value(Value.<CalculatableMoney>builder()
                                .dataType(DataType.MONEY)
                                .value(new CalculatableMoney("EUR1000.0"))
                                .build())
                        .build())
                .question("Private debts for the sold house:")
                .build();

        Question valueResidue = Question.builder()
                .variable(Variable.<CalculatableMoney, Combinator<CalculatableMoney>>builder()
                        .name("valueResidue")
                        .dataType(DataType.MONEY)
                        .value(Combinator.<CalculatableMoney>builder()
                                .left(sellingPrice.getVariable())
                                .operator(ArithOp.MIN)
                                .right(privateDebt.getVariable())
                                .build())
                        .build())
                .question("Value residue:")
                .build();

        IfBlock ifBlock = IfBlock.builder()
                .name("blockSold")
                .condition(hasSoldHouse.getVariable())
                .expressions(new LinkedList<>(Arrays.asList(sellingDate, sellingPrice, privateDebt, valueResidue)))
                .build();

        Question grade = Question.builder()
                .variable(Variable.<CalculatableDouble, Value<CalculatableDouble>>builder()
                        .name("grade")
                        .dataType(DataType.DECIMAL)
                        .value(Value.<CalculatableDouble>builder()
                                .dataType(DataType.DECIMAL)
                                .value(new CalculatableDouble("10.0"))
                                .build())
                        .build())
                .question("How would you rate this questionnaire?")
                .build();

        Form expectedForm = Form.builder()
                .name("taxOfficeExample")
                .formExpressions(new LinkedList<>(Arrays.asList(name, age, hasSoldHouse, hasBoughtHouse, hasMaintLoan, ifBlock, grade)))
                .build();

        Form actualForm = FormBuilder.parseFormFromLocation(INPUT_BASIC_FILE);

        assertEquals(expectedForm.toString(), actualForm.toString());
    }

    @Test
    public void testNullValue() throws IOException {
        // Questions
        Question presetValue = Question.builder()
                .variable(Variable.<String, Value<String>>builder()
                        .name("currentMonth")
                        .dataType(DataType.STRING)
                        .value(Value.<String>builder()
                                .dataType(DataType.STRING)
                                .value("February")
                                .build())
                        .build())
                .question("The current month is")
                .build();

        // Questions
        Question nullValue = Question.builder()
                .variable(Variable.<String , Value<String>>builder()
                        .name("favoriteMonth")
                        .dataType(DataType.STRING)
                        .build())
                .question("What is your favorite month?")
                .build();

        LinkedList<FormExpression> expectedExpressions =
                new LinkedList<>(Arrays.asList(
                        presetValue,
                        nullValue
                ));

        Form expectedForm = Form.builder()
                .name("nullValueTest")
                .formExpressions(expectedExpressions)
                .build();

        Form actualForm = FormBuilder.parseFormFromLocation(INPUT_NULL_TEST);

        assertEquals(expectedForm.toString(), actualForm.toString());
    }
}