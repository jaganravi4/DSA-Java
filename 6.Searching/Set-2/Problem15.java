/**
 *  Problem link -> https://leetcode.com/problems/kth-missing-positive-number/description/
 */

public class Problem15{

    public static int f_brute(int[] arr, int k){

        int[] map = new int[5001];

        for(int num : arr){

            map[num]++;
        }

        for(int i = 1; i < map.length; i++){

            if(map[i] == 0){
                k--;
            }

            if(k == 0){
                return i;
            }
        }

        return -1;
    }

    public static int f_better(int[] arr, int k){

        int n = arr.length;
        
        for(int i = 0; i < n; i++){

            if(arr[i] <= k){
                k++;
            }else{
                break;
            }
        }

        return k;
    }

    public static int f_optimal(int[] arr, int k){

        int n = arr.length;

        int low = 0, high = n - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(check(arr, mid, k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return high + k + 1;
    }

    public static boolean check(int[] arr, int i, int k){

        int missingNumbers = arr[i] - (i + 1);

        return missingNumbers >= k;
    }

    public static void main(String[] args){

        int[] arr = {2, 3, 4, 7, 11};

        int k = 3;

        // int res = f_brute(arr, k);

        // int res =f_better(arr, k);

        int res = f_optimal(arr, k);

        System.out.println(res);
    }
}
