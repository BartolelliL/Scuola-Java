public class Main {
    public static void main(String[] args) {
        Squadra s1 = new Squadra("Leoni", 12);

        // implementazione del copy constructor
        // dove 'altra' ha come type hint: Squadra
        Squadra s2 = new Squadra(s1);

        s2.setGoalFatti(20);

        System.out.println("Goal squadra originale (s1): " + s1.getGoalFatti());
        Squadra s3 = new Squadra("Leoni", 12);

        System.out.println("s1 è uguale a s3? " + s1.equals(s3));
        // il metodo equals non era definito, e veniva creata
        // una squadra s2 con stesso riferimento in memoria di s1.
        // di conseguenza cambiare una significa cambiare anche l'altra.
        // adesso l'equals restituisce TRUE e non FALSE come prima,
        // poichè bisognava fare un override del metodo equals
    }
}