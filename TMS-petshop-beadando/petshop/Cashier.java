package petshop;

public class Cashier implements Runnable {
    private PetShop petShop;

    public Cashier(PetShop petShop) {
        this.petShop = petShop;
    }

    @Override
    public void run() {
        // TODO: 1. ismételjük a műveleteket, amíg meg nem szakítják a szálat
        // TODO: 2. vegyük ki a következő fizetési kérelmet a boltból (blokkoló művelet)
        // TODO: 3. dolgozzuk fel a petShop.processCheckout() segítségével
        // TODO: 4. InterruptedException esetén álljunk le (állítsuk vissza a megszakításjelzőt)
    }
}