package X_Exercises.Interfaces;

/**
 * Created by Mateusz Niedośpiał on 18.05.2017.
 */
public interface Run extends Walk{

    double maxSpeed();
    boolean canHuntWhileRunning();
    boolean canRunOnTwoLegs();

    default void run(){
        System.out.println("Creature is running.");
    }

    static void runAsFastAsPossible(){
        System.out.println("Creature is running as fast as possible.");
    }
}
