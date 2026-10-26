public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.aggiungi(new Prodotto("A1", "Acqua", 80, 5));
        inventory.aggiungi(new Prodotto("A2", "Cola", 150, 3));
        inventory.aggiungi(new Prodotto("B1", "Caffè", 100, 0));

        Cassa cassa = new Cassa();
        VendingMachine macchina = new VendingMachine(inventory, cassa);

        System.out.println("--- Credito insufficiente ---");
        macchina.inserisciSoldi(100);
        macchina.selezionaProdotto("A2");

        System.out.println("--- Acquisto riuscito ---");
        macchina.inserisciSoldi(100);
        macchina.selezionaProdotto("A2");

        System.out.println("--- Prodotto esaurito e annullamento ---");
        macchina.inserisciSoldi(200);
        macchina.selezionaProdotto("B1");
        macchina.annulla();

        System.out.println("--- Codice errato ---");
        macchina.selezionaProdotto("Z9");
    }
}