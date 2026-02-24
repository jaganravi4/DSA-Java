/**
 *  Problem link -> http://leetcode.com/problems/split-array-largest-sum/description/
 */

public class Problem17{

    /**
     *  Time: O(log(sum - max + 1) * n)
     */
    public static int f(int[] nums, int k){

        int n = nums.length;

        if(n < k){
            return 0;
        }

        int max = 0;

        int sum = 0;

        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);

            sum += nums[i];
        }

        if(k == 1){
            return sum;
        }

        int low = max, high = sum;

        int res = sum;

        while(low <= high){

            int mid = low + (high - low) / 2;

            boolean isPossible = f_helper(nums, mid, k, n);

            if(isPossible){

                res = mid;

                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return res;
    }

    public static boolean f_helper(int[] nums, int limit, int k, int n){

        int sum = 0;

        int count = 1;

        for(int i = 0; i < n; i++){
            
            if(nums[i] > limit){
                return false;
            }

            if(sum + nums[i] > limit){

                count++;

                sum = nums[i];
            }else{
                sum += nums[i];
            }
        }

        return count <= k;
    }

    public static void main(String[] args){

        int[] nums = {7, 2, 5, 10, 8};

        int k = 3;

        int res = f(nums, k);

        System.out.println(res);
    }
}