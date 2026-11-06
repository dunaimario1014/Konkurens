package petshop.customer;

import petshop.PetShop;
import petshop.pet.Pet;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Parent extends Customer {
    private int numberOfChildren;
    private BlockingQueue<Pet> selectedPets;
    private BlockingQueue<Boolean> familyFinished;
    private CountDownLatch goHomeLatch;

    public Parent(String name, PetShop petShop, int numberOfChildren) {
        super(name, petShop);
        this.numberOfChildren = numberOfChildren;
        this.selectedPets = new LinkedBlockingQueue<>();
        this.familyFinished = new LinkedBlockingQueue<>();
        this.choiceLatch = new CountDownLatch(numberOfChildren);
        this.goHomeLatch = new CountDownLatch(1);
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
        try{

            // TODO: 1. lépjünk be a boltba
            petShop.enterShop;
            // TODO: 2. várjuk meg, amíg minden gyerek befejezi a választást
            for (int i = 0; i < numberOfChildren; i++) {
                awaitFamilyFinished();
            }
            // TODO: 3. kérjük le a kiválasztott állatokat
            List<Pet> chosenPets = new ArrayList<>();

            for (int i = 0; i < numberOfChildren; i++) {
                Pet pet = selectedPets.take();
                chosenPets.add(pet);
            }
            // TODO: 4. küldjük el a fizetési kérelmeket
            for(Pet pet : selectedPets){
                pestShop.CheckoutRequest(this, pet);
            }
            // TODO: 5. jelezzük a gyerekeknek, hogy indulhatnak haza
            goHomeLatch.countDown();
            // TODO: 6. hagyjuk el a boltot
            petShop.leaveShop();
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}