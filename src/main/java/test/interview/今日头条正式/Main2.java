package test.interview.今日头条正式;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by【王耀冲】on 【2017/4/18】 at 【19:13】.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<String> cache=new HashSet<String>();
        while(true){
            String s = in.nextLine();
            if(s.equals("0")){
                break;
            }
            cache.add(s);
        }
        System.out.println(cache.size());
    }
}
