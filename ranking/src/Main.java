import functions.*;
import ranking.*;

import java.util.ArrayList;

public class Main {
        public static <E> void main(String[] args) {
//            output.display(enumeration.factorial(7));
//            TrotterJohnson.main(null);
//            System.out.println(enumeration.factorial(7));
//            Integer[] Start={2,4,6,7,5,3,1};
//            int[] s={2,4,6,7,5,3,1};
//            ArrayList<Integer> start=convert.toArrayList(Start);
//            int totalsum=0;
//            for (int i = 0; i < 7; i++) {
//                totalsum+=enumeration.power(2,i);
//            }
//
//            System.out.print("Lexographic rank of [2,4,6,7,5,3,1]: ");
//            output.display(Lexographic.rank(start,7),true);

            Integer[] LEX = new Integer[]{1,1,1};
            while (LEX!=null){
                LEX=Lexographic.MultiSetSuccessor(LEX,3,3);
                output.display(LEX);
            }

//            output.display(totalsum);
//            System.out.print("Trotter Johnson rank of [2,4,6,7,5,3,1]: ");
////            output.display(TrotterJohnson.rank(Start),true);
////            int temp = TrotterJohnson.rank(Start);
//            System.out.print("Lexographic successor of [2,4,6,7,5,3,1]: ");
//            output.display(Lexographic.lexSuc(s,7),true);
//            System.out.print("Trotter Johnson successor of [2,4,6,7,5,3,1]: ");
////            output.display(TrotterJohnson.unrank(temp++,7),true);

//            System.out.print("\u001B[31m");
//            output.display("");
//            System.out.print("\u001B[0m");
//            ArrayList<Integer> x = new ArrayList<>();


//            output.display(x);
//            output.display(DeArrangment.swap(x,1,2));
//            DeArrangment.generate(4);
//            ArrayList<Integer> x= null;
//            ArrayList<E> e= new ArrayList<>();
//            x.add(3);
<<<<<<< Updated upstream
            boolean run =true;
            output.display(enumeration.combination_replace(2,2));
            int k=3;
            int n=4;
            int[] x = new int[n];
            for (int i = 0; i <n; i++) {
                x[i]=0;
            }
            int i=0;
//            output.display(enumeration.permutation_replace(126-32,4));
//            for(int t =1;t<6;t++){
//                for (int j=1;j<6;j++) {
//                    output.display(t);
//                    output.display(" ");
//                    output.display(j);
//                    output.display(" || ");
//                    output.display(enumeration.combination(t + j - 1, j - 1));
//                    output.display(" ",true);
//                }
//            }
            while(run) {
                output.display(i,2);
                output.display(" | ");
                output.display(Lexographic.rank(x,126-32));
                output.display(" || ");
                output.display(x);
                output.display("",true);


//                int m = Lexographic.MultiSetRank(x,n);
//                output.display(m,2);
                Lexographic.Successor(x,126-32);
//                output.display("||");
////                output.display(m-i);
//                output.display("",true);
                i++;
                if(x==null){
                    run=false;
                }
=======
//            boolean run =true;
//            output.display(enumeration.combination_replace(2,2));
//            int k=3;
//            int n=3;
//            Integer[] x = new Integer[n];
//            for (int i = 0; i <n; i++) {
//                x[i]=1;
//            }
//            int i=0;
////            for(int t =1;t<6;t++){
////                for (int j=1;j<6;j++) {
////                    output.display(t);
////                    output.display(" ");
////                    output.display(j);
////                    output.display(" || ");
////                    output.display(enumeration.combination(t + j - 1, j - 1));
////                    output.display(" ",true);
////                }
////            }
//            while(run) {
//                output.display(i,2);
//                output.display(" | ");
//                output.display(x);
//                output.display(" || ");
//                output.display(Lexographic.MultiSetUnRank(i,n,k));
//                output.display(" || ");
//                int m = Lexographic.MultiSetRank(x,k,n);
//                output.display(m,2);
//                x=Lexographic.MultiSetSuccessor(x,n,k);
//                output.display("||");
//                output.display(m-i);
//                output.display("",true);
//                i++;
//                if(x==null){
//                    run=false;
//                }
>>>>>>> Stashed changes

//            }
        }
}
