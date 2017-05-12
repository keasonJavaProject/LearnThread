package gy.java.basis.extendsClassInitOrder;

/**
 * Created by KEASON on 2017/5/12.
 */
public class extendsClassInitOrderTwo extends extendsClassInitOrderOne{
    private int n;
    public extendsClassInitOrderTwo() {
        System.out.println("extendsClassInitOrderTwo");
    }

    public extendsClassInitOrderTwo(int m) {
        super(m);
        System.out.println("extendsClassInitOrderTwo    " +m);
    }
    public extendsClassInitOrderTwo(int m,int n) {
        super(m);
        this.n = n;
        System.out.println("extendsClassInitOrderTwo    " +m);
    }

}
