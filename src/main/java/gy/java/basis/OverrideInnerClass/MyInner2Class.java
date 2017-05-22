package gy.java.basis.OverrideInnerClass;

/**
 * Created by KEASON on 2017/5/17.
 */
public class MyInner2Class {
    public InnerInterface getInnerInterface(String str) {
        return new InnerInterface() {
            @Override
            public void show(int j) {

            }
            private  String temp =str;
            private String getTemp() {
                return temp;
            }
        };
    }

    public static void main(String[] args) {
        MyInner2Class pp= new MyInner2Class();
        InnerInterface  innerInterface = pp.getInnerInterface("aaaa");
    }
}
