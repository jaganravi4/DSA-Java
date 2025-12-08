public class Pattern6 {

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
        0 1       
        1 0 1     
        0 1 0 1   
        1 0 1 0 1 
    */
    public static void func(int i, int j, int n) {
        if (i >= j) {
            System.out.print((i + j + 1) % 2);
        } else {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int n = 5;

        print(n);
    }
}
