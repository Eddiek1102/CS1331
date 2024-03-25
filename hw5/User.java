import java.util.ArrayList;
/**
 * Represents a user of the music player application.
 * @author Eddie Kwak
 * @version 1.0
 */
public class User {
    private String username;
    private ArrayList<Playlist> library;
    private Song currentPlaying;

    /**
     * Constructor that creates a User.
     * @param u User's username.
     */
    public User(String u) {
        if (u.equals(null)) {
            username = "";
        } else {
            username = u;
        }
        Playlist liked = new Playlist("Liked", this, 0);
        library = new ArrayList<Playlist>();
        library.add(liked);
    }

    /**
     * Getter for user's library.
     * @return Arraylist with playlists.
     */
    public ArrayList<Playlist> getLibrary() {
        return library;
    }

    /**
     * Creates a new playlist and adds it to user's library.
     * @param s Playlist title.
     * @param a Date created.
     */
    public void createPlaylist(String s, int a) {
        if (getPlaylist(s) == null) {
            Playlist p = new Playlist(s, this, a);
            for (int i = 0; i < library.size(); i++) {
                if (p.compareTo(library.get(i)) != 1) {
                    library.add(i, p);
                    return;
                }
            }

            library.add(p);
        }
        return;
    }
    /**
     * Removes playlist from library.
     * @param p Playlist to be removed.
     * @return True if removed, false otherwise.
     */
    /*
    public boolean removePlaylist(Playlist p) {
        for (int i = 1; i < library.size(); i++) {
            if (p.equals(library.get(i))) {
                library.remove(i);
                return true;
            }
        }
        return false;
    }
    */

    /**
     * Remvoe playlist from library.
     * @param s Name of playlist.
     * @return True if removed, false otherwise.
     */
    public boolean removePlaylist(String s) {
        for (int i = 1; i < library.size(); i++) {
            if (s.equals(library.get(i).getTitle())) {
                library.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Likes song and adds it to Liked playlist.
     * @param s Song to be liked.
     */
    public void likeSong(Song s) {
        Playlist likedPlaylist = library.get(0);
        for (int i = 0; i < likedPlaylist.getSongs().size(); i++) {
            if (likedPlaylist.getSongs().get(i).equals(s)) {
                return;
            }
        }
        likedPlaylist.addSong(s);
        s.like();
    }

    /**
     * Updates dislike count for a song.
     * @param s Song being disliked.
     */
    public void dislikeSong(Song s) {
        s.dislike();
    }

    /**
     * Updates like count on playlist.
     * @param p Playlist being liked.
     */
    public void likePlaylist(Playlist p) {
        p.like();
    }

    /**
     * Updates dislike on playlist.
     * @param p Playlist being disliked.
     */
    public void dislikePlaylist(Playlist p) {
        p.dislike();
    }

    /**
     * Shares palylist with another use.
     * @param u User to share with.
     * @param index Index of playlist being shared.
     */
    public void sharePlaylist(User u, int index) {
        Playlist toShare = this.library.get(index);
        u.addPlaylist(toShare);
    }

    /**
     * Plays a song.
     * @param s Song.
     */
    public void playSong(Song s) {
        currentPlaying = s;
    }

    /** Pauses song being played. */
    public void pauseSong() {
        currentPlaying = null;
    }

    /**
     * User's toString.
     * @return Description of user.
     */
    public String toString() {
        if (currentPlaying == null) {
            return username + " is idle";
        }
        String s1 = username + " is listening to " + currentPlaying.getTitle() + ", Duration: ";
        String s2 = currentPlaying.getDuration() + ", Likes: " + currentPlaying.getLikes() + ", Dislikes: ";
        String s3 = currentPlaying.getDislikes() + "";
        return s1 + s2 + s3;
    }

    //- If the User is currently listening to a song, returns:
    // {username} is listening to {song_title}, Duration:
    //{song_duration}, Likes: {song_likes}, Dislikes:
    //{song_dislikes}
    //- If the User isn’t listening to a song, returns:
    // {username} is idle

    /**
     * Adds a playlist to library.
     * @param p Playlist being added.
     * @return True if overwritten. False otherwise.
     */
    public boolean addPlaylist(Playlist p) {
        boolean overwrite = false;
        for (int i = 1; i < library.size(); i++) {
            Playlist temp = library.get(i);
            if (temp.getTitle().equals(p.getTitle())) {
                library.remove(i);
                overwrite = true;
                break;
            }
        }
        for (int j = 0; j < library.size(); j++) {
            if (p.compareTo(library.get(j)) < 1) {
                library.add(j, p);
                return overwrite;
            }
        }
        library.add(p);
        return overwrite;
    }

    /**
     * Returns playlist.
     * @param s Title of playlist.
     * @return Playlist or null.
     */
    public Playlist getPlaylist(String s) {
        for (int i = 1; i < library.size(); i++) {
            if (library.get(i).getTitle().equals(s)) {
                return library.get(i);
            }
        }
        return null;
    }
}