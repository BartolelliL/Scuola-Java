public class Main {
    public static class Persona {
        private final String nome;
        private final String cognome;
        private final Integer eta;

        public Persona(String nome, String cognome, int eta) {
            this.nome = nome;
            this.cognome = cognome;
            this.eta = eta;
        }

        public String getNome() { return nome; }
        public String getCognome() { return cognome; }
        public Integer getEta() { return eta; }
    }

    public static class Studente extends Persona {
        private final String id;
        private final String scuola;
        private final String classe;

        public Studente(String nome, String cognome, int eta, String id, String scuola, String classe) {
            super(nome, cognome, eta);
            this.id = id;
            this.scuola = scuola;
            this.classe = classe;
        }

        public String getId() { return id; }
        public String getScuola() { return scuola; }
        public String getClasse() { return classe; }
    }

    public static void main(String[] args) {
        Studente s = new Studente("Leonardo", "Bartox", 18, "1234", "Galileo Galilei", "4F");
        System.out.println(s.getNome() + " " + s.getCognome() + " - " + s.getScuola());
    }
}