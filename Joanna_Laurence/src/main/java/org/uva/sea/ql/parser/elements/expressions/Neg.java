package org.uva.sea.ql.parser.elements.expressions;

import org.uva.sea.ql.parser.elements.ASTNode;

public class Neg extends ASTNode {
    private ASTNode value;

    public Neg(ASTNode value) {
        this.value = value;
    }

    public ASTNode getValue() {
        return value;
    }

    public void setValue(ASTNode value) {
        this.value = value;
    }
}

