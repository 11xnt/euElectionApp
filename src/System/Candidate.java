package System;

public class Candidate {

    private int numOfVotes;
    private String electionName;
    private String candidateName;

    public Candidate(String candidateName, String electionName, int numOfVotes) {
        this.candidateName = candidateName;
        this.electionName = electionName;
        this.numOfVotes = numOfVotes;
    }

    public String getElectionName() {
        return electionName;
    }

    public void setElectionName(String electionName) {
        this.electionName = electionName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public int getNumOfVotes() {
        return numOfVotes;
    }

    public void setNumOfVotes(int numOfVotes) {
        this.numOfVotes = numOfVotes;
    }


    @Override
    public String toString() {
        return "Number of Votes: " + numOfVotes + '\n' +
                "Election: " + electionName + '\n' +
                "Candidate: " + candidateName;
    }


}
