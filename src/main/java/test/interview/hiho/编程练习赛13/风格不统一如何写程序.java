package test.interview.hiho.编程练习赛13;

import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/4/19】 at 【19:44】.
 */
public class 风格不统一如何写程序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer count = Integer.parseInt( in.nextLine().trim());
        while(count>0){
            String input=in.nextLine().trim();
            int current=0;
            while(current<input.length()){
                if(input.charAt(current)=='_'){//如果是下划线
                    current++;
                    System.out.print(Character.toUpperCase(input.charAt(current)));
                }
                else if(Character.isUpperCase( input.charAt(current))){
                    System.out.print("_");
                    System.out.print(Character.toLowerCase(input.charAt(current)));
                }else{
                    System.out.print(input.charAt(current));
                }
                current++;
            }
            System.out.println();
            count--;
        }
    }
}
