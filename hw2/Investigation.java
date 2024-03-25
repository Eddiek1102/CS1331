public class Investigation {
    public static void main(String[] args) {
        Observer ron = new Observer("Ron", "Atlanta");
        Observer bob = new Observer("Bob", "Roswell");

        Sighting s1 = ron.documentSighting(Silhouette.SAUCER, Size.GINORMOUS, "02/11/2024");
        Sighting s2 = bob.documentSighting(Silhouette.SAUCER, Size.GINORMOUS, "02/12/2024");
        Sighting s3 = ron.documentSighting(Silhouette.PYRAMID, Size.TINY, "02/13/2024");

        Sighting[] sightings = {s1, s2, s3};

        System.out.println("-------------------------------------");
        System.out.println("--------------SIGHTINGS--------------");
        System.out.println("-------------------------------------\n");

        for (Sighting s : sightings) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("-------------------------------------");
        System.out.println("----------MOST SIGHTED UFO-----------");
        System.out.println("-------------------------------------\n");

        System.out.println(Sighting.mostSighted(sightings));
    }
}