/**
 *  find x in the given array.
 * 
 *  for eg: arr = [1, 2, 3, 4, 5], x = 4 -> output: 3 (0 based index)
 */

public class Problem1{

    public static int f(int[] arr, int x){

        int n = arr.length;

        int low = 0;

        int high = n - 1;

        while(low <= high){
            
            int mid = low + (high - low) / 2;

            if(arr[mid] == x){
                return mid;
            }else if (arr[mid] < x){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int f_rec(int[] arr, int low, int high, int x){

        if(low > high){
            return -1;
        }

        int mid = low + (high - low) / 2;

        if(arr[mid] == x){
            return mid;
        }else if (arr[mid] < x){
            return f_rec(arr, mid + 1, high, x);
        }else{
            return f_rec(arr, low, mid - 1, x);
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 3, 4, 5, 8, 10};

        int x = 5;

        int n = arr.length;

        // int res = f(arr, x);

        int res = f_rec(arr, 0, n - 1, x);

        System.out.println(res);
    }
}