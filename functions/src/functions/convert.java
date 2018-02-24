package functions;

import java.util.ArrayList;

/**
 * conversions of datatypes
 * i.e. arrayList -> []
 */
public class convert {
    /**
     * Converts E[] to ArrayList<E>
     *
     * @param e
     * @param <E>
     * @return
     */
    public static <E> ArrayList<E> toArrayList(E[] e) {
        ArrayList<E> a = new ArrayList<>();
        for (int i = 0; i < e.length; i++) {
            a.add(e[i]);
        }
        return a;
    }

    /**
     * given and Arraylist[] convert to Integer
     * This is essential for using generics
     * i.e. Integer within AnyType
     *
     * @param A Integer ArrayList
     * @ Integer array
     */
    public static Integer[] toIntegerArray(ArrayList<Integer> A) {
        Integer[] e = new Integer[A.size()];
        for (int i = 0; i < A.size(); i++) {
            e[i] = A.get(i);
        }
        return e;
    }

    /**
     * Binary
     * converts proper boolean array to a binary integer array
     * i.e. {true,false,true} ->  {1,0,1}
     * anything in the array that
     *
     * @param in Boolean Binary array
     * @return Integer Binary array
     */
    public static Integer[] binary(Boolean[] in) {
        Integer[] out = new Integer[in.length];
        for (int i = 0; i < in.length; i++) {
            if (in[i]) {
                out[i] = 1;
            } else {
                out[i] = 0;
            }
        }
        return out;
    }

    /**
     * Binary
     * converts binary integer array to a proper boolean array
     * i.e. {1,0,1} -> {true,false,true}
     * anything in the array that
     *
     * @param in Integer Binary array
     * @return Boolean Binary array
     */
    public static Boolean[] binary(Integer[] in) {
        Boolean[] out = new Boolean[in.length];
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                out[i] = false;
            }
            if (in[i] == 1) {
                out[i] = true;
            } else {
                System.out.println("Error: non-binary value given, defautling to false");
                out[i] = false;
            }
        }
        return out;
    }

    /**
     * given and int[] convert to Integer
     * This is essential for using generics
     * i.e. Integer within AnyType
     *
     * @param A int array
     * @return
     */
    public static Integer[] toIntegerArray(int[] A) {
        Integer[] e = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            e[i] = A[i];
        }
        return e;
    }

}
