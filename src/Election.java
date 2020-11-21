public class Election {
    String electionType;
    String countyLocation;
    int yearOfElection;
    int numberOfSeats;

    public String getElectionType() {
        return electionType;
    }

    public void setElectionType(String electionType) {
        this.electionType = electionType;
    }

    public String getCountyLocation() {
        return countyLocation;
    }

    public void setCountyLocation(String countyLocation) {
        this.countyLocation = countyLocation;
    }

    public int getYearOfElection() {
        return yearOfElection;
    }

    public void setYearOfElection(int yearOfElection) {
        this.yearOfElection = yearOfElection;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    Election(String electType, String countyLoc, int yearOfElect, int numOfSeats){

        electionType = electType;
        numberOfSeats = numOfSeats;
        countyLocation = countyLoc;
        yearOfElection = yearOfElect;

    }


}
