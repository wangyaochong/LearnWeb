package test.interview.hiho.编程练习赛13;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/4/19】 at 【21:03】.
 */
public class 最大子矩阵 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().trim();
        String[] split = s.split(" ");
        int x=Integer.parseInt(split[0]);
        int y=Integer.parseInt(split[1]);
        int [] sizeCount=new int[ x*y+1];
        Long sum=Long.parseLong(split[2]);
        ArrayList<ArrayList<Integer>> matrix=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<x;i++){
            String[] split1 = in.nextLine().trim().split(" ");
            matrix.add(new ArrayList<Integer>());
            for(int j=0;j<split1.length;j++){
                matrix.get(i).add(Integer.parseInt( split1[j]));
            }
        }
        int currentX=0;
        int currentY=0;
        int tmpX=x-1;
        int tmpY=y-1;
        while(currentX<x){
            int size=(tmpX-currentX+1)*(tmpY-currentY+1);
            if(tmpX<x&&tmpY<y&&sizeCount[size]==0){
                Long tmpSum = getSum(matrix, currentX, currentY, tmpX, tmpY);
                if(sum>=tmpSum){
                    sizeCount[size]++;
                }
            }
            tmpY--;
            if(tmpY<currentY){
                tmpX--;
                tmpY=y-1;
            }
            if(tmpX<currentX){
                currentY++;
                tmpY=y-1;
                tmpX=x-1;
            }
            if(currentY==y){
                currentY=0;
                currentX++;
                tmpY=y-1;
                tmpX=x-1;
            }
        }
        for(int i=x*y;i>=0;i--){
            if(sizeCount[i]!=0){
                System.out.println(i);
                break;
            }
        }
    }
    public static Long getSum(ArrayList<ArrayList<Integer>> matrix,int xstart,int ystart,int xend,int yend){
        Long sum=0l;
        for(int i=xstart;i<=xend;i++){
            for(int j=ystart;j<=yend;j++){
                sum+=matrix.get(i).get(j);
            }
        }
        return sum;
    }
}
