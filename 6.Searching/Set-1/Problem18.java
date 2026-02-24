/**
 *  Problem link -> https://leetcode.ca/all/1231.html
 */

public class Problem18{

    public static int f(int[] nums, int k){

        int n = nums.length;

        if(n < k){
            return 0;
        }

        int low = Integer.MAX_VALUE;

        int high = 0;

        for(int i = 0; i < n; i++){

            low = Math.min(low, nums[i]);

            high += nums[i];
        }

        int res = high;

        while(low <= high){

            int mid = low + (high - low) / 2;

            boolean isPossible = f_helper(nums, n, mid, k);

            if(isPossible){
                res = mid;

                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return res;
    }

    public static boolean f_helper(int[] nums, int n, int limit, int k){

        int sum = 0;

        int count = 0;

        for(int i = 0; i < n; i++){

            sum += nums[i];

            if(sum >= limit){

                count += 1;

                sum = 0;
            }
        }
        return count >= k;
    }

    public static void main(String[] args){

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int k = 5;

        int res = f(nums, k + 1);

        System.out.println(res);
    }
}