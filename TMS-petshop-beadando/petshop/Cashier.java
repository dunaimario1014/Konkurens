package petshop;

public class Cashier implements Runnable {
    private PetShop petShop;
    

    public Cashier(PetShop petShop) {
        this.petShop = petShop;
    }

    @Override
    public void run() {
        // TODO: 1. ismételjük a műveleteket, amíg meg nem szakítják a szálat

        while(!Thread.currentThread().isInterrupted()){
            try{
                // TODO: 2. vegyük ki a következő fizetési kérelmet a boltból (blokkoló művelet)
                CheckoutRequest cr = petShop.getNextCheckout();

                // TODO: 3. dolgozzuk fel a petShop.processCheckout() segítségével
                petShop.processCheckout(cr);
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
                break;
            }

        }

        // TODO: 4. InterruptedException esetén álljunk le (állítsuk vissza a megszakításjelzőt)
    }
}