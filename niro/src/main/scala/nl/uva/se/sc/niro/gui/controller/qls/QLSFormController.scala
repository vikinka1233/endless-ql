package nl.uva.se.sc.niro.gui.controller.qls

import javafx.fxml.FXML
import javafx.geometry.Insets
import javafx.scene.control.{ Label, Pagination }
import nl.uva.se.sc.niro.gui.component.Component
import nl.uva.se.sc.niro.gui.component.qls.QLSPageFactory
import nl.uva.se.sc.niro.gui.controller.ql.{ QLFormController, QLHomeController }
import nl.uva.se.sc.niro.model.gui.ql.GUIForm
import nl.uva.se.sc.niro.model.gui.qls.GUIStylesheet
import nl.uva.se.sc.niro.model.ql.QLForm
import nl.uva.se.sc.niro.util.StringUtil

class QLSFormController(homeController: QLHomeController, model: QLForm, guiForm: GUIForm, stylesheet: GUIStylesheet)
    extends QLFormController(homeController, model, guiForm) {

  private val pagination = new Pagination()
  private val pageName: Label = new Label("Page Name")
  override def applicationName(): String = "QLS Forms"

  @FXML
  def initialize(): Unit = {
    applyStylingToPageName()
    topBox.getChildren.add(pageName)
  }

  def applyStylingToPageName(): Unit = {
    pageName.setPadding(new Insets(10.0, 0.0, 0.0, 0.0))
    pageName.getStyleClass.add("-fx-font-size: 18pt;")
  }

  override def initializeForm(): Unit = {
    pagination.setPageCount(stylesheet.pages.size)
    pagination.setPadding(new Insets(00.0, 20.0, 00.0, 20.0))
    pagination.setPageFactory(new QLSPageFactory(this, guiForm, stylesheet))

    questionArea.setContent(pagination)
    questionArea.setFitToHeight(true)
    questionArea.setFitToWidth(true)

    getActiveStage.setTitle("QLS forms")
    formName.setText(guiForm.name)

    evaluateAnswers()
  }

  override def updateView(): Unit = {
    updatePageTitle()
    super.updateView()
  }

  private def updatePageTitle(): Unit = {
    val pageToShow = stylesheet.pages(pagination.getCurrentPageIndex)
    pageName.setText(StringUtil.addSpaceOnCaseChange(pageToShow.name))
  }

  def setQuestionControls(questionComponents: Seq[Component[_]]): Unit = this.questionComponents = questionComponents
}