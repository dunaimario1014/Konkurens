package elso_szalak;
import java.util.*;


public class Main{

    public static void main(String[] args){

        Runnable task = () -> {
            for(int i = 0; i < 100_000; i++){
                System.out.println(i);
            }
        };
        Runnable task2 = () -> {
            int szam = 1;
            
            for(int i = 0; i < 100_000; i++){
                if(i % 2 == 0){
                    System.out.println(szam);
                } else{
                    System.out.println("-" + szam + ", ");
                    szam++;
                }
                
            }
        };

        Thread szal1 = new Thread(task);
        Thread szal2 = new Thread(task2);
        szal1.start();
        szal2.start();


    }

}