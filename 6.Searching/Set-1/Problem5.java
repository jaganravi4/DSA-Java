/**
 *  find the upper bound of x?
 *  eg: arr = [1, 2, 3, 4, 5], x = 3 -> output: 4
 */

public class Problem5{

    public static int f(int[] arr, int x, int n){

        int res = n;

        int low = 0, high = n - 1;

        while(low <= high){

            int mid = (low + high) / 2;

            if(arr[mid] > x){
                res = arr[mid];

                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args){

        int[] arr = {1, 2, 3, 4, 5};

        int n = arr.length;

        int x = 3;

        int res = f(arr, x, n);

        System.out.println(res);
    }
}