/**
 *  Problem link -> https://leetcode.com/problems/merge-sorted-array/description/
 */

public class Problem3{

    /**
     *  Time: O(m + n)
     *  Space: O(m + n)
     */
    public static void merge_brute(int[] a, int m, int[] b, int n){
        int[] c = new int[m + n];

        int i = 0, j = 0, k = 0;

        // loop will end when any one array exhausts
        while(i < m && j < n){
            if(a[i] <= b[j]){
                c[k] = a[i]; 
                i++;
            }else{
                c[k] = b[j];
                j++;
            }
            k++;
        }

        // if [a] still has elements
        while(i < m){
            c[k] = a[i];
            i++;
            k++;
        }

        // if [b] still has elements
        while(j < n){
            c[k] = b[j];
            j++;
            k++;
        }

        for(int idx = 0; idx < c.length; idx++){
            a[idx] = c[idx];
        }
    }

    /**
     *  Time: O(m + n)
     *  Space: O(1)
     */
    public static void merge_optimal(int[] a, int m, int[] b, int n){
        int i = m - 1;

        int j = n - 1;
        
        int k = m + n - 1;
        
        while(i >= 0 && j >= 0){
            if(a[i] >= b[j]){
                a[k] = a[i];
                i--;
            }else{
                a[k] = b[j];
                j--;
            }
            k--;
        }

        while(i >= 0){
            a[k] = a[i];
            i--;
            k--;
        }

        while(j >= 0){
            a[k] = b[j];
            j--;
            k--;
        }
    }

    public static void print(int[] arr){

        for(int i = 0; i < arr.length; i++){

            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        int[] a = {1, 2, 3, 0, 0, 0};
        
        int m = 3; // number of elements in [a]
        
        int[] b = {0, 1, 2};

        int n = 3; // number of elements in [b]

        // merge_brute(a, m, b, n);

        merge_optimal(a, m, b, n);

        print(a);
    }
}