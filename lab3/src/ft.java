import java.util.Scanner;

abstract class Item {
    protected String name;
    protected double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void Show();
}

class Product extends Item {
    protected String expirationDate;

    public Product(String name, double price, String expirationDate) {
        super(name, price);
        this.expirationDate = expirationDate;
    }

    @Override
    public void Show() {
        System.out.println("Product: " + name + ", Price: " + price + ", Expiration date: " + expirationDate);
    }
}

class DairyProduct extends Product {
    private double fatContent;

    public DairyProduct(String name, double price, String expirationDate, double fatContent) {
        super(name, price, expirationDate);
        this.fatContent = fatContent;
    }

    @Override
    public void Show() {
        System.out.println("Dairy product: " + name + ", Price: " + price + ", Expiration date: " + expirationDate + ", Fat content: " + fatContent + "%");
    }
}

class Toy extends Item {
    private int minAge;

    public Toy(String name, double price, int minAge) {
        super(name, price);
        this.minAge = minAge;
    }

    @Override
    public void Show() {
        System.out.println("Toy: " + name + ", Price: " + price + ", Min age: " + minAge + "+");
    }
}

public class ft {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Item[] items = new Item[3];

        System.out.println("Enter data for the toy:");
        System.out.print("Name: ");
        String toyName = scanner.nextLine();
        System.out.print("Price: ");
        double toyPrice = scanner.nextDouble();
        System.out.print("Min age: ");
        int minAge = scanner.nextInt();
        scanner.nextLine(); // очистка буфера
        items[0] = new Toy(toyName, toyPrice, minAge);

        System.out.println("\nEnter data for the product:");
        System.out.print("Name: ");
        String prodName = scanner.nextLine();
        System.out.print("Price: ");
        double prodPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Expiration date: ");
        String expDate = scanner.nextLine();
        items[1] = new Product(prodName, prodPrice, expDate);

        System.out.println("\nEnter data for the dairy product:");
        System.out.print("Name: ");
        String dairyName = scanner.nextLine();
        System.out.print("Price: ");
        double dairyPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Expiration date: ");
        String dairyExp = scanner.nextLine();
        System.out.print("Fat content (%): ");
        double fat = scanner.nextDouble();
        items[2] = new DairyProduct(dairyName, dairyPrice, dairyExp, fat);

        for (Item item : items) {
            item.Show();
        }

        scanner.close();
    }
}
