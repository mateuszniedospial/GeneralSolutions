package E_DesignPatterns.Factory.Abstract;

/**
 * Created by Mateusz Niedośpiał on 20.05.2017.
 */
public class Poster implements AdItem {

    private String serialNumber;
    private double price;

    Poster(String serialNumber, double price) {
        this.serialNumber = serialNumber;
        this.price = price;
    }

    @Override
    public String name() {
        return serialNumber;
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public String type() {
        return "Poster";
    }
}
