import functions.*;
import ranking.*;

import java.util.ArrayList;

public class Main {
        public static <E> void main(String[] args) {
//            ArrayList<Integer> x = new ArrayList<>();

            Integer[] x = new Integer[4];
            for (int i = 0; i <4; i++) {
                x[i]=1;
            }
//            output.display(x);
//            output.display(DeArrangment.swap(x,1,2));
//            DeArrangment.generate(4);
//            ArrayList<Integer> x= null;
            ArrayList<E> e= new ArrayList<>();
//            x.add(3);
            boolean run =false;
            int i=0;
            int k=4;
            int n=4;
            for(int t =1;t<5;t++){
                for (int j = 1; j < 5; j++) {
                    output.display(enumeration.combination(t+j-1,j-1));
                }
            }
            while(run) {
                output.display(i);
                output.display(" | ");
                output.display(x);
                x=Lexographic.MultiSetSuccessor(x,k,n);
//                    if(x.size()!=2) {
//                    output.display(" | ");
//                    output.display(enumeration.combination(k+n-1,n-1));
                output.display("",true);
//                    }
//                    output.display(" | ");
//                    output.display(Lexographic.MultiSetRank(x,3));
                i++;
                if(x==null){
                    run=false;
                }

            }

            output.display(e);

        }
}
