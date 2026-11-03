import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Pipeline1 {
    public static void main(String[] args) throws Exception {
        var NO_FURTHER_INPUT1 = "";
        var NO_FURTHER_INPUT2 = -1;

        var bq1 = new ArrayBlockingQueue<String>(10);
        var bq2 = new ArrayBlockingQueue<Integer>(10);

        var pool = Executors.newCachedThreadPool();

        pool.submit(() -> {
            bq1.addAll(List.of("a", "bb", "ccccccc", "ddd", "eeee", NO_FURTHER_INPUT1));
        });

        pool.submit(() -> {
            try {
                while (true) {
                    // TODO queue #1 ====> txt  len ===> queue #2
                    // TODO also handle NO_FURTHER_INPUTs
                    String txt = bq1.take();
                    
                    if(NO_FURTHER_INPUT1.equals(txt)){
                        bq2.put(NO_FURTHER_INPUT2);
                        break;
                    }

                    bq2.add(txt.length());
                    
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        pool.submit(() -> {
            try {
                while (true) {
                    // TODO queue #2 ====> len ====> print it
                    int pr = bq2.take();

                    if(NO_FURTHER_INPUT2 == pr){
                        break;
                    }

                    System.out.println(pr);
                    // TODO also handle NO_FURTHER_INPUTs
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);
    }
}