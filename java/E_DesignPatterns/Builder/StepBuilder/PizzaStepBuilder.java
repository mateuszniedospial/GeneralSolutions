package E_DesignPatterns.Builder.StepBuilder;

import java.util.ArrayList;
import java.util.List;

import E_DesignPatterns.Builder.Classic.SampleClassWithBuilder;

/**
 * Created by Mateusz Niedośpiał on 19.05.2017.
 *
 * This is a simple implementation of StepBuilder design pattern.
 * The most remarkable feature of StepBuilder pattern is the guidance
 * which it provides for constructing an instance of class.
 * This feature is accomplished using inner interfaces and inner static class
 * which implements them. Returning this class from each next method maintains
 * specific order of methods and it amount on the way so it prevents
 * finally created object from being inconsistent internally.
 * This is also not much harder reusable and maintained design that a classic Builder.
 * Full responsibility lays on the StepBuilder side.
 *
 * Since in this case implementation of PizzaStepBuilder is written in
 * another class, the Pizza class does provide package-private basic constructor
 * so the Builder can use it underneath.
 *
 * @see SampleClassWithBuilder
 */
public class PizzaStepBuilder {


    /**
     * Prevent instantiating.
     */
    private PizzaStepBuilder(){}

    /**
     * Start building with this method and finish on the build() one.
     */
    public static TypeOfPie start(){
        return new StepBuilder();
    }

    public interface TypeOfPie{
        TomatoSauce typeOfPie(PieType type);
    }

    public interface TomatoSauce{
        DoesItHaveMeatOrFishIngredients amountOfTomatoSauce(String amount);
    }

    public interface DoesItHaveMeatOrFishIngredients{
        MeatOrFishIngredients meatOrFishIngredients(boolean doesItHave);
    }

    public interface MeatOrFishIngredients{
        MeatOrFishIngredients addMeat(String name);
        MeatOrFishIngredients addFish(String name);
        DoesItHaveVegetablesOrFruitsIngredients noMoreMeat();
    }

    public interface DoesItHaveVegetablesOrFruitsIngredients{
        VegetablesOrFruitsIngredients vegetablesOrFruitsIngredients(boolean doesItHave);
    }

    public interface VegetablesOrFruitsIngredients{
        VegetablesOrFruitsIngredients addVegetable(String name);
        VegetablesOrFruitsIngredients addFruit(String name);
        OfSize noMoreVegetablesOrFruits();
    }

    public interface OfSize{
        StartBuild ofSize(PizzaSize pizzaSize);
    }

    public interface StartBuild{

        /**
         * Ending method.
         */
        Pizza build();
    }

    /**
     * Inner class which actually do all the work through
     * overriden methods.
     */
    private static class StepBuilder implements TypeOfPie,
                                                TomatoSauce,
                                                DoesItHaveMeatOrFishIngredients,
                                                MeatOrFishIngredients,
                                                DoesItHaveVegetablesOrFruitsIngredients,
                                                VegetablesOrFruitsIngredients,
                                                OfSize,
                                                StartBuild {

        private PieType typeOfPie;
        private String amountOfTomatoSauce;

        private boolean doesItHaveMeatOrFishIngredients;

        private List<String> meatAndFishIngredients = new ArrayList<>();

        private boolean doesItHaveVegetablesOrFruitsIngredients;

        private List<String> vegetablesAndFruitsIngredients = new ArrayList<>();

        private PizzaSize size;

        private StepBuilder() {}


        @Override
        public TomatoSauce typeOfPie(PieType type) {
            this.typeOfPie = type;
            return this;
        }

        @Override
        public DoesItHaveMeatOrFishIngredients amountOfTomatoSauce(String amount) {
            this.amountOfTomatoSauce = amount;
            return this;
        }

        @Override
        public MeatOrFishIngredients meatOrFishIngredients(boolean doesItHave) {
            this.doesItHaveMeatOrFishIngredients = doesItHave;
            return this;
        }

        @Override
        public MeatOrFishIngredients addMeat(String name) {
            this.meatAndFishIngredients.add(name);
            return this;
        }

        @Override
        public MeatOrFishIngredients addFish(String name) {
            this.meatAndFishIngredients.add(name);
            return this;
        }

        @Override
        public DoesItHaveVegetablesOrFruitsIngredients noMoreMeat() {
            return this;
        }

        @Override
        public VegetablesOrFruitsIngredients vegetablesOrFruitsIngredients(boolean doesItHave) {
            this.doesItHaveVegetablesOrFruitsIngredients = doesItHave;
            return this;
        }

        @Override
        public VegetablesOrFruitsIngredients addVegetable(String name) {
            this.vegetablesAndFruitsIngredients.add(name);
            return this;
        }

        @Override
        public VegetablesOrFruitsIngredients addFruit(String name) {
            this.vegetablesAndFruitsIngredients.add(name);
            return this;
        }

        @Override
        public OfSize noMoreVegetablesOrFruits() {
            return this;
        }

        @Override
        public StartBuild ofSize(PizzaSize pizzaSize) {
            this.size = pizzaSize;
            return this;
        }

        @Override
        public Pizza build() {
            return new Pizza(typeOfPie,
                             amountOfTomatoSauce,
                             doesItHaveMeatOrFishIngredients,
                             meatAndFishIngredients,
                             doesItHaveVegetablesOrFruitsIngredients,
                             vegetablesAndFruitsIngredients,
                             size);
        }
    }
}
