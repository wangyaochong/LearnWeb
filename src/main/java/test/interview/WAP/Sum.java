package test.interview.WAP;

import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/5/28】 at 【15:22】.
 */
public class Sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int sum=Integer.parseInt(split[0])+Integer.parseInt(split[1]);
        System.out.println(sum);
    }
}
