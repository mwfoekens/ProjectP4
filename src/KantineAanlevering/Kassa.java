package KantineAanlevering;

import java.util.Iterator;

/**
 * Klasse om een kassa in een kantine te simuleren.
 */
public class Kassa {
    private double geldInKassa;
    private int aantalArtikelen;
    private static final double STANDAARD_GELD_IN_LADE = 50.0;

    /**
     * Constructor met parameters.
     *
     * @param kassarij maakt een kassarij bij de kassa
     */
    public Kassa(KassaRij kassarij) {
        this.geldInKassa = STANDAARD_GELD_IN_LADE;
        this.aantalArtikelen = 0;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param dienblad die moet afrekenen
     */
    public void rekenAf(Dienblad dienblad) {
        Betaalwijze betaalwijze = dienblad.getPersoon().getBetaalwijze();
        double teBetalen = 0;
        int aantalArtikelen = 0;
        Iterator<Artikel> it = dienblad.getArtikelInfo();
        while (it.hasNext()) {
            Artikel current = it.next();
            aantalArtikelen++;
            teBetalen += current.getPrijs();
        }
        if (dienblad.getPersoon() instanceof KortingskaartHouder) {
            KortingskaartHouder kortingskaartHouder = (KortingskaartHouder) dienblad.getPersoon();
            double kortingsbedrag = teBetalen * kortingskaartHouder.geefKortingsPercentage();
            if (kortingskaartHouder.heeftMaximum()) {
                kortingsbedrag = Math.min(kortingsbedrag, kortingskaartHouder.geefMaximum());
            }
            teBetalen -= kortingsbedrag;
        }
        try {
            betaalwijze.betaal(teBetalen);
            geldInKassa += teBetalen;
            this.aantalArtikelen += aantalArtikelen;
        } catch (TeWeinigGeldException e) {
            System.out.println(dienblad.getPersoon().getVoorNaam() + " " + dienblad.getPersoon().getAchterNaam() + " is een arme sloeber.");
        }

    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return aantalArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass
     * zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return geldInKassa;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        this.geldInKassa = STANDAARD_GELD_IN_LADE;
        this.aantalArtikelen = 0;
    }
}