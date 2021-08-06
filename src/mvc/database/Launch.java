package mvc.database;

import mvc.entities.Bookmark;
import mvc.entities.User;
import mvc.managers.BookmarkManager;
import mvc.managers.UserManager;

public class Launch {

    public static Bookmark[][] bookmarks;
    private static User[] users;

    public static void loadData() {
        System.out.println("Loading data ...");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();

        System.out.println("Printing data ...");
        printUserData();
        System.out.println();
        printBookmarkData();

    }

    private static void printBookmarkData() {
        for (Bookmark[] bookmarkList : bookmarks) {
            for (Bookmark bookmark : bookmarkList) {
                System.out.println(bookmark);
            }

        }
    }

    private static void printUserData() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public static void main(String[] args) {
        loadData();
    }
}
