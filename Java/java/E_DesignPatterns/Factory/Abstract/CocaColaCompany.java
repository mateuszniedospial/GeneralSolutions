package E_DesignPatterns.Factory.Abstract;

import E_DesignPatterns.Factory.Classic.CocaColaCompanyDrink;
import E_DesignPatterns.Factory.Classic.CocaColaDrinksType;
import E_DesignPatterns.Factory.Classic.CocaColaCompanyDrinkFactory;
import E_DesignPatterns.Factory.Classic.Carbonated;
import E_DesignPatterns.Factory.Classic.NotCarbonated;

import E_DesignPatterns.Factory.Classic.Cappy;
import E_DesignPatterns.Factory.Classic.CocaCola;
import E_DesignPatterns.Factory.Classic.Fanta;
import E_DesignPatterns.Factory.Classic.Nestea;
import E_DesignPatterns.Factory.Classic.Sprite;

/**
 * Created by Mateusz Niedośpiał on 20.05.2017.
 *
 * This is simple implementation example of Abstract Factory design pattern.
 * The idea is to create a factory that stands above the classic factories
 * and the FactoryProducer class which provide method to get desired factory
 * out of many different factories that e.g are properties of one single company (in this case CocaColaCompany).
 * This way construction of appropriate objects is more simple and robust.
 *
 * This implementation uses also the classic one as one of the available factories.
 * Small changes which had to be done are mentioned in the classic example.
 *
 * In this implementation the abstract factory is the interface. Nevertheless, there are cases
 * when usage of abstract class is more appropriate to use. There is no connection between
 * 'abstract' word in the name of the design pattern and 'abstract' keyword for class.
 *
 * All classes examples for this factory listed below:
 * @see CocaColaFactoryProducer
 *
 * @see CocaColaCompanyFactoriesType
 * @see CocaColaAccessoriesFactory
 * @see CocaColaCompanyDrinkFactory
 *
 * @see CocaColaCompanyAccessory
 * @see CocaColaCompanyDrink
 *
 * @see CocaColaAccessoriesType
 * @see CocaColaDrinksType
 *
 * @see AdItem
 * @see Clothes
 * @see Carbonated
 * @see NotCarbonated
 *
 * @see Poster
 * @see TShirt
 * @see Cappy
 * @see CocaCola
 * @see Fanta
 * @see Nestea
 * @see Sprite
 */
public interface CocaColaCompany {
    CocaColaCompanyDrink makeDrinkForAbstract(CocaColaDrinksType cocaColaDrinksType, String volume, String typeOfBottle);
    CocaColaCompanyAccessory produceAccessory(CocaColaAccessoriesType cocaColaAccessoriesType, String serialNumber, double price);
}
