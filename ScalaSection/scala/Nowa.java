/**
 * Created by Mateusz Niedośpiał on 18.06.2017.
 */
public class Nowa {

    private static final int NUMBER = 10;

    private String firstField;
    private String secondField;

    private Integer firstNumber;
    private int secondNumberPr;

    public Nowa(String firstField, String secondField, Integer firstNumber, int secondNumberPr) {
        this.firstField = firstField;
        this.secondField = secondField;
        this.firstNumber = firstNumber;
        this.secondNumberPr = secondNumberPr;
    }

    public static int getNUMBER() {
        return NUMBER;
    }

    public String getFirstField() {
        return firstField;
    }

    public String getSecondField() {
        return secondField;
    }

    public Integer getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumberPr() {
        return secondNumberPr;
    }

    public void setFirstField(String firstField) {
        this.firstField = firstField;
    }

    public void setSecondField(String secondField) {
        this.secondField = secondField;
    }

    public void setFirstNumber(Integer firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumberPr(int secondNumberPr) {
        this.secondNumberPr = secondNumberPr;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
