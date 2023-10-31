import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InventoryItem {
    private String itemName;
    private int quantity;

    public InventoryItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class InventoryManager {
    private List<InventoryItem> inventory;

    public InventoryManager() {
        inventory = new ArrayList<>();
    }

    public void addItem(InventoryItem item) {
        inventory.add(item);
    }

    public void updateItemQuantity(String itemName, int newQuantity) {
        for (InventoryItem item : inventory) {
            if (item.getItemName().equals(itemName)) {
                item.setQuantity(newQuantity);
                break;
            }
        }
    }

    public void removeItem(String itemName) {
        inventory.removeIf(item -> item.getItemName().equals(itemName));
    }

    public List<InventoryItem> listItems() {
        return new ArrayList<>(inventory);
    }
}

public class InventoryManagementModule {
    public static void run(Scanner scanner) {
        InventoryManager inventoryManager = new InventoryManager();

        boolean running = true;
        while (running) {
            System.out.println("Inventory Management Menu");
            System.out.println("1. Add Inventory Item");
            System.out.println("2. Update Inventory Item Quantity");
            System.out.println("3. Remove Inventory Item");
            System.out.println("4. List Inventory Items");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    InventoryItem item = new InventoryItem(name, quantity);
                    inventoryManager.addItem(item);
                    System.out.println("Inventory item added.");
                    break;
                case 2:
                    System.out.print("Enter item name to update: ");
                    String itemNameToUpdate = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine();
                    inventoryManager.updateItemQuantity(itemNameToUpdate, newQuantity);
                    System.out.println("Inventory item quantity updated.");
                    break;
                case 3:
                    System.out.print("Enter item name to remove: ");
                    String itemToRemove = scanner.nextLine();
                    inventoryManager.removeItem(itemToRemove);
                    System.out.println("Inventory item removed.");
                    break;
                case 4:
                    List<InventoryItem> items = inventoryManager.listItems();
                    if (items.isEmpty()) {
                        System.out.println("Inventory is empty.");
                    } else {
                        System.out.println("Inventory Items:");
                        for (InventoryItem i : items) {
                            System.out.println("Item: " + i.getItemName() + ", Quantity: " + i.getQuantity());
                        }
                    }
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
            }
        }
    }
}
