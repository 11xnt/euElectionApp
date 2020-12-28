package System;

public class Candidate {

    private String numOfVotes;
    private String electionName;
    private String candidateName;

    public Candidate(String candidateName, String electionName, String numOfVotes) {
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

    public String getNumOfVotes() {
        return numOfVotes;
    }

    public void setNumOfVotes(String numOfVotes) {
        this.numOfVotes = numOfVotes;
    }


    @Override
    public String toString() {
        return "Number of Votes: " + numOfVotes + '\n' +
                "Election: " + electionName + '\n' +
                "Candidate: " + candidateName;
    }


}
