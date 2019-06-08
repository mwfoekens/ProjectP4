package KantineAanlevering;

public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     */
    @Override
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if (saldo >= tebetalen){
            setSaldo(saldo - tebetalen);
        } else throw new TeWeinigGeldException("Geen voldoende saldo");
    }
}