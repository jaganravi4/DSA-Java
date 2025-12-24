/**
 *  Print elements in 2D array
 */

public class Problem10{

    public static void printRowWise(int[][] mat, int n, int m){
        
        for(int i = 0; i < n; i++){
            
            for(int j = 0; j < m; j++){
                System.out.print(mat[i][j] + " ");
            }

            System.out.print("\n");
        }
    }

    public static void printColWise(int[][] mat, int n, int m){

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                System.out.print(mat[j][i] + " ");
            }

            System.out.print("\n");
        }
    }

    public static void main(String[] args){
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int n = mat.length;

        int m = mat[0].length;

        // printRowWise(mat, n, m);

        printColWise(mat, n, m);
    }
}