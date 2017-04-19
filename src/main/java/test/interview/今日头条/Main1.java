package test.interview.今日头条;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder strInput=new StringBuilder(in.nextLine());
        int opCount=Integer.parseInt(in.nextLine());
        ArrayList<String> opStrs=new ArrayList<String>();
        while(opCount>0){
            opStrs.add(in.nextLine());
            opCount--;
        }
        for(int i=0;i<opStrs.size();i++){
            int beginLoc=Integer.parseInt( opStrs.get(i).split(" ")[0]);
            int length=Integer.parseInt( opStrs.get(i).split(" ")[1]);
            String subStr=strInput.substring(beginLoc,beginLoc+length);
            StringBuilder sb=new StringBuilder(subStr);
            StringBuilder reverse = sb.reverse();
            strInput.insert(beginLoc+length,reverse);
        }
        System.out.println(strInput);
    }
}
