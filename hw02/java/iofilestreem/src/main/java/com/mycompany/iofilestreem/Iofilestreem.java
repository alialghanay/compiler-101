/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.iofilestreem;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author HP
 */
public class Iofilestreem {

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
