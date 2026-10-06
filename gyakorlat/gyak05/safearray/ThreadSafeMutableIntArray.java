package safearray;
import java.util.*;

// Ahelyett, hogy a teljes tömböt megbénítjuk, létrehozunk egy object tömböt,
// ami azt fogja eltárolni, hogy éppen melyik elem van "zárt" állapotban.

public class ThreadSafeMutableIntArray{

    private int lista[];
    private Object kulcsok[];

    ThreadSafeMutableIntArray(int capacity){
        this.lista = new int[capacity];   
        this.kulcsok = new Object[capacity]; 
        for(int i = 0; i < capacity; i++){
            kulcsok[i] = new Object();
        }    
    }
    
    public int get(int n){
        synchronized(kulcsok[n]){
            return lista[n];
        }
    }
    public void set(int n, int m){
        synchronized(kulcsok[n]){
            lista[n] = m;
        }
    }

    
    
    public static void main(String[] args){

        ThreadSafeMutableIntArray arr = new ThreadSafeMutableIntArray(10);

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                System.out.println("A t1 szál " + i + " futásra " + arr.get(i) + " értéket olvasott be a set() metódus előtt");
                arr.set(i,1);
                System.out.println("A t1 szál " + i + " futásra " + arr.get(i) + " értéket olvasott be a set() metódus után");
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                System.out.println("A t2 szál " + i + " futásra " + arr.get(i) + " értéket olvasott be a set() metódus előtt");
                arr.set(i,2);
                System.out.println("A t2 szál " + i + " futásra " + arr.get(i) + " értéket olvasott be a set() metódus után");

            }
        });

        t1.start();
        t2.start();


    }







}