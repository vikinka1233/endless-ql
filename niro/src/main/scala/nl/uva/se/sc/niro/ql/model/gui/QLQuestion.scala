package nl.uva.se.sc.niro.ql.model.gui

import nl.uva.se.sc.niro.ql.model.ast.AnswerType
import nl.uva.se.sc.niro.ql.model.ast.expressions.Expression

case class QLQuestion(
    override val id: String,
    override val answerType: AnswerType,
    override val label: String,
    override val isReadOnly: Boolean,
    override val visibility: Expression
) extends Question(id, answerType, label, isReadOnly, visibility, component = None)
