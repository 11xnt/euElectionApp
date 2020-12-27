package System;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.collections.ObservableList;
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
    public TableColumn<Candidate, String> candidateT;
    @FXML
    public TableColumn<Candidate, String> electionT;
    @FXML
    public TableColumn<Candidate, Integer> numberOfVotesT;

    //Candidate text fields
    @FXML
    public TextField updateCandidateVotes;
    @FXML
    public TextField updateCandidateParty;
    @FXML
    public TextField numberOfVotes;

    @FXML
    public ChoiceBox electionList;
    @FXML
    public ChoiceBox politicianList;
    @FXML
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

    public void loadCandidateTable(Election election1) {
        candidateT.setCellValueFactory(new PropertyValueFactory<Candidate, String>("candidateName"));
        electionT.setCellValueFactory(new PropertyValueFactory<Candidate, String>("electionName"));
        numberOfVotesT.setCellValueFactory(new PropertyValueFactory<Candidate, Integer>("numOfVotes"));

        LinkedNode<Candidate> candidateNode = election1.getCandidateList().head;
        while (candidateNode != null) {
            candidateTable.getItems().add(election1.getCandidateList().head.getContents());
            candidateNode = candidateNode.next;
        }
    }

    public void reloadCandidateTable() {
        candidateT.setCellValueFactory(new PropertyValueFactory<Candidate, String>("candidateName"));
        electionT.setCellValueFactory(new PropertyValueFactory<Candidate, String>("electionName"));
        numberOfVotesT.setCellValueFactory(new PropertyValueFactory<Candidate, Integer>("numOfVotes"));

        LinkedNode<Candidate> candidateNode = election.getCandidateList().head;
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

    public void addCandidate(ActionEvent actionEvent) {
        LinkedNode<Election> electionNode = myElectionList.head;
        Candidate c;
        while(electionNode != null && electionNode.getContents().equals(electionList.getValue())) {
                Election election1 = electionNode.getContents();
                    c = new Candidate(politicianList.getValue().toString(), electionList.getValue().toString(), Integer.parseInt(numberOfVotes.getText()));
                    election1.getCandidateList().addElement(c);
                    System.out.println(election1.getCandidateList().listElementContents());
                    loadCandidateTable(election1);
                    loadCandidateChoiceBox();
                    electionNode = electionNode.next;
        }
    }


    public void updatePolitician(ActionEvent actionEvent) {

    }

    public void editElection(ActionEvent actionEvent) {

    }

    public void editCandidate(ActionEvent actionEvent) {

    }

    public void  removePolitician(){
        ObservableList <Politician> selectedRows, allPoliticians;
        allPoliticians = politicianTable.getItems();

        selectedRows = politicianTable.getSelectionModel().getSelectedItems();

        allPoliticians.removeAll(selectedRows);
    }



    public void save(ActionEvent actionEvent) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream polout = xstream.createObjectOutputStream(new FileWriter("PoliticianData.xml"));
        ObjectOutputStream elecout = xstream.createObjectOutputStream(new FileWriter("ElectionData.xml"));
        polout.writeObject(myPoliticianList);
        elecout.writeObject(myElectionList);
        polout.close();
        elecout.close();
        Alertbox.alert("Political system", "System has been saved", "Click ok to continue");
    }

    //loads everything bar the candidate table
    public void load(ActionEvent actionEvent) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream pol = xstream.createObjectInputStream(new FileReader("PoliticianData.xml"));
        ObjectInputStream elec = xstream.createObjectInputStream(new FileReader("ElectionData.xml"));
        myPoliticianList = (MyList<Politician>) pol.readObject();
        myElectionList = (MyList<Election>) elec.readObject();
        pol.close();
        elec.close();
        //Enables tabs
        politicianTab.setDisable(false);
        electionTab.setDisable(false);
        candidateTab.setDisable(false);
        searchTab.setDisable(false);
        //Reloads tables and choice-boxes
        loadElectionChoiceBox();
        loadPoliticianChoiceBox();
        loadCandidateChoiceBox();
        loadPoliticianTable();
        loadElectionTable();
    }

    public void quit(){
        System.exit(0);
    }

}
