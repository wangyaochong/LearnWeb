package test.interview.去哪网;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/4/1】 at 【19:49】.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String count=in.nextLine();
        String preOrder=in.nextLine();
        String midOrder=in.nextLine();
        String[] preOrderArr = preOrder.split(" ");
        String[] midOrderArr = midOrder.split(" ");
        System.out.println(preOrderArr[0]);//打印根结点
        ArrayList<Integer> prePosList=new ArrayList<Integer>();
        prePosList.add(0);
        ArrayList<ArrayList<Integer>> levelPrePos=new ArrayList<ArrayList<Integer>>();
        levelPrePos.add(prePosList);
        while(true){
            ArrayList<Integer> prePos = makeLevel(prePosList, preOrderArr, midOrderArr);
            if(prePos.size()==2&&prePos.get(0)==-1&&prePos.get(1)==-1)break;
            levelPrePos.add(prePos);
        }
        for(int i=0;i<levelPrePos.size();i++){
            for(int j=0;j<levelPrePos.get(i).size();j++){
                System.out.println(preOrderArr[levelPrePos.get(i).get(j)]);
            }
        }
    }
    public static ArrayList<Integer> visitedPreLoc=new ArrayList<Integer>();
    public static  ArrayList<Integer> makeLevel(ArrayList<Integer> prePosList,String[] pre,String[] mid){
        ArrayList<Integer> result=new ArrayList<Integer>();
        for(int i=0;i<prePosList.size();i++){
            int midDiv=findLoc(pre[prePosList.get(i)],mid);
            result.add(getChildLocInMid(pre,mid,0,midDiv-1));
            result.add(getChildLocInMid(pre,mid,midDiv+1,pre.length));
        }
        return result;
    }
    public static int getChildLocInMid(String[] pre,String[] mid,int start,int end){
        for(int i=0;i<pre.length;i++){
            for(int j=start;j<end;j++){
                if(pre[i].equals(mid[j])&&visitedPreLoc.contains(i)==false){
                    visitedPreLoc.add(i);//前序该结点已经遍历过
                    return j;
                }
            }
        }
        return -1;
    }
    public static int findLoc(String target,String[] strs){
        for(int i=0;i<strs.length;i++){
            if(strs[i].equals(target)){
                return i;
            }
        }
        return -1;
    }
}
