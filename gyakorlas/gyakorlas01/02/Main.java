public class Main{


    public static void main(String[] args){

        String[] szoveg = {"Lazítani", "próbálj", "meg", "lazítani", "nem", "győzlek", "tanítani"};

        for(String s : szoveg){
            Thread t1 = new Thread(() -> {
                System.out.println(s);

            });
                t1.start();
        }
        



    }


}