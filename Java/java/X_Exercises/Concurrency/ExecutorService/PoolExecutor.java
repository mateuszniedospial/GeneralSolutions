package X_Exercises.Concurrency.ExecutorService;

import java.util.concurrent.*;

/**
 * Created by Mateusz Niedośpiał on 06.07.2017.
 *
 * Simple example of how ThreadPool may be used with ExecutorService.
 * Of course there are also Pool types which are of scheduled type and are built
 * using Executors factory as well.
 *
 * In the case 'cached' type is able to reuse threads that are already created but
 * not doing any work at the time or create next ones if needed.
 *
 * In contrary 'fixed' type is using as many threads as is specified to.
 */
public class PoolExecutor {

    private PoolExecutor() {}

    public static void workOnCached(){
        ExecutorService executorService = null;
        try {
            executorService = Executors.newCachedThreadPool();
            Future<CopyOnWriteArrayList<Integer>> submitResult = executorService.submit(() -> {
                System.out.println("Cached Executor Pool");
                CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                for (int i = 20; i > 0; i--) {
                    copyOnWriteArrayList.add(i);
                }
                return copyOnWriteArrayList;
            });
            CopyOnWriteArrayList<Integer> copyOnWriteArrayList = submitResult.get();
            copyOnWriteArrayList.parallelStream()
                    .filter(number -> number%4 != 0)
                    .limit(8)
                    .forEach(System.out::println);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            if(executorService != null){
                try {
                    executorService.awaitTermination(10L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                executorService.shutdownNow();
            }
        }
    }

    public static void workOnFixed(){
        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(5);
            executorService.execute(() -> {
                System.out.println("Fixed Thread Pool");
                for(int i=0; i<20; i=i+3){
                    System.out.println(i);
                }
            });
        } finally {
            if(executorService != null){
                executorService.shutdownNow();
            }
        }
    }
}
