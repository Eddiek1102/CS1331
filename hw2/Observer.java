public class Observer {
    private String name;
    private String location;

    public Observer(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String toString() {
        return this.getName() + " in " + this.getLocation();
    }

    public Sighting documentSighting(Silhouette shape, Size size, String dateIncidence) {
        Observer newObserver = new Observer(this.getName(), this.getLocation());
        Sighting newSighting = new Sighting(shape, size, newObserver, dateIncidence);
        return newSighting;
    }
}