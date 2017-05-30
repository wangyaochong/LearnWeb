package test.interview.WAP;

import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/5/28】 at 【15:26】.
 */
public class SumM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count=Integer.parseInt(in.nextLine());
        int sum=0;
        while(count>0){
            String[] split = in.nextLine().split(" ");
            for (String s : split) {
                sum+=Integer.parseInt(s);
            }
            count--;
        }
        System.out.println(sum);
    }
}
