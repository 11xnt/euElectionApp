package System;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    MyList <Politician> politician = new MyList<Politician>();
    MyList <Election> election = new MyList<Election>();
    MyList<Candidate> candidate = new MyList<Candidate>();

    //Initialized table view
    @FXML public TableView<Election> electionTable;
    @FXML public TableView<Politician> politicianTable;

    //Al tabs used
    @FXML public Tab politicianTab;
    @FXML public Tab electionTab;
    @FXML public Tab candidateTab;
    @FXML public Tab searchTab;

    //Text fields Politician
    @FXML public TextField politicianParty;
    @FXML public TextField polPartyUpdate;
    @FXML public TextField polDobUpdate;
    @FXML public TextField imgUpdate;
    @FXML public TextField imageUrl;
    @FXML public TextField polNameUpdate;
    @FXML public TextField politicianName;
    @FXML public TextField politicianCounty;

    //Politician Tables
    @FXML public TableColumn<Politician, String> politicianNameT;
    @FXML public TableColumn<Politician, String> politicianPartyT;
    @FXML public TableColumn<Politician, Integer> dateOfBirthT;
    @FXML public TableColumn<Politician, String> countyLocationT;

    //Elections Tables
    @FXML public TableColumn<Election, String> electionTypeT;
    @FXML public TableColumn<Election, String> countyT;
    @FXML public TableColumn<Election, Integer> electionYearT;
    @FXML public TableColumn<Election, Integer> numOfSeatsT;

    //Text fields Election
    @FXML public TextField electionUpdate;
    @FXML public TextField countyUpdate;
    @FXML public TextField yearUpdate;
    @FXML public TextField updateSeats;
    @FXML public TextField electionType;
    @FXML public TextField countyLocation;
    @FXML public TextField electionYear;
    @FXML public TextField numOfSeats;
    @FXML public TextField dateOfBirth;

    //Candidate Tables
    @FXML public TableColumn<Candidate,String> numOfVotesT;
    @FXML public TableColumn<Candidate,String> candidatePartyT;

    //Candidate text fields
    public TextField updateCandidateVotes;
    public TextField updateCandidateParty;
    public TextField candidateParty;
    public TextField candidateVotes;
    public ChoiceBox selectCandidate;

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

    public void addCandidate(ActionEvent actionEvent) {
        Candidate c = new Candidate(Integer.parseInt(candidateVotes.getText()),candidateParty.getText());
        candidate.addElement(c);
        System.out.println(candidate.listElementContents());

    }


    public void updatePolitician(ActionEvent actionEvent) {
    }

    public void editElection(ActionEvent actionEvent) {
    }

    public void editCandidate(ActionEvent actionEvent) {
    }

    public void save(ActionEvent actionEvent) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("SystemData.xml"));
        out.writeObject(politician);
        out.close();
        Alertbox.alert("Political system", "System has been saved", "Click ok to continue");
    }

    public void load(ActionEvent actionEvent) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("SystemData.xml"));
        politician = (MyList<Politician>) is.readObject();
        is.close();
        //Enables tabs
        politicianTab.setDisable(false);
        electionTab.setDisable(false);
        candidateTab.setDisable(false);
        searchTab.setDisable(false);
    }
    public void quit(){
        System.exit(0);
    }



}
