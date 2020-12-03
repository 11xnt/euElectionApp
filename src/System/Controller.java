package System;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    MyList <Politician> politician = new MyList<Politician>();
    MyList <Election> election = new MyList<Election>();
    MyList<Candidate> candidate = new MyList<Candidate>();

    @FXML private TableView<Election> electionTable;
    @FXML private TableView<Politician> politicianTable;
    @FXML public Tab politicianTab;
    @FXML public Tab electionTab;
    @FXML public Tab candidateTab;
    @FXML public Tab searchTab;
    @FXML public TextField politicianParty;
    @FXML public TextField polPartyUpdate;
    @FXML public TextField polDobUpdate;
    @FXML public TextField imgUpdate;
    @FXML public TextField polNameUpdate;
    @FXML public TextField electionUpdate;
    @FXML public TextField countyUpdate;
    @FXML public TextField yearUpdate;
    @FXML public TextField updateSeats;
    @FXML public TextField electionType;
    @FXML public TextField countyLocation;
    @FXML public TextField electionYear;
    @FXML public TextField numOfSeats;
    @FXML public TextField imageUrl;
    @FXML public TextField dateOfBirth;
    @FXML public TextField politicianName;
    @FXML public TextField politicianCounty;
    @FXML public TableColumn<Politician, String> politicianNameT;
    @FXML public TableColumn<Politician, String> politicianPartyT;
    @FXML public TableColumn<Politician, Integer> dateOfBirthT;
    @FXML public TableColumn<Politician, String> countyLocationT;
    @FXML public TableColumn<Election, String> electionTypeT;
    @FXML public TableColumn<Election, String> countyT;
    @FXML public TableColumn<Election, Integer> electionYearT;
    @FXML public TableColumn<Election, Integer> numOfSeatsT;

    public void loadTable(){
        politicianNameT.setCellValueFactory(new PropertyValueFactory<Politician,String>("fullName"));
        politicianPartyT.setCellValueFactory(new PropertyValueFactory<Politician,String>("politicalParty"));
        dateOfBirthT.setCellValueFactory(new PropertyValueFactory<Politician,Integer>("dateOfBirth"));
        countyLocationT.setCellValueFactory(new PropertyValueFactory<Politician,String>("homeCounty"));

        electionTypeT.setCellValueFactory(new PropertyValueFactory<Election, String>("electionType"));
        countyT.setCellValueFactory(new PropertyValueFactory<Election, String>("countyLocation"));
        electionYearT.setCellValueFactory(new PropertyValueFactory<Election, Integer>("yearOfElection"));
        numOfSeatsT.setCellValueFactory(new PropertyValueFactory<Election, Integer>("numberOfSeats"));


        LinkedNode<Politician> politicianNode = politician.head;
        while(politicianNode != null){
            politicianTable.getItems().add(politicianNode.getContents());
            politicianNode = politicianNode.next;
        }
        LinkedNode<Election> electionNode = election.head;
        while(electionNode !=null){
            electionTable.getItems().add(electionNode.getContents());
            electionNode = electionNode.next;
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addPolitician(ActionEvent actionEvent) {
          Politician p = new Politician (politicianName.getText(), Integer.parseInt(dateOfBirth.getText()), politicianParty.getText(), countyLocation.getText(), imageUrl.getText());
          politician.addElement(p);
          System.out.println(politician.listElementContents());
          loadTable();
    }

    public void addElection(ActionEvent actionEvent) {
        Election e = new Election(countyLocation.getText(),electionType.getText(), Integer.parseInt(numOfSeats.getText()), Integer.parseInt(electionYear.getText()));
        election.addElement(e);
        System.out.println(election.listElementContents());
        loadTable();
        Alertbox.alert("Election", "New election added", "Thank you");
        electionTab.setDisable(false);
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
