/**
 * Represents a song in the music application.
 * @author Eddie Kwak
 * @version 1.0
 */
public class Song implements Likeable, Comparable<Song> {
    private String title;
    private int duration;
    private int likes;
    private int dislikes;

    /**
     * Constructor to create a song.
     * @param t Title of song.
     * @param d Duration of song.
     */
    public Song(String t, int d) {
        if (t.equals(null)) {
            title = "Untitled Song";
        } else {
            title = t;
        }
        if (d < 0 || d > 10) {
            duration = 5;
        } else {
            duration = d;
        }
        likes = 0;
        dislikes = 0;
    }

    /**
     * Compares the likeness of two songs.
     * @param s The song being compared to.
     * @return 1 = this.song >, -1 = this.song <, 0 means they're equal.
     */
    public int compareTo(Song s) {
        int thisLikeFactor = this.likes - this.dislikes;
        int sLikeFactor = s.likes - s.dislikes;

        if (thisLikeFactor > sLikeFactor) {
            return 1;
        } else if (thisLikeFactor < sLikeFactor) {
            return -1;
        } else {
            return 0;
        }
    }
    /**
     * Compares two songs.
     * @param o Song to be compared.
     * @return True if same, false otherwise.
    */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Song)) {
            return false;
        }
        Song s = (Song) o;
        if (title.equals(s.title) && duration == s.duration && likes == s.likes && dislikes == s.dislikes) {
            return true;
        }
        return false;
    }

    /**
     * Return's description of a song.
     * @return Song's description.
     */
    public String toString() {
        return title + ", Duration: " + duration + ", Likes: " + likes + ", Dislikes: " + dislikes;
    }

    /** Increments the like value of song. */
    public void like() {
        likes++;
    }

    /** Increments the dislike value of song.*/
    public void dislike() {
        dislikes++;
    }

    /**
     * Returns likes value of song.
     * @return Number of likes.
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Returns dislikes value of song.
     * @return Number of dislikes.
     */
    public int getDislikes() {
        return dislikes;
    }

    /**
     * Changes the title of a song.
     * @param s New title of song.
     */
    public void setTitle(String s) {
        if (s.equals(null)) {
            this.title = "Untitled Song";
        } else {
            this.title = s;
        }
    }

    /**
     * Return's title of song.
     * @return Title of song.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Changes the duration of song.
     * @param i New duration of song.
     */
    public void setDuration(int i) {
        if (i < 0 || i > 10) {
            this.duration = 5;
        } else {
            this.duration = i;
        }
    }

    /**
     * Returns duration of song.
     * @return Duration of song.
     */
    public int getDuration() {
        return duration;
    }
}