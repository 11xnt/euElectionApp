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


    MyList<Politician> politician = new MyList<Politician>();
    MyList<Election> election = new MyList<Election>();
    MyList<Candidate> candidate = new MyList<Candidate>();

    //Initialized table view
    @FXML
    public TableView<Election> electionTable;
    @FXML
    public TableView<Politician> politicianTable;
    @FXML
    public TableView<Candidate> candidateTable;

    //Al tabs used
    @FXML
    public Tab politicianTab;
    @FXML
    public Tab electionTab;
    @FXML
    public Tab candidateTab;
    @FXML
    public Tab searchTab;

    //Text fields Politician
    @FXML
    public TextField politicianParty;
    @FXML
    public TextField polPartyUpdate;
    @FXML
    public TextField polDobUpdate;
    @FXML
    public TextField imgUpdate;
    @FXML
    public TextField imageUrl;
    @FXML
    public TextField polNameUpdate;
    @FXML
    public TextField politicianName;
    @FXML
    public TextField politicianCounty;
    @FXML
    public TextField politicianCountyUpdate;

    //Politician Tables
    @FXML
    public TableColumn<Politician, String> politicianNameT;
    @FXML
    public TableColumn<Politician, String> politicianPartyT;
    @FXML
    public TableColumn<Politician, Integer> dateOfBirthT;
    @FXML
    public TableColumn<Politician, String> countyLocationT;
    @FXML
    public TableColumn<Politician, String> imageUrlT;

    //Elections Tables
    @FXML
    public TableColumn<Election, String> electionTypeT;
    @FXML
    public TableColumn<Election, String> countyT;
    @FXML
    public TableColumn<Election, Integer> electionYearT;
    @FXML
    public TableColumn<Election, Integer> numOfSeatsT;

    //Text fields Election
    @FXML
    public TextField electionUpdate;
    @FXML
    public TextField countyUpdate;
    @FXML
    public TextField yearUpdate;
    @FXML
    public TextField updateSeats;
    @FXML
    public TextField electionType;
    @FXML
    public TextField countyLocation;
    @FXML
    public TextField yearOfElection;
    @FXML
    public TextField numberOfSeats;
    @FXML
    public TextField dateOfBirth;

    //Candidate Tables
    @FXML
    public TableColumn<Candidate, String> candidateNameT;
    @FXML
    public TableColumn<Candidate, String> candidatePartyT;
    @FXML
    public TableColumn<Candidate, Integer> numOfVotesT;



    //Candidate text fields
    public TextField updateCandidateVotes;
    public TextField updateCandidateParty;
    public TextField candidateName;
    public TextField candidateParty;
    public TextField candidateVotes;
    public ChoiceBox electionList;
    public ChoiceBox politicianList;

    public void loadTable() {
        politicianNameT.setCellValueFactory(new PropertyValueFactory<Politician, String>("fullName"));
        politicianPartyT.setCellValueFactory(new PropertyValueFactory<Politician, String>("politicalParty"));
        dateOfBirthT.setCellValueFactory(new PropertyValueFactory<Politician, Integer>("dateOfBirth"));
        countyLocationT.setCellValueFactory(new PropertyValueFactory<Politician, String>("homeCounty"));
        imageUrlT.setCellValueFactory(new PropertyValueFactory<Politician, String>("image"));

        electionTypeT.setCellValueFactory(new PropertyValueFactory<Election, String>("electionType"));
        countyT.setCellValueFactory(new PropertyValueFactory<Election, String>("countyLocation"));
        electionYearT.setCellValueFactory(new PropertyValueFactory<Election, Integer>("yearOfElection"));
        numOfSeatsT.setCellValueFactory(new PropertyValueFactory<Election, Integer>("numberOfSeats"));

        candidateNameT.setCellValueFactory(new PropertyValueFactory<Candidate, String>("candidateName"));
        candidatePartyT.setCellValueFactory(new PropertyValueFactory<Candidate, String>("candidateParty"));
        numOfVotesT.setCellValueFactory(new PropertyValueFactory<Candidate, Integer>("numOfVotes"));


        LinkedNode<Politician> politicianNode = politician.head;
        while (politicianNode != null) {
            politicianTable.getItems().add(politicianNode.getContents());
            politicianNode = politicianNode.next;
        }
        LinkedNode<Election> electionNode = election.head;
        while (electionNode != null) {
            electionTable.getItems().add(electionNode.getContents());
            electionNode = electionNode.next;
        }
        LinkedNode<Candidate> candidateNode = candidate.head;
        while (candidateNode != null) {
            candidateTable.getItems().add(candidateNode.getContents());
            candidateNode = candidateNode.next;
        }

    }

    public void loadChoiceBox() {
        LinkedNode<Election> electionNode = election.head;
        while (electionNode != null) {
            electionList.getItems().add(electionNode.getContents().getElectionType());
            electionNode = electionNode.next;
        }

        LinkedNode<Politician> politicianNode = politician.head;
        while (politician != null) {
            politicianList.getItems().add(politicianNode.getContents().getFullName());
            politicianNode = politicianNode.next;
        }

        LinkedNode<Candidate> candidateNode = candidate.head;
        while (candidate != null) {
            candidateList.getItems().add(candidateNode.getContents().getCandidateName());
            candidateNode = candidateNode.next;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addPolitician(ActionEvent actionEvent) {
        Politician p = new Politician(politicianName.getText(), Integer.parseInt(dateOfBirth.getText()), politicianParty.getText(), politicianCounty.getText(), imageUrl.getText());
        politician.addElement(p);
        System.out.println(politician.listElementContents());
        loadTable();
        loadChoiceBox();
    }

    public void addElection(ActionEvent actionEvent) {
        Election e = new Election(electionType.getText(), countyLocation.getText(), Integer.parseInt(yearOfElection.getText()), Integer.parseInt(numberOfSeats.getText()));
        election.addElement(e);
        System.out.println(election.listElementContents());
        loadTable();
        Alertbox.alert("Election", "New election added", "Thank you");
        electionTab.setDisable(false);
        loadChoiceBox();
    }


    //select what election you want to add a politician to
    //select politician
    //add how many votes the candidate got
    //inserts politician into the candidateList of the election
    //super duper bugged, logic is there but its not right
    public void addCandidate(ActionEvent actionEvent) {
        String candidateName1;
        String candidateParty1;
        Election electionType1;
        LinkedNode<Politician> politicianNode = politician.head;
        LinkedNode<Election> electionNode = election.head;
        while ((politicianNode != null) && (electionNode != null)) {
            if ((politicianList.getValue().equals(politicianNode.getContents().getFullName())) && (electionList.getValue().equals(electionNode.getContents().getElectionType()))) {
                candidateName1 = politicianNode.getContents().getFullName();
                candidateParty1 = politicianNode.getContents().getPoliticalParty();
                Candidate c = new Candidate(candidateName1, candidateParty1, Integer.parseInt(candidateVotes.getText()));
                electionType1 = electionNode.getContents();
                electionType1.getCandidateList().addElement(c);
                System.out.println(candidate.listElementContents());
            }   electionNode = electionNode.next;
                politicianNode = politicianNode.next;
        } loadTable();
    }


    public void updatePolitician(ActionEvent actionEvent) {
        loadChoiceBox();
    }

    public void editElection(ActionEvent actionEvent) {
        loadChoiceBox();
    }

    public void editCandidate(ActionEvent actionEvent) {
        loadChoiceBox();
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
        loadTable();
    }
    public void quit(){
        System.exit(0);
    }



}
