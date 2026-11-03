import java.util.concurrent.*;
public class ThreadPools {
    public static void main(String[] args) throws Exception {
        int POOL_SIZE = 2; // You can play with different pool sizes

        int STEP_COUNT = 10_000;

        ExecutorService pool = Executors.newFixedThreadPool(POOL_SIZE);// create the thread pool

        // Create a `Callable` object: 
        Callable<Integer> counter = () -> {
            int sum = 0;
            for (int j = 0; j < STEP_COUNT; j++) {
                sum += ThreadLocalRandom.current().nextInt(10);
            }
           return sum;
        };

        Future<Integer> future1 = pool.submit(counter);// Submit a `counter` into the pool
        Future<Integer> future2 = pool.submit(counter);// Submit a `counter` into the pool
        Future<Integer> future3 = pool.submit(counter);// Submit a `counter` into the pool

        int result1 = future1.get();// Get the result of `future1`
        int result2 = future2.get();// Get the result of `future1`
        int result3 = future3.get();// Get the result of `future1`
        int result = result1 + result2 + result3;

        System.out.printf("Result: %d = %d + %d + %d%n", result, result1, result2, result3);
        pool.shutdown();
        // Shut down the pool
    }
}