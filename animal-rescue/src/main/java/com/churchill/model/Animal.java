package com.churchill.model;

public class Animal {
    private String id;
    private String species;
    private String name;
    private String gender;
    private boolean isSpayed;
    private String breed;
    private String colour;
    private String birthday;
    private String vaccineStatus;
    private String identification;
    private boolean isAdopted;

    // Constructor
    public Animal(String id, String species, String name, String gender, boolean isSpayed,
                  String breed, String colour, String birthday, String vaccineStatus,
                  String identification, boolean isAdopted) {
        this.id = id;
        this.species = species;
        this.name = name;
        this.gender = gender;
        this.isSpayed = isSpayed;
        this.breed = breed;
        this.colour = colour;
        this.birthday = birthday;
        this.vaccineStatus = vaccineStatus;
        this.identification = identification;
        this.isAdopted = isAdopted;
    }

    // Getters
    public String getId() { return id; }
    public String getSpecies() { return species; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public boolean isSpayed() { return isSpayed; }
    public String getBreed() { return breed; }
    public String getColour() { return colour; }
    public String getBirthday() { return birthday; }
    public String getVaccineStatus() { return vaccineStatus; }
    public String getIdentification() { return identification; }
    public boolean isAdopted() { return isAdopted; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setSpecies(String species) { this.species = species; }
    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setSpayed(boolean isSpayed) { this.isSpayed = isSpayed; }
    public void setBreed(String breed) { this.breed = breed; }
    public void setColour(String colour) { this.colour = colour; }
    public void setBirthday(String birthday) { this.birthday = birthday; }
    public void setVaccineStatus(String vaccineStatus) { this.vaccineStatus = vaccineStatus; }
    public void setIdentification(String identification) { this.identification = identification; }
    public void setAdopted(boolean isAdopted) { this.isAdopted = isAdopted; }


    @Override
    public String toString() {
        return String.format(
                "ID: %s | Species: %s | Name: %s | Gender: %s | Spayed: %s | " +
                        "Breed: %s | Colour: %s | Birthday: %s | Vaccine: %s | ID Tag: %s | Adopted: %s",
                id, species, name, gender, isSpayed,
                breed, colour, birthday, vaccineStatus, identification, isAdopted
        );
    }
}