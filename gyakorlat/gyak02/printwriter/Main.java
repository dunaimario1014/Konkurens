package printwriter;
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException, InterruptedException{
        PrintWriter printWriter = new PrintWriter("file.txt");

        String[] szovegek = {"Megéri", "a", "szerep", "csere", "azért", "hogy", "szeressenek"};
        List<Thread> szalak = new ArrayList<>();
        for(String szoveg:szovegek){
            Thread szal1 = new Thread(() -> {
                for(int i = 0; i < 100; i++){
                    printWriter.println(szoveg + " " + i);
                }
            });
            szalak.add(szal1);
            szal1.start();
        }

        for(Thread szal : szalak) {
            szal.join();
        }

        printWriter.close();
    }

}