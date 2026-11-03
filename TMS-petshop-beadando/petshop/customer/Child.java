package petshop.customer;

import petshop.pet.Pet;

public class Child extends Customer {
    private Parent parent;

    public Child(String name, Parent parent) {
        super(name, parent.getPetShop());
        this.parent = parent;
    }

    @Override
    public void run() {
        try {
            // TODO: 1. lépjen be a boltba
            // TODO: 2. nézelődjön 1-3 másodpercig
            // TODO: 3. válasszon egy elérhető állatot
            Pet selectedPet = null;
            // TODO: 4. sikeres választás esetén: parent.addSelectedPet(selectedPet);
        } finally {
            // TODO: 5. jelezze a szülőnek, hogy befejezte a választást
            // TODO: 6. várja meg, amíg a szülő engedélyezi a család távozását
            // TODO: 7. lépjen ki a boltból
        }
    }
}