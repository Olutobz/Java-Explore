package io;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class HttpConnect {
    public static String Download(String sourceUrl) throws URISyntaxException, MalformedURLException {
        System.out.println("Downloading ... " + sourceUrl);
        URL url = new URI(sourceUrl).toURL();

        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode >= 200 && responseCode < 300) { // OK
                return IOUtil.read(httpURLConnection.getInputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void read(InputStream inputStream) {

    }
}
