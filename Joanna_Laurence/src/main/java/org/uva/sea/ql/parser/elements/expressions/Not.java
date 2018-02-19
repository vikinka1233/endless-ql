package org.uva.sea.ql.parser.elements.expressions;

import org.uva.sea.ql.parser.elements.ASTNode;
import org.uva.sea.ql.parser.elements.TraverseType;
import org.uva.sea.ql.parser.elements.types.Type;
import org.uva.sea.ql.parser.nodeTypes.SingleNode;
import org.uva.sea.ql.traverse.Traverse;

public class Not extends SingleNode {
    public Not(ASTNode value) {
        super(value);
    }

    public void traverseNode(Traverse traverse, TraverseType traverseType) {
        traverse.doNot(this);
    }

    public Type getType() {
        return new Type("boolean");
    }
}
