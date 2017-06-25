package E_DesignPatterns.Builder.StepBuilder;

import java.util.ArrayList;
import java.util.List;

import E_DesignPatterns.Immutable.Immutable;

/**
 * Created by Mateusz Niedośpiał on 19.05.2017.
 *
 * Example class for which StepBuilder has been implemented.
 * Every Pizza instance is immutable.
 *
 * @see Immutable for more information about Immutability;
 */
public final class Pizza {
    private final PieType typeOfPie;
    private final String amountOfTomatoSauce;

    private final boolean doesItHaveMeatOrFishIngredients;

    private final List<String> meatAndFishIngredients;

    private final boolean doesItHaveVegetablesOrFruitsIngredients;

    private final List<String> vegetablesAndFruitsIngredients;

    private final PizzaSize size;

    Pizza(PieType typeOfPie, String amountOfTomatoSauce,
                 boolean doesItHaveMeatOrFishIngredients,
                 List<String> meatAndFishIngredients,
                 boolean doesItHaveVegetablesOrFruitsIngredients,
                 List<String> vegetablesAndFruitsIngredients,
                 PizzaSize size) {
        this.typeOfPie = typeOfPie;
        this.amountOfTomatoSauce = amountOfTomatoSauce;
        this.doesItHaveMeatOrFishIngredients = doesItHaveMeatOrFishIngredients;
        this.meatAndFishIngredients = new ArrayList<>(meatAndFishIngredients);
        this.doesItHaveVegetablesOrFruitsIngredients = doesItHaveVegetablesOrFruitsIngredients;
        this.vegetablesAndFruitsIngredients = new ArrayList<>(vegetablesAndFruitsIngredients);
        this.size = size;
    }

    public PieType getTypeOfPie() {
        return typeOfPie;
    }

    public String getAmountOfTomatoSauce() {
        return amountOfTomatoSauce;
    }

    public boolean doesItHaveMeatOrFishIngredients() {
        return doesItHaveMeatOrFishIngredients;
    }

    public List<String> getMeatAndFishIngredients() {
        return new ArrayList<>(meatAndFishIngredients);
    }

    public boolean doesItHaveVegetablesOrFruitsIngredients() {
        return doesItHaveVegetablesOrFruitsIngredients;
    }

    public List<String> getVegetablesAndFruitsIngredients() {
        return new ArrayList<>(vegetablesAndFruitsIngredients);
    }

    public int getSize() {
        return size.getValue();
    }
}
