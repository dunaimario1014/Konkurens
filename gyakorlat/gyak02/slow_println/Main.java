package slow_println;
import java.util.*;

public class Main{

    public static void main(String[] args){

        String[] szovegek = {"Megéri", "a", "szerep", "csere", "azért", "hogy", "szeressenek"};

        for(String szoveg:szovegek){
            Thread szal1 = new Thread(() -> {
                for(int i = 0; i < 10; i++){
                    for(int j = 0; j < szoveg.length(); j++){
                        System.out.print(szoveg.charAt(j));
                    }
                    System.out.println();
                }
            });
            szal1.start();
        }

    }

}