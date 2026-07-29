package main;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {

            System.out.println("1) Lisää kirja");
            System.out.println("2) Listaa kirjat");
            System.out.println("3) Lainaa fiktiokirja");
            System.out.println("4) Palauta fiktiokirja");
            System.out.println("0) Lopeta ohjelma");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:

                    System.out.println("Minkä kirjan haluat lisätä kirjastoon? 1) Fiktiokirja, 2) Tietokirja");

                    int type = Integer.parseInt(sc.nextLine());

                    System.out.println("Anna kirjan nimi:");
                    String title = sc.nextLine();

                    System.out.println("Anna kirjailijan nimi:");
                    String author = sc.nextLine();

                    System.out.println("Anna sivumäärä:");
                    int pages = Integer.parseInt(sc.nextLine());

                    System.out.println("Anna kirjojen määrä:");
                    int copies = Integer.parseInt(sc.nextLine());

                    if (type == 1) {
                        library.addBook(
                                new FictionBook(title, author, pages, copies));
                        System.out.println("Kirja lisätty kirjastoon!");
                    } else if (type == 2) {
                        library.addBook(
                                new NonFictionBook(title, author, pages, copies));
                        System.out.println("Kirja lisätty kirjastoon!");
                    } else {
                        System.out.println("Virheellinen kirjatyyppi.");
                    }

                    break;

                case 2:

                    library.listBooks();
                    break;

                case 3:

                    System.out.println("Anna lainattavan kirjan nimi:");
                    String borrowTitle = sc.nextLine();

                    library.borrowBook(borrowTitle);
                    break;

                case 4:

                    System.out.println("Anna palautettavan kirjan nimi:");
                    String returnTitle = sc.nextLine();

                    library.returnBook(returnTitle);
                    break;

                case 0:

                    System.out.println("Kiitos ohjelman käytöstä.");
                    break;

                default:
                    break;
            }

        } while (choice != 0);

        sc.close();
    }
}