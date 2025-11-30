import java.util.Arrays;
import java.util.Scanner;

abstract class Container {
    protected double[] elements;

    public Container(double[] elements) {
        this.elements = elements.clone();
    }

    public abstract void sort();
    public abstract double norma();

    }


class Bubble extends Container {

    public Bubble(double[] elements) {
        super(elements);
    }

    @Override
    public void sort() {
        int n = elements.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (elements[j] > elements[j + 1]) {
                    double temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    @Override
    public double norma() {
        double sum = 0;
        for (double el : elements) {
            sum += el;
        }
        return Math.sqrt(sum);
    }

    @Override
    public String toString() {
        return "Bubble Container: " + Arrays.toString(elements);
    }
}

class Choice extends Container {

    public Choice(double[] elements) {
        super(elements);
    }

    @Override
    public void sort() {
        int n = elements.length;
        for (int i = n - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (elements[j] > elements[maxIndex]) {
                    maxIndex = j;
                }
            }
            double temp = elements[maxIndex];
            elements[maxIndex] = elements[i];
            elements[i] = temp;
        }
    }

    @Override
    public double norma() {
        if (elements.length == 0) return 0.0;
        double sum = 0;
        for (double el : elements) {
            sum += el;
        }
        return sum / elements.length;
    }

    @Override
    public String toString() {
        return "Choice Container: " + Arrays.toString(elements);
    }
}

public class st {

    private static double[] readArrayFromKeyboard(Scanner scanner, String prompt) {
        System.out.println(prompt);

        String line = scanner.nextLine();

        String[] parts = line.trim().split("\\s+");

        if (parts.length == 1 && parts[0].isEmpty()) {
            return new double[0];
        }

        double[] data = new double[parts.length];

        try {
            for (int i = 0; i < parts.length; i++) {
                data[i] = Double.parseDouble(parts[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error!.");
            return new double[0];
        }

        return data;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] data1 = readArrayFromKeyboard(scanner,
                "Input data for the Bubble:");

        double[] data2 = readArrayFromKeyboard(scanner,
                "Input data for the Choice:");

        Container[] containers = new Container[2];
        containers[0] = new Bubble(data1);
        containers[1] = new Choice(data2);

        for (Container container : containers) {
            System.out.println("\nProcessing of an object: " + container.getClass().getSimpleName());
            System.out.println("Initial state: " + container.toString());

            if (container.elements.length > 0) {
                System.out.printf("Norma(): %.4f\n", container.norma());

                container.sort();
                System.out.println("Sorted state: " + container.toString());
            } else {
                System.out.println("Error!");
            }
        }

        scanner.close();
    }
}