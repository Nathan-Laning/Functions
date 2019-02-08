package functions;

import java.util.ArrayList;

/**
 * Set Manipulation
 * Meant for list, arrays, and Arraylists
 */
public class set {
    /**
     * Union
     * ~ ∪ ~
     * given two arrays, return an ArrayList
     * i.e. {1,2,3}∪{3,4,5} -> {1,2,3,4,5}
     *
     * @param a
     * @param b
     * @param <E>
     * @return
     */
    public static <E> ArrayList<E> union(E[] a, E[] b) {
        ArrayList<E> c = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            c.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            if (!c.contains(b[i])) {
                c.add(b[i]);
            }
        }
        return c;
    }

    /**
     * Symmetric Difference
     *  ~ △ ~
     * A△B is the set of things that belong to exactly one of A and B.
     * A△B=(A∖B)∪(B∖A)
     * @param a set A
     * @param b set B
     * @param <E> AnyType
     * @return result
     */
    public static <E> ArrayList<E> symmetricDifference(ArrayList<E> a, ArrayList<E> b){
        return union(compliment(a,b),compliment(b,a));
    }
    /**
     * Union
     * given two arraysLists, return an ArrayList
     * ~ ∪ ~
     * i.e. {1,2,3}∪{3,4,5} -> {1,2,3,4,5}
     *
     * @param a
     * @param b
     * @param <E>
     * @return
     */
    public static <E> ArrayList<E> union(ArrayList<E> a, ArrayList<E> b) {
        ArrayList<E> c = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            c.add(a.get(i));
        }
        for (int i = 0; i < b.size(); i++) {
            if (!c.contains(b.get(i))) {
                c.add(b.get(i));
            }
        }
        return c;
    }

    /**
     * Intersect
     * ~ ∩ ~ OR ~ & ~
     * given two arraysLists, return an ArrayList
     * i.e. {1,2,3}∩{3,4,5} -> {3}
     *
     * @param a
     * @param b
     * @param <E>
     * @return
     */
    public static <E> ArrayList<E> intersect(ArrayList<E> a, ArrayList<E> b) {
        ArrayList<E> c = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (b.contains(a.get(i))) {
                c.add(a.get(i));
            }
        }
        return c;
    }

    /**
     * Compliment
     *  ~ \ ~
     * Takes the compliment of A given b
     * i.e. {1,2}\{1,2} = {}
     * {1,2,3,4}\{1,3} = {2,4}
     *
     * @param a
     * @param b
     * @param <E>
     * @return
     */
    public static <E> ArrayList<E> compliment(ArrayList<E> a, ArrayList<E> b) {
        ArrayList<E> c = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (!b.contains(a.get(i))) {
                c.add(a.get(i));
            }
        }
        return c;
    }

    /**
     * new Set
     * Simple converter from integer array to arrayList, but without as much import
     * @param e array
     * @param <E> AnyType
     * @return ArrayList (set)
     */
    public static <E> ArrayList<E> newSet(E[] e){
        ArrayList<E> out = new ArrayList<>();
        for (int i = 0; i < e.length; i++) {
            out.add(e[i]);
        }
        return out;

    }
}
