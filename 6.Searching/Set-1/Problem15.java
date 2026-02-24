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

    public static int f_better(int[] nums, int target){

        int n = nums.length;

        int[] p = new int[n + 1];

        for(int i = 1; i <= n; i++){

            p[i] = p[i - 1] + nums[i - 1];
        }

        int res = 0;

        int low = 1, high = n;

        while(low <= high){
 
            int mid = low + (high - low) / 2;

            int val = f_helper(p, mid, n + 1);

            if(val >= target){

                res = mid;

                high = mid - 1;
            }else{

                low = mid + 1;
            }
        }

        return res;
    }

    public static int f_helper(int[] arr, int k, int n){

        int i = 0, j = k;

        int max = 0;

        while(j < n){

            int sum = arr[j] - arr[i];

            if(max < sum){
                max = sum;
            }

            j++;

            i++;
        }
        return max;
    }

    public static int f_optimal(int[] nums, int target){

        int n = nums.length;

        int i = 0, j = 0;

        int sum = 0;

        int res = Integer.MAX_VALUE;

        while(j < n){

            sum += nums[j];

            while(sum >= target){

                res = Math.min(res, j - i + 1);

                sum -= nums[i];

                i++;
            }

            j++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args){

        int[] nums = {5,1,3,5,10,7,4,9,2,8};

        int target = 15;

        // int res = f_brute(nums, target);

        // int res = f_better(nums, target);

        int res = f_optimal(nums, target);

        System.out.println(res);
    }
}