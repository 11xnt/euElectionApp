package System;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private Politician politician;
    private Election election;
    @BeforeEach
    void setUp() {
        politician  = new Politician("Peter", "Finna Fall", "333", "Waterford", "something");
        election = new Election("Local", "Waterford", "2003", "32");
    }

    @Test
    void addPolitician() {

    }

    @Test
    void addElection() {

    }

    @Test
    void removePolitician() {
    }
}