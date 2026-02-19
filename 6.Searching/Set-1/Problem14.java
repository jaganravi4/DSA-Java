// Problem link -> https://leetcode.com/problems/find-peak-element/description/

public class Problem14{

    public static int f_brute(int[] nums){

        int n = nums.length;

        int res = 0;

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){

            if(max < nums[i]){
                max = nums[i];

                res = i;
            }
        }

        return res;
    }

    public static int f_better(int[] nums){

        int n = nums.length;

        if(n == 1 || nums[0] > nums[1]){
            return 0;
        }

        if(nums[n - 2] < nums[n - 1]){
            return n - 1;
        }

        for(int i = 1; i < n - 1; i++){

            if(nums[i - 1] < nums[i] && nums[i + 1] < nums[i]){
                return i;
            }
        }

        return -1;
    }

    public static int f_optimal(int[] nums){

        int n = nums.length;

        if(n == 1 || nums[0] > nums[1]){
            return 0;
        }

        if(nums[n - 2] < nums[n - 1]){
            return n - 1;
        }

        int res = -1;

        int max = Integer.MIN_VALUE;

        int low = 1, high = n - 2;

        while(low <= high){

            int mid = (low + high) / 2;

            if(nums[mid] > nums[mid + 1]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

            if(max < nums[mid]){

                max = nums[mid];

                res = mid;
            }
        }

        return res;
    }

    public static void main(String[] args){

        int[] nums = {1, 2, 3, 4, 3, 2};

        // int res = f_brute(nums);

        // int res = f_better(nums);

        int res = f_optimal(nums);

        System.out.println(res);
    }
}