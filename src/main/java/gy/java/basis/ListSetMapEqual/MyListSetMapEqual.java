package gy.java.basis.ListSetMapEqual;

import java.util.*;

/**
 * Created by KEASON on 2017/5/12.
    listOne.remove(1);
    listOne.remove(new String(""));
    AyyayList 支持2中类型的remove。
 */
public class MyListSetMapEqual {
    public static void main(String[] args) {
        System.out.println("list show");
        //list 相等是list中的相应位置上的对象也要相等equals(),个数相等。
        List<Integer> listOne =new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> listOne1 =new ArrayList<>(Arrays.asList(3,1,2));
        List<Integer> listTwo =new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> listThree =new ArrayList<>(Arrays.asList(0,2,3));
        System.out.println(listOne.equals(listTwo));
        System.out.println(listOne.equals(listOne1));
        System.out.println(listOne.equals(listThree));

        System.out.println("\n\nset show");
        //set相等时和位置无关的，个数相等equals() ,检测 foreach + contains() 值的包含情况。和位置无关。
        Set<Integer> setOne =new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> setOne1 =new HashSet<>(Arrays.asList(3,1,2));
        Set<Integer> setTwo =new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> setThree =new HashSet<>(Arrays.asList(0,2,3));
        System.out.println(setOne.equals(setTwo));
        System.out.println(setOne.equals(setOne1));
        System.out.println(setOne.equals(setThree));


        //map相等判断size。然后检测 foreach + map.get() 值的包含情况。和位置无关。
        System.out.println("\n\nMap show");
        Map<Integer,String> map= new HashMap<>();
        map.put(1,"1");
        map.put(2,"2");
        map.put(3,"3");

        Map<Integer,String> map1= new HashMap<>();
        map1.put(1,"1");
        map1.put(2,"2");
        map1.put(3,"3");
        map1.put(4,"4");

        Map<Integer,String> map2= new HashMap<>();
        map2.put(1,"1");
        map2.put(3,"3");
        map2.put(2,"2");

        System.out.println(map.equals(map1));
        System.out.println(map.equals(map2));

    }
}
