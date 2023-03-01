package com.cleo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeProblems {

    static class DepthPair{
        BinaryTree node;
        int depth;

        public DepthPair(BinaryTree node, int depth) {
            this.node = node;
            this.depth = depth;
        }

        public DepthPair() {
        }
    }
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static BinaryTree insert(BinaryTree root,int value){
        if(root==null)
            root = new BinaryTree(value);

        else if(value<root.value)
            root.left=insert(root.left,value);
        else if(value>root.value)
            root.right=insert(root.right,value);



        return root;


    }

    public static void inOrder(BinaryTree root){
        if(root!=null) {
            inOrder(root.left);
            System.out.print(root.value+" ");
            inOrder(root.right);
        }
    }

    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        if(root==null)
            return 0;
        Queue<DepthPair> queue = new LinkedList<>();
        int depth=0;
        queue.offer(new DepthPair(root,depth));
        int depthSum=0;
        while(queue.size()>0){
            DepthPair current = queue.poll();
            BinaryTree currentNode = current.node;
            if(currentNode!=null) {

                int curr_depth = current.depth;
                depthSum += curr_depth;

                queue.offer(new DepthPair(currentNode.left, curr_depth + 1));
                queue.offer(new DepthPair(currentNode.right, curr_depth + 1));
            }


        }
        return depth;
    }

    public static int nodeDepthsV2(BinaryTree root){
        if(root==null)
            return 0;
        return nodeDepthsHelper(root,0);
    }

    public static int nodeDepthsHelper(BinaryTree root, int depth){
        if(root==null)
            return 0;
        return depth+nodeDepthsHelper(root.left,depth+1)+nodeDepthsHelper(root.right,depth+1);
    }

    public static void branchSums(BinaryTree root,int sum, List<Integer> temp){
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
            sum+=root.value;
            temp.add(sum);
            sum=0;
        }
        branchSums(root.left,sum+root.value,temp);
        branchSums(root.right,sum+root.value,temp);

    }

    public static void invertBinaryTree(BinaryTree root) {
        // Write your code here.

        BinaryTree temp;
        if(root!=null){
            temp=root.right;
            root.right=root.left;
            root.left=temp;
            invertBinaryTree(root.left);
            invertBinaryTree(root.right);

        }


    }
    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.

        List<Integer> sums = new ArrayList<>();
        if(root==null)
            return sums;

        List<Integer> temp = new ArrayList<>();
        branchSums(root,0,temp);
        return temp;
    }
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(10);
        insert(root,8);
        insert(root,12);

        insert(root,6);
        insert(root,9);
        inOrder(root);
        System.out.println(branchSums(root));
        System.out.println(nodeDepths(root));
        invertBinaryTree(root);
        System.out.println();
        inOrder(root);
        invertBinaryTree(root);
        System.out.println();
        inOrder(root);


    }
}


