import java.awt.image.BufferedImage;

public class Politician {

    String fullName;
    int dateOfBirth;
    String politicalParty;
    String homeCounty;
    String image;

    public int hashFunc(Politician politician) {
        int total = 0;
        for(int i = 0; i < politician.getFullName().length(); i++) {
            total += politician.getFullName().hashCode();
        }
        return (total%10);
    }

    public Politician insertPolIntoHash(Politician politician) {
        int tableKey = hashFunc(politician);

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Politician(String fullName, int dateOfBirth, String politicalParty, String homeCounty, String image) {
        if(Utilities.onlyContainsLetters(fullName)) this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        if(Utilities.onlyContainsLetters(politicalParty)) this.politicalParty = politicalParty;
        if(Utilities.onlyContainsLetters(homeCounty)) this.homeCounty = homeCounty;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Politician{" +
                "fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", politicalParty='" + politicalParty + '\'' +
                ", homeCounty='" + homeCounty + '\'' +
                ", image='" + image + '\'' +
                '}';
    }




}
