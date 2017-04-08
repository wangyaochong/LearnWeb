package test.interview.网易;

import java.util.*;

/**
 * Created by【王耀冲】on 【2017/3/25】 at 【15:08】.
 */
public class TestInterviewCode3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String count = in.nextLine();
        String values=in.nextLine();
        String[] split = values.split(" ");//找出所有数字
        ArrayList<Integer> reverseResult=new ArrayList<Integer>();
        for(int i=split.length-1;i>=0;i--){
            if(reverseResult.contains(Integer.parseInt(split[i]))==false){//如果没有访问过该数字
                reverseResult.add(Integer.parseInt(split[i]));
            }
        }
        for(int i=reverseResult.size()-1;i>=0;i--){
            System.out.print(reverseResult.get(i));
            if(i!=0){//如果不是最后一个数字，就打印空格
                System.out.print(' ');
            }
        }
    }
}
