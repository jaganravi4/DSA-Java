/**
 *  Problem link -> https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */

public class Problem13{

    public static int f(int[] nums, int target){

        int n = nums.length;

        for(int i = 0; i < n; i++){

            if(nums[i] == target){
                return i;
            }
        }

        return -1;
    }

    public static int f_optimal(int[] nums, int target){

        int n = nums.length;

        int low = 0, high = n - 1;

        while(low <= high){

            int mid = (low + high) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[low] <= nums[mid]){

                if(nums[low] <= target && nums[mid] >= target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{

                if(nums[mid] <= target && nums[high] >= target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            
        }

        return -1;
    }

    public static void main(String[] args){

        int[] nums = {4, 5, 0, 1, 2};

        int target = 5;

        // int res = f(nums, target);

        int res = f_optimal(nums, target);

        System.out.println(res);
    }
}