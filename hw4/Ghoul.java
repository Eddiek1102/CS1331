/**
 * Represents a Ghoul, a type of Ghost.
 * @author Eddie Kwak
 * @version 1.0
 */
public class Ghoul extends Ghost {
    /** Constructor for creating Ghoul objects.
     *  @param x frightfactor.
     */
    public Ghoul(int x) {
        super(x);
    }

    /** Default constructor for Ghouls. */
    public Ghoul() {
        super();
    }

    /**
     * Haunts player and prompts them to lose points.
     * @param r Current room.
     * @param p Player being haunted.
     */
    @Override
    public void haunt(Room[][] r, Player p) {
        r[p.getCRow()][p.getCCol()].setLock();
        super.haunt(r, p);

        System.out.print("The doors slam shut behind " + p.getName() + ". It doesn't seem");
        System.out.println(" like they can be reopened...");
    }

    /**
     * Ghoul's toString method.
     * @return A description and a spooky greeting.
     */
    public String toString() {
        return "I'm a Ghoul. Boo Hooooooo!";
    }
}