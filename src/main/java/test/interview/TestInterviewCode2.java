package test.interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/3/25】 at 【14:46】.
 */
public class TestInterviewCode2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        ArrayList<String> input=new ArrayList<String>();
        String input = in.nextLine();
        int result=Integer.parseInt(""+input.charAt(0));
        for(int i=2;i<input.length();i+=2){
            result=getResult(
                    result,
                    Integer.parseInt(""+input.charAt(i))
                    ,""+input.charAt(i-1));
        }
        System.out.println(result);
    }
    public static  Integer getResult(int a,int b,String op){
        if(op.equals("+")){
            return Integer.valueOf(a+b);
        }
        if(op.equals("-")){
            return Integer.valueOf(a-b);
        }

        if(op.equals("*")){
            return Integer.valueOf(a*b);
        }
        return 0;
    }
}
