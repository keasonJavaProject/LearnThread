package gy.java.basis.classLoderAndInit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by KEASON on 2017/5/12.
 */
public class MyClassMethodStaticInitLoder {
    public static List<Integer> list = getList();

    private static List<Integer> getList() {
        return  new ArrayList<>(Arrays.asList(1,2,3));
    }
}
