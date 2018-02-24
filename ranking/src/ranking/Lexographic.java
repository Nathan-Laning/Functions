package com.company.Ranking;
import com.company.functions.*;
import java.util.ArrayList;

/**
 * uses a mask to increase bitcount until all are used for example:
 *   T       c(T)    Rank
 * =====================
 *  {}     [0,0,0]      0
 *  {3}    [0,0,1]      1
 *  {2}    [0,1,0]      2
 * {2,3}   [0,1,1]      3
 *  ...      ...       ...
 *{1,2,3}  [1,1,1]      7
 */
public class Lexographic {
    /**
     * Lexographic Ranking
     * given the Integer set e and sample size n return numerical rank
     * @param e set
     * @param n sample size
     * @return rank
     */
    public static int rank(ArrayList<Integer> e,int n){
        int r = 0;
        for(int i =0 ; i<n;i++){
            if(e.contains(i)){
                r=r+enumeration.power(2,n-i);
            }
        }
        return r;
    }

    /**
     * Lexographic UnRank
     * given a rank, and sample size, determine set
     * @param n Sample Size
     * @param r Rank
     * @return set
     */
    public static ArrayList<Integer> unrank(int n, int r){
        ArrayList<Integer> T = new ArrayList<>();
        for(int i=n-1;i>0;i--){
            if(r%2==1){
                T=set.union(convert.toIntegerArray(T), new Integer[] {i});
            }
            r=r/2;
        }
        return T;
    }
}
