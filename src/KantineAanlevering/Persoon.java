package KantineAanlevering;

/**
 * Klasse om een persoon (oftewel klant) in de kantine aan te maken
 */
public class Persoon {
    protected String BSN;
    protected String voorNaam;
    protected String achterNaam;
    protected Datum geboorteDatum;
    protected char geslacht;

    /**
     * Constructor met parameters
     *
     * @param BSN Burgerservicenummer van de persoon
     * @param voorNaam Voornaam van de persoon
     * @param achterNaam Achternaam van de persoon
     * @param geboorteDatum Geboortedatum van de persoon
     * @param geslacht Geslacht van de persoon (M/V)
     */
    public Persoon(String BSN, String voorNaam, String achterNaam, Datum geboorteDatum, char geslacht) {
        this.BSN = BSN;
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.geboorteDatum = geboorteDatum;
        setGeslacht(geslacht);
    }

    /**
     * Constructor zonder parameters. Zet alle variabelen op onbekend.
     */
    public Persoon() {
        BSN = "Onbekend";
        voorNaam = "Onbekend";
        achterNaam = "Onbekend";
        geboorteDatum = new Datum();
        setGeslacht('O');
    }

    /**
     * Getter voor de BSN
     *
     * @return geeft BSN terug
     */
    public String getBSN() {
        return BSN;
    }

    /**
     * Getter voor de voornaam
     *
     * @return geeft voornaam terug
     */
    public String getVoorNaam() {
        return voorNaam;
    }

    /**
     * Getter voor de achternaam
     *
     * @return Geeft achternaam terug
     */
    public String getAchterNaam() {
        return achterNaam;
    }

    /**
     * Getter voor de geboortedatum
     *
     * @return geeft geboortedatum terug als string
     */
    public String getGeboorteDatum() {
        return geboorteDatum.getDatumAsString();
    }

    /**
     * Getter voor het geslacht
     *
     * @return geeft geslacht terug als string
     */
    public String getGeslacht() {
        if(geslacht == 'V'){
            return "Vrouw";
        } else if (geslacht == 'M'){
            return "Man";
        } else return "Onbekend";
    }

    /**
     * Setter voor variabele BSN
     *
     * @param BSN Burgerservicenummer van de persoon
     */
    public void setBSN(String BSN) {
        this.BSN = BSN;
    }

    /**
     * Setter voor variabele voorNaam
     *
     * @param voorNaam voornaam van de persoon
     */
    public void setVoorNaam(String voorNaam) {
        this.voorNaam = voorNaam;
    }

    /**
     * Setter voor variabele achterNaam
     *
     * @param achterNaam achternaam van de persoon
     */
    public void setAchterNaam(String achterNaam) {
        this.achterNaam = achterNaam;
    }

    /**
     * Setter voor variabele geboorteDatum
     *
     * @param geboorteDatum geboortedatum van de persoon
     */
    public void setGeboorteDatum(Datum geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    /**
     * Setter voor het geslacht. Controleert ook of het geslacht correct is ingevuld
     *
     * @param geslacht M(an) of V(rouw)
     * @return Of geslacht goed is ingevuld (Geslacht is M/V en moet een hoofdletter zijn)
     */
    public boolean setGeslacht(char geslacht) {
        if (geslacht == 'M' || geslacht == 'V') {
            this.geslacht = geslacht;
            return true;
        } else {
            this.geslacht = 'O';
            return false;
        }
    }

    /**
     * toString methode voor de klasse.
     *
     * @return geeft alle gegevens terug.
     */
    @Override
    public String toString() {
        return "Persoon{" +
                "BSN='" + getBSN() + '\'' +
                ", voorNaam='" + getVoorNaam() + '\'' +
                ", achterNaam='" + getAchterNaam() + '\'' +
                ", geboorteDatum=" + getGeboorteDatum() +
                ", geslacht=" + getGeslacht() +
                '}';
    }
}
