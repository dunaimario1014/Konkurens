import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Pipeline {
    public static void main(String[] args) throws Exception {
        var NO_FURTHER_INPUT = "";

        // TODO create the queue
        var bq = new ArrayBlockingQueue<String>(10);

        var pool = Executors.newCachedThreadPool();

        pool.submit(() -> {
            bq.addAll(List.of("a", "bb", "ccccccc", "ddd", "eeee", NO_FURTHER_INPUT));
        });

        pool.submit(() -> {
            try {
                while (true) {
                    // TODO queue #1 ====> txt ===> print it
                    // TODO also handle NO_FURTHER_INPUTs

                    String txt = bq.take();

                    if(NO_FURTHER_INPUT.equals(txt)){
                        break;
                    }

                    System.out.println(txt);
                
                
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);
    }
}