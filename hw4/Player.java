/**
 * Represents the player inside the haunted mansion.
 * @author Eddie Kwak
 * @version 1.0
 */
public class Player {
    private String name;
    private final int maxCourage = 150;
    private int courage;
    private int cRow, cCol;
    private int pRow, pCol;

    /**
     * Constructor creates Player object.
     * @param n Name of player.
     * @param s Dimension of haunted house.
     */
    public Player(String n, int s) {
        name = n;
        courage = maxCourage;
        cRow = (int) Math.floor((int) (s / 2));
        cCol = (int) Math.floor((int) (s / 2));
        pRow = cRow;
        pCol = cCol;
    }

    /**
     * Prompts player to get frightened and lose courage.
     * @param i Amount of courage player will lose.
     */
    public void getFrightened(int i) {
        if (courage - i <= 0) {
            courage = 0;
        } else {
            courage -= i;
        }
        System.out.println(name + " got scared and lost some courage! " + courage + "/" + maxCourage + " remaining...");
    }

    /**
     * Searches room for snacks.
     * @param r Room to be searched.
     */
    public void lookForSnacks(Room r) {
        if (r.getSnacks()) {
            r.setHasSnacks(false);
            if (courage + 25 >= maxCourage) {
                courage = maxCourage;
            } else {
                courage += 25;
            }
            System.out.println(name + " ate a Scooby Snack they found in the room and");
            System.out.println("felt a little more confident. Courage increased to");
            System.out.println(courage + "/" + maxCourage);
        }
    }

    /**
     * Getter method for player name.
     * @return Player's name.
     */
    public String getName() {
        return name;
    }

    /** Void, no args frighten method.
     * @param x amount frightened by
     */
    public void frighten(int x) {
        this.courage -= x;
    }

    /**
     * Setter method for current row.
     * @param r Current row index.
     */
    public void setCRow(int r) {
        cRow = r;
    }

    /**
     * Setter method for previous row.
     * @param r Previous row index.
     */
    public void setPRow(int r) {
        pRow = r;
    }

    /**
     * Setter method for current column.
     * @param c Current column index.
     */
    public void setCCol(int c) {
        cCol = c;
    }

    /**
     * Setter method for previous column.
     * @param c Previous column index.
     */
    public void setPCol(int c) {
        pCol = c;
    }

    /**
     * Getter method for current row.
     * @return Current row index.
     */
    public int getCRow() {
        return cRow;
    }

    /**
     * Getter method for current column.
     * @return Current column index.
     */
    public int getCCol() {
        return cCol;
    }

    /**
     * Getter method for previous row.
     * @return Previous row index.
     */
    public int getPRow() {
        return pRow;
    }

    /**
     * Getter method for previous column.
     * @return Previous column index.
     */
    public int getPCol() {
        return pCol;
    }

    /**
     * Getter method for player's courage.
     * @return Player's courage value.
     */
    public int getCourage() {
        return courage;
    }
}