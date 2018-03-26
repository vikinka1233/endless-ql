package org.uva.sea.languages;

import org.uva.sea.languages.ql.interpreter.Evaluator;
import org.uva.sea.languages.ql.interpreter.dataObject.EvaluationResult;
import org.uva.sea.languages.ql.interpreter.evaluate.SymbolTable;
import org.uva.sea.languages.ql.interpreter.evaluate.valueTypes.Value;

import java.io.IOException;

/**
 * Converts QL file to a list of questions
 */
public class QlEvaluator implements BaseEvaluator {

    private final Evaluator evaluator = new Evaluator();

    private final SymbolTable symbolTable = new SymbolTable();

    private final String qlFileLocation;

    /**
     * Constructor
     *
     * @param fileLocation Location of the QL file
     */
    public QlEvaluator(String fileLocation) {
        this.qlFileLocation = fileLocation;
    }

    /**
     * Generate EvaluationResult
     *
     * @return EvaluationResult
     */
    public EvaluationResult getQuestions() throws IOException, InterruptedException {
        return this.evaluator.evaluate(this.qlFileLocation, this.symbolTable);
    }

    /**
     * @param name  Name of the variable
     * @param value Value of the variable
     */
    public void setVariable(String name, Value value) {
        this.symbolTable.addOrUpdateValue(name, value);
    }
}
