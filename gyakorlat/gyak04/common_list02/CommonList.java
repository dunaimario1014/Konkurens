import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
// Ha nem lenne szinkronizálva, akkor nem 100000 lenne a lista hossza,
// hanem random (pl:77202)
// Itt a lista van szinkronizálva
public class CommonList{


private static List<Integer> intList = Collections.synchronizedList(new ArrayList<>());

private static class Odd extends Thread {
    public void run() {
            for (int i = 1; i <= 100000; i += 2) {
                intList.add(i);
        }
    }
}

private static class Even extends Thread {
    public void run() {
            for (int i = 2; i <= 100000; i += 2) {
                intList.add(i);
            }
    }
}

void main() {
    Odd odd = new Odd();
    Even even = new Even();
    odd.start();
    even.start();
    try {
        odd.join();
        even.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("Length of the list: " + intList.size());
    
    }

}