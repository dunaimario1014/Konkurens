package runnable;
import java.util.*;
class Numbers implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100000; ++i) {
            System.out.println(i + ",");
        }
    }
}

class NumbersAndNegatedNumbers implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100000; ++i) {
            System.out.println(i + "," + -i + ",");
        }
    }
}

public class Main{


void main() {
    Runnable numbers = new Numbers();
    Runnable numbersAndNegatedNumbers = new NumbersAndNegatedNumbers();
    
    Thread thread1 = new Thread(numbers);
    Thread thread2 = new Thread(numbersAndNegatedNumbers);
    
    thread1.start();
    thread2.start();
}
}