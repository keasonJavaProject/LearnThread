package gy.java.basis.classLoderAndInit;

import java.util.List;

/**
 * Created by KEASON on 2017/5/12.
 */
public class MyClassLoder {
    public int x = 2;

    public int getVal() {
        return n;
    }

    public int m = getVal();
    public int n = 1;
    public int mm = getVal();

    private int temp;


    private void showTemp() {
        List str;
        //方法中的变量不初始化，会报错
//        System.out.println(str);

        //类中的变量，没被初始化，不会报错。
        System.out.println(temp);
    }
}
