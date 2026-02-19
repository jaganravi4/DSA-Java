/**
 *  find the last occurrence of x in the given array.
 * 
 *  for eg -> arr = [1, 3, 4, 7, 9, 9, 10];
 *             x = 9;
 * 
 *      output -> 5 (0 based index)
 */

public class Problem3{

    public static int f(int[] arr, int x){

        int n = arr.length;

        int low = 0, high = n - 1;

        int res = -1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(arr[mid] == x){
                res = mid;

                low = mid + 1;
            }else if (arr[mid] > x){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return res;
    }

    public static int f_rec(int[] arr, int low, int high, int x, int res){

        if(low > high){
            return res;
        }

        int mid = low + (high - low) / 2;

        if(arr[mid] == x){
            res = mid;

            return f_rec(arr, mid + 1, high, x, res);
        }else if (arr[mid] > x){
            return f_rec(arr, low, mid - 1, x, res);
        }
        
        return f_rec(arr, mid + 1, high, x, res);
    }

    public static void main(String[] args){

        int[] arr = {1, 4, 7, 7, 11};

        int n = arr.length;

        int x = 7;

        // int res = f(arr, x);

        int res = f_rec(arr, 0, n - 1, x, -1);

        System.out.println(res);
    }
}