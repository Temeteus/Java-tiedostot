package main;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Anna tehtaalle nimi:");
        String factoryName = sc.nextLine();

        Factory factory = new Factory(factoryName);

        int choice;

        do {
            System.out.println("1) Lisää kone");
            System.out.println("2) Listaa kaikki koneet");
            System.out.println("0) Lopeta ohjelma");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.println("Anna koneen tyyppi:");
                    String type = sc.nextLine();

                    System.out.println("Anna koneen malli:");
                    String model = sc.nextLine();

                    System.out.println("Anna työntekijän nimi:");
                    String workerName = sc.nextLine();

                    System.out.println("Anna työntekijän ammattinimike:");
                    String workerRole = sc.nextLine();

                    Worker worker = new Worker(workerName, workerRole);
                    Machine machine = new Machine(type, model, worker);

                    factory.addMachine(machine);

                    System.out.println("Kone lisätty!");
                    break;

                case 2:
                    System.out.println("Tehtaasta " + factory.getName()
                            + " löytyy seuraavat koneet:");

                    for (Machine m : factory.getMachines()) {
                        System.out.println(m.getMachineDetails());
                        System.out.println();
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