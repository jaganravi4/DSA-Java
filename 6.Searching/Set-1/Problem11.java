/**
 *  Problem link -> https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */

import java.util.*;

public class Problem11{

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

            int mid = low + (high - low) / 2;

            if(nums[mid] > nums[high]){
            
                low = mid + 1;
            }else{

                high = mid - 1;
            }
            
            res = Math.min(res, nums[mid]);
        }

        return res;
    }

    public static void main(String[] args){

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        // int res = f(nums);

        int res = f_optimal(nums);

        System.out.println(res);
    }
}