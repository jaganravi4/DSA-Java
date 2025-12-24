/**
 *  Q: Print the 2D array in wave format
 */

public class Problem12{

    public static void printVerticalWave(int[][] mat, int n, int m){
        
        // iterate col wise
        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                // if ith col is odd then we have to print elements from bottom to top
                if(i % 2 != 0){
                    System.out.print(mat[n - j - 1][i] + " ");
                }else{
                    System.out.print(mat[j][i] + " ");
                }
                
            }
        }
    }

    public static void printHorizontalWave(int[][] mat, int n, int m){

        // iterate row wise
        for(int i = 0; i < n; i++){

            for(int j = 0; j < m; j++){
                
                // if ith row is odd then we have to print elements from right to left
                if(i % 2 != 0){
                    System.out.print(mat[i][m - j - 1] + " ");
                }else{
                    System.out.print(mat[i][j] + " ");
                }
            }

        }
    }

    public static void main(String[] args){
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int n = mat.length;

        int m = mat[0].length;

        // printVerticalWave(mat, n, m);

        printHorizontalWave(mat, n, m);
    }
}