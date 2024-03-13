package tokenizer.com;

import java.io.*;

public class GetRidOfComments {
    public static String removeCommentsAndSpaces(File inputFile, File intermediateFile) {
        try {
            StringBuilder codeWithoutCommentsBuilder = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                boolean inMultiLineComment = false;

                String line;
                while ((line = reader.readLine()) != null) {
                    // Check if inside a multi-line comment
                    if (inMultiLineComment) {
                        int endIndex = line.indexOf("*/");
                        if (endIndex != -1) {
                            // End of multi-line comment found
                            inMultiLineComment = false;
                            line = line.substring(endIndex + 2).trim();
                        } else {
                            // Skip the line as it's inside a multi-line comment
                            continue;
                        }
                    } else {
                        // Handle single-line comments and multi-line comments
                        line = handleSingleLineComment(line);
                        inMultiLineComment = handleMultiLineComment(line, inMultiLineComment);
                    }

                    // Remove extra spaces and append the line to the StringBuilder
                    if (!line.isEmpty()) {
                        line = line.replaceAll("\\s+", " ");
                        codeWithoutCommentsBuilder.append(line).append("\n");
                    }
                }
            }

            String codeWithoutComments = codeWithoutCommentsBuilder.toString().trim();

            // Write the final code to the output file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(intermediateFile))) {
                writer.write(codeWithoutComments);
            }

            System.out.println("Comments and spaces removed.");
            return intermediateFile.getPath();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return null;
    }

    private static String handleSingleLineComment(String line) {
        int singleLineIndex = line.indexOf("//");
        return (singleLineIndex != -1) ? line.substring(0, singleLineIndex).trim() : line;
    }

    private static boolean handleMultiLineComment(String line, boolean inMultiLineComment) {
        int multiLineStartIndex = line.indexOf("/*");
        int multiLineEndIndex = line.indexOf("*/");

        if (multiLineStartIndex != -1) {
            if (multiLineEndIndex != -1) {
                // Both start and end of a multi-line comment found on the same line
                return false;
            } else {
                // Start of a multi-line comment found, but end is not on this line
                return true;
            }
        } else {
            return inMultiLineComment && (multiLineEndIndex == -1);
        }
    }


}
