package InventoryManagementSystem;


public class Main {
public static void main(String[] args) {
   InventoryManagementSystem im = new InventoryManagementSystem();

   im.addProduct(new Product("P001", "Product 1", 10, 100.0));
   im.addProduct(new Product("P002", "Product 2", 20, 200.0));
   
   System.out.println("Initial Products: ");
   im.displayProducts();
   
   im.addProduct(new Product("P003", "Product 3", 40, 250.0));
   

   System.out.println("Products after adding:");
   im.displayProducts();

   im.updateProduct("P001", new Product("P001", "Updated Product 1", 15, 150.0));

   System.out.println("Products after updating:");
   im.displayProducts();

   im.deleteProduct("P002");

   System.out.println("Products after deleting:");
   im.displayProducts();
}
}

