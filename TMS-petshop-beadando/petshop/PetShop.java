package petshop;

import petshop.pet.Pet;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class PetShop {
    private AtomicInteger currentVisitors;
    private int revenue;
    private ConcurrentLinkedQueue<Pet> pets;
    private BlockingQueue<CheckoutRequest> checkoutQueue;

    public PetShop() {
        this.currentVisitors = new AtomicInteger(0);
        this.revenue = 0;
        this.pets = new ConcurrentLinkedQueue<>();
        this.checkoutQueue = new LinkedBlockingQueue<>();
    }

    public void addPet(Pet pet) {
        // TODO: adjuk hozzá az állatot a pets sorhoz
    }

    public Pet getRandomPet() {
        // TODO: adjunk vissza egy véletlenszerű állatot, vagy null-t, ha nincs elérhető állat
        return null;
    }

    public void enterShop() {
        // TODO: növeljük a látogatók számát
    }

    public void leaveShop() {
        // TODO: csökkentsük a látogatók számát
    }

    public int getCurrentVisitors() {
        // TODO: adjuk vissza az aktuális látogatók számát
        return 0;
    }

    public void goToCheckout(CheckoutRequest request)
            throws InterruptedException {
        // TODO: adjuk hozzá a fizetési kérelmet a blokkoló sorhoz
    }

    public CheckoutRequest getNextCheckout()
            throws InterruptedException {
        // TODO: kérjük le a következő fizetési kérelmet
        return null;
    }

    public synchronized void processCheckout(CheckoutRequest request) {
        // TODO: 1. határozzuk meg az állat árát
        // TODO: 2. frissítsük a bevételt
        // TODO: 3. írjuk ki a tranzakció adatait
    }

    public synchronized int getRevenue() {
        return revenue;
    }
}