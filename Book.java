public class Book {
    private final String bookId;
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;

    public Book(String bookId, String title, String author, String genre, String availabilityStatus) {
        if (title.isEmpty() || author.isEmpty()) {
            throw new IllegalArgumentException("Title and Author cannot be empty.");
        }
        if (!availabilityStatus.equalsIgnoreCase("Available") && !availabilityStatus.equalsIgnoreCase("Checked Out")) {
            throw new IllegalArgumentException("Availability status must be 'Available' or 'Checked Out'.");
        }
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public String getAvailabilityStatus() { return availabilityStatus; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setAvailabilityStatus(String status) {
        if (status.equalsIgnoreCase("Available") || status.equalsIgnoreCase("Checked Out")) {
            this.availabilityStatus = status;
        } else {
            throw new IllegalArgumentException("Invalid status. Use 'Available' or 'Checked Out'.");
        }
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + " | Title: " + title + " | Author: " + author +
               " | Genre: " + genre + " | Status: " + availabilityStatus;
    }
}
