package nl.uva.se.sc.niro.gui.converter

import nl.uva.se.sc.niro.gui.factory.{ GUIConditionalFactory, GUIQuestionFactory }
import nl.uva.se.sc.niro.ql.model.ast.expressions.Expression
import nl.uva.se.sc.niro.ql.model.ast.expressions.answers.BooleanAnswer
import nl.uva.se.sc.niro.ql.model.ast.{ Conditional, QLForm, Question, Statement }
import nl.uva.se.sc.niro.ql.model.gui.{ GUIForm, GUIQuestion }
import nl.uva.se.sc.niro.util.StringUtil

/**
  * Converts a AST model into a GUI model. During this conversion the AST model is flattened. In the GUI model the
  * questions are represented as a list. If a question in the AST appears within a (nested) if-construct the
  * visibility property of GUI question will consist of all intermediate expressions logical 'and'ed to ensure the
  * desired behaviour.
  */
object QLToGUIModelBridge {
  def convertForm(form: QLForm): GUIForm = {
    GUIForm(StringUtil.addSpaceOnCaseChange(form.formName), convertStatements(BooleanAnswer(true), form.statements))
  }

  def convertStatements(visible: Expression, statements: Seq[Statement]): Seq[GUIQuestion] = {
    statements.flatMap(statement =>
      statement match {
        case question: Question =>
          Seq(GUIQuestionFactory.makeGUIQuestion(visible, question))
        case conditional: Conditional =>
          GUIConditionalFactory.makeGUIConditional(visible, conditional)
        case _ =>
          Seq.empty
    })
  }

}
