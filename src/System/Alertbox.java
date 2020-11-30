package System;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;


public class Alertbox {
    public static void alert(String title, String head, String message){
        Alert popup = new Alert(Alert.AlertType.INFORMATION);
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle(title);
        popup.setHeaderText(head);
        popup.setContentText(message);
        VBox layout = new VBox(30);
        layout.setAlignment(Pos.CENTER);
        popup.showAndWait();
    }
}