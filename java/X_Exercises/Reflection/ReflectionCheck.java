package X_Exercises.Reflection;

/**
 * Created by Mateusz Niedośpiał on 24.04.2017.
 */
public class ReflectionCheck {
    private final int number = 2;
    private static final int secondNumber = 3;

    private String field;
    private String secondField = "Aloha";

    ReflectionCheck() {
    }

    public ReflectionCheck(String field) {
        this.field = field;
    }

    private void changeAlohaToHello(){
        secondField = "Hello";
    }

    private void writeSecondFieldValueIntoField(){
        field = secondField;
    }

    private void changeAlohaToYours(String parameter){
        secondField = parameter;
    }

    public int getNumber() {
        return number;
    }

    public String getField() {
        return field;
    }

    String getSecondField() {
        return secondField;
    }
}
