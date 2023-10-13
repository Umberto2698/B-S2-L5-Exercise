package main;

import com.github.javafaker.Faker;
import enteties.Book;
import enteties.Catalog;
import enteties.Magazine;
import enumerators.MagazinePeriodicity;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Supplier;

public class Archives {

    public static void main(String[] args) {
        Faker faker = new Faker(Locale.ITALY);

        Supplier<Book> bookSupplier = () -> new Book(faker.book().title(), faker.book().author(), faker.book().genre());
        Supplier<Magazine> magazineSupplier = () -> new Magazine(faker.book().title());

        ArrayList<Catalog> catalogList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            catalogList.add(bookSupplier.get());
            catalogList.add(magazineSupplier.get());
        }


        Scanner input = new Scanner(System.in);
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
                                        }
                                        case 2 -> {
                                            Magazine newMagazine = new Magazine(title, yearOfPubblication, numberOfPages, codiceISBN, MagazinePeriodicity.MENSILE);
                                            catalogList.add(newMagazine);
                                        }
                                        case 3 -> {
                                            Magazine newMagazine = new Magazine(title, yearOfPubblication, numberOfPages, codiceISBN, MagazinePeriodicity.SEMESTRALE);
                                            catalogList.add(newMagazine);
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
                        } catch (NumberFormatException ex) {
                            System.err.println("Il valore inserito non è un numero.");
                        } catch (Exception ex) {
                            System.err.println("Problema generico");
                        }
                        long finalCodiceISBN = codiceISBN;
                        if (catalogList.stream().anyMatch(el -> el.getCodiceISBN() == finalCodiceISBN))
                            catalogList.stream().filter(el -> el.getCodiceISBN() != finalCodiceISBN);
                    } while (codiceISBN <= 1000000000000L || codiceISBN > 10000000000000L);
                }
            }
        }
        while (n != 0);


    }
}
