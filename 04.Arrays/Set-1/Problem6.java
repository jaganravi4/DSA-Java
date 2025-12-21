/**
 *  Problem link -> https://leetcode.com/problems/single-number/description/
 */

public class Problem6{

    /**
     *  Time: O(N * N)
     *  Space: O(1)
     */
    public static int f_brute(int[] arr, int n){

        for(int i = 0; i < n; i++){

            int x = arr[i]; // current value

            int count = 0;

            for(int j = 0; j < n; j++){
                if(x == arr[j]){
                    count++;
                }
            }

            if(count == 1){
                return x;
            }
        }

        return -1;
    }

    /** 
     *  Time: O(N)
     */
    public static int f_optimal(int[] arr, int n){
        int xor = arr[0];

        for(int i = 1; i < n; i++){
            xor = xor ^ arr[i];
        }

        return xor;
    }

    public static void main(String[] args){
        int[] arr = {4, 2, 1, 2, 1, 4, 5};

        int n = arr.length;

        // int res = f_brute(arr, n);

        int res = f_optimal(arr, n);

        System.out.println(res);
    }
}