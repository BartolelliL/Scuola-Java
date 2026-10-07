public class CassaAutomatica {
    private static final double PAGAMENTO_INSUFFICIENTE = -1.0;

    // Gli importi sono memorizzati in centesimi
    private long totaleCentesimi;
    private long importoRicevutoCentesimi;

    public CassaAutomatica() {
        totaleCentesimi = 0;
        importoRicevutoCentesimi = 0;
    }

    /**
     * Registra il prezzo di un singolo articolo.
     * I prezzi non validi vengono ignorati.
     */
    public void registraPrezzo(double prezzo) {
        if (isImportoValido(prezzo)) {
            totaleCentesimi += convertiInCentesimi(prezzo);
        }
    }

    /**
     * Restituisce il totale della spesa in euro.
     */
    public double getTotale() {
        return totaleCentesimi / 100.0;
    }

    /**
     * Riceve un pagamento dal cliente.
     * Gli importi non validi vengono ignorati.
     */
    public void riceviPagamento(double importo) {
        if (isImportoValido(importo)) {
            importoRicevutoCentesimi += convertiInCentesimi(importo);
        }
    }

    /**
     * Restituisce il resto in euro.
     *
     * Restituisce -1.0 se il pagamento è insufficiente.
     * Dopo un pagamento completo, la cassa viene azzerata.
     */
    public double calcolaResto() {
        if (totaleCentesimi == 0 ||
                importoRicevutoCentesimi < totaleCentesimi) {
            return PAGAMENTO_INSUFFICIENTE;
        }

        long restoCentesimi =
                importoRicevutoCentesimi - totaleCentesimi;

        reset();

        return restoCentesimi / 100.0;
    }

    /**
     * Restituisce l'importo ricevuto in euro.
     */
    public double getImportoRicevuto() {
        return importoRicevutoCentesimi / 100.0;
    }

    /**
     * Azzera la cassa per iniziare una nuova transazione.
     */
    public void reset() {
        totaleCentesimi = 0;
        importoRicevutoCentesimi = 0;
    }

    /**
     * Controlla che un importo sia positivo e rappresentabile.
     */
    private boolean isImportoValido(double importo) {
        return importo > 0
                && !Double.isNaN(importo)
                && !Double.isInfinite(importo);
    }

    /**
     * Converte un importo in euro nei corrispondenti centesimi.
     */
    private long convertiInCentesimi(double importo) {
        return Math.round(importo * 100);
    }
}