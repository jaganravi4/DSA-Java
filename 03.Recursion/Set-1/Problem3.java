/**
 *  Q: Recursive binary search
 *  eg: arr = [1, 2, 3, 4, 5] 
 *      target = 4 -> return true
 *      target = 6 -> return false;
 */

public class Problem3{

    public static boolean bs(int[] arr, int n, int target){
        int low = 0, high = n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] == target){
                return true;
            }else if (arr[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }

    public static boolean bsRec(int[] arr, int low, int high, int target){
        if(low >= high){
            return false;
        }

        int mid = low + (high - low) / 2;
        if(arr[mid] == target){
            return true;
        }else if(arr[mid] > target){
            return bsRec(arr, low, mid - 1, target);
        }else{
            return bsRec(arr, mid + 1, high, target);
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};

        int n = arr.length;

        int target = 3;

        // System.out.println(bs(arr, n, target));

        System.out.println(bsRec(arr, 0, n - 1, target));
    }
}