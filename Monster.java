/**
* @author Roshni Daruvuri
* @version March 6 2024
*/
public abstract class Monster {

    protected int frightFactor;

    /**
    * @author Roshni Daruvuri
    * @param factor munber by which the frightFactor is changing
    */
    public Monster(int factor) {
        this.frightFactor = factor;
    }

    /**
    * @author Roshni Daruvuri
    * @param player the player variable who is getting frightened
    */
    public void frighten(Player player) {
        System.out.println("Suddenly, something appears in front of " + player.getName() + "!");
        System.out.println(this.toString());
        player.frighten(this.frightFactor);
    }

    /**
    * @author Roshni Daruvuri
    * @return returning a default string for this class
    */
    public String toString() {
        return "Raa! My fright factor is " + this.frightFactor;
    }

    /**
    * @author Roshni Daruvuri
    * @param houseArray the array of rooms in which the player is in (hauntedMansion)
    * @param player the player variable who is getting haunted
    */
    public abstract void haunt(Room[][] houseArray, Player player);
}