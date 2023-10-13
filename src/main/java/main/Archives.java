package main;

import com.github.javafaker.Faker;
import enteties.Book;
import enteties.Catalog;
import enteties.Magazine;

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
            System.out.println("1 - Aggiungere un elemento; 2 - Rimuovere un elemento tramite ISBN; 3 - Ricercare un elemento; 4 - Salvare l'archivio su disco; 5 - Caricare l'archivio; 0 - per chiudere. ");
            n = Integer.parseInt(input.nextLine());
        }
        while (n != 0);
    }
}
