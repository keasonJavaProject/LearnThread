package gy.java.basis.TryCatchFinallyReturn;

/**
 * Created by KEASON on 2017/5/12.
 * try return a, finally return b ,最终会以 finally返回的为准。
 */
public class MyTryCatchFinally {

    static int returnShow() {
        try {
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return 2;
        }
    }

    public static void main(String[] args) {
        int temp  = returnShow();
        System.out.println(temp);
    }
}
