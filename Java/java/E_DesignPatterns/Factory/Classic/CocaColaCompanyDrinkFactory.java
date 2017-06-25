package E_DesignPatterns.Factory.Classic;

import E_DesignPatterns.Factory.Abstract.CocaColaAccessoriesType;
import E_DesignPatterns.Factory.Abstract.CocaColaCompany;
import E_DesignPatterns.Factory.Abstract.CocaColaCompanyAccessory;

/**
 * Created by Mateusz Niedośpiał on 20.05.2017.
 *
 * This is simple implementation of Factory design pattern.
 * The idea is to create a class named with postfix Factory and
 * provide public static (or not static) method for all objects constructed within the
 * factory construction. Personally I prefer static method to not-static since
 * not static requires instantiating of Factory object itself.
 *
 * Method for constructing is used with if/switch statements to make decision
 * which object to produce.
 *
 * All classes examples for this factory listed below:
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
public class CocaColaCompanyDrinkFactory implements CocaColaCompany{

    /**
     * Must be public since is used also in implementation example of AbstractFactory design pattern.
     * @see CocaColaCompany;
     */
    public CocaColaCompanyDrinkFactory() {}

    /**
     * Method used for construction in implementation example of Classic Factory.
     */
//    public static CocaColaCompanyDrink makeDrink(CocaColaDrinksType cocaColaDrinksType, String volume, String typeOfBottle){
//        switch(cocaColaDrinksType){
//            case CAPPY:
//                return new Cappy(volume, typeOfBottle);
//            case COCACOLA:
//                return new CocaCola(volume, typeOfBottle);
//            case FANTA:
//                return new Fanta(volume, typeOfBottle);
//            case NESTEA:
//                return new Nestea(volume, typeOfBottle);
//            case SPRITE:
//                return new Sprite(volume, typeOfBottle);
//            default:
//                throw new UnsupportedOperationException("Specify the drink produced in this factory.");
//        }
//    }

    /**
     * Methods used for construction in implementation example of Abstract Factory.
     */
    @Override
    public CocaColaCompanyDrink makeDrinkForAbstract(CocaColaDrinksType cocaColaDrinksType, String volume, String typeOfBottle) {
        switch(cocaColaDrinksType){
            case CAPPY:
                return new Cappy(volume, typeOfBottle);
            case COCACOLA:
                return new CocaCola(volume, typeOfBottle);
            case FANTA:
                return new Fanta(volume, typeOfBottle);
            case NESTEA:
                return new Nestea(volume, typeOfBottle);
            case SPRITE:
                return new Sprite(volume, typeOfBottle);
            default:
                throw new UnsupportedOperationException("Specify the drink produced in this factory.");
        }
    }

    @Override
    public CocaColaCompanyAccessory produceAccessory(CocaColaAccessoriesType cocaColaAccessoriesType, String serialNumber, double price) {
        return null;
    }
}
