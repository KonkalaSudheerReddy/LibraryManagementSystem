package Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
	 	private List<LibraryItem> items;
	    private Map<String, LibraryUser> users;

	    public Library() {
	        this.items = new ArrayList<>();
	        this.users = new HashMap<>();
	    }

	    public void addItem(LibraryItem item) {
	        items.add(item);
	    }

	    public void registerUser(LibraryUser user) {
	        users.put(user.getName().toLowerCase(), user);
	    }

	    public List<LibraryItem> getAvailableItems() {
	        return items.stream().filter(LibraryItem::isAvailable).toList();
	    }

	    public LibraryItem findItem(String title) {
	        return items.stream()
	                .filter(item -> item.getTitle().equalsIgnoreCase(title))
	                .findFirst()
	                .orElse(null);
	    }

	    public LibraryUser findUser(String name) {
	        return users.get(name.toLowerCase());
	    }
}
