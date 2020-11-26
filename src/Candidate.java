public class Candidate {

    int numOfVotes;
    String partyMembership;

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

    public Candidate(int numOfVotes, String partyMembership) {
        this.numOfVotes = numOfVotes;
        this.partyMembership = partyMembership;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "numOfVotes=" + numOfVotes +
                ", partyMembership='" + partyMembership + '\'' +
                '}';
    }


}
