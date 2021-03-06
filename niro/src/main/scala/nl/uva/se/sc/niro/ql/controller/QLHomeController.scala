package nl.uva.se.sc.niro.ql.controller

import java.io.{ File, IOException }

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Alert.AlertType
import javafx.scene.control.{ Alert, ButtonType, TextArea }
import javafx.stage.{ FileChooser, Stage }
import nl.uva.se.sc.niro.errors.{ Errors, Warning }
import nl.uva.se.sc.niro.ql.application.QLScenes
import nl.uva.se.sc.niro.ql.model.QLModelBridge
import nl.uva.se.sc.niro.ql.model.ast.QLForm
import nl.uva.se.sc.niro.ql.parser.QLFormFacade
import nl.uva.se.sc.niro.util.PrettyPrinter.{ ErrorsCanPrettyPrint, WarningCanPrettyPrint }
import org.apache.logging.log4j.scala.Logging

class QLHomeController extends QLBaseController with Logging {
  // This variable gets it value injected by the FXML loader. Therefor they must be (and stay) defined as 'var'
  @FXML protected var errorMessages: TextArea = _

  override def applicationName(): String = "QL Forms"

  @FXML
  def openForm(event: ActionEvent): Unit = {
    errorMessages.setVisible(false)

    val selectedFile: File = selectQLFile(getActiveStage)
    if (selectedFile != null) try {
      QLFormFacade.importQLSpecification(selectedFile) match {
        case Right(form)  => showForm(form)
        case Left(errors) => handleErrors(errors)
      }
    } catch {
      case e: IOException =>
        errorMessages.setText(s"Reading the QL file failed.\n\n${e.getMessage}")
        errorMessages.setVisible(true)
        logger.error("QL Reading Error", e)
    }
  }

  def selectQLFile(stage: Stage): File = {
    val fileChooser = new FileChooser
    fileChooser.setTitle("Select QL form")
    fileChooser.getExtensionFilters.add(new FileChooser.ExtensionFilter("QL Form files", "*.ql"))
    fileChooser.showOpenDialog(stage)
  }

  def showForm(form: QLForm): Unit = {
    val controller = new QLFormController(this, form, QLModelBridge.convertForm(form))
    if (form.warnings.nonEmpty) showWarning(form.warnings)
    switchToScene(QLScenes.formScene, controller)

    controller.initializeForm()
  }

  def showWarning(warnings: Seq[Warning]): Unit = {
    val alert = new Alert(AlertType.WARNING, s"${warnings.map(_.prettyPrint).mkString("\n")}", ButtonType.OK)
    alert.setTitle("Warning")
    alert.showAndWait()
  }

  def handleErrors(errors: Seq[Errors.Error]): Unit = {
    errorMessages.setText(errors.map(_.prettyPrint).mkString("\n"))
    errorMessages.setVisible(true)
  }
}
