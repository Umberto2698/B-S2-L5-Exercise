package enteties;

import enumerators.MagazinePeriodicity;

import java.util.Random;

public class Magazine extends Catalog {
    MagazinePeriodicity periodicità;

    public Magazine(String titolo) {
        super(titolo);
        int n = new Random().nextInt(1, 3);
        switch (n) {
            case 1 -> this.periodicità = MagazinePeriodicity.SETTIMANALE;
            case 2 -> this.periodicità = MagazinePeriodicity.MENSILE;
            case 3 -> this.periodicità = MagazinePeriodicity.SEMESTRALE;
        }
    }

    public Magazine(String titolo, int annoDiPubblicazione, int numeroPagine, long codiceISBN, MagazinePeriodicity periodicità) {
        super(titolo, annoDiPubblicazione, numeroPagine, codiceISBN);
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
