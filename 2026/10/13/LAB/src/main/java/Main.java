public class Main {
    public static class Persona {
        protected String Nome;
        protected Integer eta;

        public Persona(String Nome, Integer eta) {
            this.Nome = Nome;
            this.eta = eta;
        }


        public String descrivi() {
            return Nome + ", " + eta + " anni";
        }
    }

    public static class Studente extends Persona {
        private final String classe;
        private final double mediaVoti;

        public Studente(String Nome, Integer eta, String classe, double mediaVoti) {
            super(Nome, eta);
            this.classe = classe;
            this.mediaVoti = mediaVoti;
        }

        @Override
        public String descrivi() {
            return super.descrivi() + ", classe: " + classe + ", media: " + mediaVoti;
        }

        public boolean promosso() {
            return mediaVoti >= 6;
        }
    }


    public static void main(String[] args) {
        Persona persona = new Persona("Leo Bartox", 33);
        Studente s1 = new Studente(persona.Nome, persona.eta, "4F", 7.5);
        Studente s2 = new Studente(persona.Nome, persona.eta, "5F", 10.0);

        Studente[] Lista_studente = {s1, s2};

        // for (Studente studente : Lista_studente)
        //
        // ^ Enhanced for

        for (int i = 0; i < Lista_studente.length; i++) {
            System.out.println(Lista_studente[i].descrivi());
            System.out.println(Lista_studente[i].promosso());
        }
    }
}
