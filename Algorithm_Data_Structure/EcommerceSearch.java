class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class EcommerceSearch {

    public static void linearSearch(Product[] products, String name) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(name)) {
                System.out.println("Product Found");
                System.out.println(products[i].productId + " "
                        + products[i].productName + " "
                        + products[i].category);
                return;
            }
        }
        System.out.println("Product Not Found");
    }

    public static void binarySearch(Product[] products, String name) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = products[mid].productName.compareToIgnoreCase(name);

            if (result == 0) {
                System.out.println("Product Found");
                System.out.println(products[mid].productId + " "
                        + products[mid].productName + " "
                        + products[mid].category);
                return;
            }

            if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Product Not Found");
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Keyboard", "Electronics"),
                new Product(102, "Laptop", "Electronics"),
                new Product(103, "Mobile", "Electronics"),
                new Product(104, "Mouse", "Electronics"),
                new Product(105, "Speaker", "Electronics")
        };

        System.out.println("Linear Search:");
        linearSearch(products, "Mouse");

        System.out.println();

        System.out.println("Binary Search:");
        binarySearch(products, "Mouse");
    }
}