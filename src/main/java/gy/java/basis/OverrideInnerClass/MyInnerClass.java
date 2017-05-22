package gy.java.basis.OverrideInnerClass;

/**
 * Created by KEASON on 2017/5/17.
 */
public class MyInnerClass {
    private class InnerClass implements NarrowClass{
        private InnerClass() {

        }
        private void op1() {
            System.out.println("op1");
        }

        private void op2() {
            System.out.println("op2");
        }
    }

    public NarrowClass getInnerClass() {
        return (NarrowClass) new InnerClass();
    }

     public static void main(String[] args) {
        MyInnerClass m = new MyInnerClass();
         //在MyInnerClass 内部可以使用 new 创建InnerClass ，然后执行操作。
         //注意此时外部类访问内部类的私有方法，和构造函数。不受限制。
        MyInnerClass.InnerClass innerClass =m.new InnerClass();
        innerClass.op1();
        innerClass.op2();

         //但是通过getInnerClass获取的窄对象，不能有任何操作，只能返回对象。
         NarrowClass narrowClass = m.getInnerClass();




    }
}
