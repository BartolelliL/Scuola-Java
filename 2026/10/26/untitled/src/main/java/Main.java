class Traccia_Audio {
    protected String titolo;
    protected int durata;

    public Traccia_Audio(String titolo, int durata) {
        this.titolo = titolo;
        this.durata = durata;
    }

    public void mostraDettagli() {
        System.out.println("Titolo: " + titolo + ", Durata: " + durata + " min");
    }
}

class Canzone extends Traccia_Audio {
    private String autore;

    public Canzone(String titolo, int durata, String autore) {
        super(titolo, durata);
        this.autore = autore;
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Canzone - Titolo: " + titolo + ", Durata: " + durata + " min, Autore: " + autore);
    }
}

class Podcast extends Traccia_Audio {
    private String conduttore;

    public Podcast(String titolo, int durata, String conduttore) {
        super(titolo, durata);
        this.conduttore = conduttore;
    }

    @Override
    public void mostraDettagli() {
        System.out.println("Podcast - Titolo: " + titolo + ", Durata: " + durata + " min, Conduttore: " + conduttore);
    }
}

public class Main {

    public static void main(String[] args) {
        Traccia_Audio[] playlist = new Traccia_Audio[] {
                new Canzone("Bohemian Rhapsody", 6, "Queen"),
                new Podcast("The Joe Rogan Experience", 120, "Joe Rogan")
        };


        // questo si chiama 'Enhanced For loop',
        for (Traccia_Audio elemento : playlist) {
            elemento.mostraDettagli();
        }
    }
}