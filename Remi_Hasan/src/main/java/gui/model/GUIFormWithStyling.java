package gui.model;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import ql.analysis.SymbolTable;
import qls.model.Page;
import qls.model.StyleSheet;

import java.util.List;

public class GUIFormWithStyling extends GUIForm {

    private final StyleSheet stylesheet;

    public GUIFormWithStyling(String identifier, List<GUIQuestion> guiQuestions, StyleSheet stylesheet) {
        super(identifier, guiQuestions);
        this.stylesheet = stylesheet;
    }


    @Override
    public Parent render(SymbolTable symbolTable) {
//        Parent parent = super.render(symbolTable);

        VBox vBox = new VBox();
        // Style questions
        for (Page page : stylesheet.getPages()) {
            GUIPage guiPage = new GUIPage(page.identifier, guiQuestions, page.getSections(), page.getDefaultStyles());
            vBox.getChildren().add(guiPage.render(symbolTable));
        }

        return vBox;
    }
}