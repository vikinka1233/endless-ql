package org.uva.jomi.qls.ast.statements.widget;

public class TextWidgetStmt extends WidgetStmt {

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
