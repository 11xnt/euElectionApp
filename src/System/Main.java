package System;
/*****************************************
 * @author Allen Terescenco & Milan Ples *
 * Elections Information System v1.0     *
 *****************************************/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

///Main Class///
public class Main extends Application {

    ///Launches Application///
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Gets FXML
        Parent root = FXMLLoader.load(getClass().getResource("Application.fxml"));
        //Sets title
        primaryStage.setTitle("Political System");
        //Sets window size
        primaryStage.setScene(new Scene(root, 1282, 850));
        //Shows GUI
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
