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
public class Sprite implements Carbonated {

    private String volume;
    private String typeOfBottle;

    Sprite(String volume, String typeOfBottle) {
        this.volume = volume;
        this.typeOfBottle = typeOfBottle;
    }


    @Override
    public void drink() {
        System.out.println("Drinking Sprite of volume: " + volume + " and type of bottle: " + typeOfBottle + ".");
    }

    @Override
    public String name() {
        return "Sprite";
    }

    @Override
    public void shakeAndOpen(){
        System.out.println("Your Sprite has spilled-over on you, at least it has no color so after drying off it won't be that bad...");
    }
}
