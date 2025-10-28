package org.example;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.h2.tools.Server;

public class Application {

    public static void main(String[] args) throws SQLException {
        startDatabase();

        AnimalDAO animalDAO = new JpaAnimalDAO();
        Animal a = new Animal("zebra", 15, Animal.GenderType.UNKNOWN);
        animalDAO.saveAnimal(a);
        Animal b = new Animal("antilop", 1, Animal.GenderType.MALE);
        animalDAO.saveAnimal(b);

        for(Animal animal : animalDAO.getAnimals()){
            System.out.println(animal);
        }

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:mem:my_database");
        System.out.println("User Name: sa");
        System.out.println("Password: ");

    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
