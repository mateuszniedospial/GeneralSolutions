package A_DivideAndConquer;

import java.util.Scanner;

/**
 * Created by Mateusz Niedośpiał on 21.03.2017.
 */
public class DivideAndConquer {

    //The problem of finding the max sub array in the array
    //using divide and conquer approach:

   static int[] findMaximumSubArray(int[] p_table, int p_start, int p_end){
       if(p_end == p_start){
           return new int[]{p_start, p_end, p_table[p_start]};
       } else {
           int mid = ((p_start + p_end)/2);
           int[] subArrayDataLeft = findMaximumSubArray(p_table, p_start, mid);
           int[] subArrayDataRight = findMaximumSubArray(p_table, mid + 1, p_end);
           int[] crossingSubArrayData = findMaxCrossingSubArray(p_table, p_start, mid, p_end);

           if(subArrayDataLeft[2] >= subArrayDataRight[2] && subArrayDataLeft[2] >= crossingSubArrayData[2]){
               return new int[]{subArrayDataLeft[0], subArrayDataLeft[1], subArrayDataLeft[2]};
           } else if (subArrayDataRight[2] >= subArrayDataLeft[2] && subArrayDataRight[2] >= crossingSubArrayData[2]){
               return new int[]{subArrayDataRight[0], subArrayDataRight[1], subArrayDataRight[2]};
           } else {
               return new int[]{crossingSubArrayData[0], crossingSubArrayData[1], crossingSubArrayData[2]};
           }
       }
   }

    private static int[] findMaxCrossingSubArray(int[] p_table, int p_start, int p_mid, int p_end){
        int leftSum = Integer.MIN_VALUE;

        int sumParam1 = 0;
        int maxLeft = 0;

        for(int i = p_mid; i >= p_start; i-- ){
            sumParam1 = sumParam1 + p_table[i];
            if(sumParam1 > leftSum){
                leftSum = sumParam1;
                maxLeft = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;

        int sumParam2 = 0;
        int maxRight = 0;

        for(int j = p_mid; j <= p_end; j++){
            sumParam2 = sumParam2 + p_table[j];
            if(sumParam2 > rightSum){
                rightSum = sumParam2;
                maxRight = j;
            }
        }

        if(leftSum == Integer.MIN_VALUE && rightSum != Integer.MIN_VALUE){
            return new int[]{maxLeft, maxRight, rightSum};
        } else {
            return new int[]{maxLeft, maxRight, leftSum + rightSum};
        }
    }

    //The problem of finding the max sub array in the array
    //using brute force approach:

    static int[] findMaximumSubArrayUsingBruteForce(int[] p_table, int p_start, int p_end){
        int maxSum = Integer.MIN_VALUE;
        int leftIndex = 0;
        int rightIndex = 0;

        int sum = 0;

        for(int i = p_start; i < p_end; i++){
            for(int j = p_start+1; j <= p_end; j++){
                for(int k = i; k < j; k++){
                    sum = sum + p_table[k];
                    if(sum > maxSum){
                        maxSum = sum;
                        leftIndex = i;
                        rightIndex = j;
                    }
                }
                sum = 0;
            }
        }

        return new int[]{leftIndex, rightIndex, maxSum};
    }


    //Recursive fibonacci sequence generator with IO:

    static int[] generateFibonacciTable(){
        Scanner input = new Scanner(System.in);

        System.out.println("!!!! Fibonacci generator (Type: Recursive) !!!!");
        System.out.println("Provide desirable length of sequence:");

        int p_tableLength = input.nextInt();

        int[] table = new int[p_tableLength];
        if(p_tableLength < 50){
            for(int i = 0; i < p_tableLength; i++){
                table[i] = fibonacci(i);
            }
            return table;
        } else {
            throw new UnsupportedOperationException("For length of sequence greater than 49, fibonacci sequence is overextending integer size.");
        }
    }

    //Fibonacci generation
    //using recursive method:

    private static int fibonacci(int p_tableLength){
        if(p_tableLength == 0){
            return 0;
        } else if(p_tableLength == 1){
            return 1;
        } else {
            return fibonacci(p_tableLength-1)+fibonacci(p_tableLength-2);
        }
    }

    static int[] iterationFibbonacci(){
        Scanner input = new Scanner(System.in);

        System.out.println("!!!! Fibonacci generator (Type: Iteration) !!!!");
        System.out.println("Provide desirable length of sequence:");

        int p_tableLength = input.nextInt();

        int[] table = new int[p_tableLength];

        for(int i = 0; i < p_tableLength; i++){
            if(i == 0){
                table[i] = 0;
            } else if (i == 1){
                table[i] = 1;
            } else {
                table[i] = table[i-1]+table[i-2];
            }
        }

        return table;
    }
}
