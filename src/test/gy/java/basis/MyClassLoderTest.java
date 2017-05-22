package gy.java.basis;

import gy.java.basis.classLoderAndInit.MyClassLoder;
import org.junit.Test;

/**
 * Created by KEASON on 2017/5/12.
 *
        public class MyClassLoder {
        public int x =2;
        public int getVal() {
        return  n;
        }
        public int m = getVal();
        public int n= 1;
        public int mm = getVal();
        }

 *
 */
public class MyClassLoderTest {
    /**
     * 可以看出，m 在getVal()时 由于n 还有没被显示初始化为 1（n=1 ）没执行，所以给的值是默认的初始化值 0
     * 当 n=1执行之后，mm=getVal（）执行，返回的值是 1。
     */
    @Test
    public void getVal() throws Exception {
        System.out.println(new MyClassLoder().m);
        System.out.println(new MyClassLoder().n);
        System.out.println(new MyClassLoder().getVal());
        System.out.println(new MyClassLoder().mm);
        /*** 结果：0  1  1   1  */
    }

    @Test
    public void getVal2() throws Exception {
        System.out.println(new MyClassLoder().m);

        //getVal()之前，肯定所有的显示初始化都做完了。所以测试n=1
        System.out.println(new MyClassLoder().getVal());
        System.out.println(new MyClassLoder().n);
        System.out.println(new MyClassLoder().mm);
        /**结果：    0  1   1   1 */
    }


    //通过getVal3() 和getVal4()说明m 的值不是动态计算的，是存储下来的。
    @Test
    public void getVal3() throws Exception {
        MyClassLoder myClassLoder =new MyClassLoder();
        System.out.println(myClassLoder.m);
        System.out.println(myClassLoder.getVal());

        System.out.println(myClassLoder.n);
        System.out.println(myClassLoder.mm);
        // 0 1 1 1
    }
    @Test
    public void getVal4() throws Exception {
        MyClassLoder myClassLoder =new MyClassLoder();
        System.out.println(myClassLoder.getVal());
        System.out.println(myClassLoder.m);

        System.out.println(myClassLoder.n);
        System.out.println(myClassLoder.mm);
        // 0 1 1 1
    }
    @Test
    public void getVal5() throws Exception {
        MyClassLoder myClassLoder =new MyClassLoder();
        System.out.println(myClassLoder.getVal());
        myClassLoder.m = myClassLoder.getVal();//动态赋值
        System.out.println(myClassLoder.m);

        System.out.println(myClassLoder.n);
        System.out.println(myClassLoder.mm);
        // 1 1 1 1
    }

}