/**
 *  Problem link -> https://leetcode.com/problems/next-permutation/description/
 */

import java.util.*;

public class Problem5{

    public static void f(int[] nums){

        int n = nums.length;

        int pivot = -1;

        for(int i = n - 2; i >= 0; i--){

            if(nums[i] < nums[i + 1]){
                pivot = i;

                break;
            }
        }

        if(pivot == -1){
            reverse(nums, 0, n - 1);
            
            return;
        }

        for(int i = n - 1; i > pivot; i--){

            if(nums[pivot] < nums[i]){
                swap(nums, i, pivot);

                break;
            }
        }

        reverse(nums, pivot + 1, n - 1);
    }

    public static void reverse(int[] nums, int start, int end){

        while(start <= end){

            swap(nums, start, end);

            start++;

            end--;
        }
    }

    public static void swap(int[] nums, int i, int j){

        int temp = nums[i];

        nums[i] = nums[j];

        nums[j] = temp;
    }

    public static void main(String[] args){

        int[] nums = {1, 5, 4, 3, 2};

        f(nums);

        System.out.println(Arrays.toString(nums));
    }
}