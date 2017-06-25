package D_DynamicProgramming;

/**
 * Created by Mateusz Niedośpiał on 24.05.2017.
 */
public class BiggestSharedSubsequence {

    /**
     * Prevent instantiating.
     */

    //TODO - not working appropriately yet.

    private BiggestSharedSubsequence() {}

    public static void calculate(String[] firstArray, String[] secondArray){
        int firstLength = firstArray.length;
        int secondLength = secondArray.length;

        int[][] b = new int[firstLength-1][secondLength-1];
        int[][] c = new int[firstLength][secondLength];

        for(int i = 0; i < firstLength; i++){
            c[i][0] = 0;
        }
        for(int j = 0; j < secondLength; j++){
            c[0][j] = 0;
        }
        for(int i = 1; i < firstLength; i++){
            for(int j = 1; j < secondLength; j++){
                if (firstArray[i].equals(secondArray[j])) {
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i-1][j-1] = 1;
                } else if (c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i-1][j-1] = 0;
                } else {
                    c[i][j] = c[i][j-1];
                    b[i-1][j-1] = -1;
                }
            }
        }

        printBiggestSharedSubsequence(b, firstArray, firstArray.length-2, secondArray.length-2);
    }

    //TODO - not working appropriately yet.

    private static void printBiggestSharedSubsequence(int[][] subsequenceOptimum, String[] array, int lengthOfFirstArray, int lengthOfSecondArray){
        if(lengthOfFirstArray <= 0 || lengthOfSecondArray <= 0){
            throw new UnsupportedOperationException("Lengths are invalid."); //END of recursion here.
        }
        if(subsequenceOptimum[lengthOfFirstArray][lengthOfSecondArray] == 1){
            printBiggestSharedSubsequence(subsequenceOptimum, array, lengthOfFirstArray-1, lengthOfSecondArray-1);
            System.out.println(array[lengthOfFirstArray]);
        } else if (subsequenceOptimum[lengthOfFirstArray][lengthOfSecondArray] == 0){
            printBiggestSharedSubsequence(subsequenceOptimum, array, lengthOfFirstArray-1, lengthOfSecondArray);
        } else {
            printBiggestSharedSubsequence(subsequenceOptimum, array, lengthOfFirstArray, lengthOfSecondArray-1);
        }
    }
}
