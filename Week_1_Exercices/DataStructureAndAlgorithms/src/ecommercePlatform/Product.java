package ecommercePlatform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }

    public static void LinearSearch(HashMap<Integer, Product> Products, int productId) {
        boolean found = false;
        for (Map.Entry<Integer, Product> entry : Products.entrySet()) {
            if (entry.getKey() == productId) {
                System.out.println("Product Found: " + entry.getValue());
                found = true;
                break; 
            }
        }
        if (!found) {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public static void BinarySearch(HashMap<Integer, Product> Products, int productId) {
        List<Integer> productIds = new ArrayList<>(Products.keySet());
        Collections.sort(productIds);

        int left = 0;
        int right = productIds.size() - 1;
        boolean found = false;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = productIds.get(mid);

            if (midId == productId) {
                System.out.println("Product Found: " + Products.get(midId));
                found = true;
                break;
            } else if (midId < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public static void display(HashMap<Integer, Product> ecommerce) {
        System.out.println("Product Inventory:");
        System.out.printf("%-10s %-20s %-10s\n", "Product ID", "Product Name", "Category");
        System.out.println("---------------------------------------------");
        for (Map.Entry<Integer, Product> entry : ecommerce.entrySet()) {
            Product product = entry.getValue();
            System.out.printf("%-10d %-20s %-10s\n", product.productId, product.productName, product.category);
        }
        System.out.println("---------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Product> Products = new HashMap<>();
        
        Products.put(1001, new Product(1001, "Mouse", "Electronic"));
        Products.put(1003, new Product(1003, "LunchBox", "Utencil"));
        Products.put(1004, new Product(1004, "Keyboard", "Electronic"));
        Products.put(1007, new Product(1007, "Pens", "Stationary"));
        Products.put(1005, new Product(1005, "Jeans", "Cloths"));
        Products.put(1002, new Product(1002, "Earphones", "Electronic"));
        Products.put(1008, new Product(1008, "T-shirt", "Cloths"));
        Products.put(1006, new Product(1006, "Cap", "Accessories")); 

        display(Products);

        System.out.print("Enter the product ID to search: ");
        int productId = sc.nextInt();

        System.out.println("Performing linear search...");
        LinearSearch(Products, productId);

        System.out.println("Performing binary search...");
        BinarySearch(Products, productId);

        sc.close();
    }
}
