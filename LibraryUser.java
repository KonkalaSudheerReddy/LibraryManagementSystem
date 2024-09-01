package Library;

//import java.util.ArrayList;
import java.util.List;

public interface LibraryUser {
	String getName();
    void borrowItem(LibraryItem item);
    void returnItem(LibraryItem item);
    List<LibraryItem> getBorrowedItems();
}


