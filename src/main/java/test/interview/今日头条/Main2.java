package test.interview.今日头条;

import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/4/17】 at 【19:07】.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int songCount = Integer.parseInt( input.split(" ")[0]);
        int second =  Integer.parseInt( input.split(" ")[1]);
        int cdL=  Integer.parseInt( input.split(" ")[2]);
        int cdSongCapacity = getCdSongCapacity(second, cdL);
        int needCount=songCount/cdSongCapacity;
        if(songCount%cdSongCapacity==0){
            if(needCount==1&&songCount%13==0){
                System.out.println(needCount+1);
            }else{
                System.out.println(needCount);
            }
        }else{
            int left=songCount%cdSongCapacity;
            if(left%13==0&&!canShift(cdSongCapacity,left)){
                System.out.println(needCount+2);
            }else{
                if(needCount+1==1&&(left)%13==0){
                    System.out.println(needCount+2);
                }else{
                    System.out.println(needCount+1);
                }
            }
        }
    }
    //判断能否通过移动打到要求
    public static  boolean canShift(int totalCapacity,int currentCapacity){
        int i=0;
        while(currentCapacity+i<=totalCapacity-i){
            if((currentCapacity+i)%13!=0&&(totalCapacity-i)%13!=0){
                return true;
            }
            i++;
        }
        return false;
    }
    public static  int getCdSongCapacity(int s,int l){
        if(s>l)return 0;
        if(s==l)return 1;
        int sCount=((l+1)/(s+1));
        if(sCount%13==0){
            return sCount-1;
        }
        return sCount;
    }
}
