/**
 *  N-Queens
 */

import java.util.*;

public class Problem2{

    public static int rec(int level, int[] queens, int n){
        // base case
        if(level == n){
            return 1;
        }

        int ans = 0;

        for(int col = 0; col < n; col++){

            if(check(level, col, queens, n)){

                queens[level] = col;

                ans += rec(level + 1, queens, n);

                queens[level] = -1;
            }
        }

        return ans;
    }

    public static boolean check(int row, int col, int[] queens, int n){

        for(int i = 0; i < row; i++){

            int prow = i;

            int pcol = queens[i];

            if(pcol == col || Math.abs(pcol - col) == Math.abs(prow - row)){

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){

        int n = 4;

        int[] queens = new int[n];

        for(int i = 0; i < n; i++){
            queens[i] = -1;
        }

        int res = rec(0, queens, n);

        System.out.println(res);
    }
}