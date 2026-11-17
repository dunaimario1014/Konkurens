import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BarberShop {
    private static final int WAITING_ROOM_SIZE = 5;
    private static final int MAX_CUSTOMERS = 30;

    private static Set<Customer> waitingRoom = new HashSet<>();
    private static boolean open = true;

    private static final Lock shopLock = new ReentrantLock();
    private static final Condition barberSleepingCondition = shopLock.newCondition();

    private static class Barber extends Thread {
        private boolean awake = true;

        public boolean isAwake() {
            return awake;
        }

        @Override
        public void run() {
            while(open) {
                Customer nextCustomer = null;

                shopLock.lock();
                try {
                    if (!waitingRoom.isEmpty()) {
                        nextCustomer = waitingRoom.iterator().next();
                        waitingRoom.remove(nextCustomer);
                    } else {
                        // TODO: Sleep until next customer arrives.
                        awake = false;
                        try {
                            barberSleepingCondition.await();
                        } catch (InterruptedException e) {
                            System.err.println("Barber: Oh! I am fired!");
                            return;
                        }
                        awake = true;
                    }
                } finally {
                    shopLock.unlock();
                }

                if (nextCustomer != null) {
                    System.out.println("Barber: Cutting hair of customer " + nextCustomer.getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println("Barber: Oh! I am fired!");
                        return;
                    }
                    System.out.println("Barber: Hair of customer " + nextCustomer.getName() + " is cut.");
                }
            }
        }
    }

    private static Barber barber = new Barber();

    private static class Customer extends Thread {
        public Customer(String name) {
            setName(name);
        }

        @Override
        public void run() {
            shopLock.lock();
            try {
                if (waitingRoom.size() < WAITING_ROOM_SIZE) {
                    System.err.println("                                                  "
                            + getName() + ": Sitting in the waiting room.");
                    waitingRoom.add(this);
                    
                    // TODO: Wake up the barber if he is sleeping.
                    if (!barber.isAwake()) {
                        barberSleepingCondition.signal();
                    }
                } else {
                    System.err.println("                                                  "
                            + getName() + ": Leaving.");
                }
            } finally {
                shopLock.unlock();
            }
        }
    }

    public static void main(String args[]) {
        Random rand = new Random();
        
        barber.start();
        for (int i = 0; i < MAX_CUSTOMERS; ++i) {
            Customer customer = new Customer("Customer" + i);
            customer.start();
            try {
                Thread.sleep(rand.nextInt(2500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        open = false;
        try {
            Thread.sleep(rand.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        barber.interrupt();
    }
}