import java.util.HashMap;


class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "ID: " + productId + " | Name: " + productName + " | Qty: " + quantity + " | Price: $" + price;
    }
}

// 2. INVENTORY MANAGEMENT CLASS
class Inventory {
    private HashMap<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            System.out.println("Error: Product ID " + product.getProductId() + " already exists.");
        } else {
            products.put(product.getProductId(), product);
            System.out.println("Product added successfully: " + product.getProductName());
        }
    }

    public void updateProduct(String productId, String newName, int newQuantity, double newPrice) {
        if (products.containsKey(productId)) {
            Product product = products.get(productId);
            product.setProductName(newName);
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Product ID " + productId + " updated successfully.");
        } else {
            System.out.println("Error: Product ID " + productId + " not found.");
        }
    }

    public void deleteProduct(String productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
            System.out.println("Product ID " + productId + " deleted successfully.");
        } else {
            System.out.println("Error: Product ID " + productId + " not found.");
        }
    }

    public void displayInventory() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }
}


public class InventoryManagement {
    public static void main(String[] args) {
        Inventory warehouse = new Inventory();

        // Test Adding
        System.out.println("\nAdding");
        warehouse.addProduct(new Product("P001", "Laptop", 10, 899.99));
        warehouse.addProduct(new Product("P002", "Smartphone", 25, 499.99));
        warehouse.displayInventory();

        // Test Updating
        System.out.println("\nUpdating");
        warehouse.updateProduct("P001", "Gaming Laptop", 15, 949.99);
        warehouse.displayInventory();


        System.out.println("\nDeleting");
        warehouse.deleteProduct("P002");
        warehouse.displayInventory();
    }
}
