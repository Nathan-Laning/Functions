package ranking;// Java program to print all
// permutations using Johnson
// and Trotter algorithm.
import java.util.*;
import java.lang.*;

public class TrotterJohnson{
    static int rank=1;
    private final static boolean LEFT_TO_RIGHT = true;
    private final static boolean RIGHT_TO_LEFT = false;

    // Utility functions for
    // finding the position
    // of largest mobile
    // integer in a[].
    public static int searchArr(int a[], int n,
                                int mobile)
    {
        for (int i = 0; i < n; i++)

            if (a[i] == mobile)
                return i + 1;

        return 0;
    }

    // To carry out step 1
    // of the algorithm i.e.
    // to find the largest
    // mobile integer.
    public static int getMobile(int a[],
                                boolean dir[], int n)
    {
        int mobile_prev = 0, mobile = 0;

        for (int i = 0; i < n; i++)
        {
            // direction 0 represents
            // RIGHT TO LEFT.
            if (dir[a[i] - 1] == RIGHT_TO_LEFT &&
                    i != 0)
            {
                if (a[i] > a[i - 1] &&
                        a[i] > mobile_prev)
                {
                    mobile = a[i];
                    mobile_prev = mobile;
                }
            }

            // direction 1 represents
            // LEFT TO RIGHT.
            if ((dir[a[i] - 1] == LEFT_TO_RIGHT) && (i !=n - 1)){
                if (a[i] > a[i + 1] &&
                        a[i] > mobile_prev)
                {
                    mobile = a[i];
                    mobile_prev = mobile;
                }
            }
        }

        if (mobile == 0 && mobile_prev == 0)
            return 0;
        else
            return mobile;
    }

    // Prints a single
    // permutation
    public static int printOnePerm(int a[], boolean dir[],
                                   int n)
    {
        int mobile = getMobile(a, dir, n);
        int pos = searchArr(a, n, mobile);

        // swapping the elements
        // according to the
        // direction i.e. dir[].
        if (dir[a[pos - 1] - 1] == RIGHT_TO_LEFT)
        {
            int temp = a[pos - 1];
            a[pos - 1] = a[pos - 2];
            a[pos - 2] = temp;
        }
        else if (dir[a[pos - 1] - 1] == LEFT_TO_RIGHT)
        {
            int temp = a[pos];
            a[pos] = a[pos - 1];
            a[pos - 1] = temp;
        }

        // changing the directions
        // for elements greater
        // than largest mobile integer.
        for (int i = 0; i < n; i++)
        {
            if (a[i] > mobile)
            {
                if (dir[a[i] - 1] == LEFT_TO_RIGHT)
                    dir[a[i] - 1] = RIGHT_TO_LEFT;

                else if (dir[a[i] - 1] == RIGHT_TO_LEFT)
                    dir[a[i] - 1] = LEFT_TO_RIGHT;
            }
        }
        System.out.print(rank);
        rank++;
        System.out.print(" | ");
        for (int i = 0; i < n; i++)
            System.out.print(a[i]);

        System.out.println(" ");

        return 0;
    }

    // To end the algorithm
    // for efficiency it ends
    // at the factorial of n
    // because number of
    // permutations possible
    // is just n!.
    public static int fact(int n)
    {
        int res = 1;

        for (int i = 1; i <= n; i++)
            res = res * i;
        return res;
    }

    // This function mainly
    // calls printOnePerm()
    // one by one to print
    // all permutations.
    public static void printPermutation(int n)
    {
        // To store current
        // permutation
        int[] a = new int[n];

        // To store current
        // directions
        boolean[] dir = new boolean[n];

        // storing the elements
        // from 1 to n and
        // printing first permutation.
        for (int i = 0; i < n; i++)
        {
            a[i] = i + 1;
            System.out.print(a[i]);
        }

        System.out.print("\n");

        // initially all directions
        // are set to RIGHT TO
        // LEFT i.e. 0.
        for (int i = 0; i < n; i++)
            dir[i] = RIGHT_TO_LEFT;

        // for generating permutations
        // in the order.
        for (int i = 1; i < fact(n); i++)
            printOnePerm(a, dir, n);
    }

    // Driver function
    public static void main(String argc[])
    {
        int n = 4;
        printPermutation(n);
    }

}//package ranking;
//
//import functions.enumeration;
//
///**
// * Trotter Johnson Ranking
// * Ideal for minimum change ordering
// */
//public class TrotterJohnson {
//
//    /**
//     * Trotter Johnson Un-Ranking
//     * given the Trotter Johnson rank of the array (r), and the array size (n)
//     * derives the array.
//     * @param n sample size
//     * @param r rank
//     * @return set
//     */
//    public static Integer[] unrank(int n, int r) {
//        Integer[] pi = new Integer[n];
//        pi[0]=1;
//        int r2=0;
//        for (int j = 1; j <= n; j++) {
//            int r1 = (r * enumeration.factorial(j)) / enumeration.factorial(n);
//            int k = r1 - j * r2;
//            if (r2 % 2 == 0) {
//                for (int i = j - 1; i >= j - k; i--) {
//                    pi[i] = pi[i-1];
//                }
//                pi[j - k - 1] = j;
//            } else {
//                for (int i = j - 1; i > k; i--) {
//                    pi[i] = pi[i-1];
//                }
//                pi[k] = j;
//            }
//            r2=r1;
//        }
//        return pi;
//    }
//
//    /**
//     * Trotter Johnson Ranking
//     * given an array, derive the Trotter Johnson rank of the array
//     * @param A set
//     * @return rank
//     */
//    public static <E extends Comparable> int rank(E[] A) {
//        int rank = 0;
//        for (int j = 1; j <= A.length; j++) {
//            int k = 1;
//            int i = 0;
//            while (A[i].compareTo(j)!=0) {
//                if (A[i].compareTo(j) < 0) {
//                    k++;
//                }
//                i++;
//            }
//            if (rank % 2 == 0) {
//                rank = j * rank + j - k;
//            } else {
//                rank = j * rank + k - 1;
//            }
//        }
//        return rank;
//    }
//}
