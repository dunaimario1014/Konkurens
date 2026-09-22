package sleep;
import java.util.*;
class Numbers implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; ++i) {
            if(i % 2 == 0){
                try{
                    Thread.sleep(5);
                } catch(InterruptedException e){
                    System.out.println("Interrupted");
                }
            }
            System.out.println(i + ",");
        }
    }
}

class NumbersAndNegatedNumbers implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; ++i) {
            if(i % 2 == 0){
                try{
                    Thread.sleep(5);
                } catch(InterruptedException e){
                    System.out.println("Interrupted");
                }
            }
            System.out.println(i + "," + -i + ",");
        }
    }
}

public class Main{


public static void main(String[] args) throws InterruptedException{
    Runnable numbers = new Numbers();
    Runnable numbersAndNegatedNumbers = new NumbersAndNegatedNumbers();
    
    Thread thread1 = new Thread(numbers);
    Thread thread2 = new Thread(numbersAndNegatedNumbers);
    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();

    System.out.println("Kész");


}
}