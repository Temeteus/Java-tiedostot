package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Syötä pelaajan nimi:");
        String name = sc.nextLine();

        Cave cave = new Cave(new Player(name));

        while (true) {

            System.out.println("1) Lisää luolaan hirviö");
            System.out.println("2) Listaa hirviöt");
            System.out.println("3) Hyökkää hirviöön");
            System.out.println("4) Tallenna peli");
            System.out.println("5) Lataa peli");
            System.out.println("0) Lopeta peli");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.println("Anna hirviön tyyppi:");
                    String type = sc.nextLine();

                    System.out.println("Anna hirviön elämän määrä numerona:");
                    int hp = Integer.parseInt(sc.nextLine());

                    cave.addMonster(new Monster(type, hp));
                    break;

                case 2:
                    System.out.println("Luolan hirviöt:");
                    cave.listMonsters();
                    break;

                case 3:
                    System.out.println("Valitse hirviö, johon hyökätä:");
                    cave.listMonsters();
                    int index = Integer.parseInt(sc.nextLine());

                    cave.attackMonster(index - 1);
                    break;

                case 4:
                    try {
                        System.out.println("Anna tiedoston nimi, johon peli tallentaa:");
                        String file = sc.nextLine();

                        ObjectOutputStream out =
                                new ObjectOutputStream(new FileOutputStream(file));

                        out.writeObject(cave);
                        out.close();

                        System.out.println("Peli tallennettiin tiedostoon " + file + ".");
                    } catch (Exception e) {
                        System.out.println("Tallennus epäonnistui.");
                    }
                    break;

                case 5:
                    try {
                        System.out.println("Anna tiedoston nimi, josta peli ladataan:");
                        String file = sc.nextLine();

                        ObjectInputStream in =
                                new ObjectInputStream(new FileInputStream(file));

                        cave = (Cave) in.readObject();
                        in.close();

                        System.out.println(
                                "Peli ladattu tiedostosta " + file + ". Tervetuloa takaisin, " + cave.getPlayer().getName() + ".");
                    } catch (Exception e) {
                        System.out.println("Lataus epäonnistui.");
                    }
                    break;

                case 0:
                    System.out.println("Peli päättyy. Kiitos pelaamisesta!");
                    sc.close();
                    return;
            }
        }
    }
}