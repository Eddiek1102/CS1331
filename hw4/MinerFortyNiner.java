import java.util.Random;
/**
 * Represents the Miner Forty Niner, a type of Monster.
 * @author Eddie Kwak
 * @version 1.0
 */
public class MinerFortyNiner extends Monster {
    /** Constructor for the Miner Forty Niner. */
    public MinerFortyNiner() {
        frightFactor = 49;
    }

    /** Single argument constructor for the Minor Forty Niner.
     * @param x frightfactor.
    */
    public MinerFortyNiner(int x) {
        frightFactor = x;
    }

    /**
     * Haunts player. Prompts them to lose courage.
     * @param r Current room.
     * @param p Player being haunted.
     */
    @Override
    public void haunt(Room[][] r, Player p) {
        p.setPCol(p.getCCol());
        p.setPRow(p.getCRow());

        Random random = new Random();

        p.setCRow(random.nextInt(r.length - 1) + 1);
        p.setCCol(random.nextInt(r.length - 1) + 1);

        System.out.print("The Miner Forty Niner raises its pickaxe and ");
        System.out.print("disappears. A whole appears under " + p.getName() + " and");
        System.out.println(" they fall into another room...");
    }

    /** Returns object's toString.
     * @return A description and spooky greeting.
    */
    public String toString() {
        return "I'm the Miner Forty Niner. RAWRR!";
    }
}