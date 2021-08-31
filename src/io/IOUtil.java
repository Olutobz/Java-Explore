package io;

import java.io.*;

public class IOUtil {

    public static void read(String[] data, String fileName) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                data[count] = line;
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String read(InputStream inputStream) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
