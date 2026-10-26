import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Prodotto> prodotti = new ArrayList<>();

    public void aggiungi(Prodotto prodotto) {
        prodotti.add(prodotto);
    }

    /** Restituisce il prodotto con quel codice, oppure null se non esiste. */
    public Prodotto trova(String codice) {
        for (Prodotto p : prodotti) {
            if (p.getCodice().equals(codice)) {
                return p;
            }
        }
        return null;
    }

    public boolean disponibile(String codice) {
        Prodotto p = trova(codice);
        return p != null && p.isDisponibile();
    }

    /** Toglie un pezzo e restituisce il prodotto, oppure null se non disponibile. */
    public Prodotto preleva(String codice) {
        Prodotto p = trova(codice);
        if (p == null || !p.isDisponibile()) {
            return null;
        }
        p.decrementa();
        return p;
    }
}