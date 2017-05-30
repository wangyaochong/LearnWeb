package test.interview.WAP;
import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/5/28】 at 【20:26】.
 */
public class SnakeGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rowCount=in.nextInt() ;
        int colCount=in.nextInt();
        int[][]map=new int[rowCount][colCount];
        int currentRow=0;
        while(currentRow<rowCount){
            for(int i=0;i<colCount;i++){
                map[currentRow][i]=in.nextInt();
            }
            currentRow++;
        }
        for(int i=0;i<rowCount;i++){
            if(map[i][0]!=-1){
                goNextStep(map,i,0,new int[rowCount][colCount],0);
            }
        }
        System.out.println(result);
    }
    public static  int result=0;
    public static void goNextStep(int [][] map,int row,int col,int[][] cache,int currentScore){
        int mapRow=map.length;
        cache[row][col]=1;
        int nextScope=currentScore+map[row][col];
        if(nextScope>result&&col==map[0].length-1){
            result=nextScope;
        }
        if(cache[(row+1+mapRow)%mapRow][col]==0&&map[(row+1+mapRow)%mapRow][col]!=-1){
            if(row+1==mapRow){//超过边界
                goNextStep(map,0,col,cache,0);
            }else{
                goNextStep(map,row+1,col,cache,nextScope);
            }
        }
        if(cache[(row-1+mapRow)%mapRow][col]==0&&map[(row-1+mapRow)%mapRow][col]!=-1){
            if(row-1<0){
                goNextStep(map,mapRow-1,col,cache,0);
            }else{
                goNextStep(map,row-1,col,cache,nextScope);
            }
        }
        if(col+1<map[0].length&&cache[row][col+1]==0&&map[row][col+1]!=-1){
            goNextStep(map,row,col+1,cache,nextScope);
        }
        cache[row][col]=0;
    }
}
