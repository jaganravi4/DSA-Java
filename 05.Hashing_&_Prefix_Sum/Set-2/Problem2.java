/**
 *  Problem link -> https://leetcode.com/problems/first-missing-positive/description/
 */

import java.util.*;

public class Problem2{

    public static int f_brute(int[] nums){

        Arrays.sort(nums);

        int n = nums.length;

        for(int i = 1; i <= Integer.MAX_VALUE; i++){

            boolean flag = true;

            int low = 0, high = n - 1;

            while(low <= high){

                int mid = low + (high - low) / 2;

                if(nums[mid] == i){

                    flag = false;

                    break;

                }else if(nums[mid] < i){
                    
                    low = mid + 1;
                }else{

                    high = mid - 1;
                }
            }

            if(flag){
                return i;
            }
        }

        return -1;
    }

    public static int f_better(int[] nums){

        int n = nums.length;

        int[] map = new int[n + 1];

        for(int i = 0; i < n; i++){

            if(nums[i] < 0 || nums[i] >= n + 1){

                continue;
            }else{

                map[nums[i]]++;
            }
        }

        int res = n + 1;

        for(int i = 1; i < map.length; i++){

            if(map[i] == 0){

                res = i;

                break;
            }
        }

        return res;
    }

    public static int f_optimal(int[] nums){

        int n = nums.length;

        boolean flag = true;

        for(int i = 0; i < n; i++){
            
            if(nums[i] == 1){
                flag = false;

                break;
            }
        }

        if(flag){
            return 1;
        }

        for(int i = 0; i < n; i++){

            if(nums[i] <= 0 || nums[i] > n){

                nums[i] = 1;
            }
        }

        for(int i = 0; i < n; i++){

            int idx = Math.abs(nums[i]) - 1;

            if(nums[idx] > 0){

                nums[idx] = nums[idx] * -1;
            }
        }

        int res = n + 1;

        for(int i = 0; i < n; i++){

            if(nums[i] > 0){

                res = i + 1;

                break;
            }
        }

        return res;
    }

    public static void main(String[] args){

        int[] nums = {3, 4, -1, 1};

        // int res = f_brute(nums);

        // int res = f_better(nums);

        int res = f_optimal(nums);

        System.out.println(res);
    } 
}