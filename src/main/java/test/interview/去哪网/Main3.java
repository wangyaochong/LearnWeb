package test.interview.去哪网;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/4/1】 at 【19:30】.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source=in.nextLine();
        String target=in.nextLine();
        String ts=in.nextLine();
        String[] split = ts.split(" ");
        List<String> tsArr = Arrays.asList(split);
        cal(source,1,target,tsArr);
        System.out.println(minCount);
    }
    public static int minCount=Integer.MAX_VALUE;
    public static void cal(String current,int currentCount,String target,List<String> options){
        if(current.equals(target)&&minCount>currentCount){
            minCount=currentCount;
        }
        ArrayList<String> op=new ArrayList<String>();
        for(int i=0;i<options.size();i++){
            op.add(options.get(i));
        }
        for(int i=0;i<options.size();i++){
            if(difCount(current,options.get(i))==1){
                op.remove(i);
                cal(options.get(i),currentCount+1,target,op);
                op.add(i,options.get(i));
            }
        }
    }
    public static int difCount(String a,String b){
        int minLength=Math.min(a.length(),b.length());
        int maxLength=Math.max(a.length(),b.length());
        int difCount=0;
        for(int i=0;i<minLength;i++){
            if(a.charAt(i)!=b.charAt(i)){
                difCount++;
            }
        }
        difCount=maxLength-minLength+difCount;
        return difCount;
    }

}
