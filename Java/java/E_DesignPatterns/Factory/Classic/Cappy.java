package E_DesignPatterns.Factory.Classic;

/**
 * Created by Mateusz Niedośpiał on 20.05.2017.
 *
 * @see CocaColaCompanyDrink
 * @see Carbonated
 * @see NotCarbonated
 *
 * @see CocaColaDrinksType
 *
 * @see Cappy
 * @see CocaCola
 * @see Fanta
 * @see Nestea
 * @see Sprite
 */
public class Cappy implements NotCarbonated {

    private String volume;
    private String typeOfBottle;

    Cappy(String volume, String typeOfBottle) {
        this.volume = volume;
        this.typeOfBottle = typeOfBottle;
    }

    @Override
    public void drink() {
        System.out.println("Drinking cappy of volume: " + volume + ", type of bottle: " + typeOfBottle + ".");
    }

    @Override
    public String name() {
        return "Cappy";
    }
}
