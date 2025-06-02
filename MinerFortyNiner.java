import java.util.Random;

/**
* @author Roshni Daruvuri
* @version March 6 2024
*/
public class MinerFortyNiner extends Monster {
    private Random rand = new Random();

    /**
    * @author Roshni Daruvuri
    */
    public MinerFortyNiner() {
        super(49);
    }

    @Override
    public void haunt(Room[][] houseArray, Player player) {
        player.changeprevColumn(player.getcurColumn());
        player.changeprevRow(player.getcurRow());
        player.changecurColumn(rand.nextInt(houseArray.length));
        player.changecurRow(rand.nextInt(houseArray.length));
        System.out.println("The miner raises its pickaxe and disappears. A hole appears under "
            + player.getName() + " and they fall into another room...");
    }

    @Override
    public String toString() {
        return "Raa! I am a miner monster, named Miner Forty Niner! My fright factor is 49.";
    }

}