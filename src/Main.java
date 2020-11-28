import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/*****************************************
 * @author Allen Terescenco & Milan Ples *
 * Elections Information System v1.0     *
 *****************************************/

public class Main {

    private final Scanner input = new Scanner(System.in);
    private Politician pol1;

    public Main() {
        runMenu();
    }


    public static void main(String[] args) {
        new Main();
    }

    /***********************************************
     * @return an integer which is the users input *
     ***********************************************/

    private int startMenu() {
        System.out.println("Elections Information System v1.0");
        System.out.println("--------------------");
        System.out.println("1) Add a new Politician");
        System.out.println("2) Add a new Election");
        System.out.println("3) Elect a candidate to an election");
        System.out.println("--------------------");
        System.out.println("4) Edit/Update/Delete Politician");
        System.out.println("5) Edit/Update/Delete Election");
        System.out.println("6) Edit/Update/Delete Candidate in an Election");
        System.out.println("--------------------");
        System.out.println("7) Search Elections");
        System.out.println("8) Search Politicians");
        System.out.println("--------------------");
        System.out.println("9) Save System Data");
        System.out.println("10) Load System Data");
        System.out.println("--------------------");
        System.out.println("0) Exit");
        return ScannerInput.readNextInt("->>");
    }

    /*************************************
     * takes in the users input and runs *
     * the method associated with it     *
     ************************************/

    private void runMenu() {
        int option = startMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    addPolitician();
                    break;
                case 2:
                    addElection();
                    break;
                case 3:
                    addCanToElection();
                    break;
                case 4:
                    editPolitician();
                    break;
                case 5:
                    editElection();
                    break;
                case 6:
                    editCandidate();
                    break;
                case 7:
                    searchElections();
                    break;
                case 8:
                    searchPoliticians();
                    break;
                case 9:
                    try {
                        save();
                        System.out.println("Saved data to the .xml file");
                    } catch (Exception e) {
                        System.err.println("Error writing to the file: " + e);
                    }
                    break;
                case 10:
                    try {
                        load();
                        System.out.println("Loaded data from the .xml file");
                    } catch (Exception e) {
                        System.err.println("Error reading from the file: " + e);
                    }
                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            input.nextLine();

            //display the main menu again
            option = startMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting...");
        System.exit(0);
    }

    //Add new politician
    private void addPolitician() {
        String fullName = ScannerInput.readNextString("Enter in the Politician's Full Name: ");
        int dateOfBirth = ScannerInput.readNextInt("Enter in the Politician's DoB (DDMMYY): ");
        String polParty = ScannerInput.readNextString("Enter in the Politician's party: ");
        String county = ScannerInput.readNextString("Enter in the Politician's home county: ");
        String image = ScannerInput.readNextString("Please enter a URL of the politician's picture: ");
        pol1 = new Politician(fullName, dateOfBirth, polParty, county, image);
        pol1.insertPolIntoHash(pol1);
    }

    //Add new election
    private void addElection() {

    }

    //Add new candidate to an election
    private void addCanToElection() {

    }

    //Edit/Update/Remove politician
    private void editPolitician() {

    }

    //Edit/Update/Remove election
    private void editElection() {

    }

    //Edit/Update/Remove candidate
    private void editCandidate() {

    }

    // searches should be sorted by choice of user: name, party, year (ascending or descending), election type
    // view search results toString and etc

    //Search elections by type and/or year
    private void searchElections() {

    }

    //Search politicians by name, party and/or location
    private void searchPoliticians() {

    }

    /******************************
     * Saves data to an .xml file *
     ******************************/

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("SystemData.xml"));
        //out.writeObject(floorList);
        out.close();
    }

    /********************************
     * Loads data from an .xml file *
     ********************************/

    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("SystemData.xml"));
        //floorList = (FloorList) is.readObject();
        is.close();
    }


}
