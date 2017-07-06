package X_Exercises.Concurrency.Regular;

/**
 * Created by Mateusz Niedośpiał on 06.07.2017.
 *
 * Different approach used for creating multithreading application.
 * In this case class extends Thread and (also) override run() method.
 * Instance of this class is then passed in constructor of a new Thread
 * which upon starting invokes 'run()'.
 *
 * This approach does not allow class to extend another one if needed which
 * makes it less flexible and therefore it should not be used only for creating new Thread.
 *
 * In my opinion extending Thread should be used only when there is need to create a specialize
 * implementation of Thread (e.g. Thread that is doing something special after some time of running).
 * It is then appropriately justified.
 */
public class UsingThread extends Thread{

    public UsingThread() {}

    @Override
    public void run() {
        for(int i = 0; i < 50; i=i+5){
            System.out.println("NumberByFive: " + i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
