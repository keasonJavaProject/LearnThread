package gy.java.basis;

import gy.java.basis.classLoderAndInit.MyClassMethodStaticInitLoder;
import org.junit.Test;

import java.util.List;

/**
 * Created by KEASON on 2017/5/12.
         public class MyClassMethodStaticInitLoder {
         public static List<Integer> list = getList();

         private static List<Integer> getList() {
         return  Arrays.asList(1,2,3);
         }
         }
 */
public class MyClassMethodStaticInitLoderTest {

    /**
     * 通过show() /show1()可以看出，第二次在show1（）中得到的list的size为4 ，说明他们公用了一个list
     */

    @Test
    public void show(){
        /**
         * 实例化对象时，直接调用getList() 方法，所以list会被初始化。
         */
        List list = MyClassMethodStaticInitLoder.list;
        list.add(4);
        show1();
    }

    @Test
    public void show1(){
        List list = MyClassMethodStaticInitLoder.list;  //此时size()=4 ,共享了一个变量。
        list.add(5);
    }

}