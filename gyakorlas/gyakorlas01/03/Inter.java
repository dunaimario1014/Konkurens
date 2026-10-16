class Numbers implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i < 1000; i++){
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                System.out.println("Interrupted");
                break;
            }
            System.out.println(i);
        }
    }
}

public class Inter{
    public static void main(String[] args) throws InterruptedException{
        Numbers number = new Numbers();
        Thread t1 = new Thread(number);

        t1.start();
        Thread.sleep(3000);
        t1.interrupt();
        t1.join();
        System.out.println("Kész.");

    }
}