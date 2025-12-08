public class Pattern3 {
    
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
        1 2 3 4 5 
        1 2 3 4   
        1 2 3     
        1 2       
        1  
    */
    public static void func(int i, int j, int n) {
        if (i + j <= n - 1) {
            System.out.print(j + 1);
        } else {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int n = 5;

        print(n);
    }
}

