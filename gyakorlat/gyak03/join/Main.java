package join;
import java.util.*;
class Numbers implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 1000; ++i) {
            System.out.println(i + ",");
        }
    }
}

class NumbersAndNegatedNumbers implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; ++i) {
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