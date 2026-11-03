public class BanyaszokEsEpitokAlap {

    public static void main(String[] args) throws InterruptedException {

        // BÁNYÁSZ: Végtelen ciklusban dolgozik, amíg meg nem szakítják (interrupt)
        Runnable banyaszFeladat = () -> {
            int kibanyaszottArany = 0;
            // TODO 1: Írj egy ciklust, ami addig fut, amíg a jelenlegi szál NINCS megszakítva!
            // Tipp: !Thread.currentThread().isInterrupted()
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    // TODO 2: Altasd a szálat 200 ms-ig!
                    Thread.currentThread().sleep(200);
                    kibanyaszottArany += 10;
                    System.out.println(Thread.currentThread().getName() + " bányászott. Összesen: " + kibanyaszottArany);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " munkáját megszakították alvás közben, hazamegy!");
                    // TODO 3: Ha alvás közben jön az interrupt, a kivétel elkapása törli az interrupt flag-et!
                    // Lépj ki a ciklusból (break), vagy állítsd vissza a flag-et!
                    break;
                    
                }
            }
        };

        // ÉPÍTŐ: 3 épületet húz fel, aztán magától végez
        Runnable epitoFeladat = () -> {
            for (int i = 1; i <= 3; i++) {
                try {
                    Thread.sleep(300);
                    System.out.println("  [Építő] elkészült a(z) " + i + ". épülettel.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // TODO 4: Hozz létre és indíts el 2 bányász szálat ("Banyasz-1", "Banyasz-2") és 1 építő szálat ("Epito-1")!
        Thread t1 = new Thread(banyaszFeladat, "Banyasz-1");
        Thread t2 = new Thread(banyaszFeladat, "Banyasz-2");

        Thread t3 = new Thread(epitoFeladat, "Epito-1");

        t1.start();
        t2.start();
        t3.start();



        // TODO 5: A main szál várja meg (join), amíg az ÉPÍTŐ szál teljesen végez!
        
        t3.join();
        System.out.println("Az építkezés véget ért! Ideje hazaküldeni a bányászokat...");

        // TODO 6: Szakítsd meg (interrupt) mindkét bányász szál futását, majd várd is meg (join), amíg leállnak!
        t1.interrupt();
        t2.interrupt();
        t1.join();
        t2.join();

        System.out.println("Mindenki végzett, a szimuláció leállt.");
    }
}