import java.util.Objects;

public class Squadra {
    private String nome;
    private int goalFatti;

    public Squadra(String nome, int goalFatti) {
        this.nome = nome;
        this.goalFatti = goalFatti;
    }

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
            return true;
        }
        if (!(oggetto instanceof Squadra altra)) {
            return false;
        }
        return goalFatti == altra.goalFatti
                && Objects.equals(nome, altra.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, goalFatti);
    }
}