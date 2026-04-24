package util;

import model.Animal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileHandler {
    private static final String FILE_PATH = "src/data/animals.csv";

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

    public static String generateNextId() {
        List<Animal> animals = loadAnimals();
        int next = animals.size() + 1;
        return String.format("%08d", next); // pads to 8 digits → 00000001
    }
}
