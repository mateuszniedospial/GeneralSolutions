package E_DesignPatterns.Factory.Classic;

/**
 * Created by Mateusz Niedośpiał on 20.05.2017.
 *
 * Specifying carbonated CocaColaCompanyDrinks.
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
public interface Carbonated extends CocaColaCompanyDrink {

    default void shakeAndOpen(){
        System.out.println("Your drink has spilled all over on you.");
    }
}
