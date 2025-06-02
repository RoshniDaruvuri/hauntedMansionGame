/**
* @author Roshni Daruvuri
* @version March 6 2024
*/
public class Player {
    private String name;
    private final int maxCourage = 150;
    private int curCourage;
    private int curColumn;
    private int curRow;
    private int prevColumn;
    private int prevRow;

    /**
    * @author Roshni Daruvuri
    * @param name name of the player
    * @param mansionSize the size that the user inputs to be the mansion size
    */
    public Player(String name, int mansionSize) {
        this.name = name;
        this.curCourage = maxCourage;
        this.curColumn = mansionSize / 2;
        this.curRow = mansionSize / 2;
        this.prevColumn = this.curColumn;
        this.prevRow = this.curRow;
    }

    /**
    * @author Roshni Daruvuri
    * @return provides the player's name
    */
    public String getName() {
        return this.name;
    }

    /**
    * @author Roshni Daruvuri
    * @return returns the current column
    */
    public int getcurColumn() {
        return this.curColumn;
    }

    /**
    * @author Roshni Daruvuri
    * @return returns the current row
    */
    public int getcurRow() {
        return this.curRow;
    }

    /**
    * @author Roshni Daruvuri
    * @return return the previous column
    */
    public int getprevColumn() {
        return this.prevColumn;
    }

    /**
    * @author Roshni Daruvuri
    * @return returns the previous row
    */
    public int getprevRow() {
        return this.prevRow;
    }

    /**
    * @author Roshni Daruvuri
    * @param change takes in a integer to change the current column
    */
    public void changecurColumn(int change) {
        this.curColumn = change;
    }

    /**
    * @author Roshni Daruvuri
    * @param change takes in a integer to change the current row
    */
    public void changecurRow(int change) {
        this.curRow = change;
    }

    /**
    * @author Roshni Daruvuri
    * @param change takes in a integer to change the previous column
    */
    public void changeprevColumn(int change) {
        this.prevColumn = change;
    }

    /**
    * @author Roshni Daruvuri
    * @param change takes in a integer to change the previous row
    */
    public void changeprevRow(int change) {
        this.prevRow = change;
    }

    /**
    * @author Roshni Daruvuri
    * @return returns the current courage score of the player
    */
    public int getcurCourage() {
        return this.curCourage;
    }

    /**
    * @author Roshni Daruvuri
    * @param amount takes in a number by which the courage of the player is going to get subtracted by
    */
    public void frighten(int amount) {
        this.curCourage = this.curCourage - amount;
        if (this.curCourage < 0) {
            this.curCourage = 0;
        }
        System.out.println(this.name + " got scared and lost some courage! "
            + this.curCourage + "/" + this.maxCourage + " remaining...");
    }

    /**
    * @author Roshni Daruvuri
    * @param room takes in the room to check if there are snacks in it
    */
    public void lookForSnacks(Room room) {
        if (room.getSnacks()) {
            room.setHasSnacks(false);
            this.curCourage += 25;
            if (this.curCourage > 150) {
                this.curCourage = 150;
            }
            System.out.println(this.name + " ate a Scooby Snack they found in the room and felt a"
                    + " little more confident. Courage increased to " + this.curCourage + "/" + this.maxCourage);
        }

    }
}