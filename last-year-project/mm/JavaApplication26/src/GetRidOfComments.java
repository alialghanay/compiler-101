import java.io.*;

public class GetRidOfComments {
    public static void removeCommentsAndSpaces(File inputFile, File outputFile) {
        try {
            // StringBuilder to store code without comments and extra spaces
            StringBuilder codeWithoutCommentsBuilder = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                boolean inMultiLineComment = false;

                while ((line = reader.readLine()) != null) {
                    line = line.trim();

                    // Check if inside a multi-line comment
                    if (inMultiLineComment) {
                        int endIndex = line.indexOf("*/");
                        if (endIndex != -1) {
                            // End of multi-line comment found
                            inMultiLineComment = false;
                            line = line.substring(endIndex + 2);
                        } else {
                            // Skip the line as it's inside a multi-line comment
                            continue;
                        }
                    }

                    int startIndex = line.indexOf("/*");
                    int endIndex = line.indexOf("*/");

                    // Handle single-line comments and multi-line comments
                    if (startIndex != -1) {
                        if (endIndex != -1) {
                            // Both start and end of a multi-line comment found on the same line
                            line = line.substring(0, startIndex) + line.substring(endIndex + 2);
                        } else {
                            // Start of a multi-line comment found, but end is not on this line
                            inMultiLineComment = true;
                            line = line.substring(0, startIndex);
                        }
                    } else if (endIndex != -1) {
                        // End of a multi-line comment found, but start is not on this line
                        inMultiLineComment = false;
                        line = line.substring(endIndex + 2);
                    }

                    // Remove extra spaces and append the line to the StringBuilder
                    if (!line.isEmpty()) {
                        line = line.replaceAll("\\s+", " ");
                        codeWithoutCommentsBuilder.append(line).append("\n");
                    }
                }
            }

            // Get the final code without comments and extra spaces
            String codeWithoutComments = codeWithoutCommentsBuilder.toString().trim();

            // Write the final code to the output file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                writer.write(codeWithoutComments);
            }

            System.out.println("Comments and spaces removed.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
