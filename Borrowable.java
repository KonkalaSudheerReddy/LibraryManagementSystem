package Library;

public interface Borrowable {
	void checkOut();
    void checkIn();
    boolean isAvailable();
}
