package X_Exercises.Interfaces;

/**
 * Created by Mateusz Niedośpiał on 18.05.2017.
 */
public interface Walk {

    boolean FOR_ANIMALS = true;
    boolean FOR_HUMANS = true;
    boolean FOR_MACHINES = false;

    void isWalking();
    double maxSpeed();
    boolean canHuntWhileWalking();
}
