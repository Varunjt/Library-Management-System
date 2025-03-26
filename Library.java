import java.util.*;

public class Library {
    private final Map<String, Book> books = new HashMap<>();

    public boolean addBook(Book book) {
        if (books.containsKey(book.getBookId())) {
            System.out.println("Book ID already exists.");
            return false;
        }
        books.put(book.getBookId(), book);
        return true;
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            books.values().forEach(System.out::println);
        }
    }

    public Book searchBook(String input) {
        return books.values().stream()
                .filter(b -> b.getBookId().equalsIgnoreCase(input) || b.getTitle().equalsIgnoreCase(input))
                .findFirst()
                .orElse(null);
    }

    public boolean updateBook(String bookId, String newTitle, String newAuthor, String newGenre, String newStatus) {
        Book book = books.get(bookId);
        if (book != null) {
            if (!newTitle.isEmpty()) book.setTitle(newTitle);
            if (!newAuthor.isEmpty()) book.setAuthor(newAuthor);
            if (!newGenre.isEmpty()) book.setGenre(newGenre);
            book.setAvailabilityStatus(newStatus);
            return true;
        }
        return false;
    }

    public boolean deleteBook(String bookId) {
        return books.remove(bookId) != null;
    }
}
