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
public class Fanta implements Carbonated {

    private String volume;
    private String typeOfBottle;

    Fanta(String volume, String typeOfBottle) {
        this.volume = volume;
        this.typeOfBottle = typeOfBottle;
    }

    @Override
    public void drink() {
        System.out.println("Drinking Fanta of volume: " + volume + " and type of bottle: " + typeOfBottle + ".");
    }

    @Override
    public String name() {
        return "Fanta";
    }

    @Override
    public void shakeAndOpen(){
        System.out.println("Your Fanta has spilled-over on you, your hands are sticky now. ");
    }
}
