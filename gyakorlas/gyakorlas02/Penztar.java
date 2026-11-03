import java.util.*;


public class Penztar implements Runnable{

    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + " szál eladata a " + i + " jegyet.");
            try{
                Thread.sleep(300);
            } catch(InterruptedException e){
                System.out.println("Interrupted");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{

        Thread t1 = new Thread(new Penztar(), "Penztar-01");
        Thread t2 = new Thread(new Penztar(), "Penztar-02");
        Thread t3 = new Thread(new Penztar(), "Penztar-03");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Minden pénztár bezárt.");
    }

}