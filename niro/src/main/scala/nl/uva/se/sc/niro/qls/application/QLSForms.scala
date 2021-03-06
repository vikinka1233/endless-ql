package nl.uva.se.sc.niro.qls.application

import javafx.application.Application
import javafx.stage.Stage
import nl.uva.se.sc.niro.ql.application.{ QLForms, QLScenes }
import nl.uva.se.sc.niro.qls.controller.QLSHomeController

object QLSForms {
  def main(args: Array[String]): Unit = Application.launch(classOf[QLSForms], args: _*)
}

class QLSForms extends QLForms {
  override def start(stage: Stage): Unit = {
    showScene(stage, QLScenes.homeScene, new QLSHomeController())
    stage.setTitle("QLS Forms")
  }
}
