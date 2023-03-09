package com.cleo;

import java.util.*;

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

    static class TreeState{
        int diameter;
        int height;

        public TreeState(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }

        public TreeState() {
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

    public static int binaryTreeDiameter(BinaryTree root) {
        // Write your code here.
        if(root==null)
            return 0;

        return diameterUtil(root).diameter;

    }
    public static TreeState diameterUtil(BinaryTree root){
        if(root==null){
            return new TreeState(0,0);
        }
        TreeState leftTreeState = diameterUtil(root.left);
        TreeState rightTreeState = diameterUtil(root.right);
        System.out.print(leftTreeState.height+":"+rightTreeState.height+"\t");


        System.out.println(leftTreeState.diameter+":"+rightTreeState.diameter);

        int longestPathThroughRoot = leftTreeState.height+rightTreeState.height;
        int maxDiameterSoFar = Math.max(leftTreeState.diameter,rightTreeState.diameter);
        int currentDiameter = Math.max(longestPathThroughRoot,maxDiameterSoFar);
        int currentHeight = 1+Math.max(leftTreeState.height,rightTreeState.height);

        return new TreeState(currentDiameter,currentHeight);

    }



    /**
     *
     * @param tree Given Binary Tree
     * @param target And a target Value
     * @param k Distance
     * @return All Nodes that are at distance k from the node
     */
    public static ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        // Write your code here.
        ArrayList<Integer> outputNodes = new ArrayList<>();
        Map<Integer,BinaryTree> targetParents = new HashMap<>();
       // targetParents.put(tree,null);
        populateParents(tree,null,targetParents);
        for(var e:targetParents.entrySet()){
            if(e.getValue()==null)
                System.out.println(e.getKey()+":null");
            else
                System.out.println(e.getKey()+":"+e.getValue().value);
        }
        BinaryTree targetNode=getTargetNode(tree,target,targetParents);

        Queue<DepthPair> queue = new LinkedList<>();
        queue.offer(new DepthPair(targetNode,0));
        Set<Integer> seen = new HashSet<>();
        seen.add(targetNode.value);
        int distance=0;
        while(queue.size()>0){
            DepthPair current=queue.poll();
            BinaryTree node=current.node;
            int curr_distance = current.depth;



            if(curr_distance==k){
                for(var output:queue){
                    outputNodes.add(output.node.value);
                }
                outputNodes.add(node.value);
                return outputNodes;
            }
            if(curr_distance>k)
                break;


            List<BinaryTree> connectedNodes = Arrays.asList(node.left,node.right,targetParents.get(node.value));
            for(BinaryTree connection:connectedNodes){
                if(connection==null)
                    continue;
                if(seen.contains(connection.value))
                    continue;
                seen.add(connection.value);
                queue.add(new DepthPair(connection,curr_distance+1));
            }


        }
        return new ArrayList<>();
    }

    public static BinaryTree getTargetNode(BinaryTree root,int target,Map<Integer,BinaryTree> parents){
        if(root.value==target)
            return root;
       BinaryTree parent = parents.get(target);
        System.out.println(parent.value);
       if(parent.left!=null&&parent.left.value==target)
           return parent.left;
       return parent.right;

    }

    public static void populateParents(BinaryTree root,BinaryTree current,Map<Integer,BinaryTree> targetParents){
        if(root!=null){
            targetParents.put(root.value,current);
            populateParents(root.left,root,targetParents);
            populateParents(root.right,root,targetParents);
        }


    }


    public static BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
        // Write your code here.
        if(tree1==null&&tree2==null)
            return null;
        if(tree2==null)
            return tree1;
        if(tree1==null)
            return tree2;
        tree1.value+=tree2.value;
        tree1.left=mergeBinaryTrees(tree1.left,tree2.left);
        tree1.right=mergeBinaryTrees(tree1.right,tree2.right);
        return tree1;
    }

    public static int height(BinaryTree root){
        if(root==null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(left<0||right<0||Math.abs(left-right)>1)
            return -1;
        return 1+Math.max(left,right);
    }
    public static boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        if(tree==null)
            return true;
       return height(tree)>=0;
    }
    public static boolean symmetricalTree(BinaryTree tree) {
        // Write your code here.
        if(tree==null)
            return true;
        return isSymmetric(tree.left,tree.right);
    }
    public static boolean isSymmetric(BinaryTree left, BinaryTree right){
        if(left==null&&right==null)
            return true;
        if(left==null||right==null||left.value!=right.value)
            return false;
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }

    static int max_sum;
    public static int maxPathSumUtil(BinaryTree root){
        if(root==null)
            return 0;

        int left = Math.max(maxPathSumUtil(root.left),0);
        int right = Math.max(maxPathSumUtil(root.right),0);

        max_sum=Math.max(max_sum,left+right+root.value);

        return root.value+Math.max(left,right);
    }
    public static int maxPathSum(BinaryTree tree) {
        // Write your code here.
        if(tree==null)
            return 0;
        max_sum=Integer.MIN_VALUE;

       maxPathSumUtil(tree);
       return max_sum;
    }



    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(10);
        insert(root,8);
        insert(root,12);

        insert(root,6);
        insert(root,9);
        inOrder(root);
        System.out.println(branchSums(root));
        System.out.println("Height of Tree:"+ height(root));
        System.out.println(nodeDepths(root));
        invertBinaryTree(root);
        System.out.println();
        inOrder(root);
        invertBinaryTree(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        System.out.println("Diameter:"+binaryTreeDiameter(root));
       List<Integer> nodes = findNodesDistanceK(root,8,1);
        System.out.println("Nodes at distance k:");
       for(int node:nodes){
           System.out.print(node+" ");
       }
        System.out.println();
       BinaryTree root2= new BinaryTree(15);
       insert(root2,20);
       insert(root2,8);
       insert(root2,25);
        insert(root2,30);
        insert(root2,35);
        insert(root2,40);
       root2=mergeBinaryTrees(root2,root);
       inOrder(root2);
        System.out.println("Height of Tree: "+ height(root2));

        System.out.println(heightBalancedBinaryTree(root2));
        System.out.println(symmetricalTree(root));
        System.out.println(maxPathSum(root));

    }
}


