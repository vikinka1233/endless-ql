package nl.uva.se.sc.niro.gui.factory

import nl.uva.se.sc.niro.gui.control.{ QLSComboBooleanField, QLSIntegerSpinField, QLSRadioBooleanField, QLWidget }
import nl.uva.se.sc.niro.model.gui._

class QLSWidgetFactory extends QLWidgetFactory {

  override def makeBooleanWidget(question: GUIQuestion): QLWidget[Boolean] = question match {
    case QLSGUIQuestion(_, _, _, _, _, styling) =>
      styling.widgetStyle match {
        case Some(GUIComboBoxStyle(trueLabel, falseLabel)) => new QLSComboBooleanField(trueLabel, falseLabel)
        case Some(GUIRadioStyle(trueLabel, falseLabel))    => new QLSRadioBooleanField(trueLabel, falseLabel)
        case _                                             => super.makeBooleanWidget(question)
      }
    case _ => super.makeBooleanWidget(question)
  }

  override def makeIntegerWidget(question: GUIQuestion): QLWidget[Integer] = question match {
    case QLSGUIQuestion(_, _, _, _, _, styling) =>
      styling.widgetStyle match {
        case Some(GUISpinBoxStyle()) => new QLSIntegerSpinField()
        case _                       => super.makeIntegerWidget(question)
      }
    case _ => super.makeIntegerWidget(question)
  }

}