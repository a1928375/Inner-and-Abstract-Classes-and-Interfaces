package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Players tina = new Players("Tina", 100, 100);
        System.out.println(tina.toString());
        save(tina);

        tina.setHP(86);
        System.out.println(tina.toString());

        load(tina);
        save(tina);

        Monsters wolves = new Monsters("Wolves", 10000, 2000);
        //ISavable wolves = new Monsters("Wolves", 10000, 2000);
        System.out.println(wolves.toString());
        save(wolves);

    }

    public static ArrayList<String> readValues() {

        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        int index = 0;

        System.out.println("Choose\n" +
                           "1 to enter a string\n" +
                           "0 to quit");

        while (!quit) {

            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                case 0:
                    quit = true;
                    break;

                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }

        return values;
    }

    public static void save (ISavable object) {

        for (int i = 0; i < object.saving().size(); i++) {

            System.out.println("The " + object.saving().get(i) + " has been saved.");
        }

    }

    public static void load (ISavable object) {

            ArrayList<String> values = readValues();
            object.loading(values);

    }
}
