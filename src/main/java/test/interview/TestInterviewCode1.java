package test.interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by【王耀冲】on 【2017/3/25】 at 【14:42】.
 */



public class TestInterviewCode1 {
    static class MyNum{
        int x;
        int y;

        MyNum(int x,int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public boolean equals(Object obj) {
            return getSimple(this).x==getSimple((MyNum)obj).x&&getSimple(this).y==getSimple((MyNum)obj).y;
        }

        @Override
        public int hashCode() {
            return getSimple(this).x*100000+getSimple(this).y;
        }

        public MyNum getSimple(MyNum num){
            int maxdiv=xymod(num.x,num.y);
            MyNum result=new MyNum(num.x/maxdiv,num.y/maxdiv);
            return result;
        }
        public static int xymod(int a,int b){
            if(a<b){
                int temp;
                temp=a;
                a=b;
                b=temp;
            }
            if(0==b){
                return a;
            }
            return xymod(a-b,b);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w=0,x=0,y=0,z=0;
            w = in.nextInt();
            x = in.nextInt();
            y = in.nextInt();
            z = in.nextInt();
        Set<MyNum> result=new HashSet<MyNum>();
        for(int i=w;i<=x;i++){
            for(int j=y;j<=z;j++){
                result.add(new MyNum(i,j));
            }
        }
        System.out.println(result.size());
    }
}
