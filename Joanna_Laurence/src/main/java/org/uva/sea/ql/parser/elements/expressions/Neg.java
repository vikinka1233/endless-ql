package org.uva.sea.ql.parser.elements.expressions;

import org.uva.sea.ql.parser.elements.ASTNode;
import org.uva.sea.ql.parser.elements.types.Type;
import org.uva.sea.ql.parser.nodeTypes.SingleNode;
import org.uva.sea.ql.traverse.Traverse;

public class Neg extends SingleNode {
    public Neg(ASTNode value) {
        super(value);
    }

    public void traverse(Traverse traverse) {
        traverse.doNeg(this);
        this.traverseChildren(traverse);
    }

    public Type getType() {
        return new Type("Boolean");
    }
}

