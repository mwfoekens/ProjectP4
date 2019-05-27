package KantineAanlevering;

import java.util.Random;

/**
 * Klasse voor een kantine
 */
public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;

    /**
     * Constructor zonder parameters
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt
     * en aan elkaar gekoppeld. Maak twee Artikelen aan
     * en plaats deze op het dienblad. Tenslotte sluit de
     * Persoon zich aan bij de rij voor de kassa.
     */
    public void loopPakSluitAan(Dienblad dienblad, Artikel[] artikelen) {
        //for (Artikel artikel : artikelen){
        //    dienblad.voegToe(artikel);
       // }
        Random random = new Random();
        int randomInt = random.nextInt(4) + 1;
        dienblad.voegToe(artikelen[randomInt]);
        dienblad.voegToe(artikelen[randomInt]);
        kassarij.sluitAchteraan(dienblad);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (kassarij.erIsEenRij()) {
            kassa.rekenAf(kassarij.eerstePersoonInRij());
        }
    }

//    /**
//     * Deze methode telt het geld uit de kassa
//     *
//     * @return hoeveelheid geld in kassa
////     */
//    public double hoeveelheidGeldInKassa() {
//        return kassa.hoeveelheidGeldInKassa();
//    }
//
//    /**
//     * Deze methode geeft het aantal gepasseerde artikelen.
//     *
//     * @return het aantal gepasseerde artikelen
//     */
//    public int aantalArtikelen() {
//       return kassa.aantalArtikelen();
//    }
//
//    /**
//     * Deze methode reset de bijgehouden telling van
//     * het aantal artikelen en "leegt" de inhoud van de kassa.
//     */
//    public void resetKassa() {
//        kassa.resetKassa();
//    }

    /**
     * Getter om alles op te kunnen vragen bij klasse Kassa.
     * @return kassa
     */
    public Kassa getKassa() {
        return kassa;
    }
}