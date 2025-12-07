public class Pattern17 {

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {

                System.out.print(func(i, j, n) + " ");
            }

            System.out.print("\n");
        }
    }
    
    /*
        a b c d e f g h i 
          a           g   
            a       e     
              a   c       
                a   
    */
    public static char func(int i, int j, int n) {
        if (i == 0) {
            return (char) ('a' + j);
        } else if (i == j) {
            return 'a';
        } else if (i + j == 2 * n - 2) {
            return (char) ('a' + 2 * (j - (n - 1)));
        } else {      
            return ' ';
        }
    }

    public static void main(String[] args) {
        int n = 5;
        
        print(n);
    }
}
