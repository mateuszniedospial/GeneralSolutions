package E_DesignPatterns;

import E_DesignPatterns.Builder.Classic.SampleClassWithBuilder;
import E_DesignPatterns.Builder.StepBuilder.PieType;
import E_DesignPatterns.Builder.StepBuilder.Pizza;
import E_DesignPatterns.Builder.StepBuilder.PizzaSize;
import E_DesignPatterns.Builder.StepBuilder.PizzaStepBuilder;
import E_DesignPatterns.Factory.Abstract.*;
import E_DesignPatterns.Factory.Classic.CocaColaCompanyDrink;
import E_DesignPatterns.Factory.Classic.CocaColaDrinksType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mateusz Niedośpiał on 19.05.2017.
 */
public class X_Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("STRING");

        Set<Integer> set = new HashSet<>();
        set.add(50);

        SampleClassWithBuilder.Builder builder = new SampleClassWithBuilder.Builder();
        SampleClassWithBuilder immutableInstance = builder
                .setFIELD_1("FIELD_1")
                .setFIELD_2("FIELD_2")
                .setFIELD_3(3)
                .setFIELD_4(5)
                .setLIST(list)
                .setSET(set)
                .build();

        Pizza fruitParadise = PizzaStepBuilder.start()
                .typeOfPie(PieType.EXTRA_THICK)
                .amountOfTomatoSauce("small")
                .meatOrFishIngredients(true)
                .addFish("salmon")
                .addMeat("salami")
                .noMoreMeat()
                .vegetablesOrFruitsIngredients(true)
                .addVegetable("tomato")
                .addFruit("kiwi")
                .noMoreVegetablesOrFruits()
                .ofSize(PizzaSize.THIRTY)
                .build();

        // CLASSIC FACTORY

//        CocaColaCompanyDrink fanta = CocaColaCompanyDrinkFactory.makeDrink(CocaColaDrinksType.FANTA, "500", "plastic");
//        fanta.shakeAndOpen();
//        fanta.drink();

        // ABSTRACT FACTORY:

        CocaColaCompany accessoryFactory = CocaColaFactoryProducer.getFactory(CocaColaCompanyFactoriesType.ACCESSORY);
        CocaColaCompanyAccessory shirtAccessory = accessoryFactory.produceAccessory(CocaColaAccessoriesType.TSHIRT, "045x12a&642C", 10.99);
        shirtAccessory.price();

        CocaColaCompany drinkFactory = CocaColaFactoryProducer.getFactory(CocaColaCompanyFactoriesType.DRINK);
        CocaColaCompanyDrink cappyDrink = drinkFactory.makeDrinkForAbstract(CocaColaDrinksType.CAPPY, "500ml", "Plastic");
        cappyDrink.shakeAndOpen();
    }
}
