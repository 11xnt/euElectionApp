package System;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable{



    //Initialized table view
    @FXML
    public TableView<Election> electionTable;
    @FXML
    public TableView<Politician> politicianTable;
    @FXML
    public TableView<Candidate> candidateTable;
    @FXML
    public TableView<Politician> searchPolT;
    @FXML
    public TableView<Election> searchElecT;
    //Al tabs used
    @FXML
    public Tab politicianTab;
    @FXML
    public Tab electionTab;
    @FXML
    public Tab candidateTab;
    @FXML
    public Tab searchTabPol;
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
    public TableColumn<Politician, String> dateOfBirthT;
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
    public TableColumn<Election, String> electionYearT;
    @FXML
    public TableColumn<Election, String> numOfSeatsT;
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
    public TableColumn<Candidate, String> numberOfVotesT;
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
    public ChoiceBox updateElectionList;
    @FXML
    public ChoiceBox politicianList;
    @FXML
    public ChoiceBox updatePoliticianList;
    @FXML
    public ChoiceBox candidateList;
    @FXML
    public ChoiceBox updateCandidateList;
    //Image window.
    @FXML
    public ImageView imgView;
    //Search Text Fields
    @FXML
    public TextField searchElecTab;
    @FXML
    public TextField searchPolTab;
    //Elections Search Tables
    @FXML
    public TableColumn<Election, String> sTypeT;
    @FXML
    public TableColumn<Election, String> sLocationT;
    @FXML
    public TableColumn<Election, String> sYearT;
    @FXML
    public TableColumn<Election, String> sNOST;
    //Politician Search Tables
    @FXML
    public TableColumn<Politician, String> sNameT;
    @FXML
    public TableColumn<Politician, String> sPartyT;
    @FXML
    public TableColumn<Politician, String> sDOBT;
    @FXML
    public TableColumn<Politician, String> sCountyT;
    @FXML
    public TableColumn<Politician, String> sURLT;
    //Radio Buttons
    @FXML
    public RadioButton searchByName;
    @FXML
    public RadioButton searchByParty;
    @FXML
    public RadioButton searchByHCounty;
    @FXML
    public RadioButton searchByType;
    @FXML
    public RadioButton searchByYear;
    @FXML
    public RadioButton searchByCounty;
    @FXML
    public ToggleGroup polGroup;
    @FXML
    public ToggleGroup elecGroup;

    MyList<Politician> myPoliticianList = new MyList<Politician>();
    MyList<Election> myElectionList = new MyList<Election>();
    MyList<Candidate> myCandidateList = new MyList<Candidate>();
    Election election;
    Politician politician;
    Candidate candidate;

    // Loads the election table and allows for multiple selection.
    public void loadElectionTable() {
        electionTable.getItems().clear();
        electionTypeT.setCellValueFactory(new PropertyValueFactory<Election, String>("electionType"));
        countyT.setCellValueFactory(new PropertyValueFactory<Election, String>("countyLocation"));
        electionYearT.setCellValueFactory(new PropertyValueFactory<Election, String>("yearOfElection"));
        numOfSeatsT.setCellValueFactory(new PropertyValueFactory<Election, String>("numberOfSeats"));

        LinkedNode<Election> electionNode = myElectionList.head;
        while (electionNode != null) {
            electionTable.getItems().add(electionNode.getContents());
            electionNode = electionNode.next;
        }
        electionTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    // Loads the politician table and allows for multiple selection.
    public void loadPoliticianTable() {
        politicianTable.getItems().clear();
        politicianNameT.setCellValueFactory(new PropertyValueFactory<Politician, String>("fullName"));
        politicianPartyT.setCellValueFactory(new PropertyValueFactory<Politician, String>("politicalParty"));
        dateOfBirthT.setCellValueFactory(new PropertyValueFactory<Politician, String>("dateOfBirth"));
        countyLocationT.setCellValueFactory(new PropertyValueFactory<Politician, String>("homeCounty"));
        imageUrlT.setCellValueFactory(new PropertyValueFactory<Politician, String>("image"));

        LinkedNode<Politician> politicianNode = myPoliticianList.head;
        while (politicianNode != null) {
            politicianTable.getItems().add(politicianNode.getContents());
            politicianNode = politicianNode.next;
        }
        politicianTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void loadCandidateTable(Election election1) {
        candidateTable.getItems().clear();
        candidateT.setCellValueFactory(new PropertyValueFactory<Candidate, String>("candidateName"));
        electionT.setCellValueFactory(new PropertyValueFactory<Candidate, String>("electionName"));
        numberOfVotesT.setCellValueFactory(new PropertyValueFactory<Candidate, String>("numOfVotes"));

        LinkedNode<Candidate> candidateNode = election1.getCandidateList().head;
        while (candidateNode != null) {
            candidateTable.getItems().add(candidateNode.getContents());
            candidateNode = candidateNode.next;
        }
        candidateTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void loadAllCandidateTables() {
        candidateTable.getItems().clear();
        LinkedNode<Election> electionNode = myElectionList.head;
        LinkedNode<Candidate> candidateNode = electionNode.getContents().getCandidateList().head;
        candidateT.setCellValueFactory(new PropertyValueFactory<Candidate, String>("candidateName"));
        electionT.setCellValueFactory(new PropertyValueFactory<Candidate, String>("electionName"));
        numberOfVotesT.setCellValueFactory(new PropertyValueFactory<Candidate, String>("numOfVotes"));
        while(electionNode != null) {
                while (candidateNode != null) {
                    candidateTable.getItems().add(candidateNode.getContents());
                    candidateNode = candidateNode.next;
                }
            electionNode = electionNode.next;
        }
    }

    //Loads Election choice box in Candidate tab
    public void loadElectionChoiceBox() {
        LinkedNode<Election> electionNode = myElectionList.head;
        while (electionNode != null) {
            electionList.getItems().add(electionNode.getContents());
            electionNode = electionNode.next;
        }
    }

    public void loadUpdateElectionChoiceBox() {
        LinkedNode<Election> electionNode = myElectionList.head;
        while (electionNode != null) {
            updateElectionList.getItems().add(electionNode.getContents());
            electionNode = electionNode.next;
        }
    }
    //Loads Politician choice box in Candidate tab
    public void loadPoliticianChoiceBox() {
        LinkedNode<Politician> politicianNode = myPoliticianList.head;
        while (politicianNode != null) {
            politicianList.getItems().add(politicianNode.getContents());
            politicianNode = politicianNode.next;
        }
    }

    public void loadUpdatePoliticianChoiceBox() {
        LinkedNode<Politician> politicianNode = myPoliticianList.head;
        while (politicianNode != null) {
            updatePoliticianList.getItems().add(politicianNode.getContents());
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

    //Sets table fields to be editable.
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        politicianTable.setEditable(true);
        politicianNameT.setCellFactory(TextFieldTableCell.forTableColumn());
        politicianPartyT.setCellFactory(TextFieldTableCell.forTableColumn());
        dateOfBirthT.setCellFactory(TextFieldTableCell.forTableColumn());
        countyLocationT.setCellFactory(TextFieldTableCell.forTableColumn());
        imageUrlT.setCellFactory(TextFieldTableCell.forTableColumn());

        electionTable.setEditable(true);
        electionTypeT.setCellFactory(TextFieldTableCell.forTableColumn());
        countyT.setCellFactory(TextFieldTableCell.forTableColumn());
        electionYearT.setCellFactory(TextFieldTableCell.forTableColumn());
        numOfSeatsT.setCellFactory(TextFieldTableCell.forTableColumn());

        candidateTable.setEditable(true);
        candidateT.setCellFactory(TextFieldTableCell.forTableColumn());
        electionT.setCellFactory(TextFieldTableCell.forTableColumn());
        numberOfVotesT.setCellFactory(TextFieldTableCell.forTableColumn());
    }
    //Adds a new politician to the list
    public void addPolitician(ActionEvent actionEvent) {
        Politician p = new Politician(politicianName.getText(), politicianParty.getText(), dateOfBirth.getText(), politicianCounty.getText(), imageUrl.getText());
        myPoliticianList.addElement(p);
        System.out.println(myPoliticianList.listElementContents());
        loadPoliticianTable();
        loadPoliticianChoiceBox();
        saveToFile();
    }
    // Edits the politician name table field
    public void editPoliticianName(TableColumn.CellEditEvent editedCell) {
        Politician politician1 = politicianTable.getSelectionModel().getSelectedItem();
        politician1.setFullName(editedCell.getNewValue().toString());
        saveToFile();
    }
    // Edits the politician political party table field
    public void editPoliticianParty(TableColumn.CellEditEvent editedCell) {
        Politician politician1 = politicianTable.getSelectionModel().getSelectedItem();
        politician1.setPoliticalParty(editedCell.getNewValue().toString());
        saveToFile();
    }
    // Edits the politician DOB table field
    public void editPoliticianDOB(TableColumn.CellEditEvent editedCell) {
        Politician politician1 = politicianTable.getSelectionModel().getSelectedItem();
        politician1.setDateOfBirth(editedCell.getNewValue().toString());
        saveToFile();

    }
    // Edits the politician county table field
    public void editPoliticianCounty(TableColumn.CellEditEvent editedCell) {
        Politician politician1 = politicianTable.getSelectionModel().getSelectedItem();
        politician1.setHomeCounty(editedCell.getNewValue().toString());
        saveToFile();
    }
    // Edits the politician URL table field
    public void editPoliticianImage(TableColumn.CellEditEvent editedCell) {
        Politician politician1 = politicianTable.getSelectionModel().getSelectedItem();
        politician1.setImage(editedCell.getNewValue().toString());
        saveToFile();
    }


    public void addElection(ActionEvent actionEvent) {
        Election e = new Election(electionType.getText(), countyLocation.getText(), yearOfElection.getText(), numberOfSeats.getText());
        myElectionList.addElement(e);
        System.out.println(myElectionList.listElementContents());
        loadElectionTable();
        Alertbox.alert("Election", "New election added", "Thank you");
        electionTab.setDisable(false);
        loadElectionChoiceBox();
        saveToFile();
    }
    // Edits the election name table field
    public void editElectionName(TableColumn.CellEditEvent editedCell) {
        Election election1 = electionTable.getSelectionModel().getSelectedItem();
        election1.setElectionType(editedCell.getNewValue().toString());
        saveToFile();
    }
    // Edits the election county table field
    public void editElectionCounty(TableColumn.CellEditEvent editedCell) {
        Election election1 = electionTable.getSelectionModel().getSelectedItem();
        election1.setCountyLocation(editedCell.getNewValue().toString());
        saveToFile();
    }
    // Edits the election year table field
    public void editElectionYear(TableColumn.CellEditEvent editedCell) {
        Election election1 = electionTable.getSelectionModel().getSelectedItem();
        election1.setYearOfElection(editedCell.getNewValue().toString());
        saveToFile();
    }
    // Edits the election seat number table field
    public void editElectionNoS(TableColumn.CellEditEvent editedCell) {
        Election election1 = electionTable.getSelectionModel().getSelectedItem();
        election1.setNumberOfSeats(editedCell.getNewValue().toString());
        saveToFile();
    }
    // Adds new candidate
    public void addCandidate(ActionEvent actionEvent) {
        LinkedNode<Election> electionNode = myElectionList.head;
        LinkedNode<Candidate> candidateNode = electionNode.getContents().getCandidateList().head;
        Candidate c;
        while (electionNode != null) {
            if (electionNode.getContents().toString().equals(electionList.getValue().toString())) {
                Election election1 = electionNode.getContents();
                c = new Candidate(politicianList.getValue().toString(), electionList.getValue().toString(), numberOfVotes.getText());
                election1.getCandidateList().addElement(c);
                while (candidateNode != null) {
                    System.out.println(candidateNode.getContents());
                    candidateNode = candidateNode.next;
                }
                loadCandidateTable(election1);
                electionNode = electionNode.next;
            }
            saveToFile();
        }
    }

    public void editCandidate(TableColumn.CellEditEvent editedCell) {
        Candidate candidate1 = candidateTable.getSelectionModel().getSelectedItem();
        candidate1.setCandidateName(editedCell.getNewValue().toString());
    }

    public void editElection(TableColumn.CellEditEvent editedCell) {
        Candidate candidate1 = candidateTable.getSelectionModel().getSelectedItem();
        candidate1.setElectionName(editedCell.getNewValue().toString());
    }

    public void editCandidateVotes(TableColumn.CellEditEvent editedCell) {
        Candidate candidate1 = candidateTable.getSelectionModel().getSelectedItem();
        candidate1.setNumOfVotes(editedCell.getNewValue().toString());
    }
    //Removes the politician from the table and list
    public void removePolitician(ActionEvent actionEvent){
        myPoliticianList.deleteElement(politicianTable.getSelectionModel().getSelectedIndex());
        saveToFile();
        loadPoliticianTable();
    }
    //Removes the election from the table and list
    public void removeElection(ActionEvent actionEvent){
        myElectionList.deleteElement(electionTable.getSelectionModel().getSelectedIndex());
        saveToFile();
        loadElectionTable();
    }
    //Removes the candidate from the table and list
    public void removeCandidate(ActionEvent actionEvent) {
        myElectionList.head.getContents().getCandidateList().deleteElement(candidateTable.getSelectionModel().getSelectedIndex());
        saveToFile();
        loadAllCandidateTables();
    }

    //Loads the image from local folder
    public void showImg(){
        File file = new File(politicianTable.getSelectionModel().getSelectedItem().getImage());
        Image image = new Image(file.toURI().toString());
        imgView.setImage(image);
    }

    //Sends the information of what is chosen to be searched for in an Election List to other methods which will handle it
    public void searchForElection(ActionEvent actionEvent) {
        searchElecT.getItems().clear();
        sTypeT.setCellValueFactory(new PropertyValueFactory<Election, String>("electionType"));
        sLocationT.setCellValueFactory(new PropertyValueFactory<Election, String>("countyLocation"));
        sYearT.setCellValueFactory(new PropertyValueFactory<Election, String>("yearOfElection"));
        sNOST.setCellValueFactory(new PropertyValueFactory<Election, String>("numberOfSeats"));
        String matchedElection = searchElecTab.getText();
        if(searchByType.isSelected() == true) {
            LinkedNode<Election> electionNode = myElectionList.head;
            while(electionNode != null) {
                if(electionNode.getContents().getElectionType().contains(matchedElection)) {
                    searchElecT.getItems().add(electionNode.getContents());
                }
                electionNode = electionNode.next;
            }
        }
        else if(searchByYear.isSelected() == true) {
            LinkedNode<Election> electionNode = myElectionList.head;
            while(electionNode != null) {
                if(electionNode.getContents().getYearOfElection().contains(matchedElection)) {
                    searchElecT.getItems().add(electionNode.getContents());
                }
                electionNode = electionNode.next;
            }
        }
        else if(searchByCounty.isSelected() == true) {
            LinkedNode<Election> electionNode = myElectionList.head;
            while(electionNode != null) {
                if(electionNode.getContents().getCountyLocation().contains(matchedElection)) {
                    searchElecT.getItems().add(electionNode.getContents());
                }
                electionNode = electionNode.next;
            }
        }
        else {
            System.out.println("No Data is available");
        }
    }

    //Sends the information of what is chosen to be searched for in an Politician List to other methods which will handle it
    public void searchForPolitician(ActionEvent actionEvent) {
        searchPolT.getItems().clear();
        sNameT.setCellValueFactory(new PropertyValueFactory<Politician, String>("fullName"));
        sPartyT.setCellValueFactory(new PropertyValueFactory<Politician, String>("politicalParty"));
        sDOBT.setCellValueFactory(new PropertyValueFactory<Politician, String>("dateOfBirth"));
        sCountyT.setCellValueFactory(new PropertyValueFactory<Politician, String>("homeCounty"));
        String matchedPol = searchPolTab.getText();
        if(searchByName.isSelected() == true) {
            LinkedNode<Politician> politicianNode = myPoliticianList.head;
            while(politicianNode != null) {
                if(politicianNode.getContents().getFullName().contains(matchedPol)) {
                    searchPolT.getItems().add(politicianNode.getContents());
                }
                    politicianNode = politicianNode.next;
            }
        }
        else if(searchByParty.isSelected() == true) {
            LinkedNode<Politician> politicianNode = myPoliticianList.head;
            while(politicianNode != null) {
                if(politicianNode.getContents().getPoliticalParty().contains(matchedPol)) {
                    searchPolT.getItems().add(politicianNode.getContents());
                }
                politicianNode = politicianNode.next;
            }
        }
        else if(searchByHCounty.isSelected() == true) {
            LinkedNode<Politician> politicianNode = myPoliticianList.head;
            while(politicianNode != null) {
                if(politicianNode.getContents().getHomeCounty().contains(matchedPol)) {
                    searchPolT.getItems().add(politicianNode.getContents());
                }
                politicianNode = politicianNode.next;
            }
        }
        else {
            System.out.println("No Data is available");
        }
    }

    //Can call this method to get auto-save function
    public void saveToFile()
    {
        try {
            save();
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e);
        }
    }

    //Saves the system
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream polout = xstream.createObjectOutputStream(new FileWriter("PoliticianData.xml"));
        ObjectOutputStream elecout = xstream.createObjectOutputStream(new FileWriter("ElectionData.xml"));
        polout.writeObject(myPoliticianList);
        elecout.writeObject(myElectionList);
        polout.close();
        elecout.close();
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
        searchTabPol.setDisable(false);
        //Reloads tables and choice-boxes
        loadPoliticianChoiceBox();
        loadPoliticianTable();
        loadElectionChoiceBox();
        loadElectionTable();
        loadCandidateChoiceBox();
        loadAllCandidateTables();
    }

    public void quit(){
        System.exit(0);
    }

}
