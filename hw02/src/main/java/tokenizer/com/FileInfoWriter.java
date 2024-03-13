package tokenizer.com;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class FileInfoWriter {

    public static void main(String[] args) {
        writeFileInfo("source.c", "output.txt");
    }

    public static void writeFileInfo(String sourceFileName, String outputFileName) {
        try {
            LocalDateTime startTime = LocalDateTime.now();
            List<String> lines = Files.readAllLines(Paths.get(sourceFileName));
            LocalDateTime endTime = LocalDateTime.now();
            Duration duration = Duration.between(startTime, endTime);

            int numberOfLines = lines.size();
            long fileSize = Files.size(Paths.get(sourceFileName));

            String yourName = "علي محمد الغناي";
            String yourID = "2191804737";
            String currentDate = LocalDateTime.now().toString();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                writer.write("Date: " + currentDate + "\n");
                writer.write("Compelling Time: " + duration.toMillis() + " milliseconds\n");
                writer.write("Number of Lines: " + numberOfLines + "\n");
                writer.write("Size of File (" + sourceFileName + "): " + fileSize + " bytes\n");
                writer.write("Your Name: " + yourName + "\n");
                writer.write("Your ID: " + yourID + "\n");
                System.out.println("File information written to: " + outputFileName);
            } catch (IOException e) {
                System.out.println("An error occurred while writing file information: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading source file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
