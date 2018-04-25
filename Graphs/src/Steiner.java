import functions.*;

import java.util.ArrayList;

class Steiner {

    int limit=2;

    void STS(int n){
        limit=n;
        int number_of_triples= n*(n-1)/6;
        //P is an n element set
        ArrayList<Integer> P = new ArrayList<>();
        for (Integer i = 1; i < n+1; i++) {
            P.add(i);
        }
        //B is the collection of n*(n-1)/6 3 element subsets of P called triples
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        //first generate all triples?

        //then for each triple branch out
        //then keep adding triples until its fully functional?
        for (Integer I =0;I<number_of_triples;I++) {
            ArrayList<Integer> set = new ArrayList<>();
            set.add(P.get(I));
            set.add(addOne(P.get(I)));
            set.add(addOne(addOne(P.get(I))));
            B.add(set);
        }
        output.display(B);


    }

    ArrayList<ArrayList<Integer>> generateAllPossibleCombinations(int size,int range){
        limit=range;
        boolean contains;
        ArrayList<ArrayList<Integer>> Master = new ArrayList<>();
        Integer[] Item = new Integer[size];
        for (int i = 0; i < size; i++) {
            Item[i]=i+1;
        }
        Master.add(convert.toArrayList(Item));
        //for the size of the array
        for (int i = 0; i < size; i++) {
            // for all possible values it isn't already
            for (int j = 0; j < range-1; j++) {
                Item[i]=addOne(Item[i]);

            }
        }

        return Master;
    }


    Integer addOne(int num){
        if(num+1>limit) return 1;
        return num+1;
    }

    Integer subOne(int num){
        if(num-1<1) return limit;
        else return num-1;
    }



    boolean contains(int[] I, int index, int value){
        for (int i = 0; i < I.length; i++) {
            if(I[i]==value&&index!=i)return true;
        }
        return false;
    }
}
