package KantineAanlevering;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KassaTest {

    @Test
    void rekenAf() {
        Persoon persoon = new Persoon();
        Betaalwijze betaalwijze = new Pinpas();
        betaalwijze.setSaldo(100);
        persoon.setBetaalwijze(betaalwijze);
        Dienblad dienblad = new Dienblad(persoon);
        KassaRij kassaRij = new KassaRij();
        Kassa kassa = new Kassa(kassaRij);
        Artikel artikel = new Artikel("Broodje", 5.00);
        dienblad.voegToe(artikel);

        kassa.rekenAf(dienblad);
        assertEquals(55, kassa.hoeveelheidGeldInKassa(), "normaal persoon/student");

        kassa.resetKassa();
        persoon = new Docent();
        persoon.setBetaalwijze(betaalwijze);
        dienblad.setPersoon(persoon);
        kassa.rekenAf(dienblad);
        assertEquals(54, kassa.hoeveelheidGeldInKassa(), "Docent met korting");

        kassa.resetKassa();
        persoon = new KantineMedewerker();
        persoon.setBetaalwijze(betaalwijze);
        dienblad.setPersoon(persoon);
        kassa.rekenAf(dienblad);
        assertEquals(53.25, kassa.hoeveelheidGeldInKassa(), "kassamedewerker met korting");
    }
}