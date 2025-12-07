public class Pattern15 {

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(func2(i, j, n) + " ");
            }

            System.out.print("\n");
        }
    }

    /*
        4 4 4 4 4 4 4 
        4 3 3 3 3 3 4 
        4 3 2 2 2 3 4 
        4 3 2 1 2 3 4 
        4 3 2 2 2 3 4 
        4 3 3 3 3 3 4 
        4 4 4 4 4 4 4 
    */
    public static int func1(int i, int j, int n) {
        int max = Math.max(Math.abs(i - (n / 2)), Math.abs(j - (n / 2)));
        return 1 + max;
    }

    /*
        4 3 2 1 2 3 4 
        3 3 2 1 2 3 3 
        2 2 2 1 2 2 2 
        1 1 1 1 1 1 1 
        2 2 2 1 2 2 2 
        3 3 2 1 2 3 3 
        4 3 2 1 2 3 4 
    */
    public static int func2(int i, int j, int n) {
        int min = Math.min(Math.abs(i - ( n  / 2)), Math.abs(j - (n / 2)));
        return 1 + min;
    }

    public static void main(String[] args) {
        int n = 7;

        print(n);
    }
}

