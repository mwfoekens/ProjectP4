package KantineAanlevering;

import java.util.Iterator;
import java.util.Stack;

/**
 * Klasse voor een dienblad in de kantine
 */
public class Dienblad {
    private Stack<Artikel> artikelen;
    private Persoon persoon;

    /**
     * Constructor zonder parameters.
     */
    public Dienblad() {
        this.artikelen = new Stack<>();
    }

    /**
     * Constructor met paramaters. Maakt een dienblad voor een bestaande klant
     *
     * @param persoon gebruikt een bestaande klant
     */
    public Dienblad(Persoon persoon) {
        this.artikelen = new Stack<>();
        this.persoon = persoon;
    }

    /**
     * Getter voor variabele klant
     *
     * @return gegevens van de klant
     */
    public Persoon getPersoon() {
        return persoon;
    }

    /**
     * Setter voor de variabele klant
     *
     * @param persoon
     */
    public void setPersoon (Persoon persoon
    ) {
        this.persoon = persoon;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        artikelen.push(artikel);
    }

//    /**
//     * Methode om aantal artikelen op dienblad te tellen
//     *
//     * @return Het aantal artikelen
//     */
//    public int getAantalArtikelen() {
//        return artikelen.size();
//    }
//
//    /**
//     * Methode om de totaalprijs van de artikelen
//     *
//     * op dienblad uit te rekenen
//     *
//     * @return De totaleprijs
//     */
//    public double getTotaalPrijs() {
//        double totalePrijs = 0;
//        for (Artikel artikel : artikelen) {
//            totalePrijs += artikel.getPrijs();
//        }
//        return totalePrijs;
//    }

    public Iterator<Artikel> getArtikelInfo() {
        return artikelen.iterator();
    }
}

