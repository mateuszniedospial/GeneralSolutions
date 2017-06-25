package A_DivideAndConquer;

/**
 * Created by Mateusz Niedośpiał on 21.03.2017.
 */
public class X_Test {

    public static void main(String[] args) {

//        //Fibonacci:
//        int[] sequence = DivideAndConquer.generateFibonacciTable();
//
//        for (int aSequence : sequence) {
//            System.out.println(aSequence);
//        }
//
//        int[] sequence2 = DivideAndConquer.iterationFibbonacci();
//
//        for (int aSequence : sequence2) {
//            System.out.println(aSequence);
//        }
        //End of Fibonacci.

        //Table:
        int[] table = {-1, 5, 6, -2, 3, -7, -8, 9, 5, 2, -3, 4, 5, 5, 3, 1, 1, 1, 5, 6, 3};

        long startTime = System.nanoTime();
        int[] maximumSubArrayData = DivideAndConquer.findMaximumSubArray(table, 0, table.length-1);
        long stopTime = System.nanoTime();

        long startTimeBF = System.nanoTime();
        int[] maximumSubArrayUsingBruteForceData = DivideAndConquer.findMaximumSubArrayUsingBruteForce(table, 0, table.length-1);
        long stopTimeBF = System.nanoTime();

        System.out.println("Dla tablicy:");
        for(int tab: table){
            System.out.print(tab+" ");
        }
        System.out.println();
        System.out.println();
        System.out.println("  !!!  DZIEL I ZWYCIEZAJ  !!!   ");
        System.out.println("Max podtablica to: ");
        for(int i = maximumSubArrayData[0]; i < maximumSubArrayData[1]; i++){
            System.out.print(table[i]+" ");
        }
        System.out.println();
        System.out.println("O sumie wartości: "+ maximumSubArrayData[2]);
        System.out.println("Całkowity czas wykonywania: "+(stopTime - startTime)+" ns");

        System.out.println();
        System.out.println("    !!!  BRUTE FORCE  !!!     ");
        System.out.println("Max podtablica to: ");
        for(int i = maximumSubArrayUsingBruteForceData[0]; i < maximumSubArrayUsingBruteForceData[1]; i++){
            System.out.print(table[i]+" ");
        }
        System.out.println();
        System.out.println("O sumie wartości: "+ maximumSubArrayUsingBruteForceData[2]);
        System.out.println("Całkowity czas wykonywania: "+(stopTimeBF - startTimeBF)+" ns");
    }
}
