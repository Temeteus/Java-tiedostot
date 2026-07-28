package main;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Safe safe = new Safe("0000");

        while (true) {

            System.out.println("1) Aseta PIN-koodi");
            System.out.println("2) Lisää tietoja kansioon");
            System.out.println("3) Listaa tiedot kansiosta");
            System.out.println("0) Lopeta ohjelma");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {

                System.out.println("Anna uusi PIN-koodi:");
                String newPin = sc.nextLine();
                safe.changePin(newPin);

            } else if (choice == 2) {

                System.out.println("Anna kansioon lisättävä tieto:");
                String item = sc.nextLine();
                safe.addItem(item);

            } else if (choice == 3) {

                System.out.println("Anna PIN-koodi:");
                String pin = sc.nextLine();

                ArrayList<String> items = safe.getList(pin);

                if (items == null) {
                    System.out.println("Väärä PIN-koodi!");
                } else {
                    for (String item : items) {
                        System.out.println(item);
                    }
                }

            } else if (choice == 0) {

                System.out.println("Kiitos ohjelman käytöstä.");
                break;
            }
        }

        sc.close();
    }
}