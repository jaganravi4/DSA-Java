/**
 *  Q: Given n * m matrix, you start from top left corner (0, 0) and you have to reach bottom right corner (n - 1, m - 1)
 *     you can move 4 directions one step at the time and you cannot visit each index more than once. return the count of all 
 *     possible unique path that you can take inorder to reach the destination.
 *   eg: n = 3, m = 2
 *      output -> 4 -> [RDD, DRD, DDR, RDLDR]
 */

public class Problem16{

    public static int f(int i, int j, int n, int m, int[] dRow, int[] dCol, boolean[][] vis){
        if(i < 0 || i >= n || j < 0 || j >= m || vis[i][j]){
            return 0;
        }

        if(i == n - 1 && j == m - 1){
            return 1;
        }

        vis[i][j] = true;

        int cnt = 0;

        for(int x = 0; x < 4; x++){
            cnt += f(i + dRow[x], j + dCol[x], n, m, dRow, dCol, vis);
        }

        vis[i][j] = false;

        return cnt;
    }

    public static void main(String[] args){
        int n = 3, m = 2;

        boolean[][] vis = new boolean[n][m];
        
        int[] dRow = {1, 0, 0, -1};
        int[] dCol = {0, -1, 1, 0};

        int res = f(0, 0, n, m, dRow, dCol, vis);

        System.out.println(res);
    }
}