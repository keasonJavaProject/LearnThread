package gy.java.basis.extendsClassInitOrder;

/**
 * Created by KEASON on 2017/5/12.
 */
public class extendsClassInitOrderOne {
    int m;

    public extendsClassInitOrderOne(int m) {
        this.m = m;
        System.out.println("extendsClassInitOrderOne    "+m);
    }

    public extendsClassInitOrderOne() {
        System.out.println("extendsClassInitOrderOne");
    }
}
