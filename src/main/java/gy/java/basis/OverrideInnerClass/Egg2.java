package gy.java.basis.OverrideInnerClass;

/**
 * Created by KEASON on 2017/5/17.
 */
public class Egg2 {
    protected class York{
        public  York() {
            System.out.println("Egg2.York()");
        }
        public void f() {
            System.out.println("Egg2.York.f()");
        }
    }
    private York york = new York();
    public Egg2(){
        System.out.println("new Egg2()");
    }

    public void insertYork(York york){
        this.york = york;
    }
    public void g() {
        york.f();
    }
}
