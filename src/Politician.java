import java.awt.image.BufferedImage;

public class Politician {

    String firstName;
    String lastName;
    int dateOfBirth;
    String politicalParty;
    String homeCounty;
    String image;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Politician(String firstName, String lastName, int dateOfBirth, String politicalParty, String homeCounty, String image) {
        if(Utilities.onlyContainsLetters(firstName)) this.firstName = firstName;
        if(Utilities.onlyContainsLetters(lastName)) this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        if(Utilities.onlyContainsLetters(politicalParty)) this.politicalParty = politicalParty;
        if(Utilities.onlyContainsLetters(homeCounty)) this.homeCounty = homeCounty;
        this.image = image;
    }

    public String toString(){
        return "tbd";
    }


}
