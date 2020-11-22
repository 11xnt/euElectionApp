import java.awt.image.BufferedImage;

public class Politician {

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

    public Politician(String firstName, String lastName, int dateOfBirth, String politicalParty, String homeCounty, BufferedImage image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.politicalParty = politicalParty;
        this.homeCounty = homeCounty;
        this.image = image;
    }

    public String toString(){
        return "tbd";
    }


}
