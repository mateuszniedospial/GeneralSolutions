package E_DesignPatterns.Factory.Classic;

/**
 * Created by Mateusz Niedośpiał on 20.05.2017.
 *
 * Specifying not-carbonated CocaColaCompanyDrinks.
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
public interface NotCarbonated extends CocaColaCompanyDrink{

    default void shakeAndOpen(){
        System.out.println("You shook your drink and opened, everything is okay tho.");
    }
}
