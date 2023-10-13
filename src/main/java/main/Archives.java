package main;

import com.github.javafaker.Faker;
import enteties.Book;
import enteties.Catalog;
import enteties.Magazine;
import enumerators.MagazinePeriodicity;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Archives {

    public static void main(String[] args) throws InterruptedException, IOException {
        Faker faker = new Faker(Locale.ITALY);

        Supplier<Book> bookSupplier = () -> new Book(faker.book().title(), faker.book().author(), faker.book().genre());
        Supplier<Magazine> magazineSupplier = () -> new Magazine(faker.book().title());

        List<Catalog> catalogList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            catalogList.add(bookSupplier.get());
            catalogList.add(magazineSupplier.get());
        }

        File file = new File("src/main/catalog.txt");

        System.err.println("Lista elementi nel catalogo:");
        catalogList.forEach(System.out::println);
        TimeUnit.MILLISECONDS.sleep(1500);

        Scanner input = new Scanner(System.in);

        System.out.println(System.lineSeparator());
        System.out.println("*****************************************************************");
        System.out.println(System.lineSeparator());
        System.out.println("Benvenuto nell'archivio cosa desieri fare?");
        List<Catalog> resultList = methodList(catalogList, input, file);
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

    public static List<Catalog> removeElementFromCatalogByISBN(List<Catalog> catalogList, long codiceISBN, Scanner input, File file) throws InterruptedException, IOException {
        if (catalogList.stream().anyMatch(el -> el.getCodiceISBN() == codiceISBN)) {
//            methodList(catalogList, input);
            System.err.println("Elemento rimosso:");
            System.out.println(catalogList.stream().filter(el -> el.getCodiceISBN() == codiceISBN).toList());

            TimeUnit.MILLISECONDS.sleep(1000);

            System.err.println("Nuovo catalogo:");
            catalogList = catalogList.stream().filter(el -> el.getCodiceISBN() != codiceISBN).toList();
            salvaProdottiSuDisco(catalogList, file);
            return catalogList;
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
                            System.out.println("Inserisci il codice ISBN dell'elemento che vuoi rimuovere, un numero intero con 13 cifre.");
                            try {
                                newCodiceISBN = Long.parseLong(input.nextLine());
                                if (newCodiceISBN <= 1000000000000L || newCodiceISBN > 10000000000000L)
                                    System.err.println("Inserisci un valore consentito.");
                                else {
                                    removeElementFromCatalogByISBN(catalogList, newCodiceISBN, input, file);
                                }
                            } catch (NumberFormatException ex) {
                                System.err.println("Il valore inserito non è un numero.");
                            } catch (Exception ex) {
                                System.err.println("Problema generico");
                            }
                        } while (newCodiceISBN <= 1000000000000L || newCodiceISBN > 10000000000000L);
                    }
                    case "n" -> methodList(catalogList, input, file);
                }
            } while (choice.equals("y") || choice.equals("n"));
        }
        return catalogList;
    }

    public static void searchElementFromCatalogByISBN(List<Catalog> catalogList, long codiceISBN, Scanner input, File file) throws IOException {
        if (catalogList.stream().anyMatch(el -> el.getCodiceISBN() == codiceISBN)) {
            System.err.println("Risultato ricerca:");
            System.out.println(catalogList.stream().filter(el -> el.getCodiceISBN() == codiceISBN).toList());
            methodList(catalogList, input, file);
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
                                    searchElementFromCatalogByISBN(catalogList, newCodiceISBN, input, file);
                                }
                            } catch (NumberFormatException ex) {
                                System.err.println("Il valore inserito non è un numero.");
                            } catch (Exception ex) {
                                System.err.println("Problema generico");
                            }
                        } while (newCodiceISBN <= 1000000000000L || newCodiceISBN > 10000000000000L);
                    }
                    case "n" -> methodList(catalogList, input, file);
                }
            } while (choice.equals("y") || choice.equals("n"));
        }
    }

    public static void searchElementFromCatalogByYear(List<Catalog> catalogList, int year, Scanner input, File file) throws IOException {
        if (catalogList.stream().anyMatch(el -> el.getAnnoDiPubblicazione() == year)) {
            System.err.println("Risultato ricerca:");
            System.out.println(catalogList.stream().filter(el -> el.getAnnoDiPubblicazione() == year).toList());
            methodList(catalogList, input, file);
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
                                    searchElementFromCatalogByYear(catalogList, newYear, input, file);
                                }
                            } catch (NumberFormatException ex) {
                                System.err.println("Il valore inserito non è un numero.");
                            } catch (Exception ex) {
                                System.err.println("Problema generico");
                            }
                        } while (newYear <= 1500 || newYear > 2023);
                    }
                    case "n" -> methodList(catalogList, input, file);
                }
            } while (choice.equals("y") || choice.equals("n"));
        }
    }

    public static void searchElementFromCatalogByAuthor(List<Catalog> catalogList, String author, Scanner input, File file) throws IOException {
        List<Catalog> onlyBook = catalogList.stream().filter(el -> el.getClass() == Book.class && ((Book) el).getAutore().equals(author)).toList();
        if (onlyBook.stream().anyMatch(el -> ((Book) el).getAutore().equals(author))) {
            System.err.println("Risultato ricerca:");
            System.out.println(onlyBook.stream().filter(el -> ((Book) el).getAutore().equals(author)).toList());
            methodList(catalogList, input, file);
        } else {
            String choice;
            do {
                System.err.println("Nessun elemento presente con questo autore, vuoi riprovare?");
                System.out.println("y - yes; n - no.");
                choice = input.nextLine().trim().toLowerCase();
                switch (choice) {
                    case "y" -> {
                        System.out.println("Inserisci l'autore dell'elemento ricercato.");
                        String newAuthor = input.nextLine();
                        searchElementFromCatalogByAuthor(catalogList, newAuthor, input, file);
                    }
                    case "n" -> methodList(catalogList, input, file);
                }
            } while (choice.equals("y") || choice.equals("n"));
        }
    }

    public static void salvaProdottiSuDisco(List<Catalog> catalogList, File file) throws IOException {
        FileUtils.writeStringToFile(file, " ", StandardCharsets.UTF_8);
        List<Catalog> onlyBooks = catalogList.stream().filter(el -> el.getClass() == Book.class).toList();
        List<Catalog> onlyMagazines = catalogList.stream().filter(el -> el.getClass() == Magazine.class).toList();
        try {
            for (Catalog element : onlyBooks) {
                FileUtils.writeStringToFile(file, ((Book) element).getAutore() + "-" + ((Book) element).getGenere() + "-" + element.getTitolo()
                        + "-" + element.getNumeroPagine() + "-" + element.getAnnoDiPubblicazione() + "-" + element.getCodiceISBN()
                        + System.lineSeparator(), StandardCharsets.UTF_8, true);
            }
            for (Catalog element : onlyMagazines) {
                FileUtils.writeStringToFile(file, ((Magazine) element).getPeriodicità() + "-" + element.getTitolo()
                        + "-" + element.getNumeroPagine() + "-" + element.getAnnoDiPubblicazione()
                        + "-" + element.getCodiceISBN() + System.lineSeparator(), StandardCharsets.UTF_8, true);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<Catalog> caricaDaDisco(File file) {
        List<Catalog> empityCatalogList = new ArrayList<>();
        try {
            String contenuto = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            String[] separetedElementString = contenuto.split(System.lineSeparator());
            for (String element : separetedElementString) {
                String[] productData = element.split("-");
                if (productData.length == 6) {
                    Catalog composedProduct = new Book(productData[2], productData[0], productData[1], Integer.parseInt(productData[4]), Integer.parseInt(productData[3]), Long.parseLong(productData[5]));
                    empityCatalogList.add(composedProduct);
                } else if (productData.length == 5) {
                    if (productData[0].equals("SETTIMANALE")) {
                        Catalog composedProduct = new Magazine(productData[1], Integer.parseInt(productData[3]), Integer.parseInt(productData[2]), Long.parseLong(productData[4]), MagazinePeriodicity.SETTIMANALE);
                        empityCatalogList.add(composedProduct);
                    } else if (productData[0].equals("MENSILE")) {
                        Catalog composedProduct = new Magazine(productData[1], Integer.parseInt(productData[3]), Integer.parseInt(productData[2]), Long.parseLong(productData[4]), MagazinePeriodicity.MENSILE);
                        empityCatalogList.add(composedProduct);
                    } else if (productData[0].equals("SEMESTRALE")) {
                        Catalog composedProduct = new Magazine(productData[1], Integer.parseInt(productData[3]), Integer.parseInt(productData[2]), Long.parseLong(productData[4]), MagazinePeriodicity.SEMESTRALE);
                        empityCatalogList.add(composedProduct);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return empityCatalogList;
    }

    public static List<Catalog> methodList(List<Catalog> catalogList, Scanner input, File file) throws IOException {
        int n = 0;
        do {
            System.out.println("Scegli un'azione da svolgere:");
            System.out.println("1 - Aggiungere un elemento; 2 - Rimuovere un elemento tramite ISBN; 3 - Ricercare un elemento; 4 - Salvare l'archivio su disco; 5 - Caricare l'archivio; 0 - Per chiudere. ");
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
                                return removeElementFromCatalogByISBN(catalogList, codiceISBN, input, file);
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
                                            searchElementFromCatalogByISBN(catalogList, codiceISBN, input, file);
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
                                            searchElementFromCatalogByYear(catalogList, year, input, file);
                                        }
                                    } catch (NumberFormatException ex) {
                                        System.err.println("Il valore inserito non è un numero.");
                                    } catch (Exception ex) {
                                        System.err.println("Problema generico");
                                    }
                                } while (year <= 1500 || year > 2023);
                            }
                            case 3 -> {
                                System.out.println("Inserisci l'autore dell'elemento ricercato.");
                                String author = input.nextLine();
                                searchElementFromCatalogByAuthor(catalogList, author, input, file);
                            }
                        }
                    } while (b < 0 || b > 3);
                }
                case 4 -> salvaProdottiSuDisco(catalogList, file);
                case 5 -> caricaDaDisco(file).forEach(System.out::println);
            }
        } while (n != 0);
        return catalogList;
    }
}