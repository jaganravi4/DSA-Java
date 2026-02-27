/**
 *  Given rotated sorted arr of size N. count number of times rotated?
 *  
 *  eg : arr = {3, 5, 9, 1, 2} -> 3 (output)
 */

public class Problem3{

    public static int f(int[] arr){

        int n = arr.length;

        int low = 0, high = n - 1;

        int ans = -1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(check(arr, mid) == 1){

                ans = mid;

                high = mid - 1;
            }else{

                low = mid + 1;
            }
        }

        return ans;
    }

    public static int check(int[] arr, int idx){

        if(arr[idx] < arr[0]){
            return 1;
        }

        return 0;
    }

    public static void main(String[] args){

        int[] arr = {5, 1, 2, 3, 4};

        int res = f(arr);

        System.out.println(res);
    }
}