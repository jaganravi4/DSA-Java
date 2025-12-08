public class Pattern7 {

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
            2 1 
          3 2 1 
        4 3 2 1 
    */
    public static void func(int i, int j, int n) {
        if (i + j >= n - 1) {
            System.out.print(n - j);
        } else {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int n = 4;

        print(n);
    }
}
