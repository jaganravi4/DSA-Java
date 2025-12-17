/**
 *  Q: Given n * m matrix, you start from top left corner (0, 0) and you have to reach bottom right corner (n - 1, m - 1)
 *     you can move 4 directions one step at the time and you cannot visit each index more than once. return the list of all 
 *     possible unique path that you can take inorder to reach the destination.
 *   eg: n = 3, m = 2
 *      output -> [RDD, DRD, DDR, RDLDR]
 */

import java.util.*;

public class Problem14{

    public static void f_brute(int i, int j, int n, int m, String path, List<String> res, boolean[][] visited){
        if(i >= n || j >= m || i < 0 || j < 0 || visited[i][j]){
            return;
        }

        if(i == n - 1 && j == m - 1){
            res.add(path);
            return;
        }

        // mark
        visited[i][j] = true;
        
        // move up 
        f_brute(i - 1, j, n, m, path + "U", res, visited);

        // move right
        f_brute(i, j + 1, n, m, path + "R", res, visited);

        // move down
        f_brute(i + 1, j, n, m, path + "D", res, visited);

        // move left
        f_brute(i, j - 1, n, m, path + "L", res, visited);

        // unmark
        visited[i][j] = false;
    }

    public static void f_optimal(int i, int j, int n, int m, String path, String dir, int[] dRow, int[] dCol, List<String> res, boolean[][] visited){   
        if(i < 0 || i >= n || j < 0 || j >= m || visited[i][j]){
            return;
        }

        if(i == n - 1 && j == m - 1){
            res.add(path);
            return;
        }

        visited[i][j] = true;

        for(int idx = 0; idx < 4; idx++){
            f_optimal(i + dRow[idx], j + dCol[idx], n, m, path + dir.charAt(idx), dir, dRow, dCol, res, visited);
        }

        visited[i][j] = false;
    }

    public static void main(String[] args){
        int n = 3, m = 2;

        List<String> res = new ArrayList<>();

        boolean[][] visited = new boolean[n][m];

        // f_brute(0, 0, n, m, "", res, visited);

        String dir = "URDL"; // directions

        int[] dRow = {-1, 0, 1, 0};

        int[] dCol = {0, 1, 0, -1};

        f_optimal(0, 0, n, m, "", dir, dRow, dCol, res, visited);

        System.out.println(res);
    }
}