package X_Exercises.Concurrency.Regular;

/**
 * Created by Mateusz Niedośpiał on 06.07.2017.
 *
 * Classic and very simple scenario when a class implements Runnable interface
 * and is supposed to be passed into new Thread constructor.
 * Then starting thread using .start() method takes Runnable object (target)
 * and invokes 'run()' on it.
 *
 * This approach is more elegant than extending Thread class due to the
 * fact that it is not restricting class extending another one if needed.
 */
public class UsingRunnable implements Runnable {

    public UsingRunnable() {}

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            System.out.println("Number: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
