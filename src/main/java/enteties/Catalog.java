package enteties;

import java.util.Random;

public abstract class Catalog {
    long codiceISBN;
    String titolo;
    int annoDiPubblicazione;
    int numeroPagine;

    public Catalog(String titolo, int annoDiPubblicazione, int numeroPagine) {
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.numeroPagine = numeroPagine;
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
