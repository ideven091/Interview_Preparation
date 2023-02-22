package com.cleo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayProblems {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        int first=0;
        int sum = 0;
        Arrays.sort(array);
        int n = array.length;
        List<Integer[]> output = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            first=array[i];
            for (int j = i+1; j < array.length; j++) {
                if(first+array[j]<=targetSum){
                    sum=first+array[j];
                    int s = n-1;
                    while(sum+array[s]>targetSum&&s>j)
                        s--;
                    if(sum+array[s]==targetSum&&(s!=i)&&(s!=j)){
                        Integer[] temp = {first,array[j],array[s]};
                        if(!output.contains(temp))
                            output.add(temp);


                    }
                }
            }
        }
        for(var c: output){
            System.out.println(Arrays.toString(c));
        }
        return output;
    }
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int n = arrayOne.length,m = arrayTwo.length;
        int[] output = new int[2];
        int diff = -1,min_diff=Integer.MAX_VALUE;
        int k1 = 0,k2=0;
        System.out.println(Arrays.toString(arrayTwo));
        //[-1, 5, 10, 20, 28, 3],[26, 134, 135, 15, 17]
        if(arrayTwo[0]<arrayOne[0]) {
            while (arrayTwo[k1] < arrayOne[0]&&k1<Math.min(n,m)){
                k1++;
            diff = Math.abs(arrayOne[0]-arrayTwo[k1]);
                System.out.println(diff);

                if(min_diff>diff) {
                min_diff = diff;
                output = new int[]{arrayOne[k1], arrayTwo[0]};
            }
            }

        }else if(arrayTwo[0]>arrayOne[0]) {
            while (k2 < Math.min(n, m) && (arrayTwo[k2] > arrayOne[0]) ){

                diff = Math.abs(arrayOne[0] - arrayTwo[k2]);
                if (min_diff > diff) {
                    System.out.println("HI1");

                    min_diff = diff;
                    output = new int[]{arrayOne[0], arrayTwo[k2]};
                }
                k2++;

            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 10, 20, 28, 3};
        int[] array2 = new int[]{26, 134, 135, 15, 17};
        int target = 0;
        System.out.println(threeNumberSum(array,target));
        System.out.println(Arrays.toString(smallestDifference(array,array2)));
    }
}
