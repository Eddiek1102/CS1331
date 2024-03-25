public class Sighting {
    private UFO ufo;
    private Observer observer;
    private String dateIncidence;

    public Sighting(Silhouette shape, Size size, Observer observer, String dateIncidence) {
        ufo = new UFO(shape, size);
        this.observer = new Observer(observer.getName(), observer.getLocation());
        this.dateIncidence = dateIncidence;
    }

    public UFO getUfo() {
        return ufo;
    }

    public Observer getObserver() {
        return observer;
    }

    public String getDateIncidence() {
        return dateIncidence;
    }

    public static UFO mostSighted(Sighting[] sightingArray) {
        UFO mostSightedUFO = sightingArray[0].getUfo();
        for (int i = 1; i < sightingArray.length; i++) {
            if (sightingArray[i].getUfo().getNumSightings() > mostSightedUFO.getNumSightings()) {
                mostSightedUFO = sightingArray[i].getUfo();
            }
        }
        return mostSightedUFO;
    }

    public String toString() {
        String report = observer + " saw a " + ufo + ", on " + dateIncidence;
        return report;
    }
}