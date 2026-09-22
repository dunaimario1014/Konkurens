package interrupt;
import java.util.*;
class Numbers implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 1000; ++i) {
            System.out.println(i + ",");
            if(i % 2 == 0){
                try{
                    Thread.sleep(5);
                } catch(InterruptedException e){
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}

class NumbersAndNegatedNumbers implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 1000; ++i) {
            System.out.println(i + "," + -i + ",");
                try{
                    Thread.sleep(5);
                } catch(InterruptedException e){
                    e.printStackTrace();
                    break;
                }
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

    try{
        Thread.sleep(100);
    } catch(InterruptedException e){
        e.printStackTrace();
    }


    thread1.interrupt();
    thread2.interrupt();

    //thread1.join();
    //thread2.join();


    System.out.println("Kész");


}
}