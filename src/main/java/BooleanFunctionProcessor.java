import java.io.*;
import java.util.*;

public class BooleanFunctionProcessor {
    private static final String FILE_NAME = "src/main/boole.txt";

    public static void process() {
        try {
            String booleanExpression = readFromFile(FILE_NAME);
            List<Character> variables = extractVariables(booleanExpression);
            int[][] truthTable = generateTruthTable(variables, booleanExpression);
            printTruthTable(variables, truthTable);
            printExpressions(variables, truthTable);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    private static String readFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        reader.close();
        return line;
    }

    private static List<Character> extractVariables(String expression) {
        Set<Character> variables = new TreeSet<>();
        for (char c : expression.toCharArray()) {
            if (Character.isLetter(c) && Character.isUpperCase(c)) {
                variables.add(c);
            }
        }
        return new ArrayList<>(variables);
    }

    private static int[][] generateTruthTable(List<Character> variables, String expression) {
        int rows = (int) Math.pow(2, variables.size());
        int cols = variables.size() + 1;
        int[][] table = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] binary = decimalToBinary(i, variables.size());
            System.arraycopy(binary, 0, table[i], 0, variables.size());
            table[i][variables.size()] = evaluateExpression(binary, variables, expression);
        }

        return table;
    }

    private static int[] decimalToBinary(int decimal, int bits) {
        int[] binary = new int[bits];
        for (int i = bits - 1; i >= 0; i--) {
            binary[i] = decimal % 2;
            decimal /= 2;
        }
        return binary;
    }

    private static int evaluateExpression(int[] values, List<Character> variables, String expression) {
        // Placeholder for the actual expression evaluation logic
        return 0;
    }

    private static void printTruthTable(List<Character> variables, int[][] table) {
        for (Character variable : variables) {
            System.out.print(variable + " ");
        }
        System.out.println("F");
        for (int[] row : table) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static void printExpressions(List<Character> variables, int[][] table) {
        // Placeholder for printing minterms and maxterms
    }
}
