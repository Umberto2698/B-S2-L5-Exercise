package enteties;

import enumerators.MagazinePeriodicity;

public class Magazine extends Catalog {

    MagazinePeriodicity periodicità;

    public Magazine(String titolo, MagazinePeriodicity periodicità, int annoDiPubblicazione, int numeroPagine) {
        super(titolo, annoDiPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "periodicità=" + periodicità +
                ", codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    public MagazinePeriodicity getPeriodicità() {
        return periodicità;
    }
}
