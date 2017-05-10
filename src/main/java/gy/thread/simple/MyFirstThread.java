package gy.thread.simple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;


/**
 * Created by KEASON on 2017/5/10.
 * 集合安全
 */
@Service
public class MyFirstThread {
    @Autowired
    private List list;

    public List<Integer> getList() {
        if (!CollectionUtils.isEmpty(list)) {
            return list;
        }
        return new ArrayList<Integer>();
    }

    public void showListRemoveWithForeach(){
        List<Integer> list= getList();
        // foreach  list.remove 会报异常的。
        for (Integer inte : list) {
            if (inte == 1) {
                list.remove(inte);
            }
        }
        System.out.println(list);
    }


    public void showListRemoveWithIterator(){
        List<Integer> list =getList();
//       通过迭代器remoive 就不会报异常
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (Integer.valueOf(1).equals(iterator.next())) {
                iterator.remove();
            };
        }
        System.out.println(list);
    }

    public void showListRemoveWithListGet() {
        List<Integer> list =getList();
        // 通过数组方式也可以 ，不报异常 ，从后到前remove ,减少数组拷贝
        for (int i= list.size()-1; i>=0; i--){
            if (list.get(i).equals(3)) {
                list.remove(i);
            }
        }
        System.out.println(list);
    }
}
