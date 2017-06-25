package E_DesignPatterns.Factory.Abstract;

import E_DesignPatterns.Factory.Classic.CocaColaCompanyDrinkFactory;

/**
 * Created by Mateusz Niedośpiał on 20.05.2017.
 */
public class CocaColaFactoryProducer {

    private CocaColaFactoryProducer() {}

    public static CocaColaCompany getFactory(CocaColaCompanyFactoriesType cocaColaCompanyFactoriesType){
        switch (cocaColaCompanyFactoriesType){
            case ACCESSORY:
                return new CocaColaAccessoriesFactory();
            case DRINK:
                return new CocaColaCompanyDrinkFactory();
            default:
                throw new UnsupportedOperationException("Specify the factory.");
        }
    }
}
