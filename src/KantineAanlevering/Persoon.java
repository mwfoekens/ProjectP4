package KantineAanlevering;

public class Persoon {
    String BSN;
    String voorNaam;
    String achterNaam;
    Datum geboorteDatum;
    char geslacht;

    public Persoon(String BSN, String voorNaam, String achterNaam, Datum geboorteDatum, char geslacht) {
        this.BSN = BSN;
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.geboorteDatum = geboorteDatum;
        setGeslacht(geslacht);
    }

    public Persoon() {
        BSN = "Onbekend";
        voorNaam = "Onbekend";
        achterNaam = "Onbekend";
        geboorteDatum = new Datum();
        setGeslacht('O');
    }

    public String getBSN() {
        return BSN;
    }

    public String getVoorNaam() {
        return voorNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public String getGeboorteDatum() {
        return geboorteDatum.getDatumAsString();
    }

    public String getGeslacht() {
        if(geslacht == 'V'){
            return "Vrouw";
        } else if (geslacht == 'M'){
            return "Man";
        } else return "Onbekend";
    }

    public void setBSN(String BSN) {
        this.BSN = BSN;
    }

    public void setVoorNaam(String voorNaam) {
        this.voorNaam = voorNaam;
    }

    public void setAchterNaam(String achterNaam) {
        this.achterNaam = achterNaam;
    }

    public void setGeboorteDatum(Datum geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    /**
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
