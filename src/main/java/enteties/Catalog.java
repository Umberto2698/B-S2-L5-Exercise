package enteties;

import java.util.Random;

public abstract class Catalog {
    long codiceISBN;
    String titolo;
    int annoDiPubblicazione;
    int numeroPagine;

    public Catalog(String titolo) {
        this.titolo = titolo;
        this.annoDiPubblicazione = new Random().nextInt(1500, 2023);
        this.numeroPagine = new Random().nextInt(50, 1000);
        this.codiceISBN = (new Random().nextLong(1000000000000L, 10000000000000L));
    }

    public long getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }
}
