public class Pattern5 {
    
    public static void print(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {

                func(i, j, n);
                System.out.print(" ");
            }

            System.out.println();
        }
    }
    
    /*
        1             1 
        1 2         2 1 
        1 2 3     3 2 1 
        1 2 3 4 4 3 2 1 
    */
    public static void func(int i, int j, int n) {
        if (i >= j) {
            System.out.print(j + 1);
        } else if (i + j >= 2 * n - 1) {
            System.out.print(2 * n - j);   
        }
        else {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int n = 4;

        print(n);
    }
}

