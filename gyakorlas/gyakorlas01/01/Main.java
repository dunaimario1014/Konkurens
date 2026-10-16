public class Main{


    public static void main(String[] agrs){

        int counter = 100;

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < counter; i++){
                System.out.println("Szia" + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < counter; i++){
                System.out.println("Világ" + i);
            }
        });

        Thread t3 = new Thread(() -> {
            for(int i = 0; i < counter; i++){
                System.out.println("Másik" + i);
            }
        });
        t1.start();
        t2.start();
        t3.start();

    }




}