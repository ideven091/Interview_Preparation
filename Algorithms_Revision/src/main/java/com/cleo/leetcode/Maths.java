package com.cleo.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Maths {
    public int findKthPositive(int[] A, int k) {
      /*  int n = arr.length;
        int[] values = IntStream.rangeClosed(1,arr[n-1]).toArray();
        //values[0]=1;
        int counter=1;
        int j=1;
        for (int i = 0; i < n; i++) {
            if(arr[i]==values[j-1])
                j++;
            else{
                values[i]=0;
            }


       */
      /*  int l = 0, r = A.length, m;
        while (l < r) {

            m = (l + r) / 2;
            if (A[m] - 1 - m < k)
                l = m + 1;
            else
                r = m;
            System.out.print(A[m]+" ");
        }

       */
        System.out.println();
        for(int i:A){
            System.out.print(k+" ");
            if(i<=k)
                k++;
            else

                break;
        }
        return k;








    }

    public String countAndSay(int n) {
        if(n==1)
            return "1";

        return null;

    }

    public static void main(String[] args) {
        Maths maths = new Maths();
        int[] vals = {2,4,11};
        System.out.println("\n"+maths.findKthPositive(vals,3));

    }
}
