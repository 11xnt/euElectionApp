package System;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

    MyList <Politician> politician = new MyList<Politician>();
    MyList <Election> election = new MyList<Election>();
    MyList<Candidate> candidate = new MyList<Candidate>();

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
      //It bugs out here for some reason.
        //  Politician p = new Politician(politicianName.getText(), politicalParty.getText(), Integer.parseInt(dateOfBirth.getText()), countyLocation.getText(), imageUrl.getText());
    }

    public void addElection(ActionEvent actionEvent) {
        Election e = new Election(countyLocation.getText(),electionType.getText(), Integer.parseInt(numOfSeats.getText()), Integer.parseInt(electionYear.getText()));
        election.addElement(e);
        System.out.println(election.listElementContents());
        // Popup works but gives null pointer, i might play around with it.
//        Alertbox.alert("Election", "New election added", "Thank you");
//        addElectionTab.setDisable(false);
    }
    public void updatePolitician(ActionEvent actionEvent) {
    }

    public void editElection(ActionEvent actionEvent) {
    }

    public void addCandidate(ActionEvent actionEvent) {
    }

    public void editCandidate(ActionEvent actionEvent) {
    }

    public void save(ActionEvent actionEvent) {
    }

    public void load(ActionEvent actionEvent) {
    }

    public void quit(){
        System.exit(0);
    }



}
