package Nodes.Operator;

import Nodes.ASTNode;
import Nodes.Term.Term;
import QLExceptions.*;

public abstract class Operator extends ASTNode {
    private String value;

    public Operator(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * Fallback method that throws a TypeException, because the specific calculate function isn't implemented for the given types
     * @param left left hand side of the Operator
     * @param right right hand side of the operator
     * @return A new intermediary Term with the result of the calculation
     * @throws SyntaxException When there is an invalid Operator
     * @throws TypeException When types don't match
     */
    public Term calculate(Term left, Term right) throws SyntaxException, TypeException {
        throw new TypeException();
    }
}
