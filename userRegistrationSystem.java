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


