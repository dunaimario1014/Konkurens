package harom_szal;
import java.util.*;

public class Main{
    public static void main(String[] args){

        Thread szal1 = new Thread(() -> {
            for(int i = 0; i < 100; i++){
                System.out.println("szia " + i);
            }
        });
        Thread szal2 = new Thread(() -> {
            for(int i = 0; i < 100; i++){
                System.out.println("világ " + i);
            }
        });
        Thread szal3 = new Thread(() -> {
            for(int i = 0; i < 100; i++){
                System.out.println("másik " + i);
            }
        });

        szal1.start();
        szal2.start();
        szal3.start();

    }
}