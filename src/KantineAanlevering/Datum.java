package KantineAanlevering;

public class Datum {

    private int dag;
    private int maand;
    private int jaar;

    public Datum(int dag, int maand, int jaar) {
        this();
        if (bestaatDatum(dag, maand, jaar)) {
            this.dag = dag;
            this.maand = maand;
            this.jaar = jaar;
        }
    }

    public Datum() {
        dag = 0;
        maand = 0;
        jaar = 0;
    }


    public static boolean bestaatDatum(int dag, int maand, int jaar) {
        int bestaatDag;
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
        if (jaar < 1900 || jaar > 2100) {
            return false;
        }
        return true;
    }

    /**
     * Getter voor Sting weergave van datum
     *
     * @return Geboortedatum
     */
    public String getDatumAsString() {
        if (dag == 0){
            return "Onbekend";
        }
        return String.format("%s-%s-%s",dag, maand, jaar);
    }
}
