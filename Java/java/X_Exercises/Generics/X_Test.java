package X_Exercises.Generics;

import java.util.List;

/**
 * Created by Mateusz Niedośpiał on 25.04.2017.
 */
public class X_Test {

    public static void main(String[] args) {

        //BACKPACK COLLECTION CHECK:

        Backpack<String> ashBP = new Backpack<>();
        ashBP.add("6 Pokeballs");
        ashBP.add("3 Potions");
        ashBP.add("1 Repel");
        ashBP.add("3 Meals");

        Backpack<String> mistyBP = new Backpack<>();
        mistyBP.add("2 Pokeballs");
        mistyBP.add("1 Tissue Box");
        mistyBP.add("4 Meals");
        mistyBP.add("2 Greatballs");

        System.out.println("============================================");
        System.out.println("== Content of Ash's and Misty's Backpacks ==");
        System.out.println("============================================");

        List<String> contentAsh = ashBP.retrieveAll();
        List<String> contentMisty = mistyBP.retrieveAll();

        ReadingData ashRD = new ReadingData<>(contentAsh, "Ash", 1700);
        ReadingData mistyRD = new ReadingData<>(contentMisty, "Misty", 500);
        Thread t1 = new Thread(ashRD);
        Thread t2 = new Thread(mistyRD);

        t1.start();
        t2.start();

        //BACKPACK COLLECTION CHECK END.
    }

}
