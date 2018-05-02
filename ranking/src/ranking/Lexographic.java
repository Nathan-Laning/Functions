package ranking;

import functions.*;

import java.util.ArrayList;

/**
 * uses a mask to increase bit-count until all are used for example:
 *   T     c(T)     Rank
 * =====================
 *  {}    [0,0,0]    0
 *  {3}   [0,0,1]    1
 *  {2}   [0,1,0]    2
 * {2,3}  [0,1,1]    3
 *   ...    ...     ...
 * {1,2,3}[1,1,1]    7
 */
public class Lexographic {
    /**
     * Lexographic Ranking
     * given the Integer set e and sample size n return numerical rank
     *
//     * @param e set
     * @param n sample size
     * @return rank
     */
    public static int rank(int[] T,int n) {
        int rank=0;
        for (int i = T.length-1; i >=0 ; i--) {
            rank += T[i]*enumeration.power(n,T.length-i-1);
        }
        return rank;
    }

    /**
     * Lexographic UnRank
     * given a rank, and sample size, determine set
     *
     * @param n Sample Size
     * @param r Rank
     * @return set
     */
    public static ArrayList<Integer> unrank(int n, int r) {
        ArrayList<Integer> T = new ArrayList<>();
        for (int i = n - 1; i > 0; i--) {
            if (r % 2 == 1) {
                T = set.union(convert.toIntegerArray(T), new Integer[]{i});
            }
            r = r / 2;
        }
        return T;
    }

    public static ArrayList<Integer> MultiSetUnRank(int r, int k, int n) {
        ArrayList<Integer> t = new ArrayList<>();
        int x=1;
        for (int i = 1; i < k+1; i++) {
            while (enumeration.combination(k+n-x,n-i-1)<=r){
                r-=enumeration.combination(k+n-x,n-i);
                x++;
            }
            t.add(x);
        }
        return t;
    }


    public static int MultiSetRank(Integer[] t, int k,int n) {
        int r=0;
        Integer[] T=t.clone();
        T[0]=0;
        for (int i = 1; i < k; i++) {
            if(T[i-1]+1<=T[i]) {
                for (int j = T[i-1]; j < T[i]-1; j++) {
                    r+=enumeration.combination(k + n-j, n-i);
                }
            }
        }
        return r;
    }


    public static Integer[] MultiSetSuccessor(Integer[] T, int k, int n) {
        if (T == null) {
            Integer[] temp = new Integer[k];
            for (int i = 0; i < k; i++) {
                temp[i] = 1;
            }
            return temp;
        }
        int i = k;
        boolean run = true;
        while (i > 0 && run) {
            i--;
            if (T[i] < n) {
                T[i]++;
                for (int j = i; j < k; j++) {
                    T[j] = T[i];
                }
                run = false;
            }
        }
        if (run) return null;
        return T;
    }


    public static void Successor(int[] T, int n){
        for (int i = T.length-1; i >=0 ; i--) {
            if(T[i]==n-1){
                T[i]=0;
            }else{
                T[i]++;
                return;
            }

        }

    }

    public static int[] lexSuc(int[] T, int n) {
        for (int i = 0; i <T.length-1; i++) {
            if (T[i+1] - T[i] != 1) {
                T[i + 1] ++;
                return T;
            }
        }
        if (T[0] < n) {
            T[0] += 1;
            int j = 1;
            for (int i = T.length - 1; i > 0; i--) {
                T[i] = j;
                j++;
            }
        } else {
            return null;
        }
        return T;
    }
}
