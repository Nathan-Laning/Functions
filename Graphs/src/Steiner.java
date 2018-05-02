import functions.*;
import java.util.ArrayList;
import java.util.Random;

class Steiner {

   private int size=0,limit = 2;

    void STS(int n) {
        Random R = new Random(System.currentTimeMillis());
        int number_of_triples = n * (n - 1) / 6;
        //generating all possible permutations
        ArrayList<ArrayList<Integer>> Pairs = generate(2,n);
        ArrayList<ArrayList<Integer>> triples = combine(Pairs);
        ArrayList<ArrayList<Integer>> Seed = new ArrayList<>();
        ArrayList<ArrayList<ArrayList<Integer>>> Removed = new ArrayList<>();
        while (Seed.size()!=number_of_triples){
            ArrayList<Integer> next = triples.get(R.nextInt(triples.size()));
//            Removed.get(Seed.size()).add(next);
            if(check(Seed,next)) {
                Seed.add(next);
                output.display(Seed);
            }

        }
    }

    private ArrayList<ArrayList<Integer>> combine(ArrayList<ArrayList<Integer>> pairs) {
        ArrayList<ArrayList<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < pairs.size(); i++) {
            for (int j = i+1; j < pairs.size(); j++) {
                ArrayList<Integer> temp = set.union(pairs.get(i),pairs.get(j));
                if(temp.size()==3){
                    triplets.add(Sorting.basicIntegerSort(temp));
                }
            }
        }
        return set.union(new ArrayList<>(),triplets);
    }

    ArrayList<ArrayList<Integer>> generate(int size, int range) {
        limit = range;
        this.size=size;
        ArrayList<Integer> Item = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Item.add(1);
        }
        return generateAllPossibleCombinations(size);
    }

    ArrayList<ArrayList<Integer>> generateAllPossibleCombinations(int n) {
        ArrayList<ArrayList<Integer>> Master = new ArrayList<>();
//        ArrayList<Integer> sample = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i < limit; i++) {
                ArrayList<Integer> Base = new ArrayList<>();
                Base.add(i + 1);
                Master.add(Base);
            }
            return Master;
        }
        for (int i = 0; i < limit; i++) {
            ArrayList<ArrayList<Integer>> Previous = generateAllPossibleCombinations(n - 1);
            for (ArrayList<Integer> M : Previous) {
                M.add(i + 1);
            }
            Master.addAll(Previous);
        }
        return Master;
    }

    ArrayList<ArrayList<Integer>> removeMultisets(ArrayList<ArrayList<Integer>> ITEMS){
        int i=0;
        for (;;) {
            try {
                if (functions.set.union(ITEMS.get(i), ITEMS.get(i)).size() != size){
                    ITEMS.remove(i);
                    i--;
                }
                i++;
            }catch (IndexOutOfBoundsException E){
                return ITEMS;
            }
        }
    }

    boolean check(ArrayList<ArrayList<Integer>> master, ArrayList<Integer> Component){
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        for (int i = 0;i<Component.size()-1;i++){
            for (int j = i+1;j<Component.size();j++){
                ArrayList<Integer> pair=new ArrayList<>();
                pair.add(Component.get(i));
                pair.add(Component.get(j));
                pairs.add(pair);
            }
        }
        for (ArrayList<Integer> All: master) {
            for (ArrayList<Integer> NEW: pairs) {
                if(set.union(All,NEW).size()==3){
                    return false;
                }
            }
        }

        return true;
    }

}
