package szoveg_szalak;
import java.util.*;


public class Main{


    
    public static void main(String[] args){

        
        String[] szovegek = {"Megéri", "a", "szerep", "csere", "azért", "hogy", "szeressenek"};

        for(String szoveg:szovegek){
            Thread szal1 = new Thread(() -> {
                for(int i = 0; i < 100; i++){
                    System.out.println(szoveg + " " + i);
                }
            });
            szal1.start();
        }
        

    }

}