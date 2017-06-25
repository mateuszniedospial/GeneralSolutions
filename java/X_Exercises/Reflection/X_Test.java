package X_Exercises.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Mateusz Niedośpiał on 24.04.2017.
 */
public class X_Test {

    public static void main(String[] args) {
        ReflectionCheck object = new ReflectionCheck();
        try {

            //Reflection for getting the private field from ReflectionCheck object:
            Field field = object.getClass().getDeclaredField("number");
            field.setAccessible(true); //Abracadabra

            System.out.println("You may be private but I can get You anyway: " + field.get(object));
            System.out.println("===========================================");
            System.out.println("I could even change you although You are final from the moment constructor was used: ");
            field.set(object, 30);
            System.out.println("... ... ...");
            System.out.println("See? You are now: " + field.get(object));
            System.out.println("===========================================");
            System.out.println("Now this is funny since I can use your private methods too...");
            System.out.println("Let's use ... hmm your private method changeAlohaToYours and make Your aloha a ROCK:");
            System.out.println("... ... ...");

            Method method = object.getClass().getDeclaredMethod("changeAlohaToYours", String.class);
            method.setAccessible(true);
            method.invoke(object, "ROCK");

            System.out.println("Check it out:");
            System.out.println(object.getSecondField());

            System.out.println("");
            System.out.println("___________________________________");
            System.out.println("You don't know the day nor the hour.");


        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
