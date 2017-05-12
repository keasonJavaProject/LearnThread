package gy.java.basis.extendsClassInitOrder;

/**
 * Created by KEASON on 2017/5/12.
 */
public class extendsClassInitOrderThree extends extendsClassInitOrderTwo{
    private int x;

    public extendsClassInitOrderThree() {
        System.out.println("extendsClassInitOrderThree");
    }

    public extendsClassInitOrderThree(int m) {
        super(m);
        System.out.println("extendsClassInitOrderThree  "+m);
    }

    public extendsClassInitOrderThree(int m, int n) {
        super(m, n);
    }
    public extendsClassInitOrderThree(int m, int n,int x) {
        super(m, n);
        this.x =x;
    }
}
