
import java.util.*;

class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display() {
        System.out.printf("%-8d %-20s %-10d %.2f%n",
                id, name, quantity, price);
    }
}

public class InventoryManagementSystem {

    // Collection with Generics
    static ArrayList<Product> products = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static Product findById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findById(id) != null) {
            System.out.println("Product ID already exists!");
            return;
        }

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        if (quantity < 0 || price < 0) {
            System.out.println("Quantity and price cannot be negative.");
            return;
        }

        products.add(new Product(id, name, quantity, price));
        System.out.println("Product added successfully!");
    }

    static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Product p = findById(id);

        if (p == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter New Price: ");
        double price = sc.nextDouble();

        if (quantity < 0 || price < 0) {
            System.out.println("Quantity and price cannot be negative.");
            return;
        }

        p.setName(name);
        p.setQuantity(quantity);
        p.setPrice(price);

        System.out.println("Product updated successfully!");
    }

    static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();

        Product p = findById(id);

        if (p != null) {
            products.remove(p);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    static void searchProduct() {
        sc.nextLine();
        System.out.print("Enter product name to search: ");
        String name = sc.nextLine();

        boolean found = false;

        for (Product p : products) {
            if (p.getName().toLowerCase()
                    .contains(name.toLowerCase())) {
                p.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching product found!");
        }
    }

    static void sortProducts() {
        System.out.println("1. Sort by Price");
        System.out.println("2. Sort by Quantity");
        System.out.print("Choose option: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            products.sort(
                Comparator.comparingDouble(Product::getPrice)
            );
        } else if (choice == 2) {
            products.sort(
                Comparator.comparingInt(Product::getQuantity)
            );
        } else {
            System.out.println("Invalid option!");
            return;
        }

        System.out.println("Products sorted in ascending order.");
        displayProducts();
    }

    static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        System.out.printf("%-8s %-20s %-10s %s%n",
                "ID", "Name", "Quantity", "Price");
        System.out.println("-----------------------------------------------");

        for (Product p : products) {
            p.display();
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Search Product by Name");
            System.out.println("5. Sort Products");
            System.out.println("6. Display All Products");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    searchProduct();
                    break;
                case 5:
                    sortProducts();
                    break;
                case 6:
                    displayProducts();
                    break;
                case 0:
                    System.out.println("Exiting Inventory System.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}

