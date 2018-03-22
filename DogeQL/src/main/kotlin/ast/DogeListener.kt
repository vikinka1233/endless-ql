package ast

import QuestionareLanguageParser
import QuestionareLanguageParserBaseListener
import data.question.Question
import data.question.SymbolType
import data.symbol.SymbolTable
import data.value.*
import expression.*
import expression.operation.BinaryOperation
import expression.operation.UnaryOperation
import node.Node

class DogeListener : QuestionareLanguageParserBaseListener() {

    val symbolTable = SymbolTable()
    private val expressionBuilder = ExpressionBuilder()
    private val formTreeBuilder = FormTreeBuilder(symbolTable)


    override fun enterBlock(ctx: QuestionareLanguageParser.BlockContext?) {
        if (!expressionBuilder.isEmpty()) {
            val ifExpression = expressionBuilder.pop()
            val result = symbolTable.registerSymbol(SymbolType.BOOLEAN, ifExpression)

            formTreeBuilder.pushExpression(result.name, ifExpression.sourceLocation)
        }
    }


    override fun exitIfStatement(ctx: QuestionareLanguageParser.IfStatementContext?) {
        formTreeBuilder.build()
    }

    override fun exitQuestionStatement(ctx: QuestionareLanguageParser.QuestionStatementContext?) {
        requireNotNull(ctx)
        val context = ctx!!

        val label = context.LIT_STRING().text
        val name = context.NAME().text
        val type = convertType(context.TYPE().text)

        symbolTable.registerSymbol(name, type)

        if (!expressionBuilder.isEmpty()) {

            val questionExpression = expressionBuilder.pop()

            if (questionExpression.containsReference()) {
                symbolTable.assign(name, type, questionExpression)
            } else {
                symbolTable.assign(name, questionExpression.evaluate(symbolTable))
            }
        }

        val questionNameLocation = SourceLocation(
                context.NAME().symbol.line, context.NAME().symbol.charPositionInLine
        )
        val questionLabelLocation = SourceLocation(
                context.LIT_STRING().symbol.line, context.LIT_STRING().symbol.charPositionInLine
        )
        val question = Question(name, label, type.getDefaultInstance(), questionNameLocation, questionLabelLocation)

        formTreeBuilder.pushQuestion(question)
    }

    override fun exitExpression(ctx: QuestionareLanguageParser.ExpressionContext?) {
        requireNotNull(ctx)

        val context = ctx!!

        context.NAME()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushReferenceExpression(it.text, sourceLocation)
            return
        }

        context.NOT()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushUnaryExpression(UnaryOperation.Negate, sourceLocation)
            return
        }

        context.MUL()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushBinaryExpression(BinaryOperation.Multiply, sourceLocation)
            return
        }

        context.DIV()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushBinaryExpression(BinaryOperation.Divide, sourceLocation)
            return
        }

        context.ADD()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushBinaryExpression(BinaryOperation.Add, sourceLocation)
            return
        }

        context.SUB()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushBinaryExpression(BinaryOperation.Subtract, sourceLocation)
            return
        }

        context.LT()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushBinaryExpression(BinaryOperation.Less, sourceLocation)
            return
        }

        context.GT()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushBinaryExpression(BinaryOperation.Greater, sourceLocation)
            return
        }

        context.LE()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushBinaryExpression(BinaryOperation.LessOrEqual, sourceLocation)
            return
        }

        context.GE()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushBinaryExpression(BinaryOperation.GreaterOrEqual, sourceLocation)
            return
        }

        context.EQUAL()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushBinaryExpression(BinaryOperation.Equal, sourceLocation)
            return
        }

        context.NOTEQUAL()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushBinaryExpression(BinaryOperation.NotEqual, sourceLocation)
            return
        }

        context.AND()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushBinaryExpression(BinaryOperation.And, sourceLocation)
            return
        }

        context.OR()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushBinaryExpression(BinaryOperation.Or, sourceLocation)
            return
        }

    }

    override fun exitLiteral(ctx: QuestionareLanguageParser.LiteralContext?) {
        requireNotNull(ctx)

        val context = ctx!!

        context.LIT_BOOLEAN()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushLiteralExpression(BooleanValue(it.text), sourceLocation)
            return
        }

        context.LIT_INTEGER()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushLiteralExpression(IntegerValue(it.text), sourceLocation)
            return
        }

        context.LIT_DECIMAL()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushLiteralExpression(DecimalValue(it.text), sourceLocation)
            return
        }

        context.LIT_STRING()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushLiteralExpression(StringValue(it.text), sourceLocation)
            return
        }

        context.LIT_COLOR()?.let {
            val sourceLocation = SourceLocation(it.symbol.line, it.symbol.charPositionInLine)
            pushLiteralExpression(ColorValue(it.text), sourceLocation)
            return
        }
    }

    private fun pushLiteralExpression(value: BaseSymbolValue, sourceLocation: SourceLocation) {
        expressionBuilder.push(
                LiteralExpression(value, sourceLocation)
        )
    }

    private fun pushReferenceExpression(name: String, sourceLocation: SourceLocation) {
        expressionBuilder.push(
                ReferenceExpression(name, SymbolType.UNDEFINED, sourceLocation)
        )
    }

    private fun pushUnaryExpression(operation: UnaryOperation, sourceLocation: SourceLocation) {
        val value = expressionBuilder.pop()

        expressionBuilder.push(
                UnaryExpression(value, operation, sourceLocation)
        )
    }

    private fun pushBinaryExpression(operation: BinaryOperation, sourceLocation: SourceLocation) {
        val right = expressionBuilder.pop()
        val left = expressionBuilder.pop()

        expressionBuilder.push(
                BinaryExpression(left, right, operation, sourceLocation)
        )
    }

    private fun convertType(type: String) = when (type) {
        "boolean" -> SymbolType.BOOLEAN
        "int" -> SymbolType.INTEGER
        "string" -> SymbolType.STRING
        "money" -> SymbolType.MONEY
        "decimal" -> SymbolType.DECIMAL
        "date" -> SymbolType.DATE
        "color" -> SymbolType.COLOR
        else -> SymbolType.UNDEFINED
    }

    fun getParsedDogeLanguage(): Node {
        return formTreeBuilder.build()
    }
}