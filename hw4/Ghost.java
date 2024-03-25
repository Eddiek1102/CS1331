/**
 * Represents Ghost object, a type of Monster.
 * @author Eddie Kwak
 * @version 1.0
 */
public class Ghost extends Monster {
    /** Constructor creating Ghost object.
     * @param x frightfactor.
    */
    public Ghost(int x) {
        frightFactor = x;
    }

    /** Default constructor for Ghost. */
    public Ghost() {
        frightFactor = 10;
    }

    /**
     * Method to haunt player. Prompts player to lose courage.
     * @param r Current room.
     * @param p Player being haunted.
     */
    @Override
    public void haunt(Room[][] r, Player p) {
        p.setCCol(p.getPCol());
        p.setCRow(p.getPRow());
        System.out.println(p.getName() + " is teleported back to where they were before.");
    }

    /**
     * Ghost's toString method.
     * @return A description and spooky greeting.
     */
    public String toString() {
        return "I am a Ghost! BOO!!!";
    }
}