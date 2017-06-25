package X_Exercises.Polimorphism.A_Zoo;

import X_Exercises.Polimorphism.A_Zoo.Animals.Animal;
import X_Exercises.Polimorphism.A_Zoo.Animals.AnimalSex;
import X_Exercises.Polimorphism.A_Zoo.Animals.Cat;
import X_Exercises.Polimorphism.A_Zoo.Species.Mammal;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Mateusz Niedośpiał on 23.04.2017.
 */
public class ZooSimulation {
    public static void run() {

        LocalDate date = LocalDate.now();
        Integer keepCosts = 1000;
        Animal bob = new Cat(date, keepCosts, Mammal.name, "Bob", AnimalSex.MALE, 2);
        Cat harry = new Cat(date, keepCosts, "Cat", "Harry", AnimalSex.MALE, 3);
        Cat dong = new Cat(date, keepCosts, "Jaguar", "Dong", AnimalSex.MALE, 4);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(bob);
        animals.add(harry);
        animals.add(dong);

        ZooOperations.checkCages(animals);
        System.out.println();
        System.out.println("Species:");
        animals.forEach(animal -> System.out.println(animal.getSpecie()));

        ArrayList<Mammal> mammals = new ArrayList<>();
        mammals.add(harry);
        mammals.add(dong);

        System.out.println("===========");

        ZooOperations.feedMammals(animals);
        ZooOperations.furDropStart(mammals);
        ZooOperations.putMammalsToSleep(animals);

        Exception nowy;
        nowy = new Exception();
    }
}
