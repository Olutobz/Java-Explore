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
        fileMethodsDemo();

        // Serialization
        if (args.length > 0 && args[0].equals("true")) {
            new IODemo().doSerialization();
        }
        new IODemo().doDeserialization();
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

    public static void fileMethodsDemo() {
        System.out.println("\nInside fileMethodsDemo ...");

        File file = new File("/home/olutobz/IdeaProjects/JavaExplore/pexels-photo-1181244.jpeg");
        // File f = new File("pexels-photo-1181244.jpeg");

        System.out.println("getAbsolutePath(): " + file.getAbsolutePath());
        try {
            System.out.println("getCanonicalPath(): " + file.getCanonicalPath());
            System.out.println("createNewFile(): " + file.createNewFile());
        } catch (IOException e) {
            System.out.println("separator: ");
            System.out.println("separatorChar: ");
            System.out.println("getParent(): " + file.getParent());
            System.out.println("lastModified(): " + file.lastModified());
            System.out.println("exists(): " + file.exists());
            System.out.println("isFile(): " + file.isFile());
            System.out.println("isDirectory(): " + file.isDirectory());
            System.out.println("length(): " + file.length());

            System.out.println("My working or User directory: " + System.getProperty("user.olutobz"));
            System.out.println("new File(\"testdir\").mkdir(): " + new File("testdir").mkdir());

        }
    }

    private void doDeserialization() {
        System.out.println("\nInside doDeSerialization ...");

        try (ObjectInputStream in =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream("serial.ser")))) {
            SerializableDemo serializableObj = (SerializableDemo) in.readObject();
            System.out.println("name (after serialization): " + serializableObj.getName());
            System.out.println("id (after serialization): " + serializableObj.getId());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void doSerialization() {
        System.out.println("\nInside doSerialization ...");
        SerializableDemo serializableDemo = new SerializableDemo();
        serializableDemo.setName("Java");
        System.out.println("name (before serialization): " + serializableDemo.getName());
        System.out.println("id (before serialization): " + serializableDemo.getId());

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("serial.ser")))) {
            out.writeObject(serializableDemo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class SerializableDemo implements Serializable {
        // Static final Long serialVersionUID = 8882416210786165012L;
        // private String gender
        private String name;
        private transient int id = 4;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }
    }


}
