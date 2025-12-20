/**
 *  Q: Given an array which only contains 0's and 1's and the data is shuffled randomly.
 *     write a function that can rearrange the data such that all the 0's are present before 1's.
 *      
 *    eg: arr = [1, 0, 0, 0, 1, 1] -> output -> [0, 0, 0, 1, 1, 1] -> [don't create new array]
 *      
 *    [follow up : do the rearrangement by reading / accessing the whole array only once (Single Pass)]
 */

import java.util.*;

public class Problem1{

    public static void f_brute(int[] arr, int n){
        int countZero = 0;

        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                countZero++;
            }
        }

        // two pass
        for(int i = 0; i < n; i++){
            if(i < countZero){
                arr[i] = 0;
            }else{
                arr[i] = 1;
            }
        }
    }

    public static void f_optimal(int[] arr, int n){
        int i = 0;
        int j = n - 1;

        while(i <= j){
            if(arr[i] == 1){
                swap(arr, i, j);
                j--;
            }else{
                i++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr, int n){

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        int[] arr = {0, 0, 0, 1, 0};

        int n = arr.length;

        // f_brute(arr, n);

        f_optimal(arr, n);

        print(arr, n);
    }
}