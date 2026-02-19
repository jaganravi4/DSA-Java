/**
 *  Given x, find the number of occurrence of x in the array.
 *  eg: arr = [1, 2, 2, 2, 3, 4, 5], x = 2 -> output: 3
 */

public class Problem6{

    public static int f(int[] arr, int n, int x){

        int count = 0;

        for(int i = 0; i < n; i++){
            if(arr[i] == x){
                count++;
            }
        } 

        return count;
    }

    public static int f_optimal(int[] arr, int n, int x){

        int first = firstOccurrence(arr, n, x);

        if(first == -1){
            return 0;
        }

        int last = lastOccurrence(arr, n, x);

        return last - first + 1;
    }

    public static int firstOccurrence(int[] arr, int n, int x){

        int res = -1;

        int low = 0, high = n - 1;

        while(low <= high){

            int mid = (low + high) / 2;

            if(arr[mid] == x){

                res = mid;

                high = mid - 1;
            }else if(arr[mid] < x){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return res;
    }

    public static int lastOccurrence(int[] arr, int n, int x){

        int res = -1;

        int low = 0, high = n - 1;

        while(low <= high){
            int mid = (low + high) / 2;

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

    public static void main(String[] args){
        
        int[] arr = {1, 2, 2, 2, 3, 4};

        int x = 2;

        int n = arr.length;

        // int res = f(arr, n, x);

        int res = f_optimal(arr, n, x);

        System.out.println(res);
    }
}