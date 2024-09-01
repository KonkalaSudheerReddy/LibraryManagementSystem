package Library;

public abstract class LibraryItem implements Borrowable {
	protected String title;
    protected String author;
    protected String isbn;
    protected boolean available;

    public LibraryItem(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    public abstract String getDetails();

    @Override
    public void checkOut() {
        available = false;
    }

    @Override
    public void checkIn() {
        available = true;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    public String getTitle() {
        return title;
    }
}