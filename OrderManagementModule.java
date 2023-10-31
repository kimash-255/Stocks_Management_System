import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Order {
    private int orderNumber;
    private String customerName;
    private List<String> itemsOrdered;

    public Order(int orderNumber, String customerName) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        itemsOrdered = new ArrayList<>();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<String> getItemsOrdered() {
        return new ArrayList<>(itemsOrdered);
    }

    public void addItemToOrder(String itemName) {
        itemsOrdered.add(itemName);
    }
}

class OrderManager {
    private List<Order> orders;
    private int nextOrderNumber;

    public OrderManager() {
        orders = new ArrayList<>();
        nextOrderNumber = 1;
    }

    public void createOrder(String customerName) {
        Order order = new Order(nextOrderNumber++, customerName);
        orders.add(order);
    }

    public void addItemToOrder(int orderNumber, String itemName) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                order.addItemToOrder(itemName);
                break;
            }
        }
    }

    public List<Order> listOrders() {
        return new ArrayList<>(orders);
    }
}

public class OrderManagementModule {
    public static void run(Scanner scanner) {
        OrderManager orderManager = new OrderManager();

        boolean running = true;
        while (running) {
            System.out.println("Order Management Menu");
            System.out.println("1. Create Order");
            System.out.println("2. Add Item to Order");
            System.out.println("3. List Orders");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    orderManager.createOrder(customerName);
                    System.out.println("Order created.");
                    break;
                case 2:
                    System.out.print("Enter order number: ");
                    int orderNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    orderManager.addItemToOrder(orderNumber, itemName);
                    System.out.println("Item added to order.");
                    break;
                case 3:
                    List<Order> orders = orderManager.listOrders();
                    if (orders.isEmpty()) {
                        System.out.println("No orders found.");
                    } else {
                        System.out.println("Orders:");
                        for (Order order : orders) {
                            System.out.println("Order Number: " + order.getOrderNumber() + ", Customer: " + order.getCustomerName());
                            List<String> itemsOrdered = order.getItemsOrdered();
                            if (itemsOrdered.isEmpty()) {
                                System.out.println("No items in this order.");
                            } else {
                                System.out.println("Items Ordered:");
                                for (String item : itemsOrdered) {
                                    System.out.println(item);
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
            }
        }
    }
}
