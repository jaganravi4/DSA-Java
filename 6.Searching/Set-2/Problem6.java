/**
 *  Problem link -> https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
 */
public class Problem6{

    public static int f(int[] arr, int k){

        int n = arr.length;

        int low = 0;

        int high = 0;

        for(int i = 0; i < n; i++){

            if(low < arr[i]){
                low = arr[i];
            }

            high += arr[i];
        }

        int ans = high;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(check(arr, mid, k, n)){
                ans = mid;

                high = mid - 1;
            }else{

                low = mid + 1;
            }
        }

        return ans;
    }

    public static boolean check(int[] arr, int limit, int k, int n){

        int sum = 0;

        int count = 1;

        for(int i = 0; i < n; i++){

            if(sum + arr[i] > limit){

                count += 1;

                sum = arr[i];
            }else{

                sum += arr[i];
            }
        }

        return count <= k;
    }

    public static void main(String[] args){

        int[] arr = {10, 5, 20, 25, 17, 23, 2, 9, 4, 13};

        int k = 7;

        int res = f(arr, k);

        System.out.println(res);
    }
}