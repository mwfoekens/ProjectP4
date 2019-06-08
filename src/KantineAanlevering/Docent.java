package KantineAanlevering;

public class Docent extends Persoon {
    private String docentAfkorting;
    private String afdeling;

    public Docent() {
        super();
        this.docentAfkorting = "";
        this.afdeling = "";
    }

    public Docent(String docentAfkorting, String afdeling, String BSN, String voorNaam, String achterNaam, Datum geboorteDatum, char geslacht) {
        super(BSN, voorNaam, achterNaam, geboorteDatum, geslacht);

        setDocentAfkorting(docentAfkorting);
        this.afdeling = afdeling;
    }

    public String getDocentAfkorting() {
        return docentAfkorting;
    }

    public void setDocentAfkorting(String docentAfkorting) {
        if (docentAfkorting.length() != 4){
            throw new IllegalArgumentException("Docentenafkorting moet altijd 4 tekens zijn");
        }

        this.docentAfkorting = docentAfkorting;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    @Override
    public String toString() {
        return "Docent{" +
                "docentAfkorting='" + docentAfkorting + '\'' +
                ", afdeling='" + afdeling + '\'' +
                ", BSN='" + BSN + '\'' +
                ", voorNaam='" + voorNaam + '\'' +
                ", achterNaam='" + achterNaam + '\'' +
                ", geboorteDatum=" + geboorteDatum +
                ", geslacht=" + geslacht +
                '}';
    }
}
