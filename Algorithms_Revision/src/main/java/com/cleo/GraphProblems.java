package com.cleo;

public class GraphProblems {

    public int[][] removeIslands(int[][] matrix) {
        // Write your code here.
        boolean rowIsBorder=false,colIsBorder=false,isBorder=false;
        boolean[][] isIsland = new boolean[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
<<<<<<< HEAD

=======
                if((i==0||i+1== matrix.length)&&matrix[i][j]==1)
>>>>>>> 3447aaa8a00baddde5f652e5eaa150311f2880a1

            }
        }
        return new int[][] {{}};
    }
    public void dfsUtil(int[][] matrix,int row, int column,boolean[][] isIsland){


    }
    public void isBorder(int[][] matrix,int row,int col,boolean[][] isBorder){

    }
}