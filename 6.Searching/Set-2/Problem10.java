/**
 *  Problem link -> https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 */

public class Problem10{

    public static int f(int[] weights, int days){

        int n = weights.length;

        int low = 0, high = 0;

        for(int i = 0; i < n; i++){
            
            if(low < weights[i]){
                low = weights[i];
            }

            high += weights[i];
        }  

        int ans = 0;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(isPossible(weights, mid, days, n)){
                ans = mid;

                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] weights, int capacity, int days, int n){

        int sum = 0;

        int count = 1;

        for(int i = 0; i < n; i++){

            if(sum + weights[i] > capacity){

                count += 1;

                sum = weights[i];
            }else{

                sum += weights[i];
            }
        }

        return count <= days;
    }

    public static void main(String[] args){

        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int days = 5;

        int res = f(weights, days);

        System.out.println(res);
    }
}