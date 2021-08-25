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
}
