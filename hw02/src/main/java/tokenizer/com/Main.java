package tokenizer.com;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static String currentPath = System.getProperty("user.dir");

    public static void main(String[] args) {
        // Tokenizer code

        String sourceFileName = currentPath + "\\" + "source.c";
        String intermediateFileName = currentPath + "\\" + "intermediate_code.c";

        GetRidOfComments.removeCommentsAndSpaces(new File(sourceFileName), new File(intermediateFileName));



        if (intermediateFileName != null) {
            List<String> intermediateCode = tokenizeIntermediateCode(intermediateFileName);

            String symbolTableFile = currentPath + "\\" + "SymbolTablecode";
            buildAndPrintSymbolTable(intermediateFileName, symbolTableFile);


            SyntaxTree syntaxTree = new SyntaxTree();
            syntaxTree.buildSyntaxTree(intermediateCode);
            syntaxTree.writeTreeToFile(currentPath + "\\" + "SyntaxTree.txt");

            FileInfoWriter.writeFileInfo(sourceFileName, "FileInfo.txt");
        }

    }

    private static List<String> tokenizeIntermediateCode(String intermediateFileName) {
        // Step 2: Tokenize the intermediate code
        String outputFileName = currentPath + "\\" + "target.txt"; // Change this to your output file name

        try (FileReader reader = new FileReader(intermediateFileName);
             FileWriter writer = new FileWriter(outputFileName)) {

            ArrayList<String> words = TokenizerMethods.wordReader(reader);
            ArrayList<String> tokens = new ArrayList<>();
            Map<String, Integer> variableMap = new HashMap<>();

            for (String word : words) {
                TokenizerMethods.addTokens(tokens, word, variableMap);
            }
            tokens.add("count of b ==" + TokenizerMethods.counterOfb);
            String tokenCode = String.join("\n", tokens);

            try (BufferedWriter writers = new BufferedWriter(writer)) {
                writers.write(tokenCode);
            }

            System.out.println("The code has been successfully converted into tokens.");
            return tokens;

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
    private static void buildAndPrintSymbolTable(String inputFile, String outputFile) {
        SymbolTable symbolTable = new SymbolTable();
        try {
            symbolTable.buildSymbolTable(inputFile);
            symbolTable.printSymbolTable(outputFile);
            System.out.println("Symbol Table Converted: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
