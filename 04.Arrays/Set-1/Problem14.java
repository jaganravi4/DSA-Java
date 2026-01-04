/**
 *  Problem link -> https://leetcode.com/problems/set-matrix-zeroes/
 */

public class Problem14{

    /**
     *  this solution only works if [0 <= mat[i][j] <= 2^31 - 1]
     * 
     *  Time: O(N * M * (N + M))
     *  Space: O(1)
     */
    public static void f_brute(int[][] mat, int n, int m){

        for(int i = 0; i < n; i++){

            for(int j = 0; j < m; j++){

                if(mat[i][j] == 0){
                    mark_row(mat, m, i);
                    mark_col(mat, n, j);
                }
            }
        }

        for(int i = 0; i < n; i++){

            for(int j = 0; j < m; j++){

                if(mat[i][j] == -1){
                    mat[i][j] = 0;
                }

            }
        }
    }

    public static void mark_row(int[][] mat, int len, int i){

        for(int j = 0; j < len; j++){
            if(mat[i][j] != 0){
                mat[i][j] = -1;
            }
        }
    }

    public static void mark_col(int[][] mat, int len, int i){
        
        for(int j = 0; j < len; j++){
            if(mat[j][i] != 0){
                mat[j][i] = -1;
            }
        }
    }

    public static void f_better(int[][] mat, int n, int m){

        int[] row = new int[n];

        int[] col = new int[m];

        for(int i = 0; i < n; i++){

            for(int j = 0; j < m; j++){

                if(mat[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){

            for(int j = 0; j < m; j++){

                if(row[i] == 1 || col[j] == 1){
                    mat[i][j] = 0;
                }
            }
        }
    }

    public static void f_optimal(int[][] mat, int n, int m){

        boolean isRow = false;

        boolean isCol = false;

        for(int i = 0; i < n; i++){

            for(int j = 0; j < m; j++){

                if(mat[i][j] == 0){

                    mat[i][0] = 0;
                    mat[0][j] = 0;

                    if(i == 0) isRow = true;

                    if(j == 0) isCol = true;
                }
            }
        }

        for(int i = 1; i < n; i++){

            for(int j = 1; j < m; j++){

                if(mat[i][0] == 0 || mat[0][j] == 0){
                    mat[i][j] = 0;
                }
            }
        }

        if(isRow){
            for(int i = 0; i < m; i++){
                mat[0][i] = 0;
            }
        }

        if(isCol){
            for(int i = 0; i < n; i++){
                mat[i][0] = 0;
            }
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

        int[][] mat = { {1, 1, 1}, {1, 0, 1}, {1, 1, 1} };

        int n = mat.length;

        int m = mat[0].length;

        // f_brute(mat, n, m);

        // f_better(mat, n, m);

        f_optimal(mat, n, m);

        print(mat, n, m);
    }
}