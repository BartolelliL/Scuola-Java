public class Cassa {

    private int credito = 0;    // in centesimi

    public void inserisci(int importo) {
        if (importo > 0) {
            credito += importo;
        }
    }

    public int getCredito() {
        return credito;
    }

    public int calcolaResto(int prezzo) {
        return credito - prezzo;
    }

    /** Azzera il credito e restituisce quanto c'era. */
    public int azzera() {
        int vecchio = credito;
        credito = 0;
        return vecchio;
    }
}