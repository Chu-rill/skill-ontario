package com.churchill;

import main.java.model.Animal;
import main.java.util.FileHandler;

import java.util.List;
import java.util.Scanner;

public class Main {
   static Scanner scanner = new Scanner(System.in);
    public static void main() {

        while (true) {
            System.out.println("Select a task to perform");
            System.out.println("\n1. Add Animal");
            System.out.println("2. Remove Animal");
            System.out.println("3. Search");
            System.out.println("4. Display All");
            System.out.println("5. Update Animal");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Animal newAnimal = createAnimalFromInput();
                    FileHandler.appendAnimal(newAnimal);
                    System.out.println("Animal added successfully.");
                    break;
                case 2:
                    String removeId =  removeAnimalInput();
                    FileHandler.removeById(removeId);
                    break;
                case 3:
                    String keyword = searchAnimal();
                    List<Animal> Animals = FileHandler.search(keyword);
                    for (Animal a : Animals){
                        System.out.println(a);
                    }
                    break;
                case 4:
                    System.out.println("Displaying all animal");
                    List<Animal> loadedAnimals =   FileHandler.loadAnimals();
                    if (loadedAnimals.isEmpty()) {
                        System.out.println("No animals found.");
                    } else {
                        for (Animal a : loadedAnimals) {
                            System.out.println(a);
                        }
                    }
                    break;
                case 5:

                    String updateId = updateAnimalInput();
                    FileHandler.updateAnimal(updateId);
                    break;
                case 6:
                    return;
            }
        }
    }

    static Animal createAnimalFromInput() {
        scanner.nextLine(); // clear leftover newline

        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Species: ");
        String species = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Spayed/Neutered (true/false): ");
        boolean spayed = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("Breed: ");
        String breed = scanner.nextLine();

        System.out.print("Colour: ");
        String colour = scanner.nextLine();

        System.out.print("Birthday (YYYY-MM-DD): ");
        String birthday = scanner.nextLine();

        System.out.print("Vaccine Status: ");
        String vaccineStatus = scanner.nextLine();

        System.out.print("Identification (chip/tag): ");
        String identification = scanner.nextLine();

        System.out.print("Adopted (true/false): ");
        boolean adopted = Boolean.parseBoolean(scanner.nextLine());

        return new Animal(id, species, name, gender, spayed,
                breed, colour, birthday,
                vaccineStatus, identification, adopted);
    }

    static String removeAnimalInput(){
        scanner.nextLine(); // clear leftover newline

        System.out.print("ID: ");

        return scanner.nextLine();
    };

    static String updateAnimalInput(){
        scanner.nextLine(); // clear leftover newline

        System.out.print("Enter ID to update: ");

        return scanner.nextLine();
    };


    static String searchAnimal(){
        scanner.nextLine(); // clear leftover newline

        System.out.print("Search by Name or Specie: ");

        return scanner.nextLine();
    };
}
