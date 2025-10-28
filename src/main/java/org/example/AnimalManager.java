package org.example;

public class AnimalManager {
    AnimalDAO animalDAO;

    public AnimalManager(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    public void manage() {

        Animal a = new Animal("zebra", 15, Animal.GenderType.UNKNOWN);
        animalDAO.saveAnimal(a);
        Animal b = new Animal("antilop", 1, Animal.GenderType.MALE);
        animalDAO.saveAnimal(b);

        for (Animal animal : animalDAO.getAnimals()) {
            System.out.println(animal);
        }

        Animal c = new Animal("lion", 7, Animal.GenderType.MALE);

        Zoo zoo = new Zoo("Debrecen Zoo");
        zoo.getAnimals().add(a);
        zoo.getAnimals().add(b);
        zoo.getAnimals().add(c);

        animalDAO.saveZoo(zoo);
    }
}
