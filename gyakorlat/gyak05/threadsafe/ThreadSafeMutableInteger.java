package threadsafe;

import java.util.*;


class ThreadSafeMutableInteger{

    private int safe;

    public ThreadSafeMutableInteger(int safe){
        this.safe = safe;
    }

    public ThreadSafeMutableInteger(){

    }


    public synchronized int get(){
        return safe;
    }

    public synchronized void set(int value){
        safe = value;
    }

    //n.set(n.get()+1) helyett az alábbi metódusokat tudjuk használni
    
    public synchronized int getAndIncrement(){
        return safe++;
    }

    public synchronized int getAndDecrement(){
        return safe--;
    }

    public synchronized int getAndAdd(int add){
        int returned = safe;
        safe += add;
        return returned;
    }

    public synchronized int incrementAndGet(){
        return ++safe;
    }

    public synchronized int decrementAndGet(){
        return --safe;
    }

    public synchronized int updateAndGet(IntUnaryOperator operator){
        safe = operator.applyAsInt(safe);
        return safe;
    }
    
    public synchronized int getAndUpdate(IntUnaryOperator operator){
        int returned = safe;
        safe = operator.applyAsInt(safe);
    }

    public synchronized int addAndGet(int add){
        return safe += add;
    }

    public static void main(String[] args){


        ThreadSafeMutableInteger szam = new ThreadSafeMutableInteger(4);

        Thread t1 = new Thread(() -> {
            for(int i=0;i<100;i++){
                System.out.println(szam.getAndIncrement());
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0;i<100;i++){
                System.out.println(szam.getAndDecrement());
            }
        });

        Thread t3 = new Thread(() -> {
            for(int i=0;i<100;i++){
                System.out.println(szam.incrementAndGet());
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }





}