public class VendingMachine {

    private Inventory inventory;
    private Cassa cassa;

    public VendingMachine(Inventory inventory, Cassa cassa) {
        this.inventory = inventory;
        this.cassa = cassa;
    }

    public void inserisciSoldi(int importo) {
        cassa.inserisci(importo);
        System.out.println("Credito: " + euro(cassa.getCredito()));
    }

    public void selezionaProdotto(String codice) {
        Prodotto prodotto = inventory.trova(codice);

        if (prodotto == null) {
            System.out.println("Codice non valido: " + codice);
            return;
        }
        if (!inventory.disponibile(codice)) {
            System.out.println("Prodotto esaurito: " + prodotto.getNome());
            return;
        }
        if (cassa.getCredito() < prodotto.getPrezzo()) {
            int mancano = prodotto.getPrezzo() - cassa.getCredito();
            System.out.println("Credito insufficiente, mancano " + euro(mancano));
            return;
        }

        inventory.preleva(codice);
        int resto = cassa.calcolaResto(prodotto.getPrezzo());
        cassa.azzera();

        System.out.println("Erogato: " + prodotto.getNome());
        if (resto > 0) {
            System.out.println("Resto: " + euro(resto));
        }
    }

    public void annulla() {
        int rimborso = cassa.azzera();
        System.out.println("Annullato, restituiti: " + euro(rimborso));
    }

    /** Formatta centesimi come "1,50 EUR". */
    private String euro(int centesimi) {
        return String.format("%d,%02d EUR", centesimi / 100, centesimi % 100);
    }
}