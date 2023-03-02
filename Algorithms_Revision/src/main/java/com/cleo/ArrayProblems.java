package com.cleo;

import java.util.*;

public class ArrayProblems {

    public static int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int left=1,right=1;
        int[] output = new int[array.length];
        Arrays.fill(output,1);
        for (int i = 0; i < array.length; i++) {
            output[i]=left;
            left*=array[i];
        }
        for (int i = array.length-1; i >=0 ; i--) {
            output[i]*=right;
            right*=array[i];


        }

        return output;
    }
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
        int diff=0,min_diff=Integer.MAX_VALUE;
        int first=0,second=0;
        while(first<n&&second<m){
            int firstNum=arrayOne[first];
            int secondNum=arrayTwo[second];
            if(firstNum<secondNum){
                diff = secondNum-firstNum;
                first++;
            }else if(firstNum==secondNum){
                return new int[]{firstNum,secondNum};
            }else {
                diff = firstNum - secondNum;
                second++;
            }
            if(min_diff>diff){
                min_diff=diff;
                output[0]=firstNum;
                output[1]=secondNum;
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
        System.out.println(Arrays.toString(arrayOfProducts(array)));
    }
}
