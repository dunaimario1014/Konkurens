package petshop.pet;
import java.util.concurrent.ThreadLocalRandom;
import petshop.State;

public abstract class Pet implements Runnable {
    protected String name;
    protected int age;
    protected State state;
    protected boolean needsFood, needsWater, isSelected;

    public Pet(String name, int age, State state) {
        this.name = name;
        this.age = age;
        this.state = state;
    }

    public abstract int getPrice();

    public synchronized String getName() {
        return name;
    }

    public synchronized int getAge() {
        return age;
    }

    public synchronized State getState() {
        return state;
    }

    public synchronized boolean isNeedsFood() {
        return needsFood;
    }

    public synchronized boolean isNeedsWater() {
        return needsWater;
    }

    public synchronized boolean isSelected() {
        return isSelected;
    }

    public synchronized boolean select() {
        // TODO: csak az első kiválasztáskor adjunk vissza igaz értéket
        if(!isSelected){
            isSelected = true;
            return true;
        }

        return false;
    }

    @Override
    public void run() {
        
        while(!Thread.currentThread().isInterrupted()){
            int rand = ThreadLocalRandom.current().nextInt(2000,5001);
            State[] values = State.values();
            State randomState = values[ThreadLocalRandom.current().nextInt(values.length)];
        
            try{
                Thread.sleep(rand);
            } catch(InterruptedException e){
                System.out.println("Interrupted");
                Thread.currentThread().interrupt();
                break;
            }

            synchronized(this){
                this.needsFood = ThreadLocalRandom.current().nextBoolean();
                this.needsWater = ThreadLocalRandom.current().nextBoolean();
                this.state = randomState;
            }


        }
        // TODO: 1. módosítsuk az állapotot és a szükségleteket
        // TODO: 2. várjunk 2-5 másodpercet (Thread.sleep + ThreadLocalRandom)
        // TODO: 3. kezeljük a megszakítást és a leállást
    }

    @Override
    public String toString() {
        // TODO: jelenítsük meg a nevet és az életkort
        return "Név:" + this.getName() + " | Életkor:" + this.getAge();
    }
}