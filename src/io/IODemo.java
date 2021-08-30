package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class IODemo {

    static String inFileStr = "pexels-photo-577585.jpeg";
    static String outFileStr = "pexels-photo-1181244.jpeg";

    public static void main(String[] args) {
        applyEncoding();
        fileCopyNoBuffer();
        fileCopyWithBufferAndArray();
    }

    private static void fileCopyNoBuffer() {
        System.out.println("\nInside fileCopyNoBuffer ...");
        long startTime, elapsedTime;

        File file = new File(inFileStr);
        System.out.println("File size is: " + file.length() + " bytes");
        try (FileInputStream in = new FileInputStream(inFileStr);
             FileOutputStream out = new FileOutputStream(outFileStr)) {
            startTime = System.nanoTime();
            int byteRead;
            while ((byteRead = in.read()) != -1) {
                out.write(byteRead);
            }

            elapsedTime = System.nanoTime() - startTime;
            System.out.println("Elapsed Time is: " + (elapsedTime / 1000000.0) + "ms");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void fileCopyWithBufferAndArray() {
        System.out.println("\nInside fileCopyWithBufferAndArray ...");
        long startTime, elapsedTime;
        startTime = System.nanoTime();

        File file = new File(inFileStr);
        System.out.println("File size is: " + file.length() + " bytes");
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFileStr));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFileStr))) {
            byte[] byteBuf = new byte[4000];
            int byteRead;
            while ((byteRead = in.read(byteBuf)) != -1) {
                out.write(byteBuf, 0, byteRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Elapsed Time is: " + (elapsedTime / 1000000.0) + "ms");

    }

    private static void printEncodingDetails(String symbol) {
        System.out.println("\nSymbol: " + symbol);
        System.out.println("ASCII: " + Arrays.toString(symbol.getBytes(StandardCharsets.US_ASCII)));
        System.out.println("ISO-8859-1: " + Arrays.toString(symbol.getBytes(StandardCharsets.ISO_8859_1)));
        System.out.println("UTF-8: " + Arrays.toString(symbol.getBytes(StandardCharsets.UTF_8)));
        System.out.println("UTF-16: " + Arrays.toString(symbol.getBytes(StandardCharsets.UTF_16)));
        System.out.println("UTF-16 BE: " + Arrays.toString(symbol.getBytes(StandardCharsets.UTF_16BE)));
        System.out.println("UTF-16 LE: " + Arrays.toString(symbol.getBytes(StandardCharsets.UTF_16LE)));
        System.out.println();
    }


    private static void applyEncoding() {
        System.out.println("Inside applyEncoding ...");
        printEncodingDetails("a");
        printEncodingDetails("$");
        printEncodingDetails("\u1F602"); // Non_BMP Unicode
    }
}
