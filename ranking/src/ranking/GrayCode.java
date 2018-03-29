package ranking;
import java.util.ArrayList;
import functions.*;
/**
 * Gray Code
 * Gray Code is used to iterate and rank over a list whilst
 * changing at most one bit at a given time
 * for sample size n = 3, It would look something like this:
 * r        bin(r)        G        Set
 * =====================================
 * 0         000         000        {}
 * 1         001         001        {3}
 * 2         010         011       {2,3}
 * 3         011         010        {2}
 * 4         100         110       {1,2}
 * 5         101         111      {1,2,3}
 * 6         110         101       {1,3}
 * 7         111         100        {1}
 */
public class GrayCode {
    /**
     * Successor
     * Creates the next item in a Gray Code for example:
     * {2,3} -> {2}
     *
     * @param n
     * @param T
     * @return
     */
    public static ArrayList<Integer> successor(int n, ArrayList<Integer> T) {
        ArrayList<Integer> U=new ArrayList<>();
        if(T == null){
            U.add(n);
            return U;
        }
        if (T.size() % 2 == 0) {
            U = set.symmetricDifference(T, convert.toArrayList(new Integer[]{n}));
        } else {
            int j = n;
            while (!T.contains(j) && j > 0) {
                j = j - 1;
            }
            if (j == 1) {
                System.out.println("Error: Undefined");
                return null;
            }
            U = set.symmetricDifference(T, convert.toArrayList(new Integer[]{j - 1}));

        }
        return U;
    }
}
