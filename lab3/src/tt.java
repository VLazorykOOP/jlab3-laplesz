import java.util.Scanner;
import java.lang.Math;

interface NormCalculable {
    double calculateModule();
    default double calculateNorm() {
        double module = calculateModule();
        return module * module;
    }
}

class Vector2D implements NormCalculable {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double calculateModule() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "Vector2D[" + x + ", " + y + "]";
    }
}

class Vector3D implements NormCalculable {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double calculateModule() {
        double absX = Math.abs(x);
        double absY = Math.abs(y);
        double absZ = Math.abs(z);
        return Math.max(absX, Math.max(absY, absZ));
    }

    @Override
    public String toString() {
        return "Vector3D[" + x + ", " + y + ", " + z + "]";
    }
}

public class tt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Input data for Vector2D ---");
        System.out.print("Input x: ");
        double x2 = scanner.nextDouble();

        System.out.print("Input y: ");
        double y2 = scanner.nextDouble();

        Vector2D v2 = new Vector2D(x2, y2);
        System.out.println("Створено об'єкт: " + v2);

        System.out.println("\n--- Input data for Vector3D ---");
        System.out.print("Input x: ");
        double x3 = scanner.nextDouble();

        System.out.print("Input y: ");
        double y3 = scanner.nextDouble();

        System.out.print("Input z: ");
        double z3 = scanner.nextDouble();

        Vector3D v3 = new Vector3D(x3, y3, z3);
        System.out.println("Created object: " + v3);

        scanner.close();

        System.out.println("\n--- Result ---");

        System.out.println("For " + v2);
        System.out.println("  -> Module: " + v2.calculateModule());
        System.out.println("  -> Norma: " + v2.calculateNorm());

        System.out.println("---");

        System.out.println("For " + v3);
        System.out.println("  -> Module: " + v3.calculateModule());
        System.out.println("  -> Norma: " + v3.calculateNorm());
    }
}