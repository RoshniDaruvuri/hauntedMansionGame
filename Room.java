/**
 * @author Roshni Daruvuri
 * @version March 6 2024
 */
public class Room {
    private Monster mon;
    private boolean snacks;
    private boolean explored = false;
    private boolean locked = false;

    /**
    * @author Roshni Daruvuri
    * @param monster inputting a monster type
    * @param snack inputting a boolean for snack
    */
    public Room(Monster monster, boolean snack) {
        this.mon = monster;
        this.snacks = snack;
    }

    /**
    * @author Roshni Daruvuri
    * @param snack inputting a boolean for snack
    */
    public Room(boolean snack) {
        this(null, snack);
    }

    /**
    * @author Roshni Daruvuri
    * @return returns a boolean to check if it's explored
    */
    public boolean isExplored() {
        return this.explored;
    }

    /**
    * @author Roshni Daruvuri
    * @return returns a boolean to see if the room is locked
    */
    public boolean isLocked() {
        return this.locked;
    }

    /**
    * @author Roshni Daruvuri
    */
    public void setLocked() {
        this.locked = true;
    }

    /**
    * @author Roshni Daruvuri
    * @param hasSnacks inputs a boolean to update the snacks boolean
    */
    public void setHasSnacks(boolean hasSnacks) {
        this.snacks = hasSnacks;
    }

    /**
    * @author Roshni Daruvuri
    * @return retruns a boolean to see if the room has snacks
    */
    public boolean getSnacks() {
        return this.snacks;
    }

    /**
    * @author Roshni Daruvuri
    * @param monster inputs a monster variable to update the monster in the room
    */
    public void setMonster(Monster monster) {
        this.mon = monster;
    }

    /**
    * @author Roshni Daruvuri
    * @return returns the monster in the room
    */
    public Monster getMonster() {
        return this.mon;
    }

    /**
    * @author Roshni Daruvuri
    */
    public void beExplored() {
        this.explored = true;
        if ((this.mon == null) && (!this.snacks)) {
            System.out.println("It doesn't look like there's anything here...");
        }
    }
}