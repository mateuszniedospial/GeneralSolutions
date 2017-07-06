package X_Exercises.Concurrency.ExecutorService;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.concurrent.*;

/**
 * Created by Mateusz Niedośpiał on 06.07.2017.
 *
 * Simple case using SingleExecutor for performing new thread operation.
 * This scenario does not require direct management of Thread object
 *
 * SingleExecutor means that only one thread is created.
 * In real life situation Executor pools are used.
 */
public class SingleExecutor {

    //No need of instantiating
    private SingleExecutor() {}

    public static void work(){
        ExecutorService executorService = null;
        try{
            executorService = Executors.newSingleThreadExecutor();
            executorService.execute( () -> {
                for(int i = 20; i > 0; i--){
                    System.out.println("Numbers from single executor: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            executorService.execute(() -> System.out.println("Operation finished."));
            Future<String> submitFuture = executorService.submit(() -> {
                System.out.println("Operation finished");
                return "OK";
            });
            submitFuture.get(5L, TimeUnit.SECONDS);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("There was not enough time to obtain data.");
        } finally {
            if(executorService != null){
                try {
                    executorService.awaitTermination(10L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                executorService.shutdown();
            }
        }
    }

    public static void schedule(){
        ScheduledExecutorService scheduledExecutorService = null;
        try{
            scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
            scheduledExecutorService.schedule(() -> {
                System.out.println("Scheduled task:");
                for(int i = 0; i < 10; i++){
                    System.out.println(i);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, 5L, TimeUnit.SECONDS);

            ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(() -> {
                System.out.println("Scheduled fixed time:");
                for (int i = 20; i > 0; i--) {
                    System.out.println(i);
                }
            }, 10L, 5L, TimeUnit.SECONDS);

            scheduledFuture.get(25L, TimeUnit.SECONDS);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("There was not enough time to obtain data.");
        } finally {
            if(scheduledExecutorService != null){
                try {
                    scheduledExecutorService.awaitTermination(20L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                scheduledExecutorService.shutdown();
            }
        }
    }
}
