/**
 *  Given an sorted arr of size N and integer x. find the index of the element >= or > x
 * 
 *  eg: arr = {1, 3, 5, 10, 11, 13} x = 7 -> output: 4
 */

public class Problem2{

    public static int f(int[] arr, int x){

        int n = arr.length;

        int ans = n;

        int low = 0, high = n - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(checkStrictlyGreaterThenX(arr, mid, x) == 1){
                ans = mid;

                high = mid - 1;
            }else{

                low = mid + 1;
            }
        }

        return ans;
    }

    /**
     *  lower bound
     */
    public static int checkGreaterThanOrEqualToX(int[] arr, int idx, int x){

        if(arr[idx] >= x){
            return 1;
        }

        return 0;
    }

    /**
     *  upper bound
     */
    public static int checkStrictlyGreaterThanX(int[] arr, int idx, int x){
        
        if(arr[idx] > x){
            return 1;
        }

        return 0;
    } 

    public static void main(String[] args){

        int[] arr = {1, 3, 5, 6, 7, 10, 11, 13};

        int x = 7;

        int res = f(arr, x);

        System.out.println(res);
    }
}