package KantineAanlevering;

/**
 * Klasse voor een kantine
 */
public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineAanbod;

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
    public void loopPakSluitAan(Dienblad dienblad, String[] artikelen) {
        for (String artikelnaam : artikelen) {
            Artikel artikel = kantineAanbod.getArtikel(artikelnaam);
            dienblad.voegToe(artikel);
        }
        kassarij.sluitAchteraan(dienblad);
    }

    public void loopPakSluitAan1() {
        Persoon persoon = new Persoon();
        Dienblad dienblad = new Dienblad(persoon);
        Artikel artikel = new Artikel("Broodje", 2.00);
        dienblad.voegToe(artikel);
        dienblad.voegToe(artikel);
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
     *
     * @return kassa
     */
    public Kassa getKassa() {
        return kassa;
    }


    /**
     * Getter voor variabele kantineaanbod
     *
     * @return kantineAanbod
     */
    public KantineAanbod getKantineAanbod() {
        return kantineAanbod;
    }

    /**
     * Setter voor variabele kantineaanbod
     *
     * @param kantineAanbod
     */
    public void setKantineAanbod(KantineAanbod kantineAanbod) {
        this.kantineAanbod = kantineAanbod;
    }
}