package tokenizer.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SyntaxTree {
    private Node root;

    public SyntaxTree() {
        this.root = new Node("Program");
    }

    public void buildSyntaxTree(List<String> intermediateCode) {
        for (String line : intermediateCode) {
            Node statementNode = parseStatement(line);
            root.addChild(statementNode);
        }
    }

    private Node parseStatement(String statement) {
        Node statementNode = new Node("Statement");

        // Split the statement into parts (e.g., assignment, condition, loop, etc.)
        String[] parts = statement.split("\\s*=[^=]|\\s*\\+\\s*|\\s*-\\s*|\\s*\\*\\s*|\\s*/\\s*|\\s*==\\s*|\\s*!=\\s*|\\s*<=\\s*|\\s*>=\\s*|\\s*<\\s*|\\s*>\\s*|\\s*\\(\\s*|\\s*\\)\\s*|\\s*;\\s*");

        for (String part : parts) {
            // Skip empty parts
            if (part.trim().isEmpty()) {
                continue;
            }

            Node partNode = parseExpression(part);
            statementNode.addChild(partNode);
        }

        return statementNode;
    }

    private Node parseExpression(String expression) {
        Node expressionNode = new Node("Expression");

        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            Node tokenNode = new Node(token);
            expressionNode.addChild(tokenNode);
        }

        return expressionNode;
    }

    public void writeTreeToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writeTreeToFile(root, 0, writer);
            System.out.println("Syntax tree saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the syntax tree to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void writeTreeToFile(Node node, int depth, BufferedWriter writer) throws IOException {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append("  ");
        }

        writer.write(indent.toString() + "+-- " + node.getValue() + "\n");

        List<Node> children = node.getChildren();
        int numChildren = children.size();

        for (int i = 0; i < numChildren; i++) {
            Node child = children.get(i);
            boolean isLastChild = (i == numChildren - 1);

            if (isLastChild) {
                writeTreeToFile(child, depth + 1, (BufferedWriter) writer.append(indent.toString() + "    "));
            } else {
                writeTreeToFile(child, depth + 1, (BufferedWriter) writer.append(indent.toString() + "|   "));
            }
        }
    }

    public static class Node {
        private String value;
        private List<Node> children;

        public Node(String value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        public String getValue() {
            return value;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void addChild(Node child) {
            children.add(child);
        }
    }
}
