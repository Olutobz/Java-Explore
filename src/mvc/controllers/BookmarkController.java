package mvc.controllers;

import mvc.entities.Bookmark;
import mvc.entities.User;
import mvc.managers.BookmarkManager;

public class BookmarkController {
    private static final BookmarkController instance = new BookmarkController();

    private BookmarkController() {
    }

    public static BookmarkController getInstance() {
        return instance;
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
    }
}
