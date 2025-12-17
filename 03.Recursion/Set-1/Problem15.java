/**
 *  Problem link -> https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
 */

import java.util.*;

public class Problem15{

    public static void f(int i, int j, int n, String path, String dir, int[] dRow, int[] dCol, int[][] maze, List<String> res, boolean[][] visited){
        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || visited[i][j]){
            return;
        }

        if(i == n - 1 && j == n - 1){
            res.add(path);
            return;
        }

        visited[i][j] = true;

        for(int idx = 0; idx < 4; idx++){
            f(i + dRow[idx], j + dCol[idx], n, path + dir.charAt(idx), dir, dRow, dCol, maze, res, visited);
        }

        visited[i][j] = false;
    }

    public static void main(String[] args){
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1} };

        int n = maze.length;

        boolean[][] visited = new boolean[n][n];

        List<String> res = new ArrayList<>();

        String dir = "DLRU"; // lexicographical order

        int[] dRow = {1, 0, 0, -1};
        int[] dCol = {0, -1, 1, 0};

        f(0, 0, n, "", dir, dRow, dCol, maze, res, visited);

        System.out.println(res);
    }
}