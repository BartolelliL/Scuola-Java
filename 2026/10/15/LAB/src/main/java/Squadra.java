import java.util.Objects;

public class Squadra {
    private String nome;
    private int goalFatti;

    public Squadra(String nome, int goalFatti) {
        this.nome = nome;
        this.goalFatti = goalFatti;
    }

    // questo è il copy constructor
    // quando una classe nuova deve essere create con
    // new Classe(...), se si deve fare la copia di una classe già esistente
    // allora si può inserire, al posto dei parametri,
    // la classe di riferimento che vogliamo copiare, con type hint: Classe

    public Squadra(Squadra altra) {
        this(altra.nome, altra.goalFatti);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGoalFatti() {
        return goalFatti;
    }

    public void setGoalFatti(int goalFatti) {
        this.goalFatti = goalFatti;
    }

    @Override
    public boolean equals(Object oggetto) {
        if (this == oggetto) {
            // se sono uguali true
            return true;
        }
        if (!(oggetto instanceof Squadra altra)) {
            // se sono due tipi diversi false
            return false;
        }

        // alla fine, confronta i goal fatti e i nomi
        // con equals originale, e se tutti e due coincidono
        // restituisce true
        return goalFatti == altra.goalFatti
                && Objects.equals(nome, altra.nome);
    }
}