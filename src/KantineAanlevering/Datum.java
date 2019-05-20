package KantineAanlevering;

/**
 * Klasse voor de geboortedatum van een persoon
 */
public class Datum {

    private int dag;
    private int maand;
    private int jaar;

    /**
     * Constructor met parameters. Roept de constructor zonder parameters aan als de datum niet bestaat.
     *
     * @param dag   Persoons geboortedag
     * @param maand Persoons geboortemaand
     * @param jaar  Persoons geboortemaand
     */
    public Datum(int dag, int maand, int jaar) {
        this();
        if (bestaatDatum(dag, maand, jaar)) {
            this.dag = dag;
            this.maand = maand;
            this.jaar = jaar;
        }
    }

    /**
     * Constructor zonder parameters. Zet alle variabelen op 0.
     */
    public Datum() {
        dag = 0;
        maand = 0;
        jaar = 0;
    }

    /**
     * Controleert of de datum bestaat
     *
     * @param dag   Persoons geboortedag
     * @param maand Persoons geboortemaand
     * @param jaar  Persoons geboortemaand
     * @return geeft true terug als de datum bestaat, false als de datum niet bestaat.
     */
    public static boolean bestaatDatum(int dag, int maand, int jaar) {
        int bestaatDag;
        int jaarMin = 1900;
        int jaarMax = 2100;
        switch (maand) {
            case 2:
                if (jaar % 4 == 0 && (jaar % 100 != 0 || jaar % 400 == 0)) {
                    bestaatDag = 29;
                } else bestaatDag = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                bestaatDag = 30;
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                bestaatDag = 31;
                break;
            default:
                return false;
        }
        if (dag < 1 || dag > bestaatDag) {
            return false;
        }
        if (jaar < jaarMin || jaar > jaarMax) {
            return false;
        }
        return true;
    }

    /**
     * Getter voor Sting weergave van datum
     *
     * @return Geboortedatum geboortedatum van de persoon
     */
    public String getDatumAsString() {
        if (dag == 0) {
            return "Onbekend";
        }
        return String.format("%s-%s-%s", dag, maand, jaar);
    }
}
