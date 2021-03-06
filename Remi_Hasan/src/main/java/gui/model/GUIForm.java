package gui.model;

import gui.components.LabelWithWidget;
import gui.render.GUIController;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.List;

public class GUIForm extends VBox implements IRenderable {
    public final String identifier;
    private final List<GUIQuestion> guiQuestions;

    public GUIForm(String identifier, List<GUIQuestion> guiQuestions) {
        this.identifier = identifier;
        this.guiQuestions = guiQuestions;
    }

    public List<GUIQuestion> getQuestions() {
        return this.guiQuestions;
    }

    public Parent render(GUIController guiController) {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));

        // Render all QL questions in order
        for (GUIQuestion guiQuestion : this.guiQuestions) {
            LabelWithWidget labelWithWidget = guiQuestion.render(guiController);
            vBox.getChildren().add(labelWithWidget);
        }

        guiController.updateQuestionWidgets();

        // Wrap form in scroll pane, so questions will always be reachable
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vBox);

        // Bind scrollPane height to window height
        VBox.setVgrow(scrollPane, Priority.ALWAYS);

        return scrollPane;
    }
}