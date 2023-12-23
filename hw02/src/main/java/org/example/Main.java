package org.example;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String currentPath = System.getProperty("user.dir");
        System.out.println(currentPath);
        String sourceFileName = currentPath + "\\" + "source.txt"; // Change this to your source file name
        String outputFileName = currentPath + "\\" + "target.txt"; // Change this to your output file name

        try (FileReader reader = new FileReader(sourceFileName);
             FileWriter writer = new FileWriter(outputFileName)) {

            int charRead;
            while ((charRead = reader.read()) != -1) {
                writer.write(charRead);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}