package test.interview.WAP;

import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/5/28】 at 【22:03】.
 */
public class 测试控制台输入 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer integer=1;
        while(integer!=0){
            integer=in.nextInt();
            System.out.println(integer);
        }
    }
}
