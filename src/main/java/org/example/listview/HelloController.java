package org.example.listview;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class HelloController {

    @FXML
    private TextField textField;

    @FXML
    private ListView<String> listView;

    // Přidání textu z TextField do ListView
    @FXML
    private void handleAddToList() {
        String input = textField.getText();
        if (input.isEmpty()) {
            // Pokud je TextField prázdný, zobrazit upozornění
            Alert alert = new Alert(Alert.AlertType.WARNING, "Textové pole je prázdné!", ButtonType.OK);
            alert.showAndWait();
        } else {
            listView.getItems().add(input);
            textField.clear(); // Vyčistit pole po přidání
        }
    }

    // Zobrazení upozornění
    @FXML
    private void handleShowAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Upozornění");
        alert.setHeaderText("Informace");
        alert.setContentText("Toto je příklad informačního dialogu.");
        alert.showAndWait();
    }

    // Zadání textu pomocí TextInputDialog
    @FXML
    private void handleGetUserInput() {
        TextInputDialog dialog = new TextInputDialog("Výchozí text");
        dialog.setTitle("Zadání textu");
        dialog.setHeaderText("Zadejte text:");
        dialog.setContentText("Text:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(input -> listView.getItems().add(input));
    }
}
