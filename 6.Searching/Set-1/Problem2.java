/**
 *  find the first occurrence of x in the given array.
 * 
 *  for eg -> arr = [1, 3, 4, 7, 9, 10];
 *             x = 9;
 * 
 *      output -> 4 (0 based index)
 */

public class Problem2{  

    /**
     *  Time: O(n)
     *  Spcae: O(1)
     */
    public static int f_brute(int[] arr, int x){

        int n = arr.length;

        // linear search
        for(int i = 0; i < n; i++){

            if(arr[i] == x){
                return i;
            }
        }

        return -1;
    }
    
    /**
     *  Time: O(log n)
     *  Space: O(1)
     */
    public static int f_optimal(int[] arr, int x){

        int n = arr.length;

        // binary search
        int low = 0, high = n - 1;

        int res = -1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(arr[mid] == x){
                res = mid;

                high = mid - 1;
            }else if (arr[mid] < x){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return res;
    }

    public static int f_optimal_rec(int[] arr, int low, int high, int x, int res){

        if(low > high){
            return res;
        }

        int mid = low + (high - low) / 2;

        if(arr[mid] == x){
            res = mid;

            return f_optimal_rec(arr, low, mid - 1, x, res);
        }else if (arr[mid] < x){
            return f_optimal_rec(arr, mid + 1, high, x, res);
        }
        
        return f_optimal_rec(arr, low, mid - 1, x, res);
    }

    public static void main(String[] args){
        int[] arr = {1, 3, 9, 9, 10};

        int n = arr.length;

        int x = 9;

        // int res = f_brute(arr, x);

        // int res = f_optimal(arr, x);

        int res = f_optimal_rec(arr, 0, n - 1, x, -1);

        System.out.println(res);
    }
}