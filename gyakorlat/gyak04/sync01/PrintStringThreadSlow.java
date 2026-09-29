public class PrintStringThreadSlow extends Thread {
    
    private static synchronized void fakePrint(String s) {
        for (int i = 0; i < s.length(); ++i) {
            System.out.print(s.charAt(i));
        }
    }

    PrintStringThreadSlow(String s) {
        super(s);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; ++i) {
            fakePrint(getName() + " " + i + ", ");
        }
    }

    public static void main(String[] args) {
        String[] array = {"hello", "world", "other"};
        for (String s: array) {
            PrintStringThreadSlow pst = new PrintStringThreadSlow(s);
            pst.start();
        }
    }
}