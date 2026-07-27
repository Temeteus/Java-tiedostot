package main;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Anna auton merkki: ");
        String brand = sc.nextLine();

        System.out.print("Anna auton malli: ");
        String model = sc.nextLine();

        Car car = new Car(brand, model);

        int choice;

        do {

            System.out.println();
            System.out.println("1) Näytä auton tila");
            System.out.println("2) Muokkaa auton merkkiä ja mallia");
            System.out.println("3) Kiihdytä autoa");
            System.out.println("4) Hidasta autoa");
            System.out.println("0) Lopeta ohjelma");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    car.status();
                    break;

                case 2:
                    System.out.print("Anna uusi auton merkki: ");
                    String newBrand = sc.nextLine();

                    System.out.print("Anna uusi auton malli: ");
                    String newModel = sc.nextLine();

                    car.setCar(newBrand, newModel);
                    break;

                case 3:
                    System.out.print("Kuinka monta km/h haluat kiihdyttää? ");
                    int accel = Integer.parseInt(sc.nextLine());

                    if (accel < 0) {
                        System.out.println(
                                "Nopeuden täytyy olla positiivinen luku.");
                    } else {
                        car.accelerate(accel);
                    }
                    break;

                case 4:
                    System.out.print("Kuinka monta km/h haluat hidastaa? ");
                    int decel = Integer.parseInt(sc.nextLine());

                    if (decel < 0) {
                        System.out.println( "Nopeuden täytyy olla positiivinen luku.");
                    } else {
                        car.decelerate(decel);
                    }
                    break;

                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    break;

                default:
                    System.out.println("Syöte oli väärä");
            }

        } while (choice != 0);

        sc.close();
    }
}