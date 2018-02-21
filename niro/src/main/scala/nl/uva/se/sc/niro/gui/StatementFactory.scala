package nl.uva.se.sc.niro.gui

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javafx.beans.value.{ ChangeListener, ObservableValue }
import javafx.scene.layout.{ HBox, VBox }
import javafx.scene.Parent
import javafx.scene.control.{ CheckBox, DatePicker, Label, TextField }
import javafx.util.StringConverter

import nl.uva.se.sc.niro.model.Ast._
import nl.uva.se.sc.niro.model.Expressions.Expression
import nl.uva.se.sc.niro.model.Expressions.Expression.Answer
import nl.uva.se.sc.niro.model.Expressions.answers._

import scala.collection.JavaConverters

object StatementFactory {

  def createStatements(statements: Seq[Statement]) : java.util.List[Parent] = {
    JavaConverters.seqAsJavaList(statements.map(this.convert))
  }

  def convert(question: Question): Parent = {
    new HBox(new Label(question.label), convert(Expression.evaluate(question.answer)))
  }

  def convert(conditional: Conditional): Parent = {
    val thenPane = new VBox()
    thenPane.setSpacing(10)
    // When invisible we don't occupy any space
    thenPane.managedProperty().bind(thenPane.visibleProperty())

    thenPane.getChildren.addAll(this.createStatements(conditional.ifStatements))

    val elsePane = new VBox()
    elsePane.setSpacing(10)
    // When invisible we don't occupy any space
    elsePane.managedProperty().bind(elsePane.visibleProperty())
    // Exclusive visibility with thenPane
    elsePane.visibleProperty().bind(thenPane.visibleProperty().not())

    elsePane.getChildren.addAll(this.createStatements(conditional.elseStatements))

    new VBox(thenPane, elsePane)
  }

  def convert(statement: Statement): Parent = {
    statement match {
      case question: Question => convert(question)
      case conditional: Conditional => convert(conditional)
    }
  }

  def convert(answer: Answer): Parent = {
    answer match {
      case _: BooleanAnswer => new CheckBox()
      case _: StringAnswer => new TextField()
      case _: IntAnswer => createIntegerField()
      case _: DecAnswer => createDecimalField()
      case _: MoneyAnswer => createDecimalField()
      case _: DateAnswer => createDateField
      case other => new Label(s"Unimplemented type: $other")
    }
  }

  private def createIntegerField(): Parent = {
    createRegExField("\\d+")
  }

  private def createDecimalField(): Parent = {
    createRegExField("\\d*(,\\d{0,2})?")
  }

  private def createRegExField(validPattern: String): Parent = {
    val regexField = new TextField()
    regexField.textProperty().addListener(new ChangeListener[String] {
      override def changed(observable: ObservableValue[_ <: String], oldValue: String, newValue: String): Unit = {
        if (!newValue.matches(validPattern)) {
          regexField.setText(oldValue)
        }
      }
    })
    regexField
  }

  private def createDateField: Parent = {
    val dateField = new DatePicker()
    dateField.setConverter(new StringConverter[LocalDate] {
      val dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy")

      override def toString(date: LocalDate): String = {
        if (date != null) dateFormat.format(date) else null
      }

      override def fromString(string: String): LocalDate = {
        if (string != null && !string.isEmpty) LocalDate.parse(string, dateFormat) else null
      }
    })
    dateField
  }

}
