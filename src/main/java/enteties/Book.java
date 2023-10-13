package enteties;

public class Book extends Catalog {
    String autore;
    String genere;

    public Book(String titolo, String autore, String genere) {
        super(titolo);
        this.autore = autore;
        this.genere = genere;
    }

    public Book(String titolo, String autore, String genere, int annoDiPubblicazione, int numeroPagine, long codiceISBN) {
        super(titolo, annoDiPubblicazione, numeroPagine, codiceISBN);
        this.autore = autore;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Book{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }
}
