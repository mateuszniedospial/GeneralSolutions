package X_Exercises.Polimorphism.A_Zoo.Species;

import X_Exercises.Polimorphism.A_Zoo.Animals.AnimalSex;

/**
 * Created by Mateusz Niedośpiał on 23.04.2017.
 */
public interface Mammal extends Specie {
    String name = "Mammal";

    boolean canProduceMilk(AnimalSex animalSex);
    void furDrop();
    void teethUse();
}
