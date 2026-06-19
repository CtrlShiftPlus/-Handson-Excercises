class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String display() {
        return "Order ID: " + orderId +"\nCustomer: " + customerName +"\nTotal Price: " + totalPrice;
    }
}

public class Sorting_Customer_Orders {

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

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);

            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order.display()+"\n");
        }
    }

    public static void main(String[] args) {

        Order[] orders1 = {
            new Order(101, "Alice", 2500),
            new Order(102, "Bob", 100),
            new Order(103, "Charlie", 350),
            new Order(104, "David", 1800)
        };

        System.out.println("Before Bubble Sort:");
        printOrders(orders1);

        bubbleSort(orders1);

        System.out.println("\nAfter Bubble Sort:");
        printOrders(orders1);

        Order[] orders2 = {
            new Order(101, "Alice", 250),
            new Order(102, "Bob", 12000),
            new Order(103, "Charlie", 300),
            new Order(104, "David", 700)
        };

        quickSort(orders2, 0, orders2.length - 1);

        System.out.println("\nAfter Quick Sort:");
        printOrders(orders2);
    }
}


    

