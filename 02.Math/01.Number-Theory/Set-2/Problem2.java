/**
 *  Q: Given N numbers a1, a2, a3, ..., aN. 
 *  calculate sum of product of all possible unique pairs
 *  where n <= 10^6
 *  
 *  eg: n = 3
 *      a1 = 2, a2 = 3, a3 = 4
 *  -> a1 * a2 + a1 * a3 + a2 * a3
 *      2 * 3 + 2 * 4 + 3 * 4
 *      6 + 8 + 12 -> 26
 */

import java.util.*;

public class Problem2{

    /**
     *  Time: O(N^2)
     *  Space: O(1)
     */
    public static int brute(int[] arr, int n){
        int sum = 0;
        // generate all pairs
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                sum += (arr[i] * arr[j]);
            }
        }
        return sum;
    }

    /**
     *  Time: O(N)
     *  Space: O(1)
     */
    public static int optimal(int[] arr, int n){
        /**
         *  (a + b)^2 = a^2 + 2ab+ b^2
         *  (a + b + c)^2 = a^2 + b^2 + c^2 + 2ab + 2bc + 2ac
         *  ab + bc + ac = ((a + b + c)^2 - a^2 - b^2 - c^2) / 2
         *  
         *  In general, 
         *      ab + bc + ac...n = ((a + b + c...n)^2 - a^2 - b^2 - c^2...n) / 2
         */
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += arr[i];
        }

        sum = sum * sum;
        for(int i = 0; i < n; i++){
            sum = sum - (arr[i] * arr[i]);
        }

        sum = sum / 2;
        return sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        // int res = brute(arr, n);

        int res = optimal(arr, n);
        System.out.println(res);
    }   
}