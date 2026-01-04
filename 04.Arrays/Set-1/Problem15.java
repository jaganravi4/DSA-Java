/**
 *  Problem link -> https://leetcode.com/problems/rotate-image/
 */

public class Problem15{

    public static void f(int[][] mat, int n, int m){

        // transpose
        for(int i = 0; i < n; i++){

            for(int j = i; j < m; j++){

                swap(mat, i, j);
            }
        }

        // reverse each row
        for(int i = 0; i < n; i++){
            reverse(mat[i], 0, m - 1);
        }
    }

    public static void swap(int[][] mat, int i, int j){
        int temp = mat[i][j];

        mat[i][j] = mat[j][i];

        mat[j][i] = temp;
    }

    public static void reverse(int[] arr, int start, int end){

        while(start <= end){
            int temp = arr[start];

            arr[start] = arr[end];

            arr[end] = temp;

            start++;

            end--;
        }
    }

    public static void print(int[][] mat, int n, int m){

        for(int i = 0; i < n; i++){

            for(int j = 0; j < m; j++){

                System.out.print(mat[i][j] + " ");
            }

            System.out.print("\n");
        }
    }

    public static void main(String[] args){

        int[][] mat = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };

        int n = mat.length;

        int m = mat[0].length;

        f(mat, n, m);

        print(mat, n, m);
    }
}