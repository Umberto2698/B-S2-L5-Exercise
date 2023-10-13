package main;

import com.github.javafaker.Faker;
import enteties.Book;
import enteties.Catalog;
import enteties.Magazine;
import enumerators.MagazinePeriodicity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Archives {

    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker(Locale.ITALY);

        Supplier<Book> bookSupplier = () -> new Book(faker.book().title(), faker.book().author(), faker.book().genre());
        Supplier<Magazine> magazineSupplier = () -> new Magazine(faker.book().title());

        List<Catalog> catalogList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            catalogList.add(bookSupplier.get());
            catalogList.add(magazineSupplier.get());
        }

        System.err.println("Lista elementi nel catalogo:");
        catalogList.forEach(System.out::println);
        TimeUnit.MILLISECONDS.sleep(1500);

        Scanner input = new Scanner(System.in);

        System.out.println(System.lineSeparator());
        System.out.println("*****************************************************************");
        System.out.println(System.lineSeparator());
        List<Catalog> resultList = methodList(catalogList, input);
        resultList.forEach(System.out::println);
//        System.out.println("Benvenuto nell'archivio cosa desieri fare?");
//        int n = 0;
//        do {
//            System.out.println("Scegli un'azione da svolgere:");
//            System.out.println("1 - Aggiungere un elemento; 2 - Rimuovere un elemento tramite ISBN; 3 - Ricercare un elemento; 4 - Salvare l'archivio su disco; 5 - Caricare l'archivio; 0 - per chiudere. ");
//            try {
//                n = Integer.parseInt(input.nextLine());
//                if (n < 0 || n > 5) System.err.println("Inserisci un valore consentito.");
//
//            } catch (NumberFormatException ex) {
//                System.err.println("Il valore inserito non è un numero.");
//            } catch (Exception ex) {
//                System.err.println("Problema generico");
//            }
//            switch (n) {
//                case 1 -> {
//                    int m = 0;
//                    do {
//                        System.out.println("Scegli un'azione da svolgere:");
//                        System.out.println("1 - Aggiungere un libro; 2 - Aggiungere una rivista; 0 - Torna inditero.");
//                        try {
//                            m = Integer.parseInt(input.nextLine());
//                            if (m < 0 || m > 2) System.err.println("Inserisci un valore consentito.");
//                        } catch (NumberFormatException ex) {
//                            System.err.println("Il valore inserito non è un numero.");
//                        } catch (Exception ex) {
//                            System.err.println("Problema generico");
//                        }
//                        switch (m) {
//                            case 1 -> {
//                                System.out.println("Inserisci il titolo del libro.");
//                                String title = input.nextLine();
//                                System.out.println("Inserisci l'autore del libro.");
//                                String author = input.nextLine();
//                                System.out.println("Inserisci il genere del libro.");
//                                String genre = input.nextLine();
//                                int yearOfPubblication = 0;
//                                do {
//                                    System.out.println("Inserisci l'anno di pubblicazione.");
//                                    try {
//                                        yearOfPubblication = Integer.parseInt(input.nextLine());
//                                        if (yearOfPubblication <= 0)
//                                            System.err.println("Inserisci un valore consentito.");
//                                    } catch (NumberFormatException ex) {
//                                        System.err.println("Il valore inserito non è un numero.");
//                                    } catch (Exception ex) {
//                                        System.err.println("Problema generico");
//                                    }
//                                } while (yearOfPubblication <= 0);
//                                int numberOfPages = 0;
//                                do {
//                                    System.out.println("Inserisci il numero di pagine.");
//                                    try {
//                                        numberOfPages = Integer.parseInt(input.nextLine());
//                                        if (numberOfPages <= 0)
//                                            System.err.println("Inserisci un valore consentito.");
//                                    } catch (NumberFormatException ex) {
//                                        System.err.println("Il valore inserito non è un numero.");
//                                    } catch (Exception ex) {
//                                        System.err.println("Problema generico");
//                                    }
//                                } while (numberOfPages <= 0);
//                                long codiceISBN = 0;
//                                do {
//                                    System.out.println("Inserisci il codice ISBN, un numero intero con 13 cifre.");
//                                    try {
//                                        codiceISBN = Long.parseLong(input.nextLine());
//                                        if (codiceISBN <= 1000000000000L || codiceISBN > 10000000000000L)
//                                            System.err.println("Inserisci un valore consentito.");
//                                    } catch (NumberFormatException ex) {
//                                        System.err.println("Il valore inserito non è un numero.");
//                                    } catch (Exception ex) {
//                                        System.err.println("Problema generico");
//                                    }
//                                } while (codiceISBN <= 1000000000000L || codiceISBN > 10000000000000L);
//                                Book newBook = new Book(title, author, genre, yearOfPubblication, numberOfPages, codiceISBN);
//                                catalogList.add(newBook);
//                            }
//                            case 2 -> {
//                                System.out.println("Inserisci il titolo del libro.");
//                                String title = input.nextLine();
//                                int yearOfPubblication = 0;
//                                do {
//                                    System.out.println("Inserisci l'anno di pubblicazione.");
//                                    try {
//                                        yearOfPubblication = Integer.parseInt(input.nextLine());
//                                        if (yearOfPubblication <= 0)
//                                            System.err.println("Inserisci un valore consentito.");
//                                    } catch (NumberFormatException ex) {
//                                        System.err.println("Il valore inserito non è un numero.");
//                                    } catch (Exception ex) {
//                                        System.err.println("Problema generico");
//                                    }
//                                } while (yearOfPubblication <= 0);
//                                int numberOfPages = 0;
//                                do {
//                                    System.out.println("Inserisci il numero di pagine.");
//                                    try {
//                                        numberOfPages = Integer.parseInt(input.nextLine());
//                                        if (numberOfPages <= 0)
//                                            System.err.println("Inserisci un valore consentito.");
//                                    } catch (NumberFormatException ex) {
//                                        System.err.println("Il valore inserito non è un numero.");
//                                    } catch (Exception ex) {
//                                        System.err.println("Problema generico");
//                                    }
//                                } while (numberOfPages <= 0);
//                                long codiceISBN = 0;
//                                do {
//                                    System.out.println("Inserisci il codice ISBN, un numero intero con 13 cifre.");
//                                    try {
//                                        codiceISBN = Long.parseLong(input.nextLine());
//                                        if (codiceISBN <= 1000000000000L || codiceISBN > 10000000000000L)
//                                            System.err.println("Inserisci un valore consentito.");
//                                    } catch (NumberFormatException ex) {
//                                        System.err.println("Il valore inserito non è un numero.");
//                                    } catch (Exception ex) {
//                                        System.err.println("Problema generico");
//                                    }
//                                } while (codiceISBN <= 1000000000000L || codiceISBN > 10000000000000L);
//                                int a = 0;
//                                do {
//                                    System.out.println("Scegli la periodicità della rivista.");
//                                    try {
//                                        System.out.println("1 - Settimanale; 2 - Mensile; 3 - Semestrale.");
//                                        a = Integer.parseInt(input.nextLine());
//                                        if (a <= 0 || a > 3)
//                                            System.err.println("Inserisci un valore consentito.");
//                                    } catch (NumberFormatException ex) {
//                                        System.err.println("Il valore inserito non è un numero.");
//                                    } catch (Exception ex) {
//                                        System.err.println("Problema generico");
//                                    }
//                                    switch (a) {
//                                        case 1 -> {
//                                            Magazine newMagazine = new Magazine(title, yearOfPubblication, numberOfPages, codiceISBN, MagazinePeriodicity.SETTIMANALE);
//                                            catalogList.add(newMagazine);
//                                        }
//                                        case 2 -> {
//                                            Magazine newMagazine = new Magazine(title, yearOfPubblication, numberOfPages, codiceISBN, MagazinePeriodicity.MENSILE);
//                                            catalogList.add(newMagazine);
//                                        }
//                                        case 3 -> {
//                                            Magazine newMagazine = new Magazine(title, yearOfPubblication, numberOfPages, codiceISBN, MagazinePeriodicity.SEMESTRALE);
//                                            catalogList.add(newMagazine);
//                                        }
//                                    }
//                                } while (a <= 0 || a > 3);
//                            }
//                        }
//                    } while (m != 0);
//                }
//                case 2 -> {
//                    long codiceISBN = 0;
//                    do {
//                        System.out.println("Inserisci il codice ISBN dell'elemento che vuoi rimuovere, un numero intero con 13 cifre.");
//                        try {
//                            codiceISBN = Long.parseLong(input.nextLine());
//                            if (codiceISBN <= 1000000000000L || codiceISBN > 10000000000000L)
//                                System.err.println("Inserisci un valore consentito.");
//                            else {
//                                catalogList = removeElementFromCatalog(catalogList, codiceISBN, input);
//                            }
//                        } catch (NumberFormatException ex) {
//                            System.err.println("Il valore inserito non è un numero.");
//                        } catch (Exception ex) {
//                            System.err.println("Problema generico");
//                        }
//                    } while (codiceISBN <= 1000000000000L || codiceISBN > 10000000000000L);
//                }
//            }
//        }
//        while (n != 0);
    }

    public static List<Catalog> removeElementFromCatalogByISBN(List<Catalog> catalogList, long codiceISBN, Scanner input) {
        if (catalogList.stream().anyMatch(el -> el.getCodiceISBN() == codiceISBN))
            return catalogList.stream().filter(el -> el.getCodiceISBN() != codiceISBN).toList();
        else {
            String choice;
            do {
                System.err.println("Nessun elemento presente con questo codice, vuoi riprovare?");
                System.out.println("y - yes; n - no.");
                choice = input.nextLine().trim().toLowerCase();
                switch (choice) {
                    case "y" -> {
                        long newCodiceISBN = 0;
                        do {
                            System.out.println("Inserisci il codice ISBN dell'elemento che vuoi rimuovere, un numero intero con 13 cifre.");
                            try {
                                newCodiceISBN = Long.parseLong(input.nextLine());
                                if (newCodiceISBN <= 1000000000000L || newCodiceISBN > 10000000000000L)
                                    System.err.println("Inserisci un valore consentito.");
                                else {
                                    removeElementFromCatalogByISBN(catalogList, newCodiceISBN, input);
                                }
                            } catch (NumberFormatException ex) {
                                System.err.println("Il valore inserito non è un numero.");
                            } catch (Exception ex) {
                                System.err.println("Problema generico");
                            }
                        } while (newCodiceISBN <= 1000000000000L || newCodiceISBN > 10000000000000L);
                    }
                    case "n" -> methodList(catalogList, input);
                }
            } while (choice.equals("y") || choice.equals("n"));
        }
        return catalogList;
    }

    public static List<Catalog> searchElementFromCatalogByISBN(List<Catalog> catalogList, long codiceISBN, Scanner input) {
        if (catalogList.stream().anyMatch(el -> el.getCodiceISBN() == codiceISBN)) {
            return catalogList.stream().filter(el -> el.getCodiceISBN() == codiceISBN).toList();
        } else {
            String choice;
            do {
                System.err.println("Nessun elemento presente con questo codice, vuoi riprovare?");
                System.out.println("y - yes; n - no.");
                choice = input.nextLine().trim().toLowerCase();
                switch (choice) {
                    case "y" -> {
                        long newCodiceISBN = 0;
                        do {
                            System.out.println("Inserisci il codice ISBN dell'elemento ricercato, un numero intero con 13 cifre.");
                            try {
                                newCodiceISBN = Long.parseLong(input.nextLine());
                                if (newCodiceISBN <= 1000000000000L || newCodiceISBN > 10000000000000L)
                                    System.err.println("Inserisci un valore consentito.");
                                else {
                                    searchElementFromCatalogByISBN(catalogList, newCodiceISBN, input);
                                }
                            } catch (NumberFormatException ex) {
                                System.err.println("Il valore inserito non è un numero.");
                            } catch (Exception ex) {
                                System.err.println("Problema generico");
                            }
                        } while (newCodiceISBN <= 1000000000000L || newCodiceISBN > 10000000000000L);
                    }
                    case "n" -> methodList(catalogList, input);
                }
            } while (choice.equals("y") || choice.equals("n"));
        }
        return catalogList;
    }

    public static List<Catalog> searchElementFromCatalogByYear(List<Catalog> catalogList, int year, Scanner input) {
        if (catalogList.stream().anyMatch(el -> el.getAnnoDiPubblicazione() == year)) {
            return catalogList.stream().filter(el -> el.getAnnoDiPubblicazione() == year).toList();
        } else {
            String choice;
            do {
                System.err.println("Nessun elemento presente con questo anno di pubblicazione, vuoi riprovare?");
                System.out.println("y - yes; n - no.");
                choice = input.nextLine().trim().toLowerCase();
                switch (choice) {
                    case "y" -> {
                        int newYear = 0;
                        do {
                            System.out.println("Inserisci l'anno di pubblicazione (compreso tra 1500 e 2023) dell'elemento ricercato.");
                            try {
                                newYear = Integer.parseInt(input.nextLine());
                                if (newYear <= 1500 || newYear > 2023)
                                    System.err.println("Inserisci un valore consentito.");
                                else {
                                    return catalogList = searchElementFromCatalogByYear(catalogList, newYear, input);
                                }
                            } catch (NumberFormatException ex) {
                                System.err.println("Il valore inserito non è un numero.");
                            } catch (Exception ex) {
                                System.err.println("Problema generico");
                            }
                        } while (newYear <= 1500 || newYear > 2023);
                    }
                    case "n" -> methodList(catalogList, input);
                }
            } while (choice.equals("y") || choice.equals("n"));
        }
        return catalogList;
    }

    public static List<Catalog> methodList(List<Catalog> catalogList, Scanner input) {
        System.out.println("Benvenuto nell'archivio cosa desieri fare?");
        int n = 0;
        do {
            System.out.println("Scegli un'azione da svolgere:");
            System.out.println("1 - Aggiungere un elemento; 2 - Rimuovere un elemento tramite ISBN; 3 - Ricercare un elemento; 4 - Salvare l'archivio su disco; 5 - Caricare l'archivio; 0 - per chiudere. ");
            try {
                n = Integer.parseInt(input.nextLine());
                if (n < 0 || n > 5) System.err.println("Inserisci un valore consentito.");

            } catch (NumberFormatException ex) {
                System.err.println("Il valore inserito non è un numero.");
            } catch (Exception ex) {
                System.err.println("Problema generico");
            }
            switch (n) {
                case 1 -> {
                    int m = 0;
                    do {
                        System.out.println("Scegli un'azione da svolgere:");
                        System.out.println("1 - Aggiungere un libro; 2 - Aggiungere una rivista; 0 - Torna inditero.");
                        try {
                            m = Integer.parseInt(input.nextLine());
                            if (m < 0 || m > 2) System.err.println("Inserisci un valore consentito.");
                        } catch (NumberFormatException ex) {
                            System.err.println("Il valore inserito non è un numero.");
                        } catch (Exception ex) {
                            System.err.println("Problema generico");
                        }
                        switch (m) {
                            case 1 -> {
                                System.out.println("Inserisci il titolo del libro.");
                                String title = input.nextLine();
                                System.out.println("Inserisci l'autore del libro.");
                                String author = input.nextLine();
                                System.out.println("Inserisci il genere del libro.");
                                String genre = input.nextLine();
                                int yearOfPubblication = 0;
                                do {
                                    System.out.println("Inserisci l'anno di pubblicazione.");
                                    try {
                                        yearOfPubblication = Integer.parseInt(input.nextLine());
                                        if (yearOfPubblication <= 0)
                                            System.err.println("Inserisci un valore consentito.");
                                    } catch (NumberFormatException ex) {
                                        System.err.println("Il valore inserito non è un numero.");
                                    } catch (Exception ex) {
                                        System.err.println("Problema generico");
                                    }
                                } while (yearOfPubblication <= 0);
                                int numberOfPages = 0;
                                do {
                                    System.out.println("Inserisci il numero di pagine.");
                                    try {
                                        numberOfPages = Integer.parseInt(input.nextLine());
                                        if (numberOfPages <= 0)
                                            System.err.println("Inserisci un valore consentito.");
                                    } catch (NumberFormatException ex) {
                                        System.err.println("Il valore inserito non è un numero.");
                                    } catch (Exception ex) {
                                        System.err.println("Problema generico");
                                    }
                                } while (numberOfPages <= 0);
                                long codiceISBN = 0;
                                do {
                                    System.out.println("Inserisci il codice ISBN, un numero intero con 13 cifre.");
                                    try {
                                        codiceISBN = Long.parseLong(input.nextLine());
                                        if (codiceISBN <= 1000000000000L || codiceISBN > 10000000000000L)
                                            System.err.println("Inserisci un valore consentito.");
                                    } catch (NumberFormatException ex) {
                                        System.err.println("Il valore inserito non è un numero.");
                                    } catch (Exception ex) {
                                        System.err.println("Problema generico");
                                    }
                                } while (codiceISBN <= 1000000000000L || codiceISBN > 10000000000000L);
                                Book newBook = new Book(title, author, genre, yearOfPubblication, numberOfPages, codiceISBN);
                                catalogList.add(newBook);
                                return catalogList;
                            }
                            case 2 -> {
                                System.out.println("Inserisci il titolo del libro.");
                                String title = input.nextLine();
                                int yearOfPubblication = 0;
                                do {
                                    System.out.println("Inserisci l'anno di pubblicazione.");
                                    try {
                                        yearOfPubblication = Integer.parseInt(input.nextLine());
                                        if (yearOfPubblication <= 0)
                                            System.err.println("Inserisci un valore consentito.");
                                    } catch (NumberFormatException ex) {
                                        System.err.println("Il valore inserito non è un numero.");
                                    } catch (Exception ex) {
                                        System.err.println("Problema generico");
                                    }
                                } while (yearOfPubblication <= 0);
                                int numberOfPages = 0;
                                do {
                                    System.out.println("Inserisci il numero di pagine.");
                                    try {
                                        numberOfPages = Integer.parseInt(input.nextLine());
                                        if (numberOfPages <= 0)
                                            System.err.println("Inserisci un valore consentito.");
                                    } catch (NumberFormatException ex) {
                                        System.err.println("Il valore inserito non è un numero.");
                                    } catch (Exception ex) {
                                        System.err.println("Problema generico");
                                    }
                                } while (numberOfPages <= 0);
                                long codiceISBN = 0;
                                do {
                                    System.out.println("Inserisci il codice ISBN, un numero intero con 13 cifre.");
                                    try {
                                        codiceISBN = Long.parseLong(input.nextLine());
                                        if (codiceISBN <= 1000000000000L || codiceISBN > 10000000000000L)
                                            System.err.println("Inserisci un valore consentito.");
                                    } catch (NumberFormatException ex) {
                                        System.err.println("Il valore inserito non è un numero.");
                                    } catch (Exception ex) {
                                        System.err.println("Problema generico");
                                    }
                                } while (codiceISBN <= 1000000000000L || codiceISBN > 10000000000000L);
                                int a = 0;
                                do {
                                    System.out.println("Scegli la periodicità della rivista.");
                                    try {
                                        System.out.println("1 - Settimanale; 2 - Mensile; 3 - Semestrale.");
                                        a = Integer.parseInt(input.nextLine());
                                        if (a <= 0 || a > 3)
                                            System.err.println("Inserisci un valore consentito.");
                                    } catch (NumberFormatException ex) {
                                        System.err.println("Il valore inserito non è un numero.");
                                    } catch (Exception ex) {
                                        System.err.println("Problema generico");
                                    }
                                    switch (a) {
                                        case 1 -> {
                                            Magazine newMagazine = new Magazine(title, yearOfPubblication, numberOfPages, codiceISBN, MagazinePeriodicity.SETTIMANALE);
                                            catalogList.add(newMagazine);
                                            return catalogList;
                                        }
                                        case 2 -> {
                                            Magazine newMagazine = new Magazine(title, yearOfPubblication, numberOfPages, codiceISBN, MagazinePeriodicity.MENSILE);
                                            catalogList.add(newMagazine);
                                            return catalogList;
                                        }
                                        case 3 -> {
                                            Magazine newMagazine = new Magazine(title, yearOfPubblication, numberOfPages, codiceISBN, MagazinePeriodicity.SEMESTRALE);
                                            catalogList.add(newMagazine);
                                            return catalogList;
                                        }
                                    }
                                } while (a <= 0 || a > 3);
                            }
                        }
                    } while (m != 0);
                }
                case 2 -> {
                    long codiceISBN = 0;
                    do {
                        System.out.println("Inserisci il codice ISBN dell'elemento che vuoi rimuovere, un numero intero con 13 cifre.");
                        try {
                            codiceISBN = Long.parseLong(input.nextLine());
                            if (codiceISBN <= 1000000000000L || codiceISBN > 10000000000000L)
                                System.err.println("Inserisci un valore consentito.");
                            else {
                                return catalogList = removeElementFromCatalogByISBN(catalogList, codiceISBN, input);
                            }
                        } catch (NumberFormatException ex) {
                            System.err.println("Il valore inserito non è un numero.");
                        } catch (Exception ex) {
                            System.err.println("Problema generico");
                        }
                    } while (codiceISBN <= 1000000000000L || codiceISBN > 10000000000000L);
                }
                case 3 -> {
                    int b = 0;
                    do {
                        System.out.println("Scegli un'azione da svolgere:");
                        System.out.println("1 - Ricerca tramite codice ISBN; 2 - Ricerca tramite anno di pubblicazione; 3 - Ricerca per autore; 0 - Torna inditero.");
                        try {
                            b = Integer.parseInt(input.nextLine());
                            if (b < 0 || b > 3) System.err.println("Inserisci un valore consentito.");
                        } catch (NumberFormatException ex) {
                            System.err.println("Il valore inserito non è un numero.");
                        } catch (Exception ex) {
                            System.err.println("Problema generico");
                        }
                        switch (b) {
                            case 1 -> {
                                long codiceISBN = 0;
                                do {
                                    System.out.println("Inserisci il codice ISBN dell'elemento ricercato, un numero intero con 13 cifre.");
                                    try {
                                        codiceISBN = Long.parseLong(input.nextLine());
                                        if (codiceISBN <= 1000000000000L || codiceISBN > 10000000000000L)
                                            System.err.println("Inserisci un valore consentito.");
                                        else {
                                            return catalogList = searchElementFromCatalogByISBN(catalogList, codiceISBN, input);
                                        }
                                    } catch (NumberFormatException ex) {
                                        System.err.println("Il valore inserito non è un numero.");
                                    } catch (Exception ex) {
                                        System.err.println("Problema generico");
                                    }
                                } while (codiceISBN <= 1000000000000L || codiceISBN > 10000000000000L);
                            }
                            case 2 -> {
                                int year = 0;
                                do {
                                    System.out.println("Inserisci l'anno di pubblicazione (compreso tra 1500 e 2023) dell'elemento ricercato.");
                                    try {
                                        year = Integer.parseInt(input.nextLine());
                                        if (year <= 1500 || year > 2023)
                                            System.err.println("Inserisci un valore consentito.");
                                        else {
                                            return catalogList = searchElementFromCatalogByYear(catalogList, year, input);
                                        }
                                    } catch (NumberFormatException ex) {
                                        System.err.println("Il valore inserito non è un numero.");
                                    } catch (Exception ex) {
                                        System.err.println("Problema generico");
                                    }
                                } while (year <= 1500 || year > 2023);
                            }
                        }
                    } while (b < 0 || b > 3);
                }
            }
        } while (n != 0);
        return catalogList;
    }
}