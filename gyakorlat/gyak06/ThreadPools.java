import java.util.concurrent.*;
public class ThreadPools {
    public static void main(String[] args) throws Exception {
        int POOL_SIZE = 10; // You can play with different pool sizes

        int THREAD_COUNT = 10;
        int STEP_COUNT = 100;

        ExecutorService pool = Executors.newFixedThreadPool(POOL_SIZE);
        // var pool = /* create the thread pool */

        for (int i = 0; i < THREAD_COUNT; i++) {
            var threadIdx = i;
            // Submit this task into the pool:
            pool.submit(() -> {
                 for (int j = 0; j < STEP_COUNT; j++) {
                     System.out.printf("Thread %d step %d%n", threadIdx, j);
                 }
            

            });
        }

        Thread.sleep(600);
        pool.shutdown();
        // Shut down the pool
        // Wait at most 1 minute to shut down the pool

        System.out.println("Done");
    }
}