package test;

import enumpackage.MyEnum;
import org.junit.Test;
import test.interview.TestInterviewCode1;

import java.io.Serializable;

class MyNum {
    Integer x;
    Integer y;

    public MyNum(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
    public MyNum(){
    }


}

public class TestEnum implements Serializable,Cloneable{
    public TestEnum(Integer x,Integer y,Integer test){
        myNum=new MyNum(x,y);
        this.test=test;
    }
    public TestEnum(){

    }
    MyNum myNum;
    int test;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void display(){
        System.out.println(myNum.x+","+myNum.y+","+test);
    }
    public static void main(String[] args) {

        Integer x=new Integer(1);
        Integer y=new Integer(2);
        Integer c=new Integer(3);
        System.out.println(x==c);//integer不是同一个对象，不相等

        TestEnum testEnum=new TestEnum(x,y,c);
        try {
            TestEnum clone = (TestEnum) testEnum.clone();
            System.out.println("地址相同？"+(clone==testEnum));
            System.out.println("类里面的字段的地址是否相同？"+(clone.myNum==testEnum.myNum));
            Boolean result=clone.myNum==testEnum.myNum;
            System.out.println(result);
            System.out.println(clone.test==testEnum.test);//这边相等却不是同一个对象
//            System.out.println("hashCode是否相等:"+(clone.test.hashCode() == testEnum.test.hashCode()));
            clone.test=4;
            clone.myNum.x=2;
            testEnum.display();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
