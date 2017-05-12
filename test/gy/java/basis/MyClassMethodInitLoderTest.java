package gy.java.basis;

import gy.java.basis.classLoderAndInit.MyClassMethodInitLoder;
import org.junit.Test;

import java.util.List;

/**
 * Created by KEASON on 2017/5/12.
         public class MyClassMethodInitLoder {
         public List<Integer> list = getList();

         private List<Integer> getList() {
         return  Arrays.asList(1,2,3);
         }
         }
 */
public class MyClassMethodInitLoderTest {
    @Test
    public void show(){
        /**
         * 实例化对象时，直接调用getList() 方法，所以list会被初始化。
         */
        MyClassMethodInitLoder initLoder =new MyClassMethodInitLoder();
        List list = initLoder.list;
    }

}