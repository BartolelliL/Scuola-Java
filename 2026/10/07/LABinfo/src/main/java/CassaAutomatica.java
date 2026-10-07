public class CassaAutomatica {
    private double totale;
    private double importoRicevuto;

    public CassaAutomatica() {
        this.totale = 0.0;
        this.importoRicevuto = 0.0;
    }

    /**
     * Registra il prezzo di un singolo articolo incrementando il totale.
     */
    public void registraPrezzo(double prezzo) {
        if (prezzo > 0) {
            this.totale += prezzo;
        }
    }

    /**
     * Restituisce il totale cumulato della spesa attuale.
     */
    public double getTotale() {
        return this.totale;
    }

    /**
     * Riceve un importo inserito dal cliente per il pagamento.
     */
    public void riceviPagamento(double importo) {
        if (importo > 0) {
            this.importoRicevuto += importo;
        }
    }

    /**
     * Calcola e restituisce il resto.
     * Restituisce -1.0 se l'importo versato non è sufficiente a coprire il totale.
     * In caso di successo, azzera la cassa per la transazione successiva.
     */
    public double calcolaResto() {
        if (importoRicevuto < totale) {
            return -1.0; // Pagamento insufficiente
        }

        double resto = importoRicevuto - totale;
        reset();
        return resto;
    }

    /**
     * Ripristina la cassa allo stato iniziale per una nuova spesa.
     */
    public void reset() {
        this.totale = 0.0;
        this.importoRicevuto = 0.0;
    }

    // Esempio di utilizzo della classe
    public static void main(String[] args) {
        CassaAutomatica cassa = new CassaAutomatica();

        // 1. Scansione dei prodotti
        cassa.registraPrezzo(3.50);
        cassa.registraPrezzo(1.20);
        cassa.registraPrezzo(4.80);

        System.out.println("Totale da pagare: €" + cassa.getTotale()); // €9.50

        // 2. Pagamento da parte del cliente (es. banconota da 10 e 2 euro)
        cassa.riceviPagamento(10.00);

        // Controllo pagamento parziale
        if (cassa.calcolaResto() == -1.0) {
            System.out.println("Importo insufficiente. Inserire altro denaro.");
        }

        cassa.riceviPagamento(2.00); // Inseriti 12.00€ in totale

        // 3. Calcolo e consegna del resto
        double resto = cassa.calcolaResto();
        if (resto >= 0) {
            System.out.println("Pagamento effettuato. Resto restituito: €" + resto);
        }
    }
}
