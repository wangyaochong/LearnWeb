package test.interview.今日头条正式;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/4/18】 at 【19:04】.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int firstCount = Integer.parseInt( in.nextLine());
        ArrayList<Integer> firstNum=new ArrayList<Integer>();
        if(firstCount==0) {
            return ;
        }
        while(firstCount>0){
            firstNum.add(Integer.parseInt(in.nextLine()));
            firstCount--;
        }
        int secondCount = Integer.parseInt( in.nextLine());
        ArrayList<Integer> secondNum=new ArrayList<Integer>();
        while(secondCount>0){
            secondNum.add(Integer.parseInt(in.nextLine()));
            secondCount--;
        }
        for(int i=0;i<secondNum.size();i++){
            if (firstNum.contains(secondNum.get(i)) ==true) {
                System.out.print(secondNum.get(i));
                System.out.print(" ");
            }
        }
    }
}
