class PrintStringThread2 extends Thread {
    private static void fakePrint(String s) {
        for (int i = 0; i < s.length(); ++i) {
            System.out.print(s.charAt(i));
        }
    }

    PrintStringThread2(String s) {
        super(s);
    }
    @Override
    public void run() {
        for (int i = 1; i <= 100000; ++i) {
            synchronized (System.out) {
                fakePrint(getName() + " " + i + ", ");
            }
        }
    }
}
public class Main{
    public static void main(String[] args) {
        String[] array = {"hello", "world", "other"};
        for (String s: array) {
            PrintStringThread2 pst = new PrintStringThread2(s);
            pst.start();
        }
    }

}