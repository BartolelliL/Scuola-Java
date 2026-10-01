public class MainApp {
    public static void main(String[] args) {
        Calcolatrice calc = new Calcolatrice();
        int risultato = calc.somma(5, 3);
        System.out.println("La somma di 5 + 3 e': " + risultato);
    }
}
