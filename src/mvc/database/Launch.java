package mvc.database;

import mvc.entities.Bookmark;
import mvc.entities.User;
import mvc.managers.BookmarkManager;
import mvc.managers.UserManager;

public class Launch {

    public static Bookmark[][] bookmarks;
    private static User[] users;

    public static void main(String[] args) {
        loadData();
        startBookmarking();
    }

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

        // remove these guys later, I'm trying to force a merge conflict
        System.out.println("testing out merging conflict");
        System.out.println("added another added another");
        String conflict = "have I added the forced merge conflict yet?";

    }

    private static void startBookmarking() {
        System.out.println("\n2. Bookmarking ...");
        for (User user : users) {
            View.bookmark(user, bookmarks);
        }
    }
}
