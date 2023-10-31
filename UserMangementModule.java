import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}

class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
        // Add default admin user
        users.add(new User("admin", "admin123", "admin"));
    }

    public boolean authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
    }

    public List<User> listUsers() {
        return new ArrayList<>(users);
    }
}

public class UserManagementModule {
    public static void run(Scanner scanner) {
        UserManager userManager = new UserManager();

        boolean running = true;
        while (running) {
            System.out.println("User Management Menu");
            System.out.println("1. Authenticate User");
            System.out.println("2. Add User");
            System.out.println("3. Remove User");
            System.out.println("4. List Users");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    if (userManager.authenticateUser(username, password)) {
                        System.out.println("Authentication successful.");
                    } else {
                        System.out.println("Authentication failed.");
                    }
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String newUser = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Enter role (admin or staff): ");
                    String newRole = scanner.nextLine();
                    User user = new User(newUser, newPassword, newRole);
                    userManager.addUser(user);
                    System.out.println("User added.");
                    break;
                case 3:
                    System.out.print("Enter username to remove: ");
                    String userToRemove = scanner.nextLine();
                    userManager.removeUser(userToRemove);
                    System.out.println("User removed.");
                    break;
                case 4:
                    List<User> users = userManager.listUsers();
                    if (users.isEmpty()) {
                        System.out.println("No users found.");
                    } else {
                        System.out.println("Users:");
                        for (User user : users) {
                            System.out.println("Username: " + user.getUsername() + ", Role: " + user.getRole());
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
