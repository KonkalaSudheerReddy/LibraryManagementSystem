package Library;

import java.util.ArrayList;
import java.util.List;

// Regular User class implementing LibraryUser
class RegularUser implements LibraryUser {
    private String name;
    private List<LibraryItem> borrowedItems;

    public RegularUser(String name) {
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void borrowItem(LibraryItem item) {
        if (borrowedItems.size() < 3) {
            borrowedItems.add(item);
            item.checkOut();
        } else {
            System.out.println("You have reached the maximum number of items you can borrow.");
        }
    }

    @Override
    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
        item.checkIn();
    }

    @Override
    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }
}

//public class RegularUser {

//}
