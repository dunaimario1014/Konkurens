class Numbers implements Runnable{
    @Override
    public void run(){

        for(int i = 0; i < 10000; i++){
            if(i % 2 == 0){
                try{
                    Thread.sleep(5);
                } catch(InterruptedException e){
                    System.out.println(e);
                }
            }
            System.out.println("Kozod?" + i);
        }
    }
}

public class Run{

    public static void main(String[] args) throws InterruptedException{

        Numbers number = new Numbers();
        Thread t1 = new Thread(number);
        t1.start();
        t1.join();
        System.out.println("KÉSZ.");
    }

}