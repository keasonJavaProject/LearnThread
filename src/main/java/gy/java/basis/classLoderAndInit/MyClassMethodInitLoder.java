package gy.java.basis.classLoderAndInit;

import java.util.Arrays;
import java.util.List;

/**
 * Created by KEASON on 2017/5/12.
 */
public class MyClassMethodInitLoder {
    public List<Integer> list = getList();

    private List<Integer> getList() {
        return  Arrays.asList(1,2,3);
    }
    
}
