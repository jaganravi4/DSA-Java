/**
 *  Problem link -> https://leetcode.com/problems/max-consecutive-ones/
 */

public class Problem4{

    public static int f(int[] arr, int n){
        
        int count = 0;

        int maxCount = 0;

        for(int i = 0; i < n; i++){

            if(arr[i] == 1){
                count++;
            }else{
                count = 0;
            }

            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

    public static void main(String[] args){
        int[] arr = {1, 1, 0, 1, 1, 1};

        int n = arr.length;

        int res = f(arr, n);

        System.out.println(res);
    }
}