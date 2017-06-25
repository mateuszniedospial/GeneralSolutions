package X_Exercises.Polimorphism.A_Zoo;

import X_Exercises.Polimorphism.A_Zoo.Animals.Animal;
import X_Exercises.Polimorphism.A_Zoo.Species.Mammal;
import X_Exercises.Polimorphism.A_Zoo.Species.Specie;

import java.util.List;

/**
 * Created by Mateusz Niedośpiał on 23.04.2017.
 */
class ZooOperations {

    static boolean checkCages(List<Animal> p_animals){
        try{
            p_animals.forEach(animal -> System.out.println(animal.occupiedCage()));
        } catch (Exception e){
            return false;
        }
        return true;
    }

    static void feedMammals(List<Animal> p_animals){
        p_animals.forEach(Specie::eat);
    }

    static void putMammalsToSleep(List<Animal> p_animals){
        p_animals.forEach(Specie::sleep);
    }

    static void furDropStart(List<Mammal> p_mammals){
        p_mammals.forEach(Mammal::furDrop);
    }
}
