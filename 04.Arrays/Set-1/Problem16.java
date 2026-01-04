/**
 *  Problem link -> https://leetcode.com/problems/spiral-matrix/description/
 */

import java.util.*;

public class Problem16{

    public static List<Integer> f(int[][] mat, int n, int m){

        List<Integer> res = new ArrayList<>();

        int top = 0;

        int bottom = n - 1;

        int left = 0;

        int right = m - 1;

        while(top <= bottom && left <= right){

            for(int i = left; i <= right; i++){
                res.add(mat[top][i]);
            }

            top++;

            for(int i = top; i <= bottom; i++){
                res.add(mat[i][right]);
            }

            right--;

            if(top <= bottom){

                for(int i = right; i >= left; i--){
                    res.add(mat[bottom][i]);
                }

                bottom--;
            }

            if(left <= right){

                for(int i = bottom; i >= top; i--){
                    res.add(mat[i][left]);
                }

                left++;
            }
        }

        return res;
    }

    public static void main(String[] args){
        
        int[][] mat = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12} };

        int n = mat.length;

        int m = mat[0].length;

        List<Integer> res = f(mat, n, m);

        System.out.println(res);
    }
}