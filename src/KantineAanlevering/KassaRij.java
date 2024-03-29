package KantineAanlevering;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Klasse voor de kassarij in de kantine
 */
public class KassaRij {
    private Queue<Dienblad> wachtrij;
    private Dienblad dienblad;

    /**
     * Constructor zonder parameters. Maakt een nieuwe kassarij
     */
    public KassaRij() {
        this.wachtrij = new LinkedList<>();
    }

    /**
     * Persoon sluit achter in de rij aan
     *
     * @param dienblad
     */
    public void sluitAchteraan(Dienblad dienblad) {
        wachtrij.add(dienblad);
    }

    /**
     * Indien er een rij bestaat, de eerste klant uit
     * de rij verwijderen en retourneren.
     * Als er niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Dienblad eerstePersoonInRij() {
        if (!erIsEenRij()) {
            return null;
        } else return wachtrij.poll();
    }

    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        return wachtrij.size() > 0;
    }
}