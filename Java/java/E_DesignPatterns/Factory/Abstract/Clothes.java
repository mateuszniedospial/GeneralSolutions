package E_DesignPatterns.Factory.Abstract;

/**
 * Created by Mateusz Niedośpiał on 20.05.2017.
 *
 * Specifying Clothes of CocaColaAccessories.
 */
public interface Clothes extends CocaColaCompanyAccessory {
    @Override
    String type();
}
