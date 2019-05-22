package KantineAanlevering;

public class Kassa {
private double geldInKassa;
private int aantalArtikelen;
    /**
     * Constructor met parameters.
     *
     * @param kassarij maakt een kassarij bij de kassa
     */
    public Kassa(KassaRij kassarij) {
        this.geldInKassa = 0.0;
        this.aantalArtikelen = 0;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        geldInKassa += klant.getTotaalPrijs();
        aantalArtikelen += klant.getAantalArtikelen();
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return aantalArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass
     * zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return geldInKassa;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        this.geldInKassa = 0.0;
        this.aantalArtikelen = 0;
    }
}