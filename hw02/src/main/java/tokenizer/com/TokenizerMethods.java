package tokenizer.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TokenizerMethods {
    private static String[] cWord = {"main", "if", "else", "printf" , "#include", "<stdio.h>", "return", "scanf", "else", "switch", "case", "break", "enum", "register", "const", "continue", "goto", "sizeof", "while", "do", "for", "static"};
    private static String[] dataType = {"int", "float", "char", "double", "long", "short", "typedef", "void"};
    private static String[] operators = {"+", "-", "*", "/", "=", "%", "++", "--", "==", "!=", "!", ">", ">=", "<", "<=", "&&", "||"};
    private static String special = "[{}();#]";
    public static int counterOfb = 0;


    public static ArrayList<String> wordReader(FileReader cFile) {
        ArrayList<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        int currentChar;
        Boolean switcher = false;
        int isWordCounter = 0;
        int isOpOrSpCounter = 0;

        try (BufferedReader reader = new BufferedReader(cFile)) {
            while ( (currentChar = reader.read()) != -1) {
                char currentCharacter = (char) currentChar;
                boolean wordState = (word.length() > 0) || Character.isWhitespace(currentCharacter);
                boolean isSpace = Character.isWhitespace(currentCharacter);
                boolean isWord = Character.isLetterOrDigit(currentCharacter) || currentCharacter == '.';
                boolean isOpOrSp = isOperator(String.valueOf(currentCharacter)) || isSpecial(String.valueOf(currentCharacter));

                if(currentCharacter == '"')switcher = !switcher;
                if(currentCharacter == '(') counterOfb++;

                if(switcher && isWordCounter == 0 && isOpOrSpCounter == 0) {
                    word.append(currentCharacter);
                }else if (isWord && isOpOrSpCounter == 0) {
                    word.append(currentCharacter);
                    isWordCounter++;
                }else if(isOpOrSp && isWordCounter == 0) {
                    word.append(currentCharacter);
                    isOpOrSpCounter++;
                }else if(wordState) {
                    isWordCounter = isOpOrSpCounter = 0;
                    words.add(word.toString());
                    word.setLength(0);
                    if(!isSpace){
                        if (isWord && isOpOrSpCounter == 0) {
                            word.append(currentCharacter);
                            isWordCounter++;
                        }else if(isOpOrSp && isWordCounter == 0) {
                            word.append(currentCharacter);
                            isOpOrSpCounter++;
                        }
                    }
                }
            }

            if (word.length() > 0) {
                words.add(word.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }
    public static void addTokens(List<String> tokens, String currentToken, Map<String, Integer> variableMap) {
        if (!currentToken.isEmpty()) {
            if (isDataType(currentToken)) tokens.add("<DATATYPE --> " + currentToken + " >");
            else if(isCWord(currentToken)) tokens.add("<C KeyWord --> " + currentToken + " >");
            else if (isNumber(currentToken)) tokens.add("<CONSTANT --> " + currentToken + " >");
            else if(isOperator(currentToken))tokens.add("<OPERATOR --> " + currentToken + " >");
            else if(isSpecial(currentToken)) tokens.add("<SPECIAL --> " + currentToken + " >");
            else variableToken(tokens, currentToken, variableMap);
        }
    }


    public static void variableToken(List<String> tokens, String currentToken, Map<String, Integer> variableMap) {
        Integer id = variableMap.computeIfAbsent(currentToken, key -> variableMap.size() + 1);
        tokens.add("<ID : " + id + " --> " + currentToken + " >");
    }




    public static boolean isCWord(String token) {
        return Arrays.asList(cWord).contains(token);
    }

    public static boolean isDataType(String token) {
        return Arrays.asList(dataType).contains(token);
    }
    public static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean test(String c) {
        return c.equals('(');
    };

    public static boolean isOperator(String token) {
        return Arrays.asList(operators).contains(token);
    }

    public static boolean isSpecial(String token) {
        return token.matches(special);
    }
}
