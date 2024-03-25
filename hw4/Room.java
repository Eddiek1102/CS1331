/**
 * Represents a room in the haunted mansion.
 * @author Eddie Kwak
 * @version 1.0
 */
public class Room {
    private Monster monster;
    private boolean snacks;
    private boolean explored;
    private boolean locked;

    /**
     * Constructor creates a Room object.
     * Initializes monster, snacks, and whether the room has been explored or is locked.
     * @param m Represents the monster in/not in the room.
     * @param s Represents whether there is a Scooby Snack in the room or not.
     */
    public Room(Monster m, boolean s) {
        monster = m;
        snacks = s;
        explored = false;
        locked = false;
    }

    /**
     * Method to check if a room has been previously explored.
     * @return True if room has been explored. False if not.
     */
    public boolean isExplored() {
        if (explored) {
            return true;
        }
        return false;
    }

    /**
     * Method to check whether a room is locked.
     * @return True if room is locked. False if not.
     */
    public boolean isLocked() {
        if (locked) {
            return true;
        }
        return false;
    }

    /**
     * Method that changes the value of snacks boolean instance variable.
     * @param b True if placing a snack. False if removing a snack.
     */
    public void setHasSnacks(boolean b) {
        snacks = b;
    }

    /**
     * Changes monster inside the room.
     * @param m Monster object being placed in the room.
     */
    public void setMonster(Monster m) {
        monster = m;
    }

    /**
     * Getter method for snacks.
     * @return True if snacks in the room, false otherwise.
     */
    public boolean getSnacks() {
        return snacks;
    }

    /**
     * Checks to see if a monster is in the room.
     * @return True if there is a monster in the room, false otherwise.
     */
    public boolean hasMonster() {
        if (monster != null) {
            return true;
        }
        return false;
    }

    /**
     * Getter method for monster inside room.
     * @return Monster object.
     */
    public Monster getMonster() {
        return monster;
    }

    /**
     * Locks the room.
     */
    public void setLock() {
        locked = true;
    }

    /**
     * Marks previously unexplored rooms as explored.
     */
    public void beExplored() {
        if (monster == null && !(snacks)) {
            System.out.println("It doesn't look like there's anything in here...");
        }
        explored = true;
    }
}