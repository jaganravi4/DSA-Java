/**
 *  Given an arr contains only 0's and 1's. return sorted arr.
 * 
 *  eg : arr = {1, 0, 0, 1, 1, 1, 0, 1} -> {0, 0, 0, 1, 1, 1, 1, 1}
 */

import java.util.*;

public class Problem2{

    public static void f_brute(int[] arr){

        int n = arr.length;

        int countZeros = 0;
        
        for(int i = 0; i < n; i++){

            if(arr[i] == 0){
                countZeros++;
            }
        }

        for(int i = 0; i < countZeros; i++){
            arr[i] = 0;
        }

        for(int i = countZeros; i < n; i++){
            arr[i] = 1;
        }
    }

    public static void f_optimal(int[] arr){

        int n = arr.length;

        int i = 0;

        while(i < n){

            if(arr[i] == 1){
                break;
            }

            i++;
        }

        int j = i + 1;

        while(j < n){

            if(arr[j] == 0){
                swap(arr, i, j);

                i++;
            }

            j++;
        }
    }

    public static void f_optimal_2(int[] arr){

        int n = arr.length;

        int i = 0, j = n - 1;

        while(i < j){

            if(arr[i] == 0){
                i++;
            }else{
                swap(arr, i, j);

                j--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j){

        int temp = arr[i];

        arr[i] = arr[j];

        arr[j] = temp;
    }

    public static void main(String[] args){

        int[] arr = {1, 1, 1, 0, 0, 0, 1};

        // f_brute(arr);

        // f_optimal(arr);

        f_optimal_2(arr);

        System.out.println(Arrays.toString(arr));
    }
}