
import java.util.*;

public class Problem19{

    public static void f_brute(int[] arr, int n, List<Integer> ds, List<List<Integer>> res, boolean[] vis){

        if(ds.size() == n){

            res.add(new ArrayList<>(ds));

            return;
        }

        for(int i = 0; i < n; i++){

            if(vis[i] == false){
                
                vis[i] = true;

                ds.add(arr[i]);

                f_brute(arr, n, ds, res, vis);

                ds.removeLast();

                vis[i] = false;
            }
        }
    }

    public static void f_optimal(int[] arr, int idx, int n, List<List<Integer>> res){

        if(idx == n){

            List<Integer> ds = new ArrayList<>();

            for(int i = 0; i < n; i++){

                ds.add(arr[i]);
            }

            res.add(new ArrayList<>(ds));

            return;
        }

        for(int i = idx; i < n; i++){

            swap(arr, i, idx);

            f_optimal(arr, idx + 1, n, res);

            swap(arr, i, idx);
        }
    }

    public static void swap(int[] arr, int i, int j){

        int temp = arr[i];

        arr[i] = arr[j];

        arr[j] = temp;
    }

    public static void main(String[] args){

        int[] arr = {1, 2, 3};

        int n = arr.length;

        List<Integer> ds = new ArrayList<>();

        boolean[] vis = new boolean[n];

        List<List<Integer>> res = new ArrayList<>();
        
        // f_brute(arr, n, ds, res, vis);

        f_optimal(arr, 0, n, res);

        System.out.println(res);
    }
}