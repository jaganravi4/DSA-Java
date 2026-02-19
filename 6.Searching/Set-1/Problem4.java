/**
 *  find the lower bound of x?
 *  eg: arr = [1, 2, 3, 5, 8, 9], x = 4 -> output: 5
 */

public class Problem4{

    public static int f(int[] arr, int x, int n){

        int res = n;

        int low = 0, high = n - 1;

        while(low <= high){

            int mid = (low + high) / 2;

            if(arr[mid] >= x){
                res = arr[mid];

                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 5, 8, 9};

        int x = 6;

        int n = arr.length;

        int res = f(arr, x, n);

        System.out.println(res);
    }
}