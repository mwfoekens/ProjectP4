package KantineAanlevering;

public class KantineSimulatie_1 {

    private Kantine kantine;
    public static final int DAGEN = 7;
    private Artikel[] artikelen;

    /**
     * Constructor zonder parameters. Maakt artikelen aan zodat er geen NullPointerExceptions zijn.
     */
    public KantineSimulatie_1() {
        this.kantine = new Kantine();
        artikelen = new Artikel[5];
        artikelen[0] = new Artikel("Broodje Kaas", 1.50);
        artikelen[1] = new Artikel("Koffie", 0.50);
        artikelen[2] = new Artikel("Pizza", 3.00);
        artikelen[3] = new Artikel("Broodje gezond", 3.50);
        artikelen[4] = new Artikel("Thee", 0.50);

    }

    /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        System.out.println("------------------------------------------------------------------");
        System.out.println("Standaard geld in kassa: " + kantine.getKassa().hoeveelheidGeldInKassa());
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i < dagen; i++) {
            // per dag nu even vast 10 + i personen naar binnen
            // laten gaan, wordt volgende week veranderd...

            // for lus voor personen
            for (int j = 0; j < 10 + i; j++) {
                Persoon persoon = new Persoon();
                Dienblad dienblad = new Dienblad(persoon);

                kantine.loopPakSluitAan1();
                kantine.verwerkRijVoorKassa();
            }
            System.out.println("Einde dag " + (i + 1) + ": \nDagtotalen: €" + kantine.getKassa().hoeveelheidGeldInKassa());
            System.out.println("Aantal artikelen verkocht: " + kantine.getKassa().aantalArtikelen());
            System.out.println("------------------------------------------------------------------");
            kantine.getKassa().resetKassa();
            // verwerk rij voor de kassa

            // toon dagtotalen (artikelen en geld in kassa)

            // reset de kassa voor de volgende dag
        }
    }

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }
        KantineSimulatie_1 kantineSimulatie_1 = new KantineSimulatie_1();
        kantineSimulatie_1.simuleer(dagen);
    }
}