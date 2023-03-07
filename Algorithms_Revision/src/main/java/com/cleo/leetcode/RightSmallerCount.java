package com.cleo.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RightSmallerCount {
    static class SpecialBST{
        int value;
        int leftSubTreeSize;
        SpecialBST left;
        SpecialBST right;

        public SpecialBST(int value) {
            this.value = value;
        }

        public void insert(int value, int index, List<Integer> rightSmallerCounts){
            insertHelper(value,index,rightSmallerCounts,0);
        }
        public void insertHelper( int value, int index, List<Integer> rightSmallerCounts,int numberOfValuesSmallerAtInsertTime){
            if(value<this.value){
                leftSubTreeSize++;
                if(left==null){
                    left = new SpecialBST(value);
                    rightSmallerCounts.set(index,numberOfValuesSmallerAtInsertTime);
                }else{
                    left.insertHelper(value,index,rightSmallerCounts,numberOfValuesSmallerAtInsertTime);
                }
            }else{
                numberOfValuesSmallerAtInsertTime+=leftSubTreeSize;
                if(value>this.value)numberOfValuesSmallerAtInsertTime++;

                if(right==null) {
                    right = new SpecialBST(value);
                    rightSmallerCounts.set(index,numberOfValuesSmallerAtInsertTime);
                }else{
                    right.insertHelper(value,index,rightSmallerCounts,numberOfValuesSmallerAtInsertTime);
                }

            }



        }

    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        if(n==0)
            return new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        for(int num:nums){
            array.add(num);
        }
        if(array.stream().sorted().toList() ==array)
            return array;
        List<Integer> rightSmallerCounts = new ArrayList<>(array);

        if(array.stream().sorted(Comparator.reverseOrder()).toList()==array){
           List<Integer> output = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                output.add(0);
            }
            return output;
        }
        int size = array.size();
        rightSmallerCounts.set(size-1,0);
        SpecialBST bst = new SpecialBST(array.get(size-1));
        for (int i = size-2; i >=0 ; i--) {//Starting from right index...

            bst.insert(array.get(i),i,rightSmallerCounts);
            //System.out.println(rightSmallerCounts);


        }
        return rightSmallerCounts;
    }

    public static void main(String[] args) {
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            s.add(0);
        }

        System.out.println(s);
    }
}
