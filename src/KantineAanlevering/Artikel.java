package KantineAanlevering;

public class Artikel {
    private String naam;
    private double prijs;

    public Artikel(String naam, double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    public Artikel() {
        this.naam = "";
        this.prijs = 0;
    }

    public double getPrijs() {
        return prijs;
    }

    public String getNaam() {
        return naam;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
