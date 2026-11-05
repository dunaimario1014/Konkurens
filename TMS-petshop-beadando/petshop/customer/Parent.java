package petshop.customer;

import petshop.PetShop;
import petshop.pet.Pet;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Parent extends Customer {
    private int numberOfChildren;
    private BlockingQueue<Pet> selectedPets;
    private BlockingQueue<Boolean> familyFinished;

    public Parent(String name, PetShop petShop, int numberOfChildren) {
        super(name, petShop);
        this.numberOfChildren = numberOfChildren;
        this.selectedPets = new LinkedBlockingQueue<>();
        this.familyFinished = new LinkedBlockingQueue<>();
    }

    public void addSelectedPet(Pet pet) throws InterruptedException {
        // TODO: helyezzük az állatot a selectedPets sorba
        selectedPets.add(pet);
    }

    public void awaitFamilyFinished() throws InterruptedException {
        // TODO: vegyünk ki egy tokent a familyFinished sorból
        familyFinished.take();
    }

    @Override
    public void run() {
        // TODO: 1. lépjünk be a boltba
        petShop.enterShop;
        // TODO: 2. várjuk meg, amíg minden gyerek befejezi a választást
        for (int i = 0; i < numberOfChildren; i++) {
            awaitFamilyFinished();
        }
        // TODO: 3. kérjük le a kiválasztott állatokat
        // TODO: 4. küldjük el a fizetési kérelmeket
        // TODO: 5. jelezzük a gyerekeknek, hogy indulhatnak haza
        // TODO: 6. hagyjuk el a boltot
    }
}