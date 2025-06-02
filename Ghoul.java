/**
* @author Roshni Daruvuri
* @version March 6 2024
*/
public class Ghoul extends Ghost {

    /**
    * @author Roshni Daruvuri
    */
    public Ghoul() {
        super();
    }

    @Override
    public void haunt(Room[][] houseArray, Player player) {
        int tempCol = player.getcurColumn();
        int tempRow = player.getcurRow();
        super.haunt(houseArray, player);
        houseArray[tempRow][tempCol].setLocked();
        System.out.println("The doors slam shut behind "
            + player.getName() + ". It doesn't seem like they can be reopened...");
    }

    @Override
    public String toString() {
        return "Raa! I am a ghoul monster, named Ghoul! My fright factor is 10.";
    }
}