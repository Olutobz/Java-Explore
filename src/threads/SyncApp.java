package threads;

public class SyncApp {

    public static void main(String[] args) {
        System.out.println("Application started");

        Printer printer = new Printer();
        Thread examResults =
                new Thread(() -> {
                    printer.printExamDocuments(10, "Exam Results ");
                    printer.printPdfFiles(20);
                });
        examResults.start();

        Downloader movieDownloader = new Downloader();
        Thread downloadMovies =
                new Thread(() -> {
                    movieDownloader.movieDownloader(100, "DC movies collections ");
                    movieDownloader.seriesDownloader(30, 2, "Game Of Thrones ");
                });
        downloadMovies.start();

        System.out.println("Application Finished");

    }

}

class Printer {
    synchronized void printExamDocuments(int numOfCopies, String docName) {
        for (int i = 1; i <= numOfCopies; i++) {
            System.out.println("Printing " + docName + i);
        }
    }

    synchronized void printPdfFiles(int numOfCopies) {
        for (int i = 1; i <= numOfCopies; i++)
            System.out.println("Printing " + i + " pdfs files");

    }

}

class Downloader {
    synchronized void movieDownloader(int numOfDownloads, String movieTitle) {
        for (int i = 1; i <= numOfDownloads; i++) {
            System.out.println("Downloading " + movieTitle + i);
        }
    }

    synchronized void seriesDownloader(int numberOfEpisodes, int numOfSeason, String seriesTitle) {
        if (numOfSeason > 0) {
            for (int i = 1; i <= numberOfEpisodes; i++) {
                System.out.println("Downloading " + i + " of " + numberOfEpisodes + " episodes from " + seriesTitle + numOfSeason);
            }
        } else System.out.println("Series not yet available for download, please check back later.");

    }

}