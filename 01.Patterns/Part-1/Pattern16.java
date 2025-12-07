public class Pattern16 {

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(func(i, j, n) + " ");
            }

            System.out.print("\n");
        }
    }

    /*
        7 6 5 4 5 6 7 
        6 5 4 3 4 5 6 
        5 4 3 2 3 4 5 
        4 3 2 1 2 3 4 
        5 4 3 2 3 4 5 
        6 5 4 3 4 5 6 
        7 6 5 4 5 6 7
    */
    public static int func(int i, int j, int n) {
        int abs = Math.abs(i - (n / 2)) + Math.abs(j - (n / 2));
        return 1 + abs;
    }

    public static void main(String[] args) {
        int n = 7;
        
        print(n);
    }
    
}
