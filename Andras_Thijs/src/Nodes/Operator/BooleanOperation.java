package Nodes.Operator;

import Nodes.Term.QLBoolean;
import Nodes.Term.Term;
import QLExceptions.*;

public class BooleanOperation extends Operator {
    /**
     * Constructor that just calls the default constructor.
     * @param value the Boolean operator.
     */
    public BooleanOperation(String value) {
        super(value);
    }

    /**
     * Implements a Boolean operator (&& and ||).
     * @param left left hand side of the operator.
     * @param right right hand side of the operator.
     * @return A new intermediary QLBoolean Term with the result of the calculation.
     * @throws TypeException when left and right aren't Booleans.
     * @throws SyntaxException when the value of this Operator is not && or ||.
     */
    public QLBoolean calculate(Term left, Term right) throws TypeException, SyntaxException {
        // Apply the correct implementation. Throw a SyntaxException for invalid operators.
        // When either left or right is not a QLBoolean, a TypeException will be thrown.
        switch(this.getValue()) {
            case "&&": return new QLBoolean(left.getBoolean() && right.getBoolean());
            case "||": return new QLBoolean(left.getBoolean() && right.getBoolean());
            default: throw new SyntaxException("Invalid boolean operator", this);
        }
    }
}
