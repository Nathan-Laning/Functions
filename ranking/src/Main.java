import functions.*;
import ranking.*;

import java.util.ArrayList;

public class Main {
        public static <E> void main(String[] args) {
//            ArrayList<Integer> x = new ArrayList<>();


//            output.display(x);
//            output.display(DeArrangment.swap(x,1,2));
//            DeArrangment.generate(4);
//            ArrayList<Integer> x= null;
            ArrayList<E> e= new ArrayList<>();
//            x.add(3);
            boolean run =true;

            int k=4;
            int n=4;
            Integer[] x = new Integer[n];
            for (int i = 0; i <n; i++) {
                x[i]=1;
            }
            int i=0;
            for(int t =1;t<6;t++){
                for (int j=1;j<6;j++) {
                    output.display(t);
                    output.display(" ");
                    output.display(j);
                    output.display(" || ");
                    output.display(enumeration.combination(t + j - 1, j - 1));
                    output.display(" ",true);
                }
            }
            while(run) {
                output.display(i,2);
                output.display(" | ");
                output.display(x);
                output.display(" || ");
                int m = Lexographic.MultiSetRank(x,n);
                output.display(m,2);
                x=Lexographic.MultiSetSuccessor(x,n,k);
                output.display("||");
                output.display(m==i);
                output.display("",true);
                i++;
                if(x==null){
                    run=false;
                }

            }
        }
}
