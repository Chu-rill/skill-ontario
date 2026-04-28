package com.churchill.util;

import com.churchill.model.Animal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class FileHandler {
    private static final String FILE_PATH = "data/animals.csv";
    static Scanner scanner = new Scanner(System.in);

    public static List<Animal> loadAnimals() {
        List<Animal> animals = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                animals.add(new Animal(
                        data[0], data[1], data[2], data[3],
                        Boolean.parseBoolean(data[4]),
                        data[5], data[6], data[7],
                        data[8], data[9],
                        Boolean.parseBoolean(data[10])
                ));
            }
            return animals;
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
        return animals;
    }

    public static void saveAnimals(List<Animal> animals) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Animal a : animals) {
                pw.println(String.join(",",
                        a.getId(), a.getSpecies(), a.getName(),
                        a.getGender(), String.valueOf(a.isSpayed()),
                        a.getBreed(), a.getColour(), a.getBirthday(),
                        a.getVaccineStatus(), a.getIdentification(),
                        String.valueOf(a.isAdopted())
                ));
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public static void appendAnimal(Animal a) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH, true))) { // true = append mode
//            String uniqueID = UUID.randomUUID().toString();
            String genId = generateNextId();
            pw.println(String.join(",",
                    genId, a.getSpecies(), a.getName(),
                    a.getGender(), String.valueOf(a.isSpayed()),
                    a.getBreed(), a.getColour(), a.getBirthday(),
                    a.getVaccineStatus(), a.getIdentification(),
                    String.valueOf(a.isAdopted())
            ));
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public static void removeById(String id){
        List<Animal> loadedAnimals =   FileHandler.loadAnimals();

        boolean found = false;
        List<Animal> updated = new ArrayList<>();

        for (Animal a : loadedAnimals) {
            if (a.getId().equals(id)) {
                found = true; // skip this one — it's the one to remove
            } else {
                updated.add(a); // keep everyone else
            }
        }

        if (!found) {
            System.out.println("No animal found with ID: " + id);
            return;
        }

        saveAnimals(updated); // write the filtered list back
        System.out.println("Animal removed successfully.");
    }

    public static List<Animal> search(String keyword){
        List<Animal> loadedAnimals =   FileHandler.loadAnimals();
//        List<Animal> found = new ArrayList<>();
//
//        for (Animal a : loadedAnimals) {
//            if (a.getName().equalsIgnoreCase(keyword)
//                    || a.getSpecies().equalsIgnoreCase(keyword)) {
//                found.add(a);
//            }
//        }
//        return found;

        return loadedAnimals.stream()
                .filter(a -> a.getName().equalsIgnoreCase(keyword)
                        || a.getSpecies().equalsIgnoreCase(keyword))
                .toList();
    }

    public static void updateAnimal(String id) {
        List<Animal> animals = loadAnimals();
        boolean found = false;

        for (Animal a : animals) {
            if (a.getId().equals(id)) {
                found = true;

                System.out.println("What would you like to update?");
                System.out.println("1. Name");
                System.out.println("2. Species");
                System.out.println("3. Gender");
                System.out.println("4. Spayed");
                System.out.println("5. Breed");
                System.out.println("6. Colour");
                System.out.println("7. Birthday");
                System.out.println("8. Vaccine Status");
                System.out.println("9. Identification");
                System.out.println("10. Adopted");

                int choice = scanner.nextInt();
                scanner.nextLine(); // clear newline

                switch (choice) {
                    case 1:
                        System.out.print("New Name: ");
                        a.setName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("New Species (Dog/Cat/Bird/Rabbit/Small & Furry/Fish/Barnyard/Other): ");
                        a.setSpecies(scanner.nextLine());
                        break;
                    case 3:
                        System.out.print("New Gender (M/F): ");
                        a.setGender(scanner.nextLine());
                        break;
                    case 4:
                        System.out.print("Spayed (true/false): ");
                        a.setSpayed(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 5:
                        System.out.print("New Breed: ");
                        a.setBreed(scanner.nextLine());
                        break;
                    case 6:
                        System.out.print("New Colour: ");
                        a.setColour(scanner.nextLine());
                        break;
                    case 7:
                        System.out.print("New Birthday (YYYY-MM-DD): ");
                        a.setBirthday(scanner.nextLine());
                        break;
                    case 8:
                        System.out.print("New Vaccine Status (Up to date/Late/Unknown): ");
                        a.setVaccineStatus(scanner.nextLine());
                        break;
                    case 9:
                        System.out.print("New Identification (Barcode-XXXXX / Microchip-XXXXX / None): ");
                        a.setIdentification(scanner.nextLine());
                        break;
                    case 10:
                        System.out.print("Adopted (true/false): ");
                        a.setAdopted(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("No animal found with ID: " + id);
            return;
        }

        saveAnimals(animals);
        System.out.println("Animal updated successfully.");
    }

    public static String generateNextId() {
        List<Animal> animals = loadAnimals();
        int next = animals.size() + 1;
        return String.format("%08d", next); // pads to 8 digits → 00000001
    }
}
