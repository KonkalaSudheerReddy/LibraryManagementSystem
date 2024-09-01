package Library;

import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
	private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeLibrary();

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Enter Library");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                enterLibrary();
            } else if (choice == 2) {
                System.out.println("Thank you for using the Library Management System. Visit Again 😁😁😁!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void initializeLibrary() {
    	// Adding all the books
        library.addItem(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 180));
        library.addItem(new Book("To Kill a Mockingbird", "Harper Lee", "9780446310789", 281));
        library.addItem(new Book("1984", "George Orwell", "9780451524935", 328));
        library.addItem(new Book("Moby Dick", "Herman Melville", "9781503280786", 635));
        // Adding the DVDs
        library.addItem(new DVD("The Matrix", "The Wachowskis", "0794043196228", 136));
        library.addItem(new DVD("Titanic", "James Cameron", "097361581118", 195));
        library.addItem(new DVD("The Departed", "Martin Scorsese", "0780668080301", 151));
        library.addItem(new DVD("Avatar", "James Cameron", "0024543581403", 162));
        library.addItem(new DVD("Inception", "Christopher Nolan", "5051890045126", 148));
        library.addItem(new DVD("The Shawshank Redemption", "Frank Darabont", "5035822883536", 142));
        // Saved Regular Users
        library.registerUser(new RegularUser("Tharun"));
        library.registerUser(new PremiumUser("Ramesh"));
        library.registerUser(new RegularUser("Suresh"));
        library.registerUser(new RegularUser("Daisy"));
//        library.registerUser(new RegularUser("Eve"));
//        library.registerUser(new RegularUser("Frank"));
//        library.registerUser(new RegularUser("Grace"));
//        library.registerUser(new RegularUser("Hank"));
//        library.registerUser(new RegularUser("Ivy"));
//        library.registerUser(new RegularUser("Jack"));
//        library.registerUser(new RegularUser("Kelly"));
//        library.registerUser(new RegularUser("Leo"));
        // Saved Premium Users
        library.registerUser(new PremiumUser("Sudheer"));
        library.registerUser(new PremiumUser("Balu"));
        library.registerUser(new PremiumUser("Mohan"));
        library.registerUser(new PremiumUser("Paul"));
        library.registerUser(new PremiumUser("Quinn"));
//        library.registerUser(new PremiumUser("Rachel"));
//        library.registerUser(new PremiumUser("Sam"));
//        library.registerUser(new PremiumUser("Tina"));
//        library.registerUser(new PremiumUser("Ursula"));
//        library.registerUser(new PremiumUser("Victor"));

    }

    private static void enterLibrary() {
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        LibraryUser user = library.findUser(userName);
        if (user == null) {
            System.out.println("User not found. Are you a Regular User or Premium User? (R/P)");
            String userType = scanner.nextLine();
            if (userType.equalsIgnoreCase("R")) {
                user = new RegularUser(userName);
            } else if (userType.equalsIgnoreCase("P")) {
                user = new PremiumUser(userName);
            } else {
                System.out.println("Invalid user type. Defaulting to Regular User.");
                user = new RegularUser(userName);
            }
            library.registerUser(user);
            System.out.println("New user registered: " + userName);
        }

        while (true) {
            System.out.println("\n--- Welcome, " + user.getName() + " ---");
            System.out.println("1. View available items");
            System.out.println("2. Borrow an item");
            System.out.println("3. Return an item");
            System.out.println("4. View borrowed items");
            System.out.println("5. Exit library");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAvailableItems();
                    break;
                case 2:
                    borrowItem(user);
                    break;
                case 3:
                    returnItem(user);
                    break;
                case 4:
                    viewBorrowedItems(user);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void viewAvailableItems() {
        List<LibraryItem> availableItems = library.getAvailableItems();
        System.out.println("\nAvailable Items:");
        for (LibraryItem item : availableItems) {
            System.out.println(item.getDetails());
        }
    }

    private static void borrowItem(LibraryUser user) {
        System.out.print("Enter the title of the item you want to borrow: ");
        String title = scanner.nextLine();

        LibraryItem item = library.findItem(title);
        if (item != null && item.isAvailable()) {
            user.borrowItem(item);
            System.out.println("You have successfully borrowed: " + item.getTitle());
        } else {
            System.out.println("Sorry, the item is not available or doesn't exist.");
        }
    }

    private static void returnItem(LibraryUser user) {
        List<LibraryItem> borrowedItems = user.getBorrowedItems();
        if (borrowedItems.isEmpty()) {
            System.out.println("You haven't borrowed any items.");
            return;
        }

        System.out.println("Your borrowed items:");
        for (int i = 0; i < borrowedItems.size(); i++) {
            System.out.println((i + 1) + ". " + borrowedItems.get(i).getTitle());
        }

        System.out.print("Enter the number of the item you want to return: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice > 0 && choice <= borrowedItems.size()) {
            LibraryItem item = borrowedItems.get(choice - 1);
            user.returnItem(item);
            System.out.println("You have successfully returned: " + item.getTitle());
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void viewBorrowedItems(LibraryUser user) {
        List<LibraryItem> borrowedItems = user.getBorrowedItems();
        if (borrowedItems.isEmpty()) {
            System.out.println("You haven't borrowed any items.");
        } else {
            System.out.println("\nYour borrowed items:");
            for (LibraryItem item : borrowedItems) {
                System.out.println(item.getDetails());
            }
        }
    }
}
