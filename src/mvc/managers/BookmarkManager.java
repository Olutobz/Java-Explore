package mvc.managers;

import mvc.entities.Movie;

public class BookmarkManager {

    private static final BookmarkManager INSTANCE = new BookmarkManager();

    private BookmarkManager() {
    }

    public static BookmarkManager getInstance() {
        return INSTANCE;
    }

    public Movie createMovie(long id, String title, String profileUrl, int releaseYear,
                             String[] casts, String[] directors, String genre, double imdbRating) {

        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setProfileUrl(profileUrl);
        movie.setReleaseYear(releaseYear);
        movie.setCasts(casts);
        movie.setDirectors(directors);
        movie.setGenre(genre);
        movie.setImdbRating(imdbRating);

        return movie;
    }

}