import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Display Inventory");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.next();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();

                    Product newProduct = new Product(name, price, quantity);
                    inventory.addProduct(newProduct);
                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    System.out.println("\nCurrent Inventory:");
                    List<Product> allProducts = inventory.getInventory();
                    for (Product product : allProducts) {
                        System.out.println("Name: " + product.getName() +
                                ", Price: $" + product.getPrice() +
                                ", Quantity: " + product.getQuantity());
                    }
                    break;

                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter Product valid option.");
            }
        }
    }
}