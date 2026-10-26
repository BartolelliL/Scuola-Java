public class Prodotto {

    private String codice;
    private String nome;
    private int prezzo;     // in centesimi
    private int quantita;

    public Prodotto(String codice, String nome, int prezzo, int quantita) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public boolean isDisponibile() {
        return quantita > 0;
    }

    public void decrementa() {
        if (quantita > 0) {
            quantita--;
        }
    }
}