public class Pattern1 {
    
    /*
        * * *
        * * *
        * * *
    */
    public static void func(int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }

            System.out.print("\n");
        }   
    }

    public static void main(String[] args) {
        int n = 3;
        func(n);
    }
}