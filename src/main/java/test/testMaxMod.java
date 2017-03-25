package test;

import org.junit.Test;

/**
 * Created by【王耀冲】on 【2017/3/25】 at 【15:28】.
 */
public class testMaxMod {
    @Test
    public void testMaxMod(){
        int xymod = xymod(12, 8);
        System.out.println(xymod);
    }
    public static int xymod(int a,int b) {
        if (a < b) {
            int temp;
            temp = a;
            a = b;
            b = temp;
        }
        if (0 == b) {
            return a;
        }
        return xymod(a-b,b);
    }
}
