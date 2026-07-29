package main;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void listBooks() {
        int totalCopies = 0;

        for (Book book : books) {
            book.displayInfo();
            System.out.println("Kirjan kategoria: " + book.categorize());

            totalCopies += book.getCopies();
        }

        System.out.println("Kirjojen määrä kirjastossa on: " + totalCopies);
    }

    public void borrowBook(String title) {

        for (Book book : books) {

            if (book.getTitle().equals(title)
                    && book instanceof Borrowable) {

                ((Borrowable) book).borrow();
                return;
            }
        }

        System.out.println("Kirjaa ei löytynyt tai sitä ei voi lainata.");
    }

    public void returnBook(String title) {

        for (Book book : books) {

            if (book.getTitle().equals(title)
                    && book instanceof Borrowable) {

                ((Borrowable) book).returnBook();
                return;
            }
        }

        System.out.println("Kirjaa ei löytynyt tai sitä ei voi palauttaa.");
    }
}