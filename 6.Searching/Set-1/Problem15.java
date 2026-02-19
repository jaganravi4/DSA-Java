// Problem link -> https://leetcode.com/problems/minimum-size-subarray-sum/description/

import java.util.*;

public class Problem15{

    public static int f_brute(int[] nums, int target){

        int n = nums.length;

        int m = 100001;

        int res = m;

        for(int i = 0; i < n; i++){

            int sum = 0;

            for(int j = i; j < n; j++){

                sum += nums[j];

                if(sum >= target && res > j - i + 1){
                    
                    res = j - i + 1;
                }
            }
        }

        return res == m ? 0 : res;
    }

    public static void main(String[] args){

        int[] nums = {2,3,1,2,4,3};

        int target = 7;

        int res = f_brute(nums, target);

        System.out.println(res);
    }
}