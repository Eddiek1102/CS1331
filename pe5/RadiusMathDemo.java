import java.util.Scanner;

public class RadiusMathDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Radius length:         ");
        double radius = scanner.nextDouble();
        System.out.print("Height (for cylinder): ");
        double height = scanner.nextDouble();

        System.out.println();

        double[] results = RadiusMath.computeAll(radius, height);

        System.out.printf("Circle Area:           %.2f\n", (float) results[0]);
        System.out.printf("Cylinder Volume:       %.2f\n", (float) results[1]);
        System.out.printf("Sphere Volume:         %.2f\n", (float) results[2]);
        System.out.printf("Sphere Surface Area:   %.2f\n", (float) results[3]);

        scanner.close();
    }
}