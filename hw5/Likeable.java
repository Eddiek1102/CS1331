/**
 * Interface denoting whether an object can receive likes or dislikes.
 * @author Eddie Kwak
 * @version 1.0
 */
public interface Likeable {
    /** Updates internal state to reflect a new like. */
    void like();
    /** Updates internal state to reflect a new dislike. */
    void dislike();
    /**
     * Returns number of likes.
     * @return Number of likes.
     */
    int getLikes();
    /**
     * Returns number of dislikes.
     * @return Number of dislikes.
     */
    int getDislikes();
}