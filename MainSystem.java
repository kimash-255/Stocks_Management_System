import java.util.Scanner;

public class MainSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Noodle Restaurant Stock Management System");
            System.out.println("1. Inventory Management");
            System.out.println("2. Recipe Management");
            System.out.println("3. Order Management");
            System.out.println("4. User Management");
            System.out.println("5. Reporting and Alerts");
            System.out.println("6. Regulatory Compliance");
            System.out.println("7. Multilingual Support");
            System.out.println("8. Security and Data Protection");
            System.out.println("9. Quality Assurance");
            System.out.println("10. Exit");
            System.out.print("Select a module: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    InventoryManagementModule.run(scanner);
                    break;
                case 2:
                    RecipeManagementModule.run(scanner);
                    break;
                case 3:
                    OrderManagementModule.run(scanner);
                    break;
                case 4:
                    UserManagementModule.run(scanner);
                    break;
                case 5:
                    ReportingAlertsModule.run(scanner);
                    break;
                case 6:
                    // Implement functionality for Regulatory Compliance Module
                    break;
                case 7:
                    // Implement functionality for Multilingual Support Module
                    break;
                case 8:
                    // Implement functionality for Security and Data Protection Module
                    break;
                case 9:
                    // Implement functionality for Quality Assurance Module
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
            }
        }
    }
}
