package System;

public class Election {

    private String electionType;
    private String countyLocation;
    private String yearOfElection;
    private String numberOfSeats;
    private MyList<Candidate> candidateList = new MyList<Candidate>();

    public Election(String electionType, String countyLocation, String yearOfElection, String numberOfSeats) {
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

    public String getYearOfElection() {
        return yearOfElection;
    }

    public void setYearOfElection(String yearOfElection) {
        this.yearOfElection = yearOfElection;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public MyList<Candidate> getCandidateList() { return candidateList;}

    @Override
    public String toString() {
        return "Election Type: " + electionType + '\n' +
                "County Location: " + countyLocation + '\n' +
                "Year Of Election: " + yearOfElection + '\n' +
                "Number Of Seats: " + numberOfSeats + '\n';
    }
}
