package X_Exercises.Interfaces;

import X_Exercises.Interfaces.Frog;
import X_Exercises.Interfaces.Pigeon;
import X_Exercises.Interfaces.Run;
import X_Exercises.Interfaces.Swim;

import java.util.function.Predicate;

/**
 * Created by Mateusz Niedośpiał on 18.05.2017.
 */
public class X_Test {

    public static void main(String[] args) {
        Frog frog = new Frog("Mike", "Friendly", "Catch flies.");
        Pigeon pigeon = new Pigeon("Pidgey", "Faint-hearted", "Fly on a command.");

        frog.swim();
        Swim.swimAsFastAsPossible();

        Frog.Tadpole tadpole = new Frog.Tadpole();

        pigeon.run();

        Run runnbleCreature = new Pigeon("Frank", "Friendly", "Jumping for food.");
        runnbleCreature.run();

        Swim swimmableCreature = frog; //redundant
        swimmableCreature.swim();

        Swim swimmableCreature2 = new Frog("Floppo", "Friendly", "Swimming in circle.");
        swimmableCreature2.swim();
    }
}
