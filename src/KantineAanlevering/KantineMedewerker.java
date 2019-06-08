package KantineAanlevering;

public class KantineMedewerker extends Persoon implements KortingskaartHouder{
    private int werknemerNummer;
    private boolean achterDeKassa;

    public KantineMedewerker() {
        super();
        this.werknemerNummer = 0;
        this.achterDeKassa = false;
    }

    public KantineMedewerker(int werknemerNummer, boolean achterDeKassa, String BSN, String voorNaam, String achterNaam, Datum geboorteDatum, char geslacht) {
        super(BSN, voorNaam, achterNaam, geboorteDatum, geslacht);
        this.werknemerNummer = werknemerNummer;
        this.achterDeKassa = achterDeKassa;
    }

    public int getWerknemerNummer() {
        return werknemerNummer;
    }

    public void setWerknemerNummer(int werknemerNummer) {
        this.werknemerNummer = werknemerNummer;
    }

    public boolean isAchterDeKassa() {
        return achterDeKassa;
    }

    public void setAchterDeKassa(boolean achterDeKassa) {
        this.achterDeKassa = achterDeKassa;
    }

    @Override
    public String toString() {
        return "KantineMedewerker{" +
                "werknemerNummer=" + werknemerNummer +
                ", achterDeKassa=" + achterDeKassa +
                ", BSN='" + BSN + '\'' +
                ", voorNaam='" + voorNaam + '\'' +
                ", achterNaam='" + achterNaam + '\'' +
                ", geboorteDatum=" + geboorteDatum +
                ", geslacht=" + geslacht +
                '}';
    }

    @Override
    public double geefKortingsPercentage() {
        return .35;
    }

    @Override
    public boolean heeftMaximum() {
        return false;
    }

    @Override
    public double geefMaximum() {
        return Double.POSITIVE_INFINITY;
    }
}
