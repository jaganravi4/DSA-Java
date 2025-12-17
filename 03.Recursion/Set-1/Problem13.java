/**
 *   Q: Given n * m matrix, you start from top left corner (0, 0) and you have to reach bottom right corner 
 *      (n - 1, m - 1). you either move right [R] or down [D] one step at the time. return the list of all possible 
 *      unique path that you can take to reach the destination.
 *   eg: n = 3, m = 2
 *       output -> ["RDD", "DDR", "DRD"]
 */

import java.util.*;

public class Problem13{

    /**
     *  Time: O(2^(n * m))
     *  Spcae: O(n * m)
     */
    public static void f(int i, int j, int n, int m, String path, List<String> res){
        if(i >= n|| j >= m){
            return;
        }

        if(i == n - 1 && j == m - 1){
            res.add(path);
            return;
        }

        // move right
        f(i, j + 1, n, m, path + "R", res);

        // move down
        f(i + 1, j, n, m, path + "D", res);
    }

    public static void main(String[] args){
        int n = 3, m = 2;

        List<String> res = new ArrayList<>();
        
        f(0, 0, n, m, "", res);

        System.out.println(res);
    }
}