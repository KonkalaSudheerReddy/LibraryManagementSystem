package Library;

import java.util.ArrayList;
import java.util.List;

public class PremiumUser implements LibraryUser {
    private String name;
    private List<LibraryItem> borrowedItems;

    public PremiumUser(String name) {
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void borrowItem(LibraryItem item) {
        borrowedItems.add(item);
        item.checkOut();
    }

    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
        item.checkIn();
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }
}