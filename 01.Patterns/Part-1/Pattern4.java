public class Pattern4 {

    
    public static void print(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(func6(i, j) + " ");
            }

            System.out.print("\n");
        }
    }
    
    /*
        * . . . . .
        . * . . . .
        . . * . . .
        . . . * . .
        . . . . * . 
        . . . . . *
    */
    public static char func1(int i, int j) {
        // i = j + c, here c is 0.
        if (i == j) {
            return '*';
        }
        return '.';
    }

    /*
        . * . . . . 
        . . * . . . 
        . . . * . . 
        . . . . * . 
        . . . . . * 
        . . . . . . 
    */
    public static char func2(int i, int j) {
        if (i == j - 1) {
            return '*';
        }
        return '.';
    }

    /*
        . . . . . . 
        * . . . . . 
        . * . . . . 
        . . * . . . 
        . . . * . . 
        . . . . * .
    */
    public static char func3(int i, int j) {
        if (i == j + 1) {
            return '*';
        }
        return '.';
    }

    /*
        * * * * * * 
        . * * * * * 
        . . * * * * 
        . . . * * * 
        . . . . * * 
        . . . . . *
    */
    public static char func4(int i, int j) {
        if (i <= j) {
            return '*';
        }
        return '.';
    }

    /*
        * . . . . . 
        * * . . . . 
        * * * . . . 
        * * * * . . 
        * * * * * . 
        * * * * * * 
    */
    public static char func5(int i, int j) {
        if (i >= j) {
            return '*';
        }
        return '.';
    }
    
    /*
        X . . . . . 
        * X . . . . 
        * * X . . . 
        * * * X . . 
        * * * * X . 
        * * * * * X 
    */
    public static char func6(int i, int j) {
        if (i == j) {
            return 'X';
        }
        if (i > j) {
            return '*';
        }
        return '.'; 
    }

    public static void main(String[] args) {
        int n = 6;

        print(n);
    }
}
