package ranking;

import functions.output;

public class DeArrangment {
    public static int totalruns=0;

    public static int Dn(int n){
        if (n<2) return 0;
        if (n == 2) return 1;
        return(n-1)*(Dn(n-1)+Dn(n-2));
    }

    public static Integer[] swap(Integer[] e, int a, int b){
        Integer[] c=new Integer[e.length];
        for (int i = 0; i < e.length; i++) c[i]=(Integer)e[i] ;
        c[a]=e[b];
        c[b]=e[a];
        return c;
    }
    public static Integer[][] merge(Integer[][] a,Integer[][] b ){
        output.display(a);
        output.display(b);
        Integer[][] c = new Integer[a.length][a[0].length];
        int j = 0;
        while(j<a.length&&a[j][0]!=null){
            c[j]=a[j];
            j++;
        }
        for (int i = j; i < a.length ; i++) {
                c[i]=b[i-j];
        }
        return c;
    }
//    /**
//     * Swaps two items in an arrayList
//     * @param A Array in question
//     * @param i first address
//     * @param j second address
//     * @return
//     */
//    public static <E> ArrayList<E> swap(ArrayList<E> A,int i,int j){
//        E tempi = A.get(i);
//        E tempj = A.get(j);
//        A.remove(i);
//        A.add(i,tempj);
//        A.remove(j);
//        A.add(j,tempi);
//
//        return A;
//    }

    public static  Integer[][] next(Integer[][] TOTAL,Integer[] A,int start){
        output.display("",true);
        output.display(A);
        output.display("  A[s] i+1 A[i] s+1",true);
        output.display("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=",true);
        for(int i = start+1;i<A.length;i++){
            output.display(A);
            output.display("  ");
            output.display(A[start]);
            output.display("    ");
            output.display(i+1);
            output.display("    ");
            output.display(A[i]);
            output.display("    ");
            output.display(1+start);
            output.display("    ");
            if(A[start]!=i+1&&A[i]!=start+1) {
                output.display(" True",true);
                Integer[] nextItem = swap(A, start, i);
                int j=0;
                while(TOTAL[j][0]!=null)j++;
                TOTAL[j]=nextItem;
                for (int k = 0; k < nextItem.length; k++)if(nextItem[k]==i)next(TOTAL,nextItem,k+1);

            }else{
                output.display(" False",true);
            }
        }
        return TOTAL;
    }
    public static void generate(int n){
        Integer[] first=new Integer[n];
        for (int i = n; i > 0; i--) {
            first[i-1]=n-i+1;
        }
        Integer[][] TOTAL = new Integer[Dn(n)][n];
        TOTAL[0]=first;
//        TOTAL[1] = next(D,0);
        TOTAL=next(TOTAL,TOTAL[0],0);
        output.display(TOTAL);
//        output.display(TOTAL);
//        for (ArrayList<Integer> i:TOTAL) {
//            output.display(i);
//        }
//        output.display(totalruns);
    }
}
