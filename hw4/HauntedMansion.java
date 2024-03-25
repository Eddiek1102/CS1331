import java.util.Scanner;
/**
 * Represents the Haunted Mansion.
 * @author Eddie Kwak
 * @version 1.0
 */
public class HauntedMansion {
    private String name;
    private Player player;
    private Room[][] rooms;
    private Room goalRoom;
    private Scanner scanner;

    /** Constructor for creating the haunted mansion.
     * @param n Name of mansion.
     * @param p Player object.
     * @param s Scanner object.
     * @param size Dimension of mansion.
     * @param percentMonsters Percent of rooms that will have a monster.
     * @param numSnacks Number of snacks in the mansion.
     */
    public HauntedMansion(String n, Player p, Scanner s, int size, int percentMonsters, int numSnacks) {
        name = n;
        player = p;
        scanner = s;

        rooms = new Room[size][size];

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                rooms[r][c] = new Room(null, false);
            }
        }

        double d = (double) percentMonsters / (double) 100.0;
        int numMonsters = (int) (d * (size * size));
        HauntedHelper helper = new HauntedHelper(rooms);
        goalRoom = helper.selectGoalRoom();
        for (int i = 0; i < numMonsters; i++) {
            helper.placeMonster();
        }

        for (int j = 0; j < numSnacks; j++) {
            helper.placeSnack();
        }
    }

    /** Method indicating that the player has won. */
    public void win() {
        System.out.println("You have reached the goal room.");
        System.out.println("You won!");
    }

    /** Method indicating that the player has lost. */
    public void lose() {
        System.out.println("You ran out of courage.");
        System.out.println("You lost.");
    }

    /**
     * Method for moving player's position.
     * @param s User input for movement (up, down, left, right, or map).
     */
    public void move(String s) {
        if (s.equals("l")) {
            if (player.getCCol() - 1 < 0) {
                System.out.println("There is only a wall in that direction!");
            } else if (rooms[player.getCRow()][player.getCCol() - 1].isLocked()) {
                System.out.println("The room in that direction is locked off!");
            } else {
                player.setPRow(player.getCRow());
                player.setPCol(player.getCCol());
                player.setCRow(player.getCRow());
                player.setCCol(player.getCCol() - 1);
            }
        } else if (s.equals("r")) {
            if (player.getCCol() + 1 > rooms.length - 1) {
                System.out.println("There is only a wall in that direction!");
            } else if (rooms[player.getCRow()][player.getCCol() + 1].isLocked()) {
                System.out.println("The room in that direction is locked off!");
            } else {
                player.setPCol(player.getCCol());
                player.setPRow(player.getCRow());
                player.setCRow(player.getCRow());
                player.setCCol(player.getCCol() + 1);
            }
        } else if (s.equals("u")) {
            if (player.getCRow() - 1 < 0) {
                System.out.println("There is only a wall in that direction!");
            } else if (rooms[player.getCRow() - 1][player.getCCol()].isLocked()) {
                System.out.println("The room in that direction is locked off!");
            } else {
                player.setPRow(player.getCRow());
                player.setPCol(player.getCCol());
                player.setCRow(player.getCRow() - 1);
                player.setCCol(player.getCCol());
            }
        } else if (s.equals("d")) {
            if (player.getCRow() + 1 > rooms.length - 1) {
                System.out.println("There is only a wall in that direction!");
            } else if (rooms[player.getCRow() + 1][player.getCCol()].isLocked()) {
                System.out.println("The room in that direction is locked off!");
            } else {
                player.setPRow(player.getCRow());
                player.setPCol(player.getCCol());
                player.setCRow(player.getCRow() + 1);
                player.setCCol(player.getCCol());
            }
        } else if (s.equals("map")) {
            String map = HauntedHelper.createMansionMap(rooms, player.getCRow(), player.getCCol());
            System.out.println(map);
        } else {
            System.out.println("Not valid. Choose l = left, r = right, u = up, d = down, map = draw map.");
        }
    }

    /** No arguments move.*/
    public void move() {
    }

    /** Method for entering the haunted house. */
    public void enter() {
        System.out.println();
        System.out.print(player.getName() + " enters " + name + ". \nThe halls are ");
        System.out.println("dimly lit and sounds echo from deeper within...");
        System.out.print(player.getName() + " looks behind them only to see the");
        System.out.println(" entrance is gone! \nThey'll have to find a way out...");
        System.out.println();
        while (true) {
            String nextMove = "";

            Room currentRoom = rooms[player.getCRow()][player.getCCol()];
            if (currentRoom == goalRoom) {
                win();
                break;
            }
            if (!(nextMove.equals("map"))) {
                System.out.println(player.getName() + " looks around the room...");
                currentRoom.beExplored();
                player.lookForSnacks(currentRoom);
            }
            if (currentRoom.hasMonster() && !(nextMove.equals("map"))) {
                Monster currentMonster = currentRoom.getMonster();
                currentMonster.frighten(player);
                currentMonster.haunt(rooms, player);
            }

            if (player.getCourage() == 0) {
                lose();
                break;
            }
            System.out.println();
            System.out.println("What's your next move? (l, r, u, d, map)");
            nextMove = scanner.nextLine();
            move(nextMove);
        }
    }
}