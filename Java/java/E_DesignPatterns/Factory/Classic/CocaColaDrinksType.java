package E_DesignPatterns.Factory.Classic;

/**
 * Created by Mateusz Niedośpiał on 20.05.2017.
 *
 * Simple enum created for all drinks types which
 * CocaColaCompanyDrinkFactory can produce.
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
public enum CocaColaDrinksType {

    CAPPY(300),
    COCACOLA(300),
    FANTA(500),
    NESTEA(500),
    SPRITE(500)

    ;

    private final int basicVolume;

    CocaColaDrinksType(int basicVolume) {
        this.basicVolume = basicVolume;
    }

    public int getBasicVolume() {
        return basicVolume;
    }
}
