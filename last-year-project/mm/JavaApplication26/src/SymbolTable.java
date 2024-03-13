 try (FileReader reader = new FileReader(sourceFileName);
             FileWriter writer = new FileWriter(outputFileName)) {

            ArrayList<String> words = TokenizerMethods.wordReader(reader);
            ArrayList<String> tokens = new ArrayList<>();
            Map<String, Integer> variableMap = new HashMap<>();

            for (String word : words) {
                System.out.println(word);
                TokenizerMethods.addTokens(tokens, word, variableMap);
            }
            String tokenCode = String.join("\n", tokens);
            System.out.println(tokenCode);

            try (BufferedWriter writers = new BufferedWriter(writer)) {
                writers.write(tokenCode);
            }

            System.out.println("The code has been successfully converted into tokens.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }

        // SymbolTable code
        String inputFile = currentPath + "\\target.txt"; // Assuming target.txt is the output file from the tokenizer
        String symbolTableOutputFile = currentPath + "\\SymbolTablecode.txt";