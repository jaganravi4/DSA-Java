public class Pattern14 {

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5 * n + 1; j++) {

                System.out.print(func(i, j, n) + " ");
            }

            System.out.print("\n");
        }
    }

    /*
        a . . . . . . . i . . . . . . . q . . . . . . . y . 
        . b . . . . . h . j . . . . . p . r . . . . . x . z 
        . . c . . . g . . . k . . . o . . . s . . . w . . . 
        . . . d . f . . . . . l . n . . . . . t . v . . . . 
        . . . . e . . . . . . . m . . . . . . . u . . . . . 
    */
    public static char func(int i, int j, int n) {
        if (i == j % (2 * n - 2) || i + j % (2 * n - 2) == 2 * n - 2) {
            return (char) ('a' + j);
        }
        return '.';
    }

    public static void main(String[] args) {
        int n = 5;

        print(n);
    }
}
