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


    MyList<Politician> myPoliticianList = new MyList<Politician>();
    MyList<Election> myElectionList = new MyList<Election>();
    MyList<Candidate> myCandidateList = new MyList<Candidate>();
    Election election;
    Politician politician;
    Candidate candidate;

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
    public TableColumn<Candidate, String> electionT;
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
    public ChoiceBox candidateList;

    public void loadElectionTable() {
        electionTypeT.setCellValueFactory(new PropertyValueFactory<Election, String>("electionType"));
        countyT.setCellValueFactory(new PropertyValueFactory<Election, String>("countyLocation"));
        electionYearT.setCellValueFactory(new PropertyValueFactory<Election, Integer>("yearOfElection"));
        numOfSeatsT.setCellValueFactory(new PropertyValueFactory<Election, Integer>("numberOfSeats"));

        LinkedNode<Election> electionNode = myElectionList.head;
        while (electionNode != null) {
            electionTable.getItems().add(electionNode.getContents());
            electionNode = electionNode.next;
        }
    }

    public void loadPoliticianTable() {
        politicianNameT.setCellValueFactory(new PropertyValueFactory<Politician, String>("fullName"));
        politicianPartyT.setCellValueFactory(new PropertyValueFactory<Politician, String>("politicalParty"));
        dateOfBirthT.setCellValueFactory(new PropertyValueFactory<Politician, Integer>("dateOfBirth"));
        countyLocationT.setCellValueFactory(new PropertyValueFactory<Politician, String>("homeCounty"));
        imageUrlT.setCellValueFactory(new PropertyValueFactory<Politician, String>("image"));

        LinkedNode<Politician> politicianNode = myPoliticianList.head;
        while (politicianNode != null) {
            politicianTable.getItems().add(politicianNode.getContents());
            politicianNode = politicianNode.next;
        }
    }

    public void loadCandidateTable() {
        candidateNameT.setCellValueFactory(new PropertyValueFactory<Candidate, String>("candidateName"));
        electionT.setCellValueFactory(new PropertyValueFactory<Candidate, String>("electionName"));
        numOfVotesT.setCellValueFactory(new PropertyValueFactory<Candidate, Integer>("numOfVotes"));

        LinkedNode<Candidate> candidateNode = myCandidateList.head;
        while (candidateNode != null) {
            candidateTable.getItems().add(candidateNode.getContents());
            candidateNode = candidateNode.next;
        }
    }

    public void loadElectionChoiceBox() {
        LinkedNode<Election> electionNode = myElectionList.head;
        while (electionNode != null) {
            electionList.getItems().add(electionNode.getContents());
            electionNode = electionNode.next;
        }
    }
    public void loadPoliticianChoiceBox() {
        LinkedNode<Politician> politicianNode = myPoliticianList.head;
        while (politicianNode != null) {
            politicianList.getItems().add(politicianNode.getContents());
            politicianNode = politicianNode.next;
        }
    }

    public void loadCandidateChoiceBox() {
        LinkedNode<Candidate> candidateNode = myCandidateList.head;
        while (candidateNode != null) {
            candidateList.getItems().add(candidateNode.getContents());
            candidateNode = candidateNode.next;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addPolitician(ActionEvent actionEvent) {
        Politician p = new Politician(politicianName.getText(), Integer.parseInt(dateOfBirth.getText()), politicianParty.getText(), politicianCounty.getText(), imageUrl.getText());
        myPoliticianList.addElement(p);
        System.out.println(myPoliticianList.listElementContents());
        loadPoliticianTable();
        loadPoliticianChoiceBox();
    }

    public void addElection(ActionEvent actionEvent) {
        Election e = new Election(electionType.getText(), countyLocation.getText(), Integer.parseInt(yearOfElection.getText()), Integer.parseInt(numberOfSeats.getText()));
        myElectionList.addElement(e);
        System.out.println(myElectionList.listElementContents());
        loadElectionTable();
        Alertbox.alert("Election", "New election added", "Thank you");
        electionTab.setDisable(false);
        loadElectionChoiceBox();
    }


    //select what election you want to add a politician to
    //select politician
    //add how many votes the candidate got
    //inserts politician into the candidateList of the election
    //super duper bugged, logic is there but its not right
    public void addCandidate(ActionEvent actionEvent) {
        LinkedNode<Election> electionNode = myElectionList.head;
        while(electionNode != null) {
            if(electionList.getValue().toString().matches(electionNode.toString())) {
                Election election1 = electionNode.getContents();
                Candidate c = new Candidate(politicianList.getItems().toString(), electionList.getItems().toString(), Integer.parseInt(candidateVotes.getText()));
                election1.getCandidateList().addElement(c);
            } else {
                electionNode = myElectionList.head.next;
            }

        }
        System.out.println(myCandidateList.listElementContents());
        loadCandidateTable();
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
        out.writeObject(myPoliticianList);
        out.close();
        Alertbox.alert("Political system", "System has been saved", "Click ok to continue");
    }

    public void load(ActionEvent actionEvent) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("SystemData.xml"));
        myPoliticianList = (MyList<Politician>) is.readObject();
        is.close();
        //Enables tabs
        politicianTab.setDisable(false);
        electionTab.setDisable(false);
        candidateTab.setDisable(false);
        searchTab.setDisable(false);
        loadPoliticianTable();
        loadCandidateTable();
        loadElectionTable();
    }
    public void quit(){
        System.exit(0);
    }



}
