/**
* @author Roshni Daruvuri
* @version March 6 2024
*/
public class Ghost extends Monster {

    /**
    * @author Roshni Daruvuri
    */
    public Ghost() {
        super(10);
    }

    @Override
    public void haunt(Room[][] houseArray, Player player) {
        player.changecurColumn(player.getprevColumn());
        player.changecurRow(player.getprevRow());
        System.out.println(player.getName() + " is teleported back to where they were before.");
    }

    @Override
    public String toString() {
        return "Raa! I am a ghost monster, named Ghost! My fright factor is 10.";
    }
}