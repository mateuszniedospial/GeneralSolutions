package X_Exercises.Polimorphism.A_Zoo.Animals;

/**
 * Created by Mateusz Niedośpiał on 23.04.2017.
 */
public enum AnimalSex {
    MALE(false),
    FEMALE(true),
    BOTH(true)

    ;

    boolean canAdjust;

    AnimalSex(boolean canAdjust) {
        this.canAdjust = canAdjust;
    }
}
