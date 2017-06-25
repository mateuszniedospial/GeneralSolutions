package X_Exercises.Generics;

import java.util.List;

/**
 * Created by Mateusz Niedośpiał on 25.04.2017.
 */
public class ReadingData<T> implements Runnable {

    private final List<T> data;
    private final String dataID;
    private final int pauseTime;

    ReadingData(List<T> data, String dataID, int pauseTime) {
        this.data = data;
        this.dataID = dataID;
        this.pauseTime = pauseTime;
    }

    @Override
    public void run() {
        data.forEach((T data) -> {
            System.out.print(dataID + ": " + data + " ; ");
            System.out.println();
            try {
                Thread.sleep(pauseTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
