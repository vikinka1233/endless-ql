package doge.typechecker.scope

import doge.ast.location.Identifier
import doge.ast.node.Block
import doge.ast.node.Form
import doge.ast.node.IfStatement
import doge.ast.node.QuestionStatement
import doge.ast.node.expression.BinaryExpression
import doge.ast.node.expression.LiteralExpression
import doge.ast.node.expression.ReferenceExpression
import doge.ast.node.expression.UnaryExpression
import doge.visitor.QuestionnaireASTBaseVisitor
import java.util.*

class ScopeVisitor(val context: ScopeErrorContext) : QuestionnaireASTBaseVisitor<Unit> {

    private val definitions = ArrayDeque<Identifier>()
    private val references = ArrayDeque<Identifier>()

    override fun visit(form: Form) {
        visit(form.block)
    }

    override fun visit(block: Block) {
        val numDefinitions = definitions.size
        val numReferences = references.size

        block.statements.forEach { visit(it) }

        context.errors += references.filter { reference ->
            definitions.find { definition ->
                definition.text == reference.text
            } == null
        }

        while (definitions.size > numDefinitions) {
            definitions.pop()
        }

        while (references.size > numReferences) {
            references.pop()
        }
    }

    override fun visit(ifStatement: IfStatement) {
        visit(ifStatement.block)
        visit(ifStatement.expression)
    }

    override fun visit(questionStatement: QuestionStatement) {
        definitions.push(questionStatement.name)

        questionStatement.expression?.let {
            visit(it)
        }
    }

    override fun visit(binaryExpression: BinaryExpression) {
        visit(binaryExpression.left)
        visit(binaryExpression.right)
    }

    override fun visit(unaryExpression: UnaryExpression) {
        visit(unaryExpression.next)
    }

    override fun visit(referenceExpression: ReferenceExpression) {
        references.push(referenceExpression.name)
    }

    override fun visit(literalExpression: LiteralExpression) {

    }
}