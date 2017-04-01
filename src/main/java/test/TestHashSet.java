package test;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by【王耀冲】on 【2017/3/27】 at 【22:30】.
 */
public class TestHashSet {
    class My{
        Integer x;
        @Override
        public boolean equals(Object obj) {
            return this.x==((My)obj).x;
        }
        My(Integer x){
            this.x=x;
        }

        @Override
        public int hashCode() {
            return this.x;
        }

        @Override
        public String toString() {
            return this.x.toString();
        }
    }
    @Test
    public void testHashSet(){
        My m1=new My(1);
        My m2=new My(1);
        Set<My> set=new HashSet<My>();
        set.add(m1);
        set.add(m2);
        System.out.println(set);
        return ;
    }
}
