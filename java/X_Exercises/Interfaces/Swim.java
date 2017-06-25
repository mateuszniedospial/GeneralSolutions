package X_Exercises.Interfaces;

/**
 * Created by Mateusz Niedośpiał on 18.05.2017.
 */
public interface Swim {

    boolean FOR_ANIMALS = true;
    boolean FOR_HUMANS = true;
    boolean FOR_MACHINES = false;

    void isSwimming();
    double maxSpeed();
    boolean canHuntWhileSwimming();


    /**
     * Default interface methods can be but doesn't have to be overriden by class that implements
     * the interface. The method can be invoked only on instance of a class that implements the interface.
     * Must have the body.
     */
    default void swim(){
        System.out.println("Creature is swimming.");
    }


    /**
     * Static interface methods cannot be overriden by class that implements the interface.
     * The method can be invoked only using static invocation on the interface and has
     * nothing to do with the instance of the class implementing the interface.
     * Must have the body.
     */
    static void swimAsFastAsPossible(){
        System.out.println("Creature is swimming as fast as possible.");
    }
}
