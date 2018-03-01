package nl.uva.se.sc.niro.gui

import java.lang
import java.time.LocalDate

import javafx.beans.value.{ ChangeListener, ObservableValue }
import javafx.scene.Node
import javafx.scene.control.{ CheckBox, DatePicker, Label, TextField }
import javafx.scene.layout.GridPane
import javafx.util.StringConverter
import nl.uva.se.sc.niro.gui.util.HierarchyUtil
import nl.uva.se.sc.niro.model.Expressions.answers._
import nl.uva.se.sc.niro.model._

import scala.collection.JavaConverters

object CreateCallbackVisitor {
  def visit(modelUpdater: ModelUpdater, grid: GridPane, statements: Seq[Statement]): Unit = {
    val controls = JavaConverters.asScalaBuffer(grid.getChildren).filterNot(node => node.isInstanceOf[Label])

    controls.zip(statements) foreach {
      case (control, statement) =>
        statement match {
          case Question(questionId, _, answerType, _, _) => visitQuestion(modelUpdater, control, questionId, answerType)
          case Conditional(_, thenStatements)            => visit(modelUpdater, control.asInstanceOf[GridPane], thenStatements)
          case ErrorStatement()                          => ()
        }
    }
  }

  def visitQuestion(modelUpdater: ModelUpdater, control: Node, questionId: String, answerType: AnswerType): Unit = {
    answerType match {
      case BooleanType =>
        val checkbox: CheckBox = HierarchyUtil.downcast(control)
        checkbox
          .selectedProperty()
          .addListener(new ChangeListener[lang.Boolean] {
            override def changed(
                observable: ObservableValue[_ <: lang.Boolean],
                oldValue: lang.Boolean,
                newValue: lang.Boolean): Unit =
              modelUpdater.updateModel(questionId, BooleanAnswer(newValue))
          })
      case IntegerType =>
        val textField: TextField = HierarchyUtil.downcast(control)
        textField
          .textProperty()
          .addListener(new ChangeListener[String] {
            override def changed(observable: ObservableValue[_ <: String], oldValue: String, newValue: String): Unit =
              modelUpdater.updateModel(questionId, IntAnswer(newValue))
          })
      case DecimalType =>
        val textField: TextField = HierarchyUtil.downcast(control)
        textField
          .textProperty()
          .addListener(new ChangeListener[String] {
            override def changed(observable: ObservableValue[_ <: String], oldValue: String, newValue: String): Unit =
              modelUpdater.updateModel(questionId, DecAnswer(newValue))
          })
      case MoneyType =>
        val textField: TextField = HierarchyUtil.downcast(control)
        textField
          .textProperty()
          .addListener(new ChangeListener[String] {
            override def changed(observable: ObservableValue[_ <: String], oldValue: String, newValue: String): Unit =
              modelUpdater.updateModel(questionId, MoneyAnswer(newValue))
          })
      case StringType =>
        val textField: TextField = HierarchyUtil.downcast(control)
        textField
          .textProperty()
          .addListener(new ChangeListener[String] {
            override def changed(observable: ObservableValue[_ <: String], oldValue: String, newValue: String): Unit =
              modelUpdater.updateModel(questionId, StringAnswer(newValue))
          })
      case DateType =>
        val datePicker: DatePicker = HierarchyUtil.downcast(control)
        datePicker
          .converterProperty()
          .addListener(new ChangeListener[StringConverter[LocalDate]] {
            override def changed(
                observable: ObservableValue[_ <: StringConverter[LocalDate]],
                oldValue: StringConverter[LocalDate],
                newValue: StringConverter[LocalDate]): Unit =
              modelUpdater.updateModel(questionId, DateAnswer(""))
          })
      case _ => ()
    }
  }
}
