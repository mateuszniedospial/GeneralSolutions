package D_DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz Niedośpiał on 22.05.2017.
 *
 * Simple implementation of an algorithm which is supposed to
 * calculate optimal profit from selling rod (as a one part or many),
 * depending on prices for particular length (again - one part or many).
 *
 * Three approaches implemented: classic one and two which are modifications to
 * lower the time complexity. More information provided above the methods.
 */
public class RodCut {

    //Prevent instantiating as all of the 'available' methods are static ones.
    private RodCut(){}

    /**
     * Simple classic recursive method which calculate the best solution in terms of
     * maximum value of profit from the initial data if we cut it in parts.
     *
     * Time complexity is O(2^n) since all possibilities are taken under consideration.
     *
     * @return maximum profit that can be achieved with given prices and length of the rod;
     */
    public static double cutRodClassic(double[] prices, double lengthOfTheRod){
        if(lengthOfTheRod == 0){
           return 0;
        }
        double maxProfit = -Double.MAX_VALUE;
        for(int i = 1; i <= lengthOfTheRod; i++){
            maxProfit = Math.max(maxProfit, prices[i-1] + cutRodClassic(prices, lengthOfTheRod-i));
        }
        return maxProfit;
    }

    /**
     * Cut rod algorithm with modification for remembering results to some calculations.
     * With this addition the algorithm can omit many of the unnecessary operations and
     * therefore its time complexity is O(n^2).
     * Nevertheless more cost is put into memory as it is needed to
     * have place to hold those remembered results.
     * (Still much better optimized than classic approach!)
     */
    public static double memorizedCutRod(double[] prices, double lengthOfTheRod){
        double[] memorized = new double[Double.valueOf(lengthOfTheRod).intValue()];
        for(int i = 0; i < memorized.length; i++){
            memorized[i] = Double.NEGATIVE_INFINITY;
        }
        return memorizedCutRodCalculate(prices, lengthOfTheRod, memorized);
    }

    private static double memorizedCutRodCalculate(double[] prices, double lengthOfTheRod, double[] memorized) {
        if(lengthOfTheRod == 0){
            return 0;
        }
        if (memorized[Double.valueOf(lengthOfTheRod).intValue()-1] >= 0) {
            return memorized[Double.valueOf(lengthOfTheRod).intValue()-1];
        }
        double maxProfit = Double.NEGATIVE_INFINITY;
        for(int i = 1; i <= lengthOfTheRod; i++){
           maxProfit = Math.max(maxProfit, prices[i-1] + memorizedCutRodCalculate(prices, lengthOfTheRod-i, memorized));
        }
        memorized[Double.valueOf(lengthOfTheRod).intValue()-1] = maxProfit;
        return maxProfit;
    }

    /**
     * Different approach that achieves the same result as memorizedCutRod method.
     * Idea behind is very similar as this function is also remembering results
     * to avoid calculating the same thing many times. The difference is that
     * in this case the algorithm starts from the bottom, meaning from the smallest
     * to the largest portion of entire problem. That ensures larger problem calculations
     * being made after obtaining results of its smaller sub-problems. The last memorized
     * result is the final result which is returned.
     *
     * Time complexity is O(n^2) (double loop).
     */
    public static double bottomUpCutRod(double[] prices, double lengthOfTheRod){
        //+1 to length because we want to remember the value for no-cut at all too.
        double[] memorized = new double[Double.valueOf(lengthOfTheRod).intValue()+1];
        memorized[0] = 0;

        for(int j = 1; j <= lengthOfTheRod; j++){

            double maxProfit = -Double.MAX_VALUE;
            for(int i = 1; i <= j; i++){
                maxProfit = Math.max(maxProfit, prices[i-1] + memorized[j-i]);
            }
            memorized[j] = maxProfit;
        }
        return memorized[Double.valueOf(lengthOfTheRod).intValue()];
    }


    public static List<List<Double>> extendedBottomUpCutRod(double[] prices, double lengthOfTheRod){
        List<Double> results = new ArrayList<>();
        List<Double> cuts = new ArrayList<>();

        results.add(0, 0.0);
        cuts.add(0, 0.0);

        for(int j = 1; j <= lengthOfTheRod; j++){
            double maxProfit = -Double.MAX_VALUE;
            for(int i = 1; i <= j ; i++){
                if(maxProfit < (prices[i-1] + results.get(j-i))){
                    maxProfit = prices[i-1] + results.get(j-i);
                    if(maxProfit != -Double.MAX_VALUE){
                        if(cuts.size() != j) {
                            cuts.set(j, (double) i);
                        } else {
                            cuts.add(j, (double) i);
                        }
                    }
                }
            }
            results.add(j, maxProfit);
        }
        List<List<Double>> solution = new ArrayList<>();
        solution.add(results);
        solution.add(cuts);
        return solution;
    }
}
