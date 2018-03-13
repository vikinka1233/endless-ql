package QLSVisitor;

import ParseObjectQLS.Page;
import ParseObjectQLS.Stylesheet;
import QLSAntlrGen.QLSBaseVisitor;
import QLSAntlrGen.QLSParser;

import java.util.ArrayList;


public class StylesheetVisitor extends QLSBaseVisitor<Stylesheet> {



    @Override
    public Stylesheet visitHead(QLSParser.HeadContext ctx){
        ArrayList<Page> pages = new ArrayList<>();
        PageVisitor pageVisitor = new PageVisitor();
        for(QLSParser.PageContext pageCtx : ctx.block().page()){
            Page page = pageVisitor.visitPage(pageCtx);
            pages.add(page);
        }

        return new Stylesheet(pages, ctx.IDENTIFIER().getText());
    }
}
