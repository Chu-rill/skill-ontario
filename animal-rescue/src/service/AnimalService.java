package service;

import model.Animal;

import java.util.List;

public class AnimalService {
    public String generateId(List<Animal> animals) {
        return String.format("%08d", animals.size() + 1);
    }

    public void removeAnimal(List<Animal> animals, String id) {
        animals.removeIf(a -> a.getId().equals(id));
    }

    public List<Animal> search(List<Animal> animals, String keyword) {
        return animals.stream()
                .filter(a -> a.getName().equalsIgnoreCase(keyword)
                        || a.getSpecies().equalsIgnoreCase(keyword))
                .toList();
    }
}
