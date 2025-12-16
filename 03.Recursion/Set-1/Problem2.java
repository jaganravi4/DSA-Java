/**
 *  Q: Reverse an array using recursion
 *  eg: arr = [1, 2, 3, 4, 5] -> [5, 4, 3, 2, 1]
 */

import java.util.*;

public class Problem2{

    public static void reverse(int[] arr, int n, int i, int j){
        if(i >= j){
            return;
        }

        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        reverse(arr, n, i + 1, j - 1);
    } 

    public static void main(String[] args){

        int[] arr = {1, 2, 3, 4, 5, 6};
        int n = arr.length;

        reverse(arr, n, 0, n - 1);

        System.out.println(Arrays.toString(arr));
    }
}