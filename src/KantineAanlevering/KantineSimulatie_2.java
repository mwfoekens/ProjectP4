package KantineAanlevering;

import java.util.*;

public class KantineSimulatie_2 {

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen = new String[]
            {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[]{1.50, 2.10, 1.65, 1.65};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;
    private static final int DAGEN = 30;

    private static final int CHANCE_STUDENT = 89;
    private static final int CHANCE_DOCENT = 10;

    /**
     * Constructor
     */
    public KantineSimulatie_2() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden = getRandomArray(
                AANTAL_ARTIKELEN,
                MIN_ARTIKELEN_PER_SOORT,
                MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(
                artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen
     * min en max van de gegeven lengte te genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte; i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl)
     * en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array
     * artikelnamen de bijhorende array van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        System.out.println("------------------------------------------------------------------");
        System.out.println("Standaard geld in kassa: " + kantine.getKassa().hoeveelheidGeldInKassa());
        System.out.println("------------------------------------------------------------------");


        int[] aantalArtikelenVerkocht = new int[dagen];
        double[] omzet = new double[dagen];


        // for lus voor dagen
        for (int i = 0; i < dagen; i++) {


            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = random.nextInt(100); //getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);

            // laat de personen maar komen...
            for (int j = 0; j < aantalpersonen; j++) {
                Persoon persoon;
//                if (j < maxStudent) {
//                    persoon = new Student();
//                } else if (j < maxStudent + maxDocent) {
//                    persoon = new Docent();
//                } else {
//                    KantineMedewerker kantineMedewerker = new KantineMedewerker();
//                    kantineMedewerker.setAchterDeKassa(false);
//                    persoon = kantineMedewerker;
//                }
                int persoonGen = getRandomValue(0, 100);
                if (persoonGen < CHANCE_STUDENT) {
                    persoon = new Student();
                } else if (persoonGen < CHANCE_STUDENT + CHANCE_DOCENT) {
                    persoon = new Docent();
                } else {
                    KantineMedewerker kantineMedewerker = new KantineMedewerker();
                    kantineMedewerker.setAchterDeKassa(false);
                    persoon = kantineMedewerker;
                }
                Betaalwijze betaalwijze = new Pinpas();
                betaalwijze.setSaldo(2);
                persoon.setBetaalwijze(betaalwijze);

                System.out.println(persoon.toString());
                Dienblad dienblad = new Dienblad(persoon);

//                // maak persoon en dienblad aan, koppel ze
//                // en bedenk hoeveel artikelen worden gepakt
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
//
//                // genereer de "artikelnummers", dit zijn indexen
//                // van de artikelnamen
                int[] tepakken = getRandomArray(
                        aantalartikelen, 0, AANTAL_ARTIKELEN - 1);
//
//                // vind de artikelnamen op basis van
//                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);
//
//                // loop de kantine binnen, pak de gewenste
//                // artikelen, sluit aan
                kantine.loopPakSluitAan(dienblad, artikelen);
                kantine.verwerkRijVoorKassa();
//                try {
//                   kantine.verwerkRijVoorKassa();
//                } catch (TeWeinigGeldException e) {
//                    System.out.println(dienblad.getPersoon().getVoorNaam() + " " + dienblad.getPersoon().getAchterNaam() + " is een arme sloeber.");
//                }
            }

            int aantalArtikelenDagVerkoop = kantine.getKassa().aantalArtikelen();
            double dagOmzet = kantine.getKassa().hoeveelheidGeldInKassa();
            omzet[i] = dagOmzet;
            aantalArtikelenVerkocht[i] = aantalArtikelenDagVerkoop;

            System.out.println("Einde dag " + (i + 1) + ": \nDagtotalen: €" + String.format("%.2f", dagOmzet));
            System.out.println("Aantal artikelen verkocht: " + aantalArtikelenDagVerkoop);
            System.out.println("Aantal klanten: " + aantalpersonen);
            System.out.println("------------------------------------------------------------------");
            kantine.getKassa().resetKassa();
            // verwerk rij voor de kassa

            // druk de dagtotalen af en hoeveel personen binnen zijn gekomen

            // reset de kassa voor de volgende dag

        }
        System.out.println(String.format("Gemiddelde aantal artikelen verkocht: %.0f", Administratie.berekenGemiddeldAantal(aantalArtikelenVerkocht)));
        System.out.println(String.format("Gemiddelde omzet: €%.2f", Administratie.berekenGemiddeldeOmzet(omzet)));
        double[] dagOmzet = Administratie.berekenDagOmzet(omzet);
        System.out.println(String.format("Omzet maandagen: €%.2f", dagOmzet[0]));
        System.out.println(String.format("Omzet dinsdagen: €%.2f", dagOmzet[1]));
        System.out.println(String.format("Omzet woensdagen: €%.2f", dagOmzet[2]));
        System.out.println(String.format("Omzet donderdagen: €%.2f", dagOmzet[3]));
        System.out.println(String.format("Omzet vrijdagen: €%.2f", dagOmzet[4]));
        System.out.println(String.format("Omzet zaterdagen: €%.2f", dagOmzet[5]));
        System.out.println(String.format("Omzet zondagen: €%.2f", dagOmzet[6]));
        System.out.println("------------------------------------------------------------------");

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
        KantineSimulatie_2 kantineSimulatie_2 = new KantineSimulatie_2();
        kantineSimulatie_2.simuleer(dagen);
    }
}