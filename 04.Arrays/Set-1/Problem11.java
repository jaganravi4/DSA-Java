/**
 *  Problem link -> https://leetcode.com/problems/transpose-matrix/description/
 */

public class Problem11{

    /**
     *  Time: O(m * n)
     *  Space: O(m * n)
     */
    public static int[][] f_brute(int[][] mat, int n, int m){
        int[][] res = new int[m][n];

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){
                res[i][j] = mat[j][i];
            }
        }

        return res;
    }

    /**
     *  Time: O(n * m)
     *  Space: O(1)
     */
    public static int[][] f_optimal(int[][] mat, int n, int m){

        // this solution works only for square matrix
        for(int i = 0; i < n; i++){
            for(int j = i; j < m; j++){
                swap(mat, i, j);
            }
        }

        return mat;
    }

    public static void swap(int[][] mat, int i, int j){
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
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

        // int[][] res = f_brute(mat, n, m);

        int[][] res = f_optimal(mat, n, m);

        print(res, m, n);
    }
}