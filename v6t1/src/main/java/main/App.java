package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Instrument> instruments = new ArrayList<>();

        int choice;

        do {
            System.out.println("1) Lisää soitin");
            System.out.println("2) Listaa soittimet");
            System.out.println("3) Viritä kielisoittimet");
            System.out.println("4) Soita rumpuja");
            System.out.println("0) Lopeta ohjelma");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.println("Minkä soittimen haluat lisätä? 1) Kitara, 2) Viulu, 3) Rummut");

                    int instrumentType = Integer.parseInt(sc.nextLine());

                    System.out.println("Anna valmistajan nimi:");
                    String manufacturer = sc.nextLine();

                    System.out.println("Anna hinta euroina:");
                    int price = Integer.parseInt(sc.nextLine());

                    switch (instrumentType) {
                        case 1:
                            instruments.add(new Guitar(manufacturer, price));
                            System.out.println("Soitin lisätty listaan!");
                            break;

                        case 2:
                            instruments.add(new Violin(manufacturer, price));
                            System.out.println("Soitin lisätty listaan!");
                            break;

                        case 3:
                            instruments.add(new Drum(manufacturer, price));
                            System.out.println("Soitin lisätty listaan!");
                            break;

                        default:
                            System.out.println("Virheellinen soitinvalinta.");
                    }
                    break;

                case 2:
                    if (instruments.isEmpty()) {
                        System.out.println("Ei lisättyjä soittimia.");
                    } else {
                        for (Instrument instrument : instruments) {
                            System.out.println(instrument.getDetails());
                        }
                    }
                    break;

                case 3:
                    for (Instrument instrument : instruments) {
                        if (instrument instanceof StringInstrument) {
                            ((StringInstrument) instrument).tune();
                        }
                    }
                    break;

                case 4:
                    for (Instrument instrument : instruments) {
                        if (instrument instanceof Drum) {
                            ((Drum) instrument).playBeat();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    break;
            }
        } while (choice != 0);

        sc.close();
    }
}