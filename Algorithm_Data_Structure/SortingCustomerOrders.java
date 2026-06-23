class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
}

public class SortingCustomerOrders {

    public static void display(Order[] orders) {
        for (int i = 0; i < orders.length; i++) {
            System.out.println(
                    orders[i].orderId + " "
                    + orders[i].customerName + " "
                    + orders[i].totalPrice
            );
        }
    }

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (orders[j].totalPrice > orders[j + 1].totalPrice) {

                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(orders, low, high);

            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    public static int partition(Order[] orders, int low, int high) {

        double pivot = orders[high].totalPrice;

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (orders[j].totalPrice < pivot) {

                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        Order[] orders = {
                new Order(1, "Rahul", 5000),
                new Order(2, "Aman", 2000),
                new Order(3, "Priya", 7000),
                new Order(4, "Riya", 3000)
        };

        System.out.println("Before Sorting:");
        display(orders);

        bubbleSort(orders);

        System.out.println("\nAfter Bubble Sort:");
        display(orders);

        Order[] orders2 = {
                new Order(1, "Rahul", 5000),
                new Order(2, "Aman", 2000),
                new Order(3, "Priya", 7000),
                new Order(4, "Riya", 3000)
        };

        quickSort(orders2, 0, orders2.length - 1);

        System.out.println("\nAfter Quick Sort:");
        display(orders2);
    }
}