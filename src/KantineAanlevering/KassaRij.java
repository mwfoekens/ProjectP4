package KantineAanlevering;

import KantineAanlevering.Dienblad;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Klasse voor de kassarij in de kantine
 */
public class KassaRij {
    private Queue<Dienblad> wachtrij;

    /**
     * Constructor zonder parameters. Maakt een nieuwe kassarij
     */
    public KassaRij() {
        this.wachtrij = new LinkedList<Dienblad>();
    }

    /**
     * Persoon sluit achter in de rij aan
     *
     * @param klant
     */
    public void sluitAchteraan(Dienblad klant) {
        wachtrij.add(klant);
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