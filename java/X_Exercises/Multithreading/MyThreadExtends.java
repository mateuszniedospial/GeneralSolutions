package X_Exercises.Multithreading;

/**
 * Created by Mateusz Niedośpiał on 24.04.2017.
 */
public class MyThreadExtends extends Thread {

    private int sleepTime;
    private String threadName;
    private int startNumber;

    MyThreadExtends(int sleepTime, String threadName, int startNumber) {
        this.sleepTime = sleepTime;
        this.threadName = threadName;
        this.startNumber = startNumber;
    }

    @Override
    public void run() {
        while(startNumber>0){
            System.out.println(threadName+": "+startNumber);
            startNumber--;
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
