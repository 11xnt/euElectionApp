import java.awt.image.BufferedImage;

public class Politician {

    private final Object BufferedImage;
    String firstName;
    String lastName;
    int dateOfBirth;
    String politicalParty;
    String homeCounty;
    BufferedImage image;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(String politicalParty) {
        this.politicalParty = politicalParty;
    }

    public String getHomeCounty() {
        return homeCounty;
    }

    public void setHomeCounty(String homeCounty) {
        this.homeCounty = homeCounty;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    Politician(String fName, String lName, int dob, String pParty, String hCounty, BufferedImage image){

        firstName = fName;
        lastName = lName;
        dateOfBirth = dob;
        politicalParty = pParty;
        homeCounty = hCounty;
        BufferedImage = image;

    }

    public String toString(){
        return "tbd";
    }


}
