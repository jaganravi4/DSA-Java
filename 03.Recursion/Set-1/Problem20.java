
import java.util.*;

public class Problem20{

    public static void f_optimal(StringBuilder s, int idx, int n, List<String> res){

        if(idx == n){
            res.add(s.toString());

            return;
        }

        for(int i = idx; i < n; i++){

            swap(s, i, idx);

            f_optimal(s, idx + 1, n, res);

            swap(s, i, idx);
        }
    }

    public static void swap(StringBuilder s, int i, int j){

        char temp = s.charAt(i);

        s.setCharAt(i, s.charAt(j));

        s.setCharAt(j, temp);
    }

    public static void main(String[] args){

        StringBuilder sb = new StringBuilder("145");

        int n = sb.length();

        List<String> res = new ArrayList<>();

        f_optimal(sb, 0, n, res);

        System.out.println(res);
    }
}