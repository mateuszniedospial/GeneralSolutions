package X_Exercises.Multithreading;

/**
 * Created by Mateusz Niedośpiał on 24.04.2017.
 */
public class X_Test {
    public static void main(String[] args) {
        MyThreadRunnable myTR1 = new MyThreadRunnable(1000, "TR1", 20);
        MyThreadRunnable myTR2 = new MyThreadRunnable(2000, "TR2", 15);
        Thread t1 = new Thread(myTR1);
        t1.start();
        Thread t2 = new Thread(myTR2);
        t2.start();

        MyThreadExtends myTE1 = new MyThreadExtends(1000, "TE1", 32);
        MyThreadExtends myTE2 = new MyThreadExtends(2000, "TE2", 22);
        myTE1.start();
        myTE2.start();
    }
}
