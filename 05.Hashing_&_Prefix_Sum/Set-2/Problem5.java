/** 
 *  https://leetcode.com/problems/longest-consecutive-sequence/description/
 */

import java.util.*;

public class Problem5{

    public static int f_brute(int[] nums){

        int n = nums.length;

        Arrays.sort(nums);

        int max = 0;

        for(int i = 0; i < n; i++){

            int count = 1;

            int x = nums[i];

            while(true){

                boolean isPresent = f_helper(nums, x - 1, n);

                if(!isPresent){
                    break;
                }

                count++;

                x--;
            }

            if(max < count){

                max = count;
            }
        }

        return max;
    }

    public static boolean f_helper(int[] arr, int x, int n){

        int low = 0, high = n - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(arr[mid] == x){

                return true;
            }else if(arr[mid] < x){

                low = mid + 1;
            }else{

                high = mid - 1;
            }
        }

        return false;
    }

    public static int f_better(int[] nums){

        int n = nums.length;

        if(n == 0){
            return 0;
        }

        Arrays.sort(nums);

        int longest = 1, count = 1, lastSmaller = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){

            if((nums[i] - 1) == lastSmaller){

                count++;

                lastSmaller = nums[i];
            }else if(nums[i] != lastSmaller){

                lastSmaller = nums[i];

                count = 1;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }

    public static int f_optimal(int[] nums){

        int n = nums.length;

        if(n == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++){

            set.add(nums[i]);
        }

        int longest = 1;

        for(int num : set){

            if(!set.contains(num - 1)){

                int count = 1;

                while(set.contains(num + 1)){

                    num += 1;

                    count += 1;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args){

        int[] nums = {100, 4, 200, 1, 3, 2};

        // int res = f_brute(nums);

        // int res = f_better(nums);

        int res = f_optimal(nums);

        System.out.println(res);
    }
}