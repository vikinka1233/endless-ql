package qls.ast;

import ql.ast.ASTNode;
import ql.ast.SourceLocation;
import qls.ast.components.Component;
import qls.ast.defaultrules.DefaultRule;
import qls.ast.visitors.StylesheetPageVisitor;

import java.util.List;

public class Page extends ASTNode {

    private final String pageId;
    private final List<Component> components;
    private final List<DefaultRule> rules;

    public Page(String pageId, List<Component> components, List<DefaultRule> rules, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.pageId = pageId;
        this.components = components;
        this.rules = rules;
    }

    public String getPageId() {
        return pageId;
    }

    public List<Component> getComponents() {
        return components;
    }

    public List<DefaultRule> getRules() {
        return rules;
    }

    public <T> T accept(StylesheetPageVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
