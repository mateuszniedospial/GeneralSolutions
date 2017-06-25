package D_DynamicProgramming;

import java.util.List;

/**
 * Created by Mateusz Niedośpiał on 22.05.2017.
 */
public class X_Test {

    public static void main(String[] args) {

        double[] prices = new double[10];
        prices[0] = 1;
        prices[1] = 5;
        prices[2] = 8;
        prices[3] = 9;
        prices[4] = 10;
        prices[5] = 17;
        prices[6] = 17;
        prices[7] = 20;
        prices[8] = 24;
        prices[9] = 25;

        double maxProfit = RodCut.cutRodClassic(prices, 10);
        System.out.println(maxProfit);

        double maxProfitUsingMemorized = RodCut.memorizedCutRod(prices, 10);
        System.out.println(maxProfitUsingMemorized);

        double v = RodCut.bottomUpCutRod(prices, 10);
        System.out.println(v);

        List<List<Double>> lists = RodCut.extendedBottomUpCutRod(prices, 10);
        List<Double> cuts = lists.get(1);

        System.out.println("Optimal cuts:");
        int lengthOfRod = 10;
        while(lengthOfRod > 0){
            System.out.println("Sell: " + cuts.get(lengthOfRod) + " units.");
            lengthOfRod = lengthOfRod - cuts.get(lengthOfRod).intValue();
        }


        String[] DNA1 = {"A", "B", "C", "B", "D", "A", "B"};
        String[] DNA2 = {"B", "D", "C", "A", "B", "A"};
    }
}
