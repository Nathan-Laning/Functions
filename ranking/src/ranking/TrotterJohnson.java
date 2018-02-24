package com.company.Ranking;

import com.company.functions.enumeration;

/**
 * Trotter Johnson Ranking
 * Ideal for minimum change ordering
 */
public class TrotterJohnson {

    /**
     * Trotter Johnson Un-Ranking
     * given the Trotter Johnson rank of the array (r), and the array size (n)
     * derives the array.
     * @param n sample size
     * @param r rank
     * @return set
     */
    public static Integer[] unrank(int n, int r) {
        Integer[] pi = new Integer[n];
        pi[0]=1;
        int r2=0;
        for (int j = 1; j <= n; j++) {
            int r1 = (r * enumeration.factorial(j)) / enumeration.factorial(n);
            int k = r1 - j * r2;
            if (r2 % 2 == 0) {
                for (int i = j - 1; i >= j - k; i--) {
                    pi[i] = pi[i-1];
                }
                pi[j - k - 1] = j;
            } else {
                for (int i = j - 1; i > k; i--) {
                    pi[i] = pi[i-1];
                }
                pi[k] = j;
            }
            r2=r1;
        }
        return pi;
    }

    /**
     * Trotter Johnson Ranking
     * given an array, derive the Trotter Johnson rank of the array
     * @param A set
     * @return rank
     */
    public static <E extends Comparable> int rank(E[] A) {
        int rank = 0;
        for (int j = 1; j <= A.length; j++) {
            int k = 1;
            int i = 0;
            while (A[i].compareTo(j)!=0) {
                if (A[i].compareTo(j) < 0) {
                    k++;
                }
                i++;
            }
            if (rank % 2 == 0) {
                rank = j * rank + j - k;
            } else {
                rank = j * rank + k - 1;
            }
        }
        return rank;
    }
}
