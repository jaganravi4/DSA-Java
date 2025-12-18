/**
 *  Problem link -> https://leetcode.com/problems/n-queens/description/ [modified]
 */

import java.util.*;

public class Problem18{

    public static boolean f(int col, int n, int[][] board){
        if(col == n){
            print(board, n);
            return true;
        }

        for(int row = 0; row < n; row++){
            if(isSafe(row, col, n, board)){
                board[row][col] = 1;

                if(f(col + 1, n, board) == true){
                    return true;
                }

                board[row][col] = 0;
            }
        }

        return false;
    }

    public static boolean isSafe(int row, int col, int n, int[][] board){

        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 1){
                return false;
            }
        }

        for(int i = row, j = col; i >= 0 && j >= 0; j--){
            if(board[i][j] == 1){
                return false;
            }
        }

        for(int i = row, j = col; i < n && j >= 0; i++, j--){
            if(board[i][j] == 1){
                return false;
            }
        }

        return true;
    }   

    public static void print(int[][] board, int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(board[i][j] + " ");
            }

            System.out.print("\n");
        }
    }

    public static void main(String[] args){
        int n = 4;

        int[][] board = new int[n][n];

        boolean res = f(0, n, board);

        System.out.println(res);
    }
}