public class RadiusMath {
    public static double circleArea(double radius) {
        return (Math.PI * Math.pow(radius, 2));
    }

    public static double cylinderVolume(double radius, double height) {
        return (Math.PI * Math.pow(radius, 2) * height);
    }

    public static double sphereVolume(double radius) {
        return ((4.0 / 3.0) * Math.PI * Math.pow(radius, 3));
    }

    public static double sphereSurfaceArea(double radius) {
        return (4.0 * Math.PI * Math.pow(radius, 2));
    }

    public static double[] computeAll(double radius, double height) {
        double[] answers = new double[4];
        answers[0] = circleArea(radius);
        answers[1] = cylinderVolume(radius, height);
        answers[2] = sphereVolume(radius);
        answers[3] = sphereSurfaceArea(radius);

        return answers;
    }
}