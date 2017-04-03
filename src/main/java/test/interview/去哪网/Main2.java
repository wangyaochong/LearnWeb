package test.interview.去哪网;

import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/4/1】 at 【19:23】.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            long result=0;
            long m=1;
            String s = in.nextLine();
            for(int i=s.length()-1;i>=0;i--){
                result=(s.charAt(i)-'a')*m+result;
                m*=26;
            }
            System.out.println(result);
        }
    }
}
