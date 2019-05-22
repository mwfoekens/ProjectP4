package KantineAanlevering;

public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private Persoon persoon;
    private Dienblad klant;

    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
        persoon = new Persoon();
        klant = new Dienblad(persoon);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt
     * en aan elkaar gekoppeld. Maak twee Artikelen aan
     * en plaats deze op het dienblad. Tenslotte sluit de
     * Persoon zich aan bij de rij voor de kassa.
     */
    public void loopPakSluitAan(Dienblad klant, String[] artikelnamen) {
        Artikel eersteItem = new Artikel();
        klant.voegToe(eersteItem);
        Artikel tweedeItem = new Artikel();
        klant.voegToe(tweedeItem);
        kassarij.sluitAchteraan(klant);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (kassarij.erIsEenRij()) {
            kassa.rekenAf(klant);
            kassarij.eerstePersoonInRij();
        }
    }

    /**
     * Deze methode telt het geld uit de kassa
     *
     * @return hoeveelheid geld in kassa
     */
    public double hoeveelheidGeldInKassa() {
        return kassa.hoeveelheidGeldInKassa();
    }

    /**
     * Deze methode geeft het aantal gepasseerde artikelen.
     *
     * @return het aantal gepasseerde artikelen
     */
    public int aantalArtikelen() {
       return kassa.aantalArtikelen();
    }

    /**
     * Deze methode reset de bijgehouden telling van
     * het aantal artikelen en "leegt" de inhoud van de kassa.
     */
    public void resetKassa() {
        kassa.resetKassa();
    }
}