package E_DesignPatterns.Builder.StepBuilder;

/**
 * Created by Mateusz Niedośpiał on 19.05.2017.
 *
 * A simple enum of possible Pizza's size.
 */
public enum PizzaSize {
    THIRTY(30),
    FORTY_FIVE(45),
    FIFTY(50),
    SIXTY(60)

    ;

    private final int asNumber;
    private PizzaSize(int asNumber){
        this.asNumber = asNumber;
    }

    public int getValue(){
        return asNumber;
    }
}
