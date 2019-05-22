package KantineAanlevering;

/**
 * Klasse voor artikelen in de kantine
 */
public class Artikel {
    private String naam;
    private double prijs;

    /** Constructor met parameters om een nieuw artikel te maken
     *
     * @param naam naam van het artikel
     * @param prijs prijs van het artikel
     */
    public Artikel(String naam, double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    /**
     * Constructor zonder parameters om een nieuw artikel te maken
     */
    public Artikel() {
        this.naam = "";
        this.prijs = 0;
    }

    /**
     * Getter voor variabele prijs
     *
     * @return prijs van het artikel
     */
    public double getPrijs() {
        return prijs;
    }

    /**
     * Getter voor variabele naam
     *
     * @return naam van het artikel
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Setter voor variabele prijs
     *
     * @param prijs verandert de prijs van het artikel
     */
    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    /**
     * Setter voor variabele naam
     *
     * @param naam verandert de naam van het artikel
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString() {
        return "Artikel{" +
                "naam='" + naam + '\'' +
                ", prijs=" + prijs +
                '}';
    }
}
