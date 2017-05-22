package gy.java.basis.OverrideInnerClass;

/**
 * Created by KEASON on 2017/5/17.
 */
public class BigEgg2  extends Egg2{
    protected class York extends Egg2.York{
        public  York() {
            System.out.println("BigEgg2.York()");
        }
        public void f() {
            System.out.println("BigEgg2.York.f()");
        }
    }

    public BigEgg2(){
        insertYork(new York());
    }

    public static void main(String[] args) {
        Egg2 egg2 = new BigEgg2();
        egg2.g();
    }
}
