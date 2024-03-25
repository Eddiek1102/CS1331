public class UFO {
    private Silhouette shape;
    private Size size;
    private int numSightings;

    private static UFO[] ufoArray = new UFO[Silhouette.values().length * Size.values().length];

    public UFO(Silhouette shape, Size size) {
        this.shape = shape;
        this.size = size;
        this.numSightings = 1;
        this.newSighting();
    }

    public Silhouette getShape() {
        return shape;
    }

    public Size getSize() {
        return size;
    }

    public int getNumSightings() {
        return numSightings;
    }

    public void newSighting() {
        for (int i = 0; i < ufoArray.length; i++) {
            if (ufoArray[i] != null) {
                if (ufoArray[i].getShape() == this.getShape() && ufoArray[i].getSize() == this.getSize()) {
                    ufoArray[i].numSightings += 1;
                    this.numSightings = ufoArray[i].numSightings;
                    return;
                }
            }
        }
        for (int i = 0; i < ufoArray.length; i++) {
            if (ufoArray[i] == null) {
                ufoArray[i] = this;
                return;
            }
        }
    }



    public String toString() {
        String shapeTemp = "", sizeTemp = "";
        switch (this.getShape()) {
        case SAUCER:
            shapeTemp = "saucer";
            break;
        case BLOB:
            shapeTemp = "blob";
            break;
        case PYRAMID:
            shapeTemp = "pyramid";
            break;
        case SPHERE:
            shapeTemp = "sphere";
            break;
        default:
            break;
        }
        switch (this.getSize()) {
        case GINORMOUS:
            sizeTemp = "ginormous";
            break;
        case REGULAR:
            sizeTemp = "regular";
            break;
        case TINY:
            sizeTemp = "tiny";
            break;
        default:
            break;
        }
        if (sizeTemp.equals("regular")) {
            return "flying " + shapeTemp + ", a UFO seen " + numSightings + " times";
        } else {
            return sizeTemp + " flying " + shapeTemp + ", a UFO seen " + numSightings + " times";
        }
    }
}