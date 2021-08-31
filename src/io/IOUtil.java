package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

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
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return text.toString();
    }
}
