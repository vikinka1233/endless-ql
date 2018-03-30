from antlr4 import *
from pyqls.antlr.QLSParser import QLSParser
from pyqls.antlr.QLSVisitor import QLSVisitor
from pyqls.antlr.QLSLexer import QLSLexer
from pyqls.ast.nodes.stylesheet import *
from pyqls.ast.nodes.block import *
from pyqls.ast.nodes.page import *
from pyqls.ast.nodes.section import *
from pyqls.ast.nodes.statement import *
from pyqls.ast.nodes.widget import *
from util.code_location import CodeLocation
from util.types import *


class ParseTreeVisitor(QLSVisitor):

    def visitStyleSheet(self, ctx: QLSParser.StyleSheetContext):
        return StyleSheet(self.location(ctx), ctx.identifier().accept(self), ctx.styleSheetBlock().accept(self))

    def visitStyleSheetBlock(self, ctx: QLSParser.StyleSheetBlockContext):
        return Block(self.location(ctx), [x.accept(self) for x in ctx.styleSheetStatement()])

    def visitStyleSheetPageStatement(self, ctx: QLSParser.StyleSheetPageStatementContext):
        return Page(self.location(ctx), ctx.identifier().accept(self), ctx.pageBlock().accept(self))

    def visitStyleSheetDefaultStatement(self, ctx: QLSParser.StyleSheetDefaultStatementContext):
        return self.visitChildren(ctx)

    def visitPageBlock(self, ctx: QLSParser.PageBlockContext):
        return Block(self.location(ctx), [x.accept(self) for x in ctx.pageStatement()])

    def visitSingleStatementSection(self, ctx: QLSParser.SingleStatementSectionContext):
        return Section(self.location(ctx), ctx.STRING(), [ctx.identifier().accept(self)])

    def visitMultiStatementSection(self, ctx: QLSParser.MultiStatementSectionContext):
        return Section(self.location(ctx), ctx.STRING(), ctx.sectionBlock().accept(self))

    def visitDefaultPageStatement(self, ctx: QLSParser.DefaultPageStatementContext):
        return self.visitChildren(ctx)

    def visitSectionBlock(self, ctx: QLSParser.SectionBlockContext):
        return Block(self.location(ctx), [x.accept(self) for x in ctx.statement()])

    def visitQuestionStatement(self, ctx: QLSParser.QuestionStatementContext):
        return Question(self.location(ctx), ctx.identifier().accept(self))

    def visitQuestionStyleStatement(self, ctx: QLSParser.QuestionStyleStatementContext):
        return self.visitChildren(ctx)

    def visitSectionStatement(self, ctx: QLSParser.SectionStatementContext):
        return self.visitChildren(ctx)

    def visitQuestionStyle(self, ctx: QLSParser.QuestionStyleContext):
        return QuestionStyle(self.location(ctx), ctx.identifier().accept(self), ctx.widget().accept(self))

    def visitWidget(self, ctx: QLSParser.WidgetContext):
        return Widget(self.location(ctx), ctx.widgetType().accept(self))

    def visitRadioWidget(self, ctx: QLSParser.RadioWidgetContext):
        return Radio(self.location(ctx), [x.getText() for x in ctx.STRING()])

    def visitDropdownWidget(self, ctx: QLSParser.DropdownWidgetContext):
        return DropDown(self.location(ctx), [x.getText() for x in ctx.STRING()])

    def visitSpinboxWidget(self, ctx: QLSParser.SpinboxWidgetContext):
        return SpinBox(self.location(ctx))

    def visitCheckboxWidget(self, ctx: QLSParser.CheckboxWidgetContext):
        return CheckBox(self.location(ctx))

    def visitSliderWidget(self, ctx: QLSParser.SliderWidgetContext):
        return Slider(self.location(ctx))

    def visitTextWidget(self, ctx: QLSParser.TextWidgetContext):
        return Text(self.location(ctx))

    def visitDefaultStatement(self, ctx: QLSParser.DefaultStatementContext):
        return Default(self.location(ctx), ctx.questionType().accept(self), ctx.widget().accept(self))

    def visitBooleanType(self, ctx: QLSParser.BooleanTypeContext):
        return Boolean()

    def visitStringType(self, ctx: QLSParser.StringTypeContext):
        return String()

    def visitIntegerType(self, ctx: QLSParser.IntegerTypeContext):
        return Integer()

    def visitDateType(self, ctx: QLSParser.DateTypeContext):
        return Date()

    def visitDecimalType(self, ctx: QLSParser.DecimalTypeContext):
        return Decimal()

    def visitMoneyType(self, ctx: QLSParser.MoneyTypeContext):
        return Money()

    def visitIdentifier(self, ctx: QLSParser.IdentifierContext):
        return ctx.getText()

    def location(self, context):
        return CodeLocation(context.start.line, context.start.column)


if __name__ == "__main__":
    input = FileStream("../antlr/example.qls")
    lexer = QLSLexer(input)
    stream = CommonTokenStream(lexer)
    parser = QLSParser(stream)
    parse_tree = parser.styleSheet()

    visitor = ParseTreeVisitor()
    ast = parse_tree.accept(visitor)
    print("End")
