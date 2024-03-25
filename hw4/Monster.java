/**
 * Represents monsters inside the haunted mansion.
 * @author Eddie Kwak
 * @version 1.0
 */
public abstract class Monster {
    /** Object's fright factor. Determines how much courage the player loses. */
    protected int frightFactor;

    /**
     * Constructor for Monster.
     * @param f Frightfactor of monster.
     */
    public Monster(int f) {
        frightFactor = f;
    }

    /**
     * Default constructor for Monsters.
     */
    public Monster() {
    }

    /**
     * Frightens player and promps them to lose courage.
     * @param p The player being frightened.
     */
    public void frighten(Player p) {
        System.out.println("Suddenly, something appears in front of " + p.getName());
        System.out.println(this);
        p.getFrightened(frightFactor);
    }
    /**
     * Haunts players. Every subclass of Monster will include this method.
     * @param r The room the monster is in.
     * @param p The player being haunted.
     */
    public abstract void haunt(Room[][] r, Player p);
}