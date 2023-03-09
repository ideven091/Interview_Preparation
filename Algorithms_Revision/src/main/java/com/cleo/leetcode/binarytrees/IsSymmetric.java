package com.cleo.leetcode.binarytrees;

import com.cleo.TreeProblems;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {

    static class Pair{
        TreeNode first;
        TreeNode second;

        public Pair(TreeNode first, TreeNode second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
        }
    }
    public TreeNode mirror(TreeNode root){
        TreeNode temp;
        if(root!=null){
            temp=root.left;
            root.left=root.right;
            root.right=temp;
        }
        return root;
    }
    public boolean isSymmetric(TreeNode root) {

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root.left,root.right));
        while(queue.size()>0){
            Pair current = queue.poll();
            TreeNode first=current.first;
            TreeNode second = current.second;
            if(first==null&&second==null)
                continue;
            if(first==null||current.second==null)
                return false;
            if(first.val!=second.val)
                return false;
            queue.offer(new Pair(first.left,second.right));
            queue.offer(new Pair(first.right,second.left));
        }
        return true;

    }
    boolean check(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;

        if (l == null || r == null || l.val != r.val) return false;

        return check(l.left, r.right) && check(l.right, r.left);
    }
}
