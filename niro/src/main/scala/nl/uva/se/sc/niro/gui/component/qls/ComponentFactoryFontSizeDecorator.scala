package nl.uva.se.sc.niro.gui.component.qls

import nl.uva.se.sc.niro.gui.component.{ Component, ComponentFactory }
import nl.uva.se.sc.niro.ql.model.gui.GUIQuestion
import nl.uva.se.sc.niro.qls.model.gui.QLSGUIQuestion

class ComponentFactoryFontSizeDecorator(componentFactory: ComponentFactory) extends ComponentFactory {
  override def make(question: GUIQuestion): Component[_] = question match {
    case qlsQuestion: QLSGUIQuestion =>
      val component = componentFactory.make(question)
      qlsQuestion.styling.fontSize.foreach(fontSize =>
        component.setStyle(s"-fx-font-size: ${fontSize.fontSize}; ${component.getStyle}"))
      component
    case _ => componentFactory.make(question)
  }
}
