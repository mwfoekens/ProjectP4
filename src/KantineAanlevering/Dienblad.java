package KantineAanlevering;

import java.util.ArrayList;

public class Dienblad {
    private ArrayList<Artikel> artikelen;
    private Persoon klant;

    /**
     * Constructor
     */
    public Dienblad() {
        this.artikelen = new ArrayList<>();
    }

    public Dienblad(Persoon klant) {
        this.artikelen = new ArrayList<>();
        this.klant = klant;
    }

    public Persoon getKlant() {
        return klant;
    }

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
        int aantalArtikelen = 0;
        for (Artikel artikel : artikelen) {
            aantalArtikelen++;
        }
        return aantalArtikelen;
    }

    /**
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        double totalePrijs = 0;
        for (Artikel artikel : artikelen) {
            totalePrijs += artikel.getPrijs();
        }
        return totalePrijs;
    }
}

