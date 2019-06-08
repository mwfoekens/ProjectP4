package KantineAanlevering;

final class Administratie {
    private static final int DAYS_IN_WEEK = 7;

    private Administratie() {

    }

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */
    public static double berekenGemiddeldAantal(int[] aantal) {
        double result = 0;
        for (int aantallen : aantal) {
            result += aantallen;
        }
        result = result / aantal.length;
        return result;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        double result = 0;
        for (double item : omzet) {
            result += item;
        }
        result = result / omzet.length;
        return result;
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] dayTotals = new double[DAYS_IN_WEEK];
        for (int i = 0; i < DAYS_IN_WEEK; i++) {

            int j = 0;

            while (i + DAYS_IN_WEEK * j < omzet.length) {
                dayTotals[i] += omzet[i + DAYS_IN_WEEK * j];
                j++;
            }
        }
        return dayTotals;
    }
}
