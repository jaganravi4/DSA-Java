/**
 *  Given bitonic arr (i.e first strictly increasing then decreasing). find the peak element?
 * 
 *  eg : arr = {1, 3, 5, 9, 5, 3, 1} -> 9 (output)
 */
public class Problem4{

    public static int f(int[] arr){

        int n = arr.length;

        int low = 0, high = n - 1;

        int ans = -1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(check(arr, mid, n) == 1){

                ans = arr[mid];

                high = mid - 1;
            }else{

                low = mid + 1;
            }
        }

        return ans;
    }

    public static int check(int[] arr, int idx, int n){

        if(idx == n - 1){
            return 1;
        }

        if(arr[idx] > arr[idx + 1]){
            return 1;
        }

        return 0;
    }

    public static void main(String[] args){

        int[] arr = {1, 2, 3};

        int res = f(arr);

        System.out.println(res);
    }
}