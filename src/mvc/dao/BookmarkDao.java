package mvc.dao;

import mvc.database.DataStore;
import mvc.entities.Bookmark;

public class BookmarkDao {
    public Bookmark[][] getBookmarks() {
        return DataStore.getBookmarks();
    }
}
