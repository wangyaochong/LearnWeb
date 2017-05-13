package test.Util;

/**
 * Created by【王耀冲】on 【2017/5/13】 at 【15:18】.
 */
public class SecondLarge {
    public static void main(String[] args) {
        int [] input=new int[]{1,2,3,4,4};
        if(input.length<2){
            return ;
        }
        int maxLoc=0;
        int secondLoc=0;
        for(int i=1;i<input.length;i++){
            if(input[i]>input[maxLoc]){//如果比最大值大，那么最大的就成为第二大
                secondLoc=maxLoc;
                maxLoc=i;
            }else{
                if(input[i]>input[secondLoc]&&input[i]!=input[maxLoc])j{//如果比第二大，就是第二大的了
                    secondLoc=i;
                }
            }
        }
        System.out.println(secondLoc);
    }
}
