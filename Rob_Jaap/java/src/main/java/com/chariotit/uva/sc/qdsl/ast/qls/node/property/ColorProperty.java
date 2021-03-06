package com.chariotit.uva.sc.qdsl.ast.qls.node.property;

import com.chariotit.uva.sc.qdsl.ast.common.SourceFilePosition;
import com.chariotit.uva.sc.qdsl.ast.qls.node.Property;
import com.chariotit.uva.sc.qdsl.ast.qls.visitor.NodeVisitor;

public class ColorProperty extends Property {

    private String color;

    public ColorProperty(String color, SourceFilePosition filePosition) {
        super(filePosition);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void acceptVisitor(NodeVisitor visitor) {
        visitor.visitColorProperty(this);
    }
}
