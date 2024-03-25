import java.util.ArrayList;
/**
 * Models a playlist in a music player application.
 * @author Eddie Kwak
 * @version 1.0
 */
public class Playlist implements Likeable, Comparable<Playlist> {
    private String title;
    private User owner;
    private int dateCreated;
    private ArrayList<Song> songs;
    private int duration;
    private int likes;
    private int dislikes;

    /**
     * Getter for title.
     * @return title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for title.
     * @param s New title.
     */
    public void setTitle(String s) {
        if (s.equals(null)) {
            title = "Untitled Playlist";
        } else {
            title = s;
        }
    }

    /**
     * Getter for creation date.
     * @return creation date.
     */
    public int getDateCreated() {
        return dateCreated;
    }

    /**
     * Setter for creation date.
     * @param i New creation date.
     */
    public void setDateCreated(int i) {
        if (i < 0) {
            dateCreated = 0;
        } else {
            dateCreated = i;
        }
    }

    /**
     * Constructor for creating a new playlist.
     * @param t Playlist title.
     * @param o Playlist owner.
     * @param d Playlist creation date.
     */
    public Playlist(String t, User o, int d) {
        if (t.equals(null)) {
            title = "Untitled Playlist";
        } else {
            title = t;
        }
        owner = o;
        if (d < 0) {
            dateCreated = 0;
        } else {
            dateCreated = d;
        }
        songs = new ArrayList<Song>();
        duration = 0;
        likes = 0;
        dislikes = 0;
    }

    /**
     * Adds a song to the playlist.
     * @param s Song being added.
     */
    public void addSong(Song s) {
        if (s == null) {
            return;
        }
        songs.add(s);
        duration += s.getDuration();
    }

    /**
     * Removes song from playlist.
     * @param s Song being removed.
     * @return True if song was removed, false otherwise.
     */
    public boolean removeSong(Song s) {
        for (Song song : songs) {
            if (song.equals(s)) {
                songs.remove(song);
                return true;
            }
        }
        return false;
    }

    /**
     * Gets list of songs in playlist.
     * @return songs ArrayList.
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * Converts song Arraylist to an array.
     * @return Array of songs in playlist.
     */
    public Song[] toArray() {
        Song[] songArray = new Song[songs.size()];
        for (int i = 0; i < songArray.length; i++) {
            songArray[i] = songs.get(i);
        }
        return songArray;
    }

    /**
     * Gets the best and worst song.
     * @return {best song, worst song}.
     */
    public Song[] topAndWorstSong() {
        Song[] topAndWorst = new Song[2];
        topAndWorst[0] = getTopSong();
        topAndWorst[1] = getWorstSong();
        return topAndWorst;
    }

    /**
     * Gets most liked song.
     * @return Most liked song.
     */
    private Song getTopSong() {
        Song topSong = songs.get(0);
        for (int i = 1; i < songs.size(); i++) {
            if (topSong.compareTo(songs.get(i)) == -1) {
                topSong = songs.get(i);
            }
        }
        return topSong;
    }

    /**
     * Gets least liked song.
     * @return Least liked song.
     */
    private Song getWorstSong() {
        Song worstSong = songs.get(0);
        for (int i = 1; i < songs.size(); i++) {
            if (worstSong.compareTo(songs.get(i)) == 1) {
                worstSong = songs.get(i);
            }
        }
        return worstSong;
    }

    /**
     * Returns description of the playlist.
     * @return String representation of description.
     */
    public String toString() {
        String s1 = title + " has " + songs.size() + " songs, is " + duration + " long, has a ";
        String s2 = "like factor of " + (likes - dislikes) + ", ";
        String s3 = "and was created " + dateCreated + " days ";
        String s4 = "after the platform released";
        return s1 + s2 + s3 + s4;
    }

    /**
     * Determines if two playlists are the same.
     * @param o Playlist being compared to.
     * @return True if same, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Playlist)) {
            return false;
        }
        Playlist p = (Playlist) o;
        if (title.equals(p.title) && owner.equals(p.owner) && songs.size() == p.songs.size()
            && duration == p.duration) {
            return true;
        }
        return false;
    }

    /**
     * Compares the creation dates of two plalists.
     * @param p Playlist being compared.
     * @return 1 if current playlist is newer, -1 if older, 0 if same.
     */
    public int compareTo(Playlist p) {
        if (this.dateCreated > p.dateCreated) {
            return 1;
        } else if (this.dateCreated < p.dateCreated) {
            return -1;
        } else {
            return 0;
        }
    }

    /** Updates dislike count of playlist. */
    public void dislike() {
        dislikes++;
    }

    /** Updates like count of playlist. */
    public void like() {
        likes++;
    }

    /**
     * Gets playlist like count.
     * @return Number of likes for playlist.
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Gets playlist dislike count.
     * @return Number of dislikes for playlist.
     */
    public int getDislikes() {
        return dislikes;
    }
}