/**
 *  Problem link -> https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */

import java.util.*;

public class Problem1{

    public static int f_brute(int[] nums){

        int n = nums.length;

        ArrayList<Integer> list = new ArrayList<>();

        list.add(nums[0]);

        for(int i = 1; i < n; i++){

            if(nums[i] != list.get(list.size() - 1)){
                list.add(nums[i]);
            }
        }

        int m = list.size();

        for(int i = 0; i < m; i++){
            nums[i] = list.get(i);
        }

        return m;
    }

    public static int f_optimal(int[] nums){

        int n = nums.length;

        if(n == 1){
            return 1;
        }

        int i = 1;
        
        for(int j = 1; j < n; j++){

            if(nums[j - 1] != nums[j]){

                nums[i] = nums[j];

                i++;
            }
        }

        return i;
    }

    public static void main(String[] args){

        int[] nums = {0, 1, 2, 3, 4, 5};

        // int res = f_brute(nums);

        int res = f_optimal(nums);

        System.out.println(res);

        System.out.println(Arrays.toString(nums));
    }
}