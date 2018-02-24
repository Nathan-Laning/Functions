package ranking;
import functions.*;
import java.util.ArrayList;

/**
 * uses a mask to increase bitcount until all are used for example:
 *   T       c(T)    Rank
 * =====================
 *  {}     [0,0,0]      0
 *  {3}    [0,0,1]      1
 *  {2}    [0,1,0]      2
 * {2,3}   [0,1,1]      3
 *  ...      ...       ...
 *{1,2,3}  [1,1,1]      7
 */
public class Lexographic {
    /**
     * Lexographic Ranking
     * given the Integer set e and sample size n return numerical rank
     * @param e set
     * @param n sample size
     * @return rank
     */
    public static int rank(ArrayList<Integer> e,int n){
        int r = 0;
        for(int i =0 ; i<n;i++){
            if(e.contains(i)){
                r=r+enumeration.power(2,n-i);
            }
        }
        return r;
    }

    /**
     * Lexographic UnRank
     * given a rank, and sample size, determine set
     * @param n Sample Size
     * @param r Rank
     * @return set
     */
    public static ArrayList<Integer> unrank(int n, int r){
        ArrayList<Integer> T = new ArrayList<>();
        for(int i=n-1;i>0;i--){
            if(r%2==1){
                T=set.union(convert.toIntegerArray(T), new Integer[] {i});
            }
            r=r/2;
        }
        return T;
    }
    public static ArrayList<Integer> MultiSetUnRank(int rank, int n) {
        ArrayList<Integer> A = new ArrayList<>();
        if (n == 1) {
            A.add(rank - 1);
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
            X = MultiSetRank(A);
            if (X < rank) {
                A.add(A.remove(A.size() - 1) + 1);
            } else {
                A.add(A.remove(A.size() - 1) - 1);
                run = false;
                output.display(A);
            }

        }
        rank -= R;

        Integer right = A.remove(A.size() - 1);
        ArrayList<Integer> left;
        left = MultiSetUnRank(rank, n - 1);
        left.add(right);
        return left;
    }


    public static int MultiSetRank(ArrayList<Integer> A) {
        int rank = 0;//rank
        if (A.size() == 0) {
            return 0;
        }
        if (A.size() == 1) {
            return A.get(0) - 1;
        } else if (A.get(A.size() - 1) == 1) {
            return 0;
        } else {
            rank++;
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            for (int i = 0; i < A.size() - 1; i++) {
                left.add(A.get(i));
                right.add(A.get(A.size() - 1) - 1);
            }
            right.add(A.get(A.size() - 1) - 1);
            rank += MultiSetRank(left);
            rank += MultiSetRank(right);
        }

        return rank;
    }

    public static ArrayList<Integer> MultiSetSuccessor(ArrayList<Integer> T, int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        int size = T.size();
        if (T.get(0) == n) {
            return null;
        }
        for (int i = 0; i < size - 1; i++) {
            temp.add(T.remove(0));
            if (!temp.get(temp.size() - 1).equals(T.get(0))) {
                temp = MultiSetSuccessor(temp, n);
                temp.addAll(T);
                return temp;
            }
        }
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            x.add(1);
        }
        x.add(T.get(0) + 1);

        return x;
    }

//    public static int[] MultiSetSuccesor(int[] T, int n){
//        for (int i = 0; i <T.length-1 ; i++) {
//
//        }
//        if(T[0]!=n){
//            T[T.length-1]+=1;
//            for(int i =0;i<T.length-1;i++){
//                T[i]=1;
//            }
//        }else{
//            return null;
//        }
//        return T;
//    }

    public static int[] lexSuc(int[] T, int n) {
        for (int i = 0; i < T.length - 1; i++) {
            if (T[i] - T[i + 1] != 1) {
                T[i + 1] += 1;
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
