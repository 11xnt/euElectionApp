public class Candidate {
    int numOfVotes;
    String partyMembership;  //Not really sure about this field Allen.

    public int getNumOfVotes() {
        return numOfVotes;
    }

    public void setNumOfVotes(int numOfVotes) {
        this.numOfVotes = numOfVotes;
    }

    public String getPartyMembership() {
        return partyMembership;
    }

    public void setPartyMembership(String partyMembership) {
        this.partyMembership = partyMembership;
    }

    Candidate(int nOfVotes, String ptMembership){
        numOfVotes = nOfVotes;
        partyMembership = ptMembership;
    }
}
