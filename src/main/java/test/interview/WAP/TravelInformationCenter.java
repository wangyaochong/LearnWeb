package test.interview.WAP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/5/28】 at 【21:02】.
 */
public class TravelInformationCenter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pathCount=in.nextInt()-1;
        int queryCount=in.nextInt();
        int[] festival=new int[pathCount+2];
        festival[1]=1;//No.1 is festival city
        int[] distance=new int[pathCount+2];
        Map<Integer,ArrayList<Integer>> pathMap=new HashMap<Integer, ArrayList<Integer>>();
        while(pathCount>0){
            Integer first=in.nextInt();
            Integer second=in.nextInt();
            if(pathMap.containsKey(first)==false){//如果没有这条记录
                pathMap.put(first,new ArrayList<Integer>());
            }
            if(pathMap.containsKey(second)==false){
                pathMap.put(second,new ArrayList<Integer>());
            }
            pathMap.get(first).add(second);
            pathMap.get(second).add(first);
            pathCount--;
        }
        for(int i=0;i<distance.length;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        update(pathMap,1,festival,distance,new int[distance.length]);
        while(queryCount>0){
            int type = in.nextInt();
            int point = in.nextInt();
            if(type==2){
                System.out.println(distance[point]);
            }else{
                festival[point]=1;
                update(pathMap,point,festival,distance,new int[distance.length]);
            }
            queryCount--;
        }
    }
    public static void update(Map<Integer,ArrayList<Integer>> path,Integer start,int[] festivalPoint,int[] distance,int [] visited){
        ArrayList<Integer> arrayList = path.get(start);
        for (Integer integer : arrayList) {
            if(visited[integer]==1){//如果已经看过了，就看下一条边
                continue;
            }
            if(festivalPoint[start]==1) {//如果这个点是节日点，那么就距离是零
                distance[start] = 0;
                distance[integer]=1;
            }else{
                distance[integer]=Math.min( distance[start]+1,distance[integer]);
            }
            visited[start]=1;//所有的点只能看一次
            update(path,integer,festivalPoint,distance,visited);
        }
    }
}
