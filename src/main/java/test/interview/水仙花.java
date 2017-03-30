package test.interview;

import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/3/31】 at 【0:09】.
 */
public class 水仙花 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            String[] split = s.split(" ");
            boolean no=true;
            for(int i=Integer.parseInt(split[0]);i<=Integer.parseInt(split[1]);i++){
                if(isShuiXianHua(i)){
                    System.out.print(i+" ");
                    no=false;
                }
            }
            if(no){
                System.out.println("no");
            }
        }
    }
    public static boolean isShuiXianHua(int input){
        int i3=input/100;
        int i2=(input/10)%10;
        int i1=input%10;
        if(i3*i3*i3+i2*i2*i2+i1*i1*i1==input){
            return true;
        }
        return false;
    }
}
