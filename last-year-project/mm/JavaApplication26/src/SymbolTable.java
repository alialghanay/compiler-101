import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SymbolTable {
    private final static String currentPath = System.getProperty("user.dir");
   
    public static void SymbolTable() {
        String inputFile = currentPath + "\\CommentRemovercode";
        String outputFile = currentPath + "\\SymbolTablecode";

        SymbolTable symbolTable = new SymbolTable();
        try {
            symbolTable.buildSymbolTable(inputFile);
            symbolTable.printSymbolTable(outputFile);
            System.out.println("Table Converted:" + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void Symboltable(File CommentRemovercode, File Symboltablecode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private HashMap<Integer, SymbolTableEntry> symbolTable;
    private int idCounter;
    private int idToken = 1;
    private List<String> reservedWords;
    private ArrayList<String> tokenSet;

    public SymbolTable() {
        this.tokenSet = new ArrayList<String>();
        symbolTable = new HashMap<>();
        idCounter = 0;
        reservedWords = Arrays.asList("main", "int", "float", "if", "goto", "cout", "cin");
    }

    public void buildSymbolTable(String inputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    addToSymbolTable(lineNumber, line);
                }
                lineNumber++;
            }
        }
    }

    private void addToSymbolTable(int lineNumber, String line) {
    String[] tokens = line.split("\\W+");
        for (String token : tokens) {
            if (!token.isEmpty() && !isReservedWord(token) && !containsNumbers(token)) {
                if (!tokenTest(token)) {
                    tokenSet.add(token);
                    SymbolTableEntry entry = new SymbolTableEntry(idToken, token, "int", lineNumber);
                    symbolTable.put(idCounter, entry);
                    idCounter++;
                    idToken++;
                } else {
                    // Handle duplicate occurrences of the same token
                    SymbolTableEntry oldEntry = symbolTable.get(tokenSet.indexOf(token));
                    SymbolTableEntry entry = new SymbolTableEntry(oldEntry.getId(), token, "int", lineNumber);
                    symbolTable.put(idCounter, entry);
                    idCounter++;
                }
            }
        }
    }
    
    private boolean isReservedWord(String token) {
        return reservedWords.contains(token);
    }
    
    private boolean tokenTest(String token) {
        if(tokenSet.isEmpty()) return false;
        return tokenSet.contains(token);
    }
    

    private boolean containsNumbers(String token) {
        return token.matches(".*\\d.*");
    }

    public void printSymbolTable(String outputFile) throws IOException {
         try (FileWriter writer = new FileWriter(outputFile)) {
        writer.write("Symbol Table\n");
        writer.write("------------------------\n");
        writer.write("|| ID || Name  || Type || Line\n");
        writer.write("------------------------\n");
        for (SymbolTableEntry entry : symbolTable.values()) {
            writer.write(String.format("|| %d || %6s || %4s || %4d\n", entry.getId(), entry.getName(), entry.getType(), entry.getLine()));
        }
        writer.write("------------------------\n");
    }
    }

    class SymbolTableEntry {
        private int id;
        private String name;
        private String type;
        private int line;

        public SymbolTableEntry(int id, String name, String type, int line) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.line = line;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public int getLine() {
            return line;
        }
    }
}