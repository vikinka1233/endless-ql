package expression

import data.question.SymbolType
import data.value.BaseSymbolValue
import expression.visitor.evaluation.EvaluationVisitor
import expression.visitor.evaluation.TypeVisitor
import expression.visitor.reference.ReferenceCollector
import expression.visitor.reference.ReferenceVisitor

class LiteralExpression(val value: BaseSymbolValue) : Expression {

    override fun accept(visitor: EvaluationVisitor): BaseSymbolValue {
        return visitor.visit(this)
    }

    override fun accept(visitor: TypeVisitor): SymbolType {
        return visitor.visit(this)
    }

    override fun accept(visitor: ReferenceVisitor): Boolean {
        return visitor.visit(this)
    }

    override fun accept(visitor: ReferenceCollector) {
        return visitor.visit(this)
    }

}