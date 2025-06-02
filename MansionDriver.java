import java.util.Scanner;

/**
* @author Roshni Daruvuri
* @version March 6 2024
*/
public class MansionDriver {
    /**
    * @author Roshni Daruvuri
    * @param args takes in any command line arguments that the user gives
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the player's name:");
        String namePlayer = scan.next();
        System.out.println("Enter the size for the haunted mansion:");
        int mansionSize = scan.nextInt();
        System.out.println("Enter the percentage of rooms which should contain monsters (out of 100):");
        int percentage = scan.nextInt();
        System.out.println("Enter the number of rooms which should have Scooby Snacks:");
        int snacks = scan.nextInt();
        Player playerOne = new Player(namePlayer, mansionSize);
        HauntedMansion mansionOne = new HauntedMansion("mansionOne", playerOne, scan, mansionSize, percentage, snacks);
        mansionOne.enter();
    }
}