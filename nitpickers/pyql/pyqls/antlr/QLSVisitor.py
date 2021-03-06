# Generated from QLS.g4 by ANTLR 4.7
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .QLSParser import QLSParser
else:
    from QLSParser import QLSParser

# This class defines a complete generic visitor for a parse tree produced by QLSParser.

class QLSVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by QLSParser#qlsObject.
    def visitQlsObject(self, ctx:QLSParser.QlsObjectContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#styleSheet.
    def visitStyleSheet(self, ctx:QLSParser.StyleSheetContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#styleSheetBlock.
    def visitStyleSheetBlock(self, ctx:QLSParser.StyleSheetBlockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#styleSheetPageStatement.
    def visitStyleSheetPageStatement(self, ctx:QLSParser.StyleSheetPageStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#styleSheetDefaultStatement.
    def visitStyleSheetDefaultStatement(self, ctx:QLSParser.StyleSheetDefaultStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#pageBlock.
    def visitPageBlock(self, ctx:QLSParser.PageBlockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#singleStatementSection.
    def visitSingleStatementSection(self, ctx:QLSParser.SingleStatementSectionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#multiStatementSection.
    def visitMultiStatementSection(self, ctx:QLSParser.MultiStatementSectionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#defaultPageStatement.
    def visitDefaultPageStatement(self, ctx:QLSParser.DefaultPageStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#sectionBlock.
    def visitSectionBlock(self, ctx:QLSParser.SectionBlockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#questionStatement.
    def visitQuestionStatement(self, ctx:QLSParser.QuestionStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#questionStyleStatement.
    def visitQuestionStyleStatement(self, ctx:QLSParser.QuestionStyleStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#sectionStatement.
    def visitSectionStatement(self, ctx:QLSParser.SectionStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#questionStyle.
    def visitQuestionStyle(self, ctx:QLSParser.QuestionStyleContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#widget.
    def visitWidget(self, ctx:QLSParser.WidgetContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#radioWidget.
    def visitRadioWidget(self, ctx:QLSParser.RadioWidgetContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#dropdownWidget.
    def visitDropdownWidget(self, ctx:QLSParser.DropdownWidgetContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#spinboxWidget.
    def visitSpinboxWidget(self, ctx:QLSParser.SpinboxWidgetContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#checkboxWidget.
    def visitCheckboxWidget(self, ctx:QLSParser.CheckboxWidgetContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#sliderWidget.
    def visitSliderWidget(self, ctx:QLSParser.SliderWidgetContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#textWidget.
    def visitTextWidget(self, ctx:QLSParser.TextWidgetContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#simpleDefault.
    def visitSimpleDefault(self, ctx:QLSParser.SimpleDefaultContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#defaultWithBody.
    def visitDefaultWithBody(self, ctx:QLSParser.DefaultWithBodyContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#defaultBody.
    def visitDefaultBody(self, ctx:QLSParser.DefaultBodyContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#styleRules.
    def visitStyleRules(self, ctx:QLSParser.StyleRulesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#width.
    def visitWidth(self, ctx:QLSParser.WidthContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#font.
    def visitFont(self, ctx:QLSParser.FontContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#fontsize.
    def visitFontsize(self, ctx:QLSParser.FontsizeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#color.
    def visitColor(self, ctx:QLSParser.ColorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#booleanType.
    def visitBooleanType(self, ctx:QLSParser.BooleanTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#stringType.
    def visitStringType(self, ctx:QLSParser.StringTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#integerType.
    def visitIntegerType(self, ctx:QLSParser.IntegerTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#decimalType.
    def visitDecimalType(self, ctx:QLSParser.DecimalTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#moneyType.
    def visitMoneyType(self, ctx:QLSParser.MoneyTypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#identifier.
    def visitIdentifier(self, ctx:QLSParser.IdentifierContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLSParser#filename.
    def visitFilename(self, ctx:QLSParser.FilenameContext):
        return self.visitChildren(ctx)



del QLSParser