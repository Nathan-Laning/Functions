package functions;


import java.util.ArrayList;

public class Sorting{
    public static ArrayList<Integer> basicIntegerSort(ArrayList<Integer> list) {
        ArrayList<Integer> sorted = new ArrayList<>();
        sorted.addAll(list);
        boolean finished=false;
        while (!finished) {
            finished = true;
            for (int i = 0; i < sorted.size()-1; i++) {
                if (sorted.get(i) > sorted.get(i + 1)) {
                    sorted.add(i, sorted.remove(i + 1));
                    finished = false;
                }
            }
        }
        return sorted;
    }


}
