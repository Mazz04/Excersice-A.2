import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class userRegistrationSystem {
    private static final List<User> userList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

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
        scanner.nextLine();

        for (int i = 1; i <= count; i++) {
            System.out.println("Register User #" + i);
            String name = "";
            while (name.isEmpty()) {
                System.out.print("Enter name > ");
                name = scanner.nextLine();
            }

            String id = "";
            while (id.isEmpty() || !id.matches("\\d+")) {
                System.out.print("Enter ID > ");
                id = scanner.nextLine();
            }

            String position = "";
            while (position.isEmpty()) {
                System.out.print("Enter position > ");
                position = scanner.nextLine();
            }

            User user = new User(name, id, position);
            userList.add(user);
            System.out.println("User registered successfully.\n");
        }
    }
    private static void viewUsers() {
        if (userList.isEmpty()) {
            System.out.println("No data found in the list.\n");
            return;
        }

        System.out.println("List of users:");
        for (User user : userList) {
            System.out.println(user.getName());
            System.out.println(user.getId());
            System.out.println(user.getPosition());
            System.out.println();
        }
    }
    private static void removeUser() {
        if (userList.isEmpty()) {
            System.out.println("No data found in the list.\n");
            return;
        }

        System.out.println("Remove user:");
        int index = 1;
        for (User user : userList) {
            System.out.println("#" + index + ": " + user.getName() + " / " + user.getId());
            index++;
        }
        System.out.print("Delete user > ");
        int userIndex = scanner.nextInt();

        if (userIndex >= 1 && userIndex <= userList.size()) {
            User removedUser = userList.remove(userIndex - 1);
            System.out.println("Are you sure you want to delete user #" + userIndex + " " + removedUser.getName() + "? (Yes/No) > ");
            scanner.nextLine();
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("Yes")) {
                System.out.println("User #" + userIndex + " " + removedUser.getName() + " deleted successfully.\n");
            } else {
                userList.add(userIndex - 1, removedUser);
                System.out.println("Deletion canceled. User #" + userIndex + " " + removedUser.getName() + " restored.\n");
            }
        } else {
            System.out.println("Invalid user index.\n");
        }
    }
    private static class User {
        private final String name;
        private final String id;
        private final String position;
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