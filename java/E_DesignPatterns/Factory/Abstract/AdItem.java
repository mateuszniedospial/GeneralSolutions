package E_DesignPatterns.Factory.Abstract;

/**
 * Created by Mateusz Niedośpiał on 20.05.2017.
 *
 * Specifying AdItem of CocaColaAccessories.
 */
public interface AdItem extends CocaColaCompanyAccessory {
    @Override
    String type();
}
