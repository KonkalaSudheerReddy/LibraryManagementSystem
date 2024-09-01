package Library;

public class DVD extends LibraryItem {
    private int duration;

    public DVD(String title, String director, String isbn, int duration) {
        super(title, director, isbn);
        this.duration = duration;
    }

    @Override
    public String getDetails() {
        return String.format("DVD: %s directed by %s, ISBN: %s, Duration: %d minutes, Available: %s",
                title, author, isbn, duration, available ? "Yes" : "No");
    }
}