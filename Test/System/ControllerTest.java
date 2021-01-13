package System;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    MyList<Politician> politicianList = new MyList<Politician>();
    MyList<Election> electionList = new MyList<Election>();
    MyList<Candidate> candidateList = new MyList<Candidate>();
    Politician p;
    Election e;
    Candidate c;

    @BeforeEach
    void setUp() {
        p = new Politician("Peter Pan", "Fun", "333", "Waterford", "something");
        e = new Election("Local", "Waterford", "2003", "32");
        c = new Candidate("Peter", "Local", "22");
    }


    @Test
    void addPolitician()
    {
        politicianList.addElement(p);
        assertSame("Fun", p.getPoliticalParty());
    }


    @Test
    void addElection() {
        electionList.addElement(e);
        assertSame("Local", e.getElectionType());
    }


    @Test
    void removePolitician() {
        politicianList.addElement(p);
        assertSame(1, politicianList.numElements);
        politicianList.deleteElement(0);
        assertSame(0, politicianList.numElements);


    }
    @Test
    public final void testToString() {
        assertTrue(p.toString().contains("Waterford"));
    }

    @Test
    void removeElection() {
        electionList.addElement(e);
        assertSame(1, electionList.numElements);
        electionList.deleteElement(0);
        assertSame(0, electionList.numElements);
    }

    @Test
    void addCandidate() {
        candidateList.addElement(c);
        assertSame("Peter", c.getCandidateName());
    }

}