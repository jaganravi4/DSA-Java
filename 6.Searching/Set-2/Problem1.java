/**
 *  Given an arr of size N. it contains only 0's and 1's.
 *  find the first index of 1 in the given array.
 * 
 *  eg: arr = [0, 0, 0, 0, 0, 1, 1, 1] -> 5 (output)
 */

public class Problem1{

    public static int f(int[] arr, int n){

        int low = 0, high = n - 1;

        int res = 0;

        while(low <= high){

            int mid = low + (high - low ) / 2;

            if(arr[mid] == 1){

                res = mid;

                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args){

        int[] arr = {0, 0, 0, 1, 1, 1};

        int n = arr.length;

        int res = f(arr, n);

        System.out.println(res);
    }

}