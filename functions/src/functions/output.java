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
    public static <AnyType> void display(int[] A) {
        for (int i = 0; i < A.length; i++) {
            display(A[i]);
            display(" ");
        }
        display("");
    }

    /**
     * Displays two dimensional arrays
     * @param A         2d Array
     * @param <AnyType> AnyType
     */
    public static <AnyType> void display(AnyType[][] A) {
        for (int j = 0; j < A.length; j++) {
            display("{");
            for (int i = 0; i < A[0].length; i++) {
                display(A[j][i]);
                if(i!=A[0].length-1)display(",");

            }
            display("}",true);
        }
    }

    /**
     * Display AnyType
     * basic shortening of System.out.println();
     *
     * @param e input
     */
    public static <E> void display(E e) {
        if(e==null){
            System.out.print("\u001B[31m");
            System.out.print(e);
            System.out.print("\u001B[0m");
        }else System.out.print(e);
    }
    /**
     * Display AnyType
     * basic shortening of System.out.println();
     * additional function of choosing to end line
     *
     * @param e input
     * @param newLine new line?
     */
    public static <E> void display(E e, boolean newLine) {
        display(e);
        if (newLine) System.out.println("");
    }
    public static void display(boolean B){
        if(B) System.out.print("\u001B[32m");
        else System.out.print("\u001B[31m");
        System.out.print(B);
        System.out.print("\u001B[30m");
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
