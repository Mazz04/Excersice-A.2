import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class userRegistrationSystem {
    private static List<User> userList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            showMenu();
            int option = getUserInput();
            switch (option) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    viewUsers();
                    break;
                case 3:
                    removeUser();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
    private static void showMenu() {
        System.out.println("Menu:");
        System.out.println("1. Register user");
        System.out.println("2. View users");
        System.out.println("3. Remove user");
        System.out.println("4. Exit");
        System.out.print("Enter option > ");
    }
    private static int getUserInput() {
        return scanner.nextInt();
    }
    private static void registerUser() {
        System.out.print("Enter the number of users to register: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (int i = 1; i <= count; i++) {
            System.out.println("Register User #" + i);
            System.out.print("Enter name > ");
            String name = scanner.nextLine();
            System.out.print("Enter ID > ");
            String id = scanner.nextLine();
            System.out.print("Enter position > ");
            String position = scanner.nextLine();

            User user = new User(name, id, position);
            userList.add(user);
            System.out.println("User registered successfully.\n");
        }
    }
    private static void viewUsers() {
        System.out.println("List of users:");
        for (User user : userList) {
            System.out.println(user.getName());
            System.out.println(user.getId());
            System.out.println(user.getPosition());
            System.out.println();
        }
    }
    private static void removeUser() {
        System.out.print("Enter the user ID to remove: ");
        String id = scanner.next();
        boolean removed = false;

        for (User user : userList) {
            if (user.getId().equals(id)) {
                userList.remove(user);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("User with ID " + id + " removed successfully.\n");
        } else {
            System.out.println("User with ID " + id + " not found.\n");
        }
    }
    private static class User {
        private String name;
        private String id;
        private String position;
        public User(String name, String id, String position) {
            this.name = name;
            this.id = id;
            this.position = position;
        }
        public String getName() {
            return name;
        }
        public String getId() {
            return id;
        }
        public String getPosition() {
            return position;
        }
    }
}