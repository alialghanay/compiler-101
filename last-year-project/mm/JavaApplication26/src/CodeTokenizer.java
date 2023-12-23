import java.io.*;
import java.util.*;

public class CodeTokenizer {
    public static void CodeTokenizer(File inputFile, File outputFile) {
        try {
            // Build the code by reading lines from the input file
            StringBuilder codeBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    codeBuilder.append(line).append("\n");
                }
            }
            
            // Convert the code builder into a string
            String code = codeBuilder.toString();
            List<String> tokens = new ArrayList<>();
            Map<String, Integer> variableMap = new HashMap<>();
            StringBuilder currentTokenBuilder = new StringBuilder();
            
            // Tokenization process
            for (int i = 0; i < code.length(); i++) {
                char ch = code.charAt(i);
                
                // Build the current token by appending valid characters
                if (Character.isLetterOrDigit(ch) || ch == '.') {
                    currentTokenBuilder.append(ch);
                } else {
                    // Add the current token and reset the builder when encountering non-valid characters
                    addToken(tokens, currentTokenBuilder.toString(), variableMap);
                    currentTokenBuilder.setLength(0); // Reset the currentTokenBuilder
                    
                    // Process non-whitespace characters
                    if (!Character.isWhitespace(ch)) {
                        addOperatorOrSpecialToken(tokens, ch);
                    }
                }
            }
            
            // Join the tokens and prepare the tokenized code
            String tokenizedCode = String.join("\n", tokens);
            
            // Write the tokenized code to the output file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                writer.write(tokenizedCode);
            }
            
            System.out.println("The code has been successfully converted into tokens.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Add a token to the tokens list based on the currentToken
    private static void addToken(List<String> tokens, String currentToken, Map<String, Integer> variableMap) {
        if (!currentToken.isEmpty()) {
            if (isReservedWord(currentToken)) {
                if (currentToken.equals("int") || currentToken.equals("float")) {
                    tokens.add("<Type : " + currentToken + " >");
                } else {
                    tokens.add("<" + currentToken + ">");
                }
            } else if (isNumber(currentToken)) {
                tokens.add("<T_INTCONSTANT : " + currentToken + " >");
            } else {
                addVariableToken(tokens, currentToken, variableMap);
            }
        }
    }
    
    // Add a variable token to the tokens list
    private static void addVariableToken(List<String> tokens, String currentToken, Map<String, Integer> variableMap) {
        Integer id = variableMap.computeIfAbsent(currentToken, key -> variableMap.size() + 1);
        tokens.add("<T_IDENTIFER : " + id + "," + currentToken + " >");
    }
    
    // Add an operator or special token to the tokens list
    private static void addOperatorOrSpecialToken(List<String> tokens, char ch) {
        String token = String.valueOf(ch);
        
        // Handle cases where '=' is part of an operator
        if (ch == '=' && tokens.size() > 0 && isOperator(tokens.get(tokens.size() - 1))) {
            tokens.set(tokens.size() - 1, "<T_OPERATOR : = " + token + " >");
        } else if (isOperator(token)) {
            tokens.add("<T_OPERATOR : " + token + " >");
        } else if (token.matches("[{}();]")) {
            tokens.add("<T_SPECIAL : " + token + " >");
        }
    }
    
    // Rest of the methods (isReservedWord, isNumber, isOperator) remain the same...
    // Define whether a token is a reserved word
    private static boolean isReservedWord(String token) {
        String[] reservedWords = {"main", "int", "float", "if", "goto", "cout", "cin"};
        return Arrays.asList(reservedWords).contains(token);
    }

    // Define whether a token is a valid number
    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Define whether a token is a valid operator
    private static boolean isOperator(String token) {
        String[] operators = {"+", "-", "*", "/", "=", "%", "++", "--", "==", "!=", "!", ">", ">=", "<", "<=", "&&", "||"};
        return Arrays.asList(operators).contains(token);
    }
}
