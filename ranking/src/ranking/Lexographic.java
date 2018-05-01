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

    public static ArrayList<Integer> MultiSetUnRank(int rank, int n) {
        ArrayList<Integer> A = new ArrayList<>();
        if (n == 1) {
            A.add(rank + 1);
            return A;
        }
        for (int i = 0; i < n; i++) {
            A.add(1);
        }
        int R = 0;
        int X = 0;
        boolean run = true;
        while (run) {
            R = X;
//            X = MultiSetRank(A);
            if (X <= rank) {
                A.add(A.remove(A.size() - 1) + 1);
            } else {
                A.add(A.remove(A.size() - 1) - 1);
                run = false;
            }
        }
        rank -= R;

        Integer right = A.remove(A.size() - 1);
        ArrayList<Integer> left;
        left = MultiSetUnRank(rank, n - 1);
        left.add(right);
//        System.out.print(rank);
//        System.out.print(" : ");
//        output.display(left);
        return left;
    }


    public static int MultiSetRank(Integer[] T, int n) {
        int rank = 0;
        int size=T.length;
//        int i = 0;
//        int v=2;
        boolean run = true;
        Integer[] N = T.clone();
//        for (int j = 0; j < N.length; j++) {
//            if(N[j]==1) N[j]--;
//        }
//        int j=0;
//        while (j < N.length) {
//            output.display(N);
//            if(N[j]>0){
//                int k = size;
//                rank+=enumeration.combination(k + v-1, v-1);
//
//                for (int i = j; i < N.length; i++) {
//                     N[j]-=v;
//                }
//            }else j++;
//            size--;
//        }

//        Integer[] N = {0,0,0};

        int j=T.length-1;
        for (int i = 1; i <T.length+1 ; i++) {
            if(N[j]>1) {
                for (int l = 0; l < N[j]-1; l++) {
                    int k = 2;
                    int v = i;
                    rank += enumeration.combination(k + v-1, v-1);
                }
            }
            j--;
        }
//        for (int i = 0; i < T.length; i++) {
//                N[T[i] - 1]++;
//            }
//        for (int i = 0; i < T.length; i++) {
//            int next = T[i];
//            while (next > 0) {
//                N[next - 1]++;
//                next--;
//            }
//        }

//        output.display(N);
//        output.display(" | ");
//        output.display(M);
//        output.display(" || ");
//        if(M[n-1]>1) {
//            N[1] -- ;
//        }
//        output.display(N);
//        output.display(" || ");
//        for (int i = 1; i < n; i++) {
//            if (N[i] > 0) {
//                int k = N[i];
//                int v = i + 1;
//                rank += enumeration.combination(k + v -1, v - 1);
////                rank -= enumeration.combination(1,k);
//            }
//        }
        return rank;
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
