import java.awt.image.BufferedImage;

public class Politician {

    String name;
    int dob;
    String politicalParty;
    String homeCounty;
    BufferedImage image;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
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



}
