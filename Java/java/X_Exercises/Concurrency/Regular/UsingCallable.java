package X_Exercises.Concurrency.Regular;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Mateusz Niedośpiał on 06.07.2017.
 *
 * Implementing Callable interface instead of a Runnable makes it possible
 * to return some value upon ending the 'run' method which in case of Callable interface
 * is called 'call()'.
 *
 * Using Callable is probably not widely used in a 'basic' new Thread way
 * because Thread doesn't have constructor which takes Callable instance as a parameter.
 * For creating new Thread with Callable one must use FutureTask wrapping (FutureTask implements
 * FutureRunnable which implements Runnable underneath).
 */
public class UsingCallable implements Callable {

    public UsingCallable() {}

    @Override
    public Object call() throws Exception {
        List<Integer> list = new ArrayList<>();
        for(int i = 75; i > 0; i=i-5){
            System.out.println("Decreasing numbers: " + i);
            list.add(i);
            Thread.sleep(2000);
        }
        return list;
    }
}
