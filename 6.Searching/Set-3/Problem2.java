/**
 *  Problem link -> https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/
 */

public class Problem2{

    public static int f(int[] nums, int maxOperations){

        int n = nums.length;

        long low = 1, high = 0;

        for(int i = 0; i < n; i++){
            high = Math.max(high, nums[i]);
        }

        long ans = low;

        while(low <= high){

            long mid = low + (high - low) / 2;

            if(isPossible(nums, n, mid, maxOperations)){
                ans = mid;

                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return (int) ans;
    }

    public static boolean isPossible(int[] nums, int n, long penalty, int maxOperations){

        long count = 0;

        for(int i = 0; i < n; i++){

            long x = (nums[i] * 1L / penalty);

            if(nums[i] % penalty == 0){
                x -= 1;
            }

            count += x;
        }

        return count <= maxOperations * 1L;
    }

    public static void main(String[] args){

        int[] nums = {2, 4, 8, 2};

        int maxOperations = 4;

        int res = f(nums, maxOperations);

        System.out.println(res);
    }
}