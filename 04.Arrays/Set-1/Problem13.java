/**
 *  Q: Given two 2D arrays where the first 2D array has a dimension (n * m) and 
 *     the second 2D array has a dimension (m * k). multiply both the 2D arrays
 * 
 *  eg: arr = [[1, 1], [2, 2], [3, 3]]
 *      brr = [[1, 1, 1], [2, 2, 2]]
 *      
 *      res = arr * brr = [[3, 3, 3], [6, 6, 6], [9, 9, 9]] -> output
 */

public class Problem13{

    public static int[][] f(int[][] arr, int n, int m, int[][] brr, int k){

        int[][] res = new int[n][k];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                // To get res[i][j] -> we need to multiply ith row of arr with jth col of brr
                res[i][j] = multiply(arr, brr, m, i, j);
            }
        }

        return res;
    }

    public static int multiply(int[][] arr, int[][] brr, int m, int row, int col){
        int sum = 0;

        // both ith row of arr and jth col of brr has m elements.
        for(int i = 0; i < m; i++){

            int a = arr[row][i];

            int b = brr[i][col];

            sum += (a * b);
        }

        return sum;
    }

    public static void print(int[][] mat){

        int n = mat.length;

        int m = mat[0].length;

        for(int i = 0; i < n; i++){

            for(int j = 0; j < m; j++){

                System.out.print(mat[i][j] + " ");
            }

            System.out.print("\n");
        }
    }

    public static void main(String[] args){
        int[][] arr = {{1, 2, 3}, {4, 5, 6}};

        int n = arr.length;
        
        int m = arr[0].length;

        int[][] brr = {{7, 8}, {9, 1}, {2, 3}};

        int k = brr[0].length;

        int[][] res = f(arr, n, m, brr, k);

        print(res);
    }
}