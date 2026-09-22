package gyakorlo_feladat;

/**
 * Resources used by ThreadCraft
 *
 * Includes goldmine capacity, gold owned by the player, houses built by the player
 * All the actions manipulating these stats should be implemented here
 */
public class Resources {

    private int goldmineCapacity = Configuration.GOLDMINE_CAPACITY;
    private int gold = 0;
    private int houses = 0;

    /**
     * If the goldmine hasn't run out yet, mines some gold
     * and adds it to the gold resource
     * @return Whether mining has been successful or not
     */
    public boolean tryToMineGold(){
        if (goldmineCapacity > 0) {
            goldmineCapacity -= Configuration.MINING_AMOUNT;
            gold += Configuration.MINING_AMOUNT;
            return true;
        }
        return false;
    }

    /**
     * Returns number of houses built
     * @return
     */
    public int getHouses() {
        return houses;
    }

    /**
     * If there is enough gold to build a house, it does
     * Increments number of houses, removes the cost from gold
     * @return Whether building was successful or not
     */
    public boolean tryToBuildHouse() {
        if (gold >= Configuration.HOUSE_COST) {
            houses++;
            gold -= Configuration.HOUSE_COST;
            return true;
        }
        return false;
    }

    /**
     * Returns gold owned by the player
     * @return
     */
    public int getGold(){
        return gold;
    }

    /**
     * Return how much gold can be mined from the mine
     * @return
     */
    public int getGoldmineCapacity(){
        return goldmineCapacity;
    }

}