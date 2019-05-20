package KantineAanlevering;

import java.util.ArrayList;

/**
 * Klasse voor een dienblad in de kantine
 */
public class Dienblad {
    private ArrayList<Artikel> artikelen;
    private Persoon klant;

    /**
     * Constructor zonder parameters.
     */
    public Dienblad() {
        this.artikelen = new ArrayList<>();
    }

    /**
     * Constructor met paramaters. Maakt een dienblad voor een bestaande klant
     *
     * @param klant gebruikt een bestaande klant
     */
    public Dienblad(Persoon klant) {
        this.artikelen = new ArrayList<>();
        this.klant = klant;
    }

    /**
     * Getter voor variabele klant
     *
     * @return gegevens van de klant
     */
    public Persoon getKlant() {
        return klant;
    }

    /**
     * Setter voor de variabele klant
     *
     * @param klant
     */
    public void setKlant(Persoon klant) {
        this.klant = klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        return artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen
     *
     * op dienblad uit te rekenen
     *
     * @return De totaleprijs
     */
    public double getTotaalPrijs() {
        double totalePrijs = 0;
        for (Artikel artikel : artikelen) {
            totalePrijs += artikel.getPrijs();
        }
        return totalePrijs;
    }
}

