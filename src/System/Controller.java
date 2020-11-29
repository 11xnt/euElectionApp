package System;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public AnchorPane image;
    @FXML
    //all of the tabs in GUI
    TabPane tabPane;

    @FXML
    // each tab we will use to connect the dots.
    Tab addPoliticianTab, addElectionTab, addCandidateTab, updateDeleteTab, searchTab, saveLoadTab;

    @FXML
    // Text fields for each of the tabs to access. **more will be added as the GUI is built.
    TextField politicianName, politicalParty, dateOfBirth, imageUrl, electionType, countyLocation, electionYear, numOfSeats, electionName;

    @FXML
    // selectors for sorting
    ChoiceBox sortAlphabetical, sortByParty;

    @FXML
    //image box
    ImageView imgView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addPolitician(ActionEvent actionEvent) {
    }

    public void addElection(ActionEvent actionEvent) {
    }
}
