/**
 *  Given a bitonic array A consisting of N integers and an integer Q. 
 *  In each query, you will be given an integer K, find the positions of K in A. Integer K exists in A.
 */

import java.util.*;

public class Problem5{

    public static void f_brute(int[] arr, int[] q){

        int n = arr.length;

        int m = q.length;

        for(int i = 0; i < m; i++){
            
            int k = q[i];

            for(int j = 0; j < n; j++){

                if(arr[j] == k){
                    System.out.print((j + 1) + " ");
                }
            }

            System.out.print("\n");
        }
    }

    public static void f_optimal(int[] arr, int[] q){

        int n = arr.length;

        int m = q.length;

        int idx = findPeakElementIndex(arr, n);

        for(int i = 0; i < m; i++){

            List<Integer> pos = new ArrayList<>();

            int k = q[i];

            binarySearchOnIncreasingOrder(arr, 0, idx, k, pos);

            binarySearchOnDecreasingOrder(arr, idx + 1, n - 1, k, pos);

            for(int x : pos){

                System.out.print(x + " ");
            }

            System.out.print("\n");
        }
    }

    public static int findPeakElementIndex(int[] arr, int n){

        int low = 0, high = n - 1;

        int ans = -1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(check(arr, mid, n) == 1){

                ans = mid;

                high = mid - 1;
            }else{

                low = mid + 1;
            }
        }

        return ans;
    }

    public static int check(int[] arr, int idx, int n){

        if(idx == n - 1) return 1;

        if(arr[idx] > arr[idx + 1]){
            return 1;
        }

        return 0;
    }

    public static void binarySearchOnIncreasingOrder(int[] arr, int low, int high, int k, List<Integer> pos){

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(arr[mid] == k){
                pos.add(mid + 1);

                break;
            }else if(arr[mid] < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
    }

    public static void binarySearchOnDecreasingOrder(int[] arr, int low, int high, int k, List<Integer> pos){

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(arr[mid] == k){
                pos.add(mid + 1);
                
                break;
            }else if(arr[mid] > k){

                low = mid + 1;
            }else{

                high = mid - 1;
            }
        }
    }

    public static void main(String[] args){

        int[] arr = {1, 2, 5, 3, 2, 1};

        int[] q = {1, 2, 3, 5};

        // f_brute(arr, q);

        f_optimal(arr, q);
    }
}