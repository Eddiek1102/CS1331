/**
 * Driver program for music player application.
 * @author Eddie Kwak
 * @version 1.0
 */
public class MusicPlayer {
    /**
     * Main.
     * @param args Arguments.
     */
    public static void main(String[] args) {
        /** First user. */
        User stasko = new User("JohnStaskoCS1331");
        /** Second user. */
        User eddie = new User("EddieKwakECE");
        /** First playlist. */
        Playlist playlist1 = new Playlist("First Playlist", stasko, 1);
        /** Second playlist. */
        Playlist playlist2 = new Playlist("Second Playlist", eddie, 2);
        /** third playlist. */
        Playlist playlist3 = new Playlist("Third Playlist", stasko, 3);
        stasko.addPlaylist(playlist1);
        stasko.addPlaylist(playlist3);
        eddie.addPlaylist(playlist2);
        /** First song. */
        Song song1 = new Song("First Song", 1);
        /** Second song. */
        Song song2 = new Song("Second Song", 2);
        /** Third song. */
        Song song3 = new Song("Third Song", 3);
        /** Fourth song. */
        Song song4 = new Song("Fourth Song", 4);
        /** Fifth song. */
        Song song5 = new Song("Fifth Song", 5);
        /** Sixth song. */
        Song song6 = new Song("Sixth Song", 6);
        /** Seventh song. */
        Song song7 = new Song("Seventh Song", 7);
        /** Eighth song. */
        Song song8 = new Song("Eighth Song", 8);
        /** Ninth song. */
        Song song9 = new Song("Ninth Song", 9);
        // Adding songs to playlist 1
        playlist1.addSong(song1);
        playlist1.addSong(song2);
        playlist1.addSong(song3);
        // Adding songs to playlist 2
        playlist2.addSong(song4);
        playlist2.addSong(song5);
        playlist2.addSong(song6);
        // Adding songs to playlist 3
        playlist3.addSong(song7);
        playlist3.addSong(song8);
        playlist3.addSong(song9);
        // Liking and disliking songs
        stasko.dislikeSong(song3);
        stasko.likeSong(song1);
        stasko.likeSong(song2);
        stasko.dislikeSong(song3);
        eddie.likeSong(song1);
        eddie.dislikeSong(song3);
        eddie.dislikeSong(song3);
        stasko.likeSong(song4);
        stasko.likeSong(song5);
        stasko.likeSong(song6);
        eddie.dislikeSong(song4);
        eddie.dislikeSong(song4);
        eddie.dislikeSong(song4);
        stasko.likeSong(song7);
        stasko.dislikeSong(song8);
        stasko.likeSong(song9);
        eddie.likeSong(song9);
        eddie.dislikeSong(song7);
        eddie.dislikeSong(song8);
        eddie.dislikeSong(song8);
        // Liking and disliking playlists
        stasko.likePlaylist(playlist1);
        stasko.likePlaylist(playlist2);
        eddie.likePlaylist(playlist2);
        eddie.dislikePlaylist(playlist3);
        stasko.dislikePlaylist(playlist3);
        // Printing all songs in playlist
        System.out.println("--------------------------------------");
        System.out.println("**toString of all songs in playlist 1**");
        Song[] songArray1 = playlist1.toArray();
        for (Song s : songArray1) {
            System.out.println(s);
        }
        System.out.println("--------------------------------------");
        System.out.println("**toString of all songs in playlist 2**");
        Song[] songArray2 = playlist2.toArray();
        for (Song s : songArray2) {
            System.out.println(s);
        }
        System.out.println("--------------------------------------");
        System.out.println("**toString of all songs in playlist 3**");
        Song[] songArray3 = playlist3.toArray();
        for (Song s : songArray3) {
            System.out.println(s);
        }
        System.out.println("--------------------------------------");
        System.out.println("**Top and worst song for playlist 1**");
        for (Song s : playlist1.topAndWorstSong()) {
            System.out.println(s);
        }
        System.out.println("--------------------------------------");
        System.out.println("**Top and worst song for playlist 2**");
        for (Song s : playlist2.topAndWorstSong()) {
            System.out.println(s);
        }
        System.out.println("--------------------------------------");
        System.out.println("**Top and worst song for playlist 3**");
        for (Song s : playlist3.topAndWorstSong()) {
            System.out.println(s);
        }
        // Sharing playlists
        System.out.println("--------------------------------------");
        System.out.println("**Stasko's Library before sharing (titles only)**");
        for (Playlist p : stasko.getLibrary()) {
            System.out.println(p.getTitle());
        }
        eddie.sharePlaylist(stasko, 1);
        stasko.sharePlaylist(eddie, 1);
        System.out.println("--------------------------------------");
        System.out.println("**Stasko's Library after Eddie shares playlist 2 (titles only)**");
        for (Playlist p : stasko.getLibrary()) {
            System.out.println(p.getTitle());
        }
        System.out.println("--------------------------------------");
        System.out.println("**Calling toString() for all playlists**");
        System.out.println(playlist1);
        System.out.println(playlist2);
        System.out.println(playlist3);
        System.out.println("--------------------------------------");
        System.out.println("**Stasko will start listening to a song 3**");
        stasko.playSong(song3);
        System.out.println(stasko);
        System.out.println("--------------------------------------");
        System.out.println("**Stasko will pause the song**");
        stasko.pauseSong();
        System.out.println(stasko);
        System.out.println("--------------------------------------");
        System.out.println("**Playlists in Stasko's library BEFORE removing playlists 1 and 3**");
        for (Playlist p : stasko.getLibrary()) {
            System.out.println(p.getTitle());
        }
        System.out.println("--------------------------------------");
        System.out.println("**Playlists in Stasko's library AFTER removing playlists 1 and 3**");
        stasko.removePlaylist(playlist1.getTitle());
        stasko.removePlaylist(playlist3.getTitle());
        for (Playlist p : stasko.getLibrary()) {
            System.out.println(p.getTitle());
        }
        System.out.println("--------------------------------------");
        System.out.println("**Attempting to remove Liked playlist...(This will not work)**");
        stasko.removePlaylist(stasko.getLibrary().get(0).getTitle());
        for (Playlist p : stasko.getLibrary()) {
            System.out.println(p.getTitle());
        }
    }
}