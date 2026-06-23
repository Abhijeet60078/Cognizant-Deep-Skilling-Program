import java.util.HashMap;

class Product {

    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}

public class InventoryManagementSystem {

    static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void addProduct(Product p) {
        inventory.put(p.productId, p);
        System.out.println("Product Added");
    }

    public static void updateProduct(int id, int quantity, double price) {

        if (inventory.containsKey(id)) {

            Product p = inventory.get(id);

            p.quantity = quantity;
            p.price = price;

            System.out.println("Product Updated");
        } else {
            System.out.println("Product Not Found");
        }
    }

    public static void deleteProduct(int id) {

        if (inventory.containsKey(id)) {
            inventory.remove(id);
            System.out.println("Product Deleted");
        } else {
            System.out.println("Product Not Found");
        }
    }

    public static void displayProducts() {

        for (Integer id : inventory.keySet()) {

            Product p = inventory.get(id);

            System.out.println(
                    p.productId + " " +
                    p.productName + " " +
                    p.quantity + " " +
                    p.price
            );
        }
    }

    public static void main(String[] args) {

        Product p1 = new Product(101, "Laptop", 10, 50000);
        Product p2 = new Product(102, "Mouse", 20, 500);

        addProduct(p1);
        addProduct(p2);

        System.out.println("\nInventory:");

        displayProducts();

        updateProduct(101, 15, 55000);

        System.out.println("\nAfter Update:");

        displayProducts();

        deleteProduct(102);

        System.out.println("\nAfter Delete:");

        displayProducts();
    }
}