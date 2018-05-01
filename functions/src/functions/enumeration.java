package functions;

public class enumeration {

    /**
     * Factorial
     * n! i.e. 3! = 1*2*3
     * @param n number
     * @return n!
     */
    public static int factorial(int n) {
        if(is_pos(n)){
            int total = 1;
            for (int i = 1; i <= n; i++) {
                total*= i;
            }
            return total;
        }else{
            System.out.println("Error: Improper Factorial");
            return -1;
        }
    }

    /**
     * Permutation
     * The number of ways to choose a sample of r elements from a set of n distinct objects where order does matter and
     * replacements are not allowed.  When n = r this reduces to n!, a simple factorial of n.
     * n - the set or population
     * r - subset of n or sample set
     * / n \
     * \ r /
     *
     * @param n the set or population
     * @param r subset of n or sample set
     * @return result
     */
    public static int permutation(int n, int r) {
        if(check_input(n,r)) {
            return factorial(n) / factorial(n - r);
        }else{
            return -1;
        }
    }

    /**
     * Permutation With Replacement
     * The number of ways to choose a sample of r elements from a set of n distinct objects where
     * order does matter and replacements are allowed.
     * n - the set or population
     * r - subset of n or sample set
     * / n \
     * \ r /
     *
     * @param n the set or population
     * @param r subset of n or sample set
     * @return result
     */
    public static int permutation_replace(int n, int r) {
        if(check_input(n,r)) {
            int total = 1;
            for (int i = 0; i < r; i++) {
                total = total * n;
            }
            return total;
        }else{
            return -1;
        }
    }

    /**
     * Combination
     * The number of ways to choose a sample of r elements from a set of n
     * distinct objects where order does not matter and replacements are not allowed.
     * n - the set or population
     * r - subset of n or sample set
     * / n \
     * \ r /
     *
     * @param n the set or population
     * @param r subset of n or sample set
     * @return result
     */
    public static int combination(int n, int r) {
        if(check_input(n,r)) {
            return factorial(n) / (factorial(r) * factorial(n - r));
        }else{
            return -1;
        }
    }

    /**
     * Combination With Replacement
     * The number of ways to choose a sample of r elements from a set of n distinct
     * objects where order does not matter and replacements are allowed.
     * n - the set or population
     * r - subset of n or sample set
     * / n \
     * \ r /
     *
     * @param n the set or population
     * @param r subset of n or sample set
     * @return result
     */
    public static int combination_replace(int n, int r) {
        if(check_input(n,r)) {
            return factorial(n + r - 1) / (factorial(r) * factorial(n - 1));
        }else{
            return -1;
        }
    }

    /**
     * validates that input was correct and displays an error if not
     *
     * @param n first
     * @param r second
     * @return success or failure
     */
    private static boolean check_input(int n, int r) {
        Boolean valid = true;
        if (!is_pos(n)) {
            System.out.print(" Object size ");
            System.out.print(n);
            System.out.print(" must be positive ");
            valid = false;
        }
        if(!is_pos(r)){
            System.out.print(" sample size ");
            System.out.print(r);
            System.out.print(" must be positive ");
            valid = false;
        }
        if (n < r) {
            System.out.print("ERROR: sample size ");
            System.out.print(r);
            System.out.print(" must be larger then object size ");
            System.out.print(n);
            valid = false;
        }
        if(!valid) System.out.println("");
        return valid;
    }

    /**
     * is_pos ~ Is Positive
     * validates that a given number is >=0
     * @param number number
     * @return boolean
     */
    private static boolean is_pos(int number){
        if(number < 0){
            System.out.println("ERROR: Positive number required");
            return false;
        }
        return true;
    }

    /**
     * Exponents (powers)
     * i.e. n^p ~ 2^3 = 8
     * @param n base
     * @param p exponent
     * @return result
     */
    public static int power(int base,int exp){
        int result=1;
        for(int i=0;i<exp;i++){
            result*=base;
        }
        return result;
    }
}