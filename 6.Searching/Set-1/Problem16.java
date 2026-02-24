/**
 *  Problem link -> https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
 */

public class Problem16{

    public static int f_brute(int[] nums, int t){
        
        int n = nums.length;

        int min = Integer.MAX_VALUE;

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){

            min = Math.min(nums[i], min);

            max = Math.max(nums[i], max);
        }

        int total = Integer.MAX_VALUE;

        int ans = max;

        for(int i = 1; i <= max; i++){

            int sum = 0;

            for(int j = 0; j < n; j++){

                sum += (nums[j] / i);

                if(nums[j] % i != 0){
                    sum = sum + 1;
                }
            }

            if(sum <= t){

                ans = Math.min(ans, i);
            }
        }

        return ans;
    }

    /**
     *  Time: O(log(max) * n)
     */
    public static int f_optimal(int[] nums, int t){

        int n = nums.length;

        int max = Integer.MIN_VALUE;

        for(int num : nums){

            max = Math.max(num, max);
        }

        int ans = max;

        int low = 1, high = max;

        while(low <= high){

            int mid = low + (high - low) / 2;

            int sum = f_helper(nums, mid, n);

            if(sum <= t){

                ans = Math.min(mid, ans);

                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int f_helper(int[] nums, int x, int n){

        int sum = 0;

        for(int i = 0; i < n; i++){

            int val = (nums[i] / x);

            sum += val;

            if(nums[i] % x != 0){
                sum = sum + 1;
            }
        }

        return sum;
    }

    public static void main(String[] args){

        int[] nums = {1, 2, 5, 9};

        int threshold = 6;

        // int res = f_brute(nums, threshold);

        int res = f_optimal(nums, threshold);

        System.out.println(res);
    }
}