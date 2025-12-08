public class Pattern2 {
    
    public static void print(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                func(i, j, n);
                System.out.print(" ");
            }

            System.out.println();
        }
    }
    
    /*
        1 
        2 2 
        3 3 3 
        4 4 4 4 
        5 5 5 5 5 
    */
    public static void func(int i, int j, int n) {
        if (i >= j) {
            System.out.print(i + 1);
        } else {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int n = 5;

        print(n);
    }
}

