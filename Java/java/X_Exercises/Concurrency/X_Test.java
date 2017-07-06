package X_Exercises.Concurrency;

import X_Exercises.Concurrency.ExecutorService.PoolExecutor;
import X_Exercises.Concurrency.ExecutorService.SingleExecutor;
import X_Exercises.Concurrency.Regular.UsingCallable;
import X_Exercises.Concurrency.Regular.UsingRunnable;
import X_Exercises.Concurrency.Regular.UsingThread;

import java.util.concurrent.FutureTask;

/**
 * Created by Mateusz Niedośpiał on 06.07.2017.
 */
public class X_Test {


    public static void main(String[] args) {

        //Regular basic way:

        //Creating new thread in a 'regular'/'basic' way
        //using Callable is not possible directly since there is
        //no Thread constructor consuming 'Callable' object.
        //That is so there is need of e.g. FutureTask wrapping.
        @SuppressWarnings("unchecked")
        FutureTask futureTask = new FutureTask<>(new UsingCallable());
        Thread firstThread = new Thread(futureTask);
        firstThread.start();

        //UsingRunnable (basic)
        Thread secondThread = new Thread(new UsingRunnable());
        secondThread.start();

        //UsingThread (basic)
        Thread thirdThread = new Thread(new UsingThread());
        thirdThread.start();

        //Of course there is also a possibility to create Thread using lambda expression
        //as Runnable is in fact FunctionalInterface:
        Thread fourthThread = new Thread(() -> {
            for(int i = 20; i > 0; i--){
                System.out.println(i);
            }
        });

        fourthThread.start();


        //ExecutorService approach:

        SingleExecutor.work();
        SingleExecutor.schedule();

        //Pools:

        PoolExecutor.workOnCached();
        PoolExecutor.workOnFixed();
    }
}
