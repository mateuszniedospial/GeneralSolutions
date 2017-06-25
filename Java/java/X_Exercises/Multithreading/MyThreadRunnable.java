package X_Exercises.Multithreading;

/**
 * Created by Mateusz Niedośpiał on 24.04.2017.
 */
public class MyThreadRunnable implements Runnable {

    private int howMuchToWait;
    private String nameOfThread;
    private int startNumber;

    MyThreadRunnable(int howMuchToWait, String nameOfThread, int startNumber) {
        this.howMuchToWait = howMuchToWait;
        this.nameOfThread = nameOfThread;
        this.startNumber = startNumber;
    }

    @Override
    public void run() {
        while(startNumber>0){
            System.out.println(nameOfThread+": " + startNumber);
            try {
                Thread.sleep(howMuchToWait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startNumber--;
        }
    }
}
