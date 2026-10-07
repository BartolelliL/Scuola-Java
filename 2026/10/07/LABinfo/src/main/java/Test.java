public class Test {
    public static void main(String[] args) {
        CassaAutomatica cassa = new CassaAutomatica();

        cassa.registraPrezzo(3.50);
        cassa.registraPrezzo(1.20);
        cassa.registraPrezzo(4.80);

        System.out.printf(
                "Totale da pagare: €%.2f%n",
                cassa.getTotale()
        );

        cassa.riceviPagamento(10.00);

        double resto = cassa.calcolaResto();

        if (resto < 0) {
            System.out.println(
                    "Importo insufficiente. Inserire altro denaro."
            );
        }

        cassa.riceviPagamento(2.00);

        resto = cassa.calcolaResto();

        if (resto >= 0) {
            System.out.printf(
                    "Pagamento effettuato. Resto restituito: €%.2f%n",
                    resto
            );
        }
    }
}