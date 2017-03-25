package test;

import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/3/25】 at 【14:37】.
 */
public class TestInputNetEase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
