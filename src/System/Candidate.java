package System;

public class Candidate {

    private int numOfVotes;
    private String candidateParty;
    private String candidateName;

    public Candidate(String candidateName, String candidateParty, int numOfVotes) {
        this.candidateName = candidateName;
        this.candidateParty = candidateParty;
        this.numOfVotes = numOfVotes;
    }

    public String getCandidateParty() {
        return candidateParty;
    }

    public void setCandidateParty(String candidateParty) {
        this.candidateParty = candidateParty;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    private int getNumOfVotes() {
        return numOfVotes;
    }

    public void setNumOfVotes(int numOfVotes) {
        this.numOfVotes = numOfVotes;
    }


    @Override
    public String toString() {
        return "Candidate{" +
                "numOfVotes=" + numOfVotes +
                '\'' +
                '}';
    }


}
