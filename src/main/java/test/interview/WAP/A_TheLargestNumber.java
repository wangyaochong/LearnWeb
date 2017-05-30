package test.interview.WAP;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/5/29】 at 【13:27】.
 */
public class A_TheLargestNumber {
    public static void add(int x) {
        if(lastQuery==Integer.MAX_VALUE){
            sequence.add(x%mod);
        }else{
            sequence.add((x+lastQuery)%mod);
        }
    }
    public static int query(int x) {

        int i=0;
        int len=sequence.size();
        int max=Integer.MIN_VALUE;
        while(i<x){
            Integer integer = sequence.get(len - 1 - i);
            if(integer>max){
                max=integer;
            }
            i++;
        }
        return max;
    }
    static  ArrayList<Integer> sequence=new ArrayList<Integer>();
    static int mod=0;
    static int lastQuery=Integer.MAX_VALUE;
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        mod = in.nextInt();

        while(m-- > 0){
            String ch = in.next();
            int x = in.nextInt();
            if(ch.equals("I")){
                add(x);
            } else {
                lastQuery=query(x);
                System.out.println(lastQuery);
            }
        }
    }
}
