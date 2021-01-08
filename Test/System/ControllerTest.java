package System;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private Politician politician;

    @BeforeEach
    void setUp() {
        politician = new Politician("Peter", "Finna Fall", "333", "Waterford", "something");
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