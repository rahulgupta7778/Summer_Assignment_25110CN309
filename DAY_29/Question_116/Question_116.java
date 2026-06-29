// Write a program to Create inventory management system.

import java.io.*;
import java.util.*;

class Product {
    int id;
    String name;
    int quantity;
    double price;

    Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return id + "," + name + "," + quantity + "," + price;
    }

    static Product fromString(String line) {
        String[] parts = line.split(",");
        return new Product(
            Integer.parseInt(parts[0]),
            parts[1],
            Integer.parseInt(parts[2]),
            Double.parseDouble(parts[3])
        );
    }
}

public class Question_116 {
    static final String FILE_NAME = "inventory.txt";
    static ArrayList<Product> products = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadFromFile();
        int choice;

        do {
            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product by ID");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addProduct(); break;
                case 2: viewProducts(); break;
                case 3: searchProduct(); break;
                case 4: updateProduct(); break;
                case 5: deleteProduct(); break;
                case 6: System.out.println("Exiting... Data saved to file."); saveToFile(); break;
                default: System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);
    }

    static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Product p : products) {
            if (p.id == id) {
                System.out.println("Product with this ID already exists!");
                return;
            }
        }

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        products.add(new Product(id, name, qty, price));
        saveToFile();
        System.out.println("Product added successfully!");
    }

    static void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }
        System.out.println("\nID\tName\t\tQuantity\tPrice");
        System.out.println("------------------------------------------------");
        for (Product p : products) {
            System.out.println(p.id + "\t" + p.name + "\t\t" + p.quantity + "\t\t" + p.price);
        }
    }

    static void searchProduct() {
        System.out.print("Enter Product ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Product p : products) {
            if (p.id == id) {
                System.out.println("Product Found: " + p.name + " | Qty: " + p.quantity + " | Price: " + p.price);
                return;
            }
        }
        System.out.println("Product not found!");
    }

    static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Product p : products) {
            if (p.id == id) {
                System.out.print("Enter new Name: ");
                p.name = sc.nextLine();
                System.out.print("Enter new Quantity: ");
                p.quantity = sc.nextInt();
                System.out.print("Enter new Price: ");
                p.price = sc.nextDouble();
                sc.nextLine();
                saveToFile();
                System.out.println("Product updated successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            if (it.next().id == id) {
                it.remove();
                saveToFile();
                System.out.println("Product deleted successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    static void saveToFile() {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            for (Product p : products) {
                fw.write(p.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    products.add(Product.fromString(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }
}