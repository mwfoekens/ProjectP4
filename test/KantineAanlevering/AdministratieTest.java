package KantineAanlevering;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdministratieTest {

    @Test
    void berekenGemiddeldAantal() {
        int[] input = {45, 56, 34, 39, 40, 31};
        double result = Administratie.berekenGemiddeldAantal(input);
        assertEquals(40.8333, result, 0.0001,"Gemiddelde aantal test");
    }

    @Test
    void berekenGemiddeldeOmzet() {
        double[] input = {567.70, 498.25, 458.90};
        double result = Administratie.berekenGemiddeldeOmzet(input);
        assertEquals(508.2833, result, 0.0001, "Gemiddelde omzet test");

    }
}