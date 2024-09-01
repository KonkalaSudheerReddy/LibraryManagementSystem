package Library;

public class Book extends LibraryItem {
	private int pages;

    public Book(String title, String author, String isbn, int pages) {
        super(title, author, isbn);
        this.pages = pages;
    }

    @Override
    public String getDetails() {
        return String.format("Book: %s by %s, ISBN: %s, Pages: %d, Available: %s",
                title, author, isbn, pages, available ? "Yes" : "No");
    }
}
