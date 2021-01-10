package System;

public class Politician {

    private String fullName;
    private String dateOfBirth;
    private String politicalParty;
    private String homeCounty;
    private String image;

    public Politician(String fullName, String politicalParty, String dateOfBirth, String homeCounty, String image) {
        if(Utilities.onlyContainsFullName(fullName)) this.fullName = fullName;
        if(Utilities.onlyContainsNumbers(dateOfBirth)) this.dateOfBirth = dateOfBirth;
        if(Utilities.onlyContainsLetters(politicalParty)) this.politicalParty = politicalParty;
        if(Utilities.onlyContainsLetters(homeCounty)) this.homeCounty = homeCounty;
        this.image = image;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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

    @Override
    public String toString() {
        return "Full Name: " + fullName + '\n' +
                "Date Of Birth: " + dateOfBirth + '\n' +
                "Political Party: " + politicalParty + '\n' +
                "Home County: " + homeCounty + '\n' +
                "URL Image: " + image + '\n';
    }



}
