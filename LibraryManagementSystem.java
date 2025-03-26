import java.util.Scanner;

public class LibraryManagementSystem {
    private static final Library library = new Library();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search for a Book");
            System.out.println("4. Update a Book");
            System.out.println("5. Delete a Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> addBook();
                case 2 -> library.viewAllBooks();
                case 3 -> searchBook();
                case 4 -> updateBook();
                case 5 -> deleteBook();
                case 6 -> {
                    System.out.println("Exiting the system...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Availability (Available/Checked Out): ");
        String status = scanner.nextLine();

        try {
            Book newBook = new Book(bookId, title, author, genre, status);
            if (library.addBook(newBook)) {
                System.out.println("Book added successfully.");
            } else {
                System.out.println("Book ID already exists.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void searchBook() {
        System.out.print("Enter Book ID or Title: ");
        String input = scanner.nextLine();
        Book book = library.searchBook(input);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void updateBook() {
        System.out.print("Enter Book ID to update: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter New Title (Leave empty to keep unchanged): ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter New Author (Leave empty to keep unchanged): ");
        String newAuthor = scanner.nextLine();
        System.out.print("Enter New Genre (Leave empty to keep unchanged): ");
        String newGenre = scanner.nextLine();
        System.out.print("Enter New Availability (Available/Checked Out): ");
        String newStatus = scanner.nextLine();

        if (library.updateBook(bookId, newTitle, newAuthor, newGenre, newStatus)) {
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book ID not found.");
        }
    }

    private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String bookId = scanner.nextLine();
        if (library.deleteBook(bookId)) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book ID not found.");
        }
    }
}
