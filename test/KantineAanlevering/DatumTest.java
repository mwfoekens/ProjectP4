package KantineAanlevering;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatumTest {
    @Test
    void bestaatDatum() {
        assertTrue(Datum.bestaatDatum(1,2,1900), "bestaatDatum simpel ;)");
        assertFalse(Datum.bestaatDatum(29, 2, 1900), "werkt schrikkeljaar test 1");
        assertTrue(Datum.bestaatDatum(28, 2, 1900), "werkt schrikkeljaar test 1");
        assertTrue(Datum.bestaatDatum(29, 2, 2000), "werkt schrikkeljaar test 2");
        assertFalse(Datum.bestaatDatum(31,8,2101), "bestaatDatum simpel ;)");
        assertFalse(Datum.bestaatDatum(32,1,2015));
    }

    @Test
    void getDatumAsString() {
        Datum datum = new Datum(31,5,2010);
        assertEquals("31-5-2010", datum.getDatumAsString());
    }
}