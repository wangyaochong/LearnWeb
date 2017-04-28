package test;

import org.apache.commons.collections.ArrayStack;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by【王耀冲】on 【2017/4/27】 at 【8:35】.
 */
class A {}
class B extends A {}
class C extends A {}
class D extends B {}
public class 测试协变 {
    public static void main(String[] args) {
        List<A> a=new ArrayList<A>();
        List list;
        list = a;   //A对，因为List就是List<?>，代表最大的范围，A只是其中的一个点，肯定被包含在内
        List<B> b=new ArrayList<B>();
//        a = b;      //B错，点之间不能相互赋值
        List<?> qm;
        List<Object> o=new ArrayStack();
        qm = o;     //C对，List<?>代表最大的范围，List<Object>只是一个点，肯定被包含在内
        List<D> d=new ArrayList<D>();
        List<? extends B> downB=new ArrayList<B>();
        downB = d;  //D对，List<? extends B>代表小于等于B的范围，List<D>是一个点，在其中
        List<?extends A> downA=new ArrayList<A>();
//        a = downA;  //E错，范围不能赋值给点
//        a = o;      //F错，List<Object>只是一个点
        downA = downB;  //G对，小于等于A的范围包含小于等于B的范围，因为B本来就比A小，B时A的子类嘛
    }
}
