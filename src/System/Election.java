package System;

public class Election {

    String electionType;
    String countyLocation;
    int yearOfElection;
    int numberOfSeats;

    public Election(String electionType, String countyLocation, int yearOfElection, int numberOfSeats) {
        this.electionType = electionType;
        this.countyLocation = countyLocation;
        this.yearOfElection = yearOfElection;
        this.numberOfSeats = numberOfSeats;
    }

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

    @Override
    public String toString() {
        return "Election Type: " + electionType + '\n' +
                "County Location: " + countyLocation + '\n' +
                "Year Of Election: " + yearOfElection + '\n' +
                "Number Of Seats: " + numberOfSeats + '\n';
    }
}
