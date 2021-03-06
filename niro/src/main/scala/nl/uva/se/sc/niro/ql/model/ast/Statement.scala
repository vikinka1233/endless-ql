package nl.uva.se.sc.niro.ql.model.ast

import nl.uva.se.sc.niro.ql.model.ast.expressions.Expression

// format: off
sealed trait Statement
case class Question     (id: String, label: String, answerType: AnswerType, expression: Option[Expression]) extends Statement
case class Conditional  (predicate: Expression, thenStatements: Seq[Statement])                             extends Statement
// format: on

object Statement {

  def collectAllQuestions(statements: Seq[Statement]): Seq[Question] = {
    statements.flatMap {
      case q: Question    => Seq(q)
      case c: Conditional => collectAllQuestions(c.thenStatements)
    }
  }

  def collectAllConditionals(statements: Seq[Statement]): Seq[Conditional] = {
    statements.flatMap {
      case _: Question    => Seq.empty
      case c: Conditional => Seq(c) ++ collectAllConditionals(c.thenStatements)
    }
  }

  def collectAllExpressions(statements: Seq[Statement]): Seq[Expression] = {
    statements.flatMap {
      case q: Question    => q.expression.toList
      case c: Conditional => Seq(c.predicate) ++ collectAllExpressions(c.thenStatements)
    }
  }
}
