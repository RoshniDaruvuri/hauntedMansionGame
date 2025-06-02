import java.util.Scanner;

/**
* @author Roshni Daruvuri
* @version March 6 2024
*/
public class HauntedMansion {
    private String name;
    private Player player;
    private Scanner scan; //should you put scanner in parameters
    private Room[][] houseArray;
    private Room goalRoom;
    private final HauntedHelper helper;

    /**
    * @author Roshni Daruvuri
    * @param name takes in the mansion's name
    * @param player takes in a player that's in the mansion
    * @param scan takes in a scanner variable
    * @param size takes in one dimension of the mansion
    * @param percentage  takes in the percentage of the rooms that have monsters
    * @param numSnacks takes in the amount of rooms with scooby snacks
    */
    public HauntedMansion(String name, Player player, Scanner scan, int size, int percentage, int numSnacks) {
        this.name = name;
        this.player = player;
        this.scan = scan;
        this.houseArray = new Room[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Room room = new Room(false);
                houseArray[i][j] = room;
            }
        }
        helper = new HauntedHelper(this.houseArray);
        this.goalRoom = helper.selectGoalRoom();

        for (int i = 0; i < (int) ((((double) percentage / 100) * size * size)); i++) {
            helper.placeMonster();
        }

        for (int i = 0; i < numSnacks; i++) {
            helper.placeSnack();
        }
    }

    /**
    * @author Roshni Daruvuri
    */
    public void win() {
        System.out.println("You won!");
    }

    /**
    * @author Roshni Daruvuri
    */
    public void lose() {
        System.out.println("You lost...Try again");
    }

    /**
    * @author Roshni Daruvuri
    */
    public void move() {
        String input;
        System.out.println("Choose your next move!: l (left), r (right), u (up), d (down), or choose map");
        input = scan.next();
        if (input.equals("u")) {
            if (((player.getcurRow() - 1) < 0)) {
                System.out.println("There is only a wall in that direction!");
                move();
            } else if (this.houseArray[player.getcurRow() - 1][player.getcurColumn()].isLocked()) {
                System.out.println("The room in that direction is locked off!");
                move();
            } else {
                player.changeprevColumn(player.getcurColumn());
                player.changeprevRow(player.getcurRow());
                player.changecurRow(player.getcurRow() - 1);
                //System.out.println(player.getcurRow());
                //System.out.println(player.getcurColumn());
                //System.out.println(HauntedHelper.createFullMansionMap(this.houseArray, this.goalRoom));
            }
        } else if (input.equals("l")) {
            if (((player.getcurColumn() - 1) < 0)) {
                System.out.println("There is only a wall in that direction!");
                move();
            } else if (this.houseArray[player.getcurRow()][player.getcurColumn() - 1].isLocked()) {
                System.out.println("The room in that direction is locked off!");
                move();
            } else {
                player.changeprevColumn(player.getcurColumn());
                player.changeprevRow(player.getcurRow());
                player.changecurColumn(player.getcurColumn() - 1);
                //System.out.println(player.getcurRow());
                //System.out.println(player.getcurColumn());
                //System.out.println(HauntedHelper.createFullMansionMap(this.houseArray, this.goalRoom));
            }
        } else if (input.equals("r")) {
            if (((player.getcurColumn() + 1) >= this.houseArray.length)) {
                System.out.println("There is only a wall in that direction!");
                move();
            } else if (this.houseArray[player.getcurRow()][player.getcurColumn() + 1].isLocked()) {
                System.out.println("The room in that direction is locked off!");
                move();
            } else {
                player.changeprevColumn(player.getcurColumn());
                player.changeprevRow(player.getcurRow());
                player.changecurColumn(player.getcurColumn() + 1);
                //System.out.println(player.getcurRow());
                //System.out.println(player.getcurColumn());
                //System.out.println(HauntedHelper.createFullMansionMap(this.houseArray, this.goalRoom));
            }
        } else if (input.equals("d")) {
            if (((player.getcurRow() + 1) >= this.houseArray.length)) {
                System.out.println("There is only a wall in that direction!");
                move();
            } else if (this.houseArray[player.getcurRow() + 1][player.getcurColumn()].isLocked()) {
                System.out.println("The room in that direction is locked off!");
                move();
            } else {
                player.changeprevColumn(player.getcurColumn());
                player.changeprevRow(player.getcurRow());
                player.changecurRow(player.getcurRow() + 1);
                //System.out.println(player.getcurRow());
                //System.out.println(player.getcurColumn());
                //System.out.println(HauntedHelper.createFullMansionMap(this.houseArray, this.goalRoom));
            }
        } else if (input.equals("map")) {
            System.out.println(HauntedHelper.createMansionMap(
                this.houseArray, player.getcurRow(), player.getcurColumn()));
            move();
        } else {
            System.out.print("Invalid input! ");
            move();
        }
    }

    /**
    * @author Roshni Daruvuri
    */
    public void enter() {
        System.out.println(player.getName() + " enters " + this.name
            + ". The halls are dimly lit and sounds echo from deeper withing... "
            + player.getName()
            + " looks behind them only to see this entrance is gone! They'll have to find a way out...");
        while (player.getcurCourage() > 0) {
            Room curRoom = this.houseArray[player.getcurRow()][player.getcurColumn()];
            System.out.println(player.getName() + " looks around the room...");
            if (curRoom == this.goalRoom) {
                break;
            }
            curRoom.beExplored();
            player.lookForSnacks(curRoom);
            if (curRoom.getMonster() != null) {
                curRoom.getMonster().frighten(this.player);
                curRoom.getMonster().haunt(this.houseArray, this.player);
                //System.out.println(player.getcurRow());
                //System.out.println(player.getcurColumn());
            } else {
                move();
            }

        }

        if (player.getcurCourage() > 0) {
            win();
        } else {
            lose();
        }
    }
}