package E_DesignPatterns.Factory.Abstract;

import E_DesignPatterns.Factory.Classic.CocaColaCompanyDrink;
import E_DesignPatterns.Factory.Classic.CocaColaDrinksType;
import E_DesignPatterns.Factory.Classic.CocaColaCompanyDrinkFactory;

/**
 * Created by Mateusz Niedośpiał on 20.05.2017.
 *
 * Simple classic factory implementation.
 * For more specific information:
 * @see CocaColaCompanyDrinkFactory
 */
public class CocaColaAccessoriesFactory implements CocaColaCompany {

    public CocaColaAccessoriesFactory() {}

    @Override
    public CocaColaCompanyAccessory produceAccessory(CocaColaAccessoriesType cocaColaAccessoriesType, String serialNumber, double price){
        switch(cocaColaAccessoriesType){
            case POSTER:
                return new Poster(serialNumber, price);
            case TSHIRT:
                return new TShirt(serialNumber, price);
            default:
                throw new UnsupportedOperationException("There is no such accessory produced in the factory.");
        }
    }

    @Override
    public CocaColaCompanyDrink makeDrinkForAbstract(CocaColaDrinksType cocaColaDrinksType, String volume, String typeOfBottle) {
        return null;
    }
}
