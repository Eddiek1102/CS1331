import java.util.Scanner;
/**
 * The driver program for the Haunted Mansion.
 * @author Eddie Kwak
 * @version 1.0
 */
public class MansionDriver {
    /** Main method for driver program.
     * @param args arguments.
    */
    public static void main(String[] args) {
        String playerName, mansionName;
        int mansionSize, numScoobySnacks;
        int percentMonsters;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter player name: ");
        playerName = scanner.nextLine();

        System.out.print("Enter Mansion Name: ");
        mansionName = scanner.nextLine();

        System.out.print("Enter the mansion's size: ");
        mansionSize = scanner.nextInt();

        System.out.print("What percent of rooms should contain monsters?: ");
        percentMonsters = scanner.nextInt();

        System.out.print("How many scooby snacks should there be?: ");
        numScoobySnacks = scanner.nextInt();
        String temp = scanner.nextLine();
        System.out.print(temp);

        Player newPlayer = new Player(playerName, mansionSize);

        HauntedMansion newMansion;
        newMansion = new HauntedMansion(mansionName, newPlayer, scanner, mansionSize, percentMonsters, numScoobySnacks);

        newMansion.enter();
    }
}