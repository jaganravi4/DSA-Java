/**
 *  Problem link -> https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 */

import java.util.*;

public class Problem7{

    public static int f_brute(int[][] matrix, int k){

        List<Integer> list = new ArrayList<>();

        int n = matrix.length;

        for(int i = 0; i < n; i++){

            for(int j = 0; j < n; j++){

                list.add(matrix[i][j]);
            }
        }

        Collections.sort(list);

        return list.get(k - 1);
    }

    public static int f_optimal(int[][] matrix, int k){

        int n = matrix.length;

        int low = matrix[0][0], high = matrix[n - 1][n - 1];

        int ans = high;

        while(low <= high){

            int mid = low + (high - low) / 2;

            int count = f_helper(matrix, mid, n);

            if(count >= k){

                ans = mid;

                high = mid - 1;
            }else{

                low = mid + 1;
            }
        }

        return ans;
    }

    public static int f_helper(int[][] matrix, int x, int n){

        int r = 0, c = n - 1;

        int res = 0;

        while(r < n && c >= 0){

            if(matrix[r][c] <= x){

                res += (c + 1);

                r++;
            }else{

                c--;
            }
        }

        return res;
    }

    public static void main(String[] args){

        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};

        int k = 8;

        // int res = f_brute(matrix, k);

        int res = f_optimal(matrix, k);

        System.out.println(res);
    }
}