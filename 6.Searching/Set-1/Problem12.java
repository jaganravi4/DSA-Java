/**
 *  Problem link -> https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */

import java.util.*;

public class Problem12{

    public static int f(int[] nums){

        int n = nums.length;

        int res = 5001;

        for(int i = 0; i < n; i++){

            if(nums[i] < res){
                res = nums[i];
            }
        }

        return res;
    }

    public static int f_optimal(int[] nums){

        int n = nums.length;

        int res = 5001;

        int low = 0, high = n - 1;

        while(low <= high){

            if(nums[low] == nums[high]){
                res = Math.min(res, nums[low]);

                low++;

                high--;

                continue;
            }

            int mid = low + (high - low) /2;

            if(nums[mid] <= nums[high]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

            res = Math.min(res, nums[mid]);
        }

        return res;
    }

    public static void main(String[] args){

        int[] nums = {3, 5, 0, 1, 2, 3, 3};

        // int res = f(nums);

        int res = f_optimal(nums);

        System.out.println(res);
    }
}