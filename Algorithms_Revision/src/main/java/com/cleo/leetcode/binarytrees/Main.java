package com.cleo.leetcode.binarytrees;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }



public class Main {

    public TreeNode insert(TreeNode root,int value){
        if(root==null)
            root = new TreeNode(value);
        if(value< root.val)
            root.left=insert(root.left,value);
        else if(value>root.val)
            root.right=insert(root.right,value);

        return root;

    }

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(10);
        Main bst = new Main();
        bst.insert(root,5);
        bst.insert(root,15);
        IsSymmetric isSymmetric = new IsSymmetric();
        System.out.println(isSymmetric.isSymmetric(root));
    }
}
