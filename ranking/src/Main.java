import functions.*;
import ranking.*;

import java.util.ArrayList;

public class Main {
        public static void main(String[] args) {
//            ArrayList<Integer> x = new ArrayList<>();
//            for (int i = 0; i <4; i++) {
//                x.add(i);
//            }
//            output.display(x);
//            output.display(DeArrangment.swap(x,1,2));
//            DeArrangment.generate(4);
            Integer[] x=null;
            boolean run = true;
            int i=0;
            while(run) {

                try {
                    output.display(i);
                    output.display(" | ");
                    x=Lexographic.MultiSetSuccessor(x, 5, 3);
                    output.display(x);
                    output.display(" | ");
                    output.display(Lexographic.MultiSetRank(x,3));
                    output.display("",true);
                }catch(NullPointerException n){
                    run=false;
                }
                i++;
            }

//            int size=4;
//            int limit = 4;
//            ArrayList<Integer> x = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                x.add(1);
//            }
////            String ANSI_RESET = "\u001B[0m";
////            String ANSI_RED = "\u001B[31m";
////            System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
//            boolean run =true;
//            int i=1;
//            while (run) {
//                try {
////                    System.out.print(i);
////                    System.out.print(" | ");
//                    x=Lexographic.MultiSetSuccessor(x,limit);
//                    output.display(x);
////                    System.out.print(" | ");
////                    int rank = Lexographic.MultiSetRank(x);
////                    output.display(rank);
////                    System.out.print(" | ");
////                    ArrayList<Integer> y=Lexographic.MultiSetUnRank(rank,size);
////                    output.display(y);
////                    System.out.print(" | ");
////                    System.out.print(rank==i&&y.equals(x));
////                    System.out.println("");
//                }catch (NullPointerException e){
//                    run=false;
//                }
//                i++;
//            }
        }
}
