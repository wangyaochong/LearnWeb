package test.Util;

/**
 * Created by【王耀冲】on 【2017/5/28】 at 【20:36】.
 */
public class UtilDisplay {
    public static void display(int[][] input){
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[i].length;j++){
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }
}
