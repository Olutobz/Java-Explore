package mvc.database;

import io.IOUtil;
import mvc.constants.BookGenre;
import mvc.constants.Gender;
import mvc.constants.MovieGenre;
import mvc.constants.UserType;
import mvc.entities.Bookmark;
import mvc.entities.User;
import mvc.entities.UserBookmark;
import mvc.managers.BookmarkManager;
import mvc.managers.UserManager;

public class DataStore {
    public static final int BOOKMARK_TYPES_COUNT = 3;
    public static final int BOOKMARK_COUNT_PER_TYPE = 5;
    public static final int TOTAL_USER_BOOKMARK = 5;
    public static final int USER_BOOKMARK_LIMIT = 5;
    public static final int TOTAL_USER_COUNT = 5;


    private static final User[] users = new User[TOTAL_USER_COUNT];
    private static final Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
    private static final UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_BOOKMARK * USER_BOOKMARK_LIMIT];
    private static int bookmarkIndex;

    public static Bookmark[][] getBookmarks() {
        return bookmarks;
    }

    public static void loadData() {
        loadUsers();
        loadWebLinks();
        loadMovies();
        loadBooks();
    }

    public static User[] getUsers() {
        return users;
    }


    private static void loadUsers() {
        users[0] = UserManager.getInstance().createUser(1000, "user0@upvaultinc.com",
                "test", "maryam", "Abdulsalam", UserType.USER, Gender.FEMALE);

        users[1] = UserManager.getInstance().createUser(1001, "user1@upvaultinc.com",
                "test", "Emmanuel", "Olajubu", UserType.USER, Gender.MALE);

        users[2] = UserManager.getInstance().createUser(1002, "user2@upvaultinc.com",
                "test", "Uchechukwu", "Nwafor", UserType.EDITOR, Gender.MALE);

        users[3] = UserManager.getInstance().createUser(1003, "user3@upvaultinc.com",
                "test", "Chinedu", "Ihedioha", UserType.EDITOR, Gender.MALE);

        users[4] = UserManager.getInstance().createUser(1004, "user4@upvaultinc.com",
                "test", "Olutoba", "Onikoyi", UserType.CHIEF_EDITOR, Gender.MALE);

    }

    private static void loadWebLinks() {
        bookmarks[0][0] = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
                "https://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "https://www.javaworld.com");

        bookmarks[0][1] = BookmarkManager.getInstance().createWeblink(2001,
                "How do I import a pre-existing Java project into Eclipse and get up and running?",
                "https://stackoverflow.com/questions/142863/" +
                        "how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
                "https://stackoverflow.com");

        bookmarks[0][2] = BookmarkManager.getInstance().createWeblink(2002, "Interface Vs Abstract Class",
                "https://mindprod.com/jgloss/interfacevsabstract.html", "https://mindprod.com");

        bookmarks[0][3] = BookmarkManager.getInstance().createWeblink(2003, "NIP tutorial by Greg Travis",
                "https://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf", "https://cs.brown.edu");

        bookmarks[0][4] = BookmarkManager.getInstance().createWeblink(2004, "Virtual Hosting and Tomcat",
                "https://tomcat.apache.org/tomcat-3.0-doc/virtual-hosting-howto.html", "https://tomcat.apache.org");

    }

    private static void loadMovies() {
        bookmarks[1][0] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "",
                1941, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orsen Welles"},
                MovieGenre.CLASSICS, 8.5);

        bookmarks[1][1] = BookmarkManager.getInstance().createMovie(3001, "The Grapes of Wrath",
                "", 1940, new String[]{"Henry Fonda", "Jane Darwell"}, new String[]{"John Ford"},
                MovieGenre.CLASSICS, 8.2);

        bookmarks[1][2] = BookmarkManager.getInstance().createMovie(3002, "A Touch of Greatness", "",
                2004, new String[]{"Albert Cullum", "Leslie Sullivan"}, new String[]{""},
                MovieGenre.DOCUMENTARIES, 7.3);

        bookmarks[1][3] = BookmarkManager.getInstance().createMovie(3003, "The Big Bang Theory",
                "", 2007, new String[]{"Kaley Cuoco", "Jim Parsons"},
                new String[]{"Chuck Lorre", "Bill Prady"}, MovieGenre.TV_SHOWS, 8.7);

        bookmarks[1][4] = BookmarkManager.getInstance().createMovie(3004, "Ikiru", "",
                1952, new String[]{"Takashi Shimura", "Minoru Chiaki"},
                new String[]{"Akira Kurosawa"}, MovieGenre.FOREIGN_MOVIES, 8.4);

    }

    private static void loadBooks() {
        bookmarks[2][0] = BookmarkManager.getInstance().createBook(4000, "Walden", 1854,
                "Wilder Publications", new String[]{"Henry", "David", "Thoreau"}, BookGenre.PHILOSOPHY, 4.3);

        bookmarks[2][1] = BookmarkManager.getInstance().createBook(4001, "Self-Reliance and Other Essays",
                1993, "Dover Publications", new String[]{"Ralph Waldo Emerson"},
                BookGenre.PHILOSOPHY, 4.5);

        bookmarks[2][2] = BookmarkManager.getInstance().createBook(4002, "Light From Many Lamps",
                1988, "Touchstone", new String[]{"Lillian Eichler Watson"},
                BookGenre.PHILOSOPHY, 5.0);

        bookmarks[2][3] = BookmarkManager.getInstance().createBook(4003, "Head First Design Patterns",
                2004, "O'Reilly Media",
                new String[]{"Eric Freeman", "Bert Bates", "Kathy Sierra", "Elizabeth Robson"}, BookGenre.TECHNICAL, 5.6);

        bookmarks[2][4] = BookmarkManager.getInstance().createBook(4004, "Effective Java programming Language Guide",
                2007, "Prentice Hall", new String[]{"Joshua Bloch"}, BookGenre.TECHNICAL, 4.9);

    }

    public static void add(UserBookmark userBookmark) {
        userBookmarks[bookmarkIndex] = userBookmark;
        bookmarkIndex++;
    }
}