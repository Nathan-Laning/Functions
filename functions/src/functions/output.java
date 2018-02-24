package functions;

import java.util.ArrayList;

public class output {
    /**
     * displays Arrays
     *
     * @param A
     * @param <AnyType>
     */
    public static <AnyType> void display(AnyType[] A) {
        for (int i = 0; i < A.length; i++) {
            display(A[i]);
            display(" ");
        }
        display("");
    }

    /**
     * Displays two dimensional arrays
     *
     * @param A         2d Array
     * @param <AnyType> AnyType
     */
    public static <AnyType> void display(AnyType[][] A) {
        for (int j = 0; j < A.length; j++) {
            for (int i = 0; i < A[0].length; i++) {
                display(A[j][i]);
            }
            display("");
        }
    }

    /**
     * displays ArrayList
     *
     * @param A         Array
     * @param <AnyType> AnyType
     */
    public static <AnyType> void display(ArrayList<AnyType> A) {
        for (int i = 0; i < A.size(); i++) {
            try {
                display(A.get(i));
                display(" ");
            } catch (NullPointerException n) {
                display("null");
            }
        }
        display("", true);
    }

    /**
     * Display AnyType
     * basic shortening of System.out.println();
     *
     * @param e input
     */
    public static <E> void display(E e) {
        System.out.print(e);
    }
    /**
     * Display AnyType
     * basic shortening of System.out.println();
     * additional function of choosing to end line
     *
     * @param e input
     * @param b new line?
     */
    public static <E> void display(E e, boolean b) {
        display(e);
        if (b) {
            System.out.println("");
        }
    }

    public static <E> void display(E e, int distance){
        int size = e.toString().length();
        int dif=distance-size;
        for(int i =0; i<dif/2;i++) {
            display(" ");
        }
        display(e);
        if(dif%2!=0){
            display(" ");
        }
        for(int i =0; i<dif/2;i++){
            display(" ");
        }
    }

    public static <E> void generateGraph(ArrayList<E> titles, ArrayList<ArrayList<E>> Data){
        int maxSize = 0;
        for (int i = 0; i < titles.size() ; i++) {
            maxSize=titles.get(i).toString().length();
            for (E e : Data.get(i)) {
                maxSize = e.toString().length();
            }
        }
        //Display Titles
        for(E e: titles){
            display(e);
        }
        //Generate Title Bar
        //Display Data
    }
}
