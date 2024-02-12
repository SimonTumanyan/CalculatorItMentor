import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input:");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("Empty input");
        }

        String[] parts = input.split("\\+|\\-|\\*|\\/");

        if (parts.length != 2) {
            throw new IllegalArgumentException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        int num1;
        int num2;

        try  {
           num1 = Integer.parseInt(parts[0].trim());
           num2 = Integer.parseInt(parts[1].trim());
        } catch (Exception e ) {
            throw new IllegalArgumentException("invalit format exception");
        }


        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new IllegalArgumentException("Numbers must be between 1 and 10");
        }

        String operation = input.replaceAll("[^\\+\\-\\*\\/]", "");
        int result;

        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }

        System.out.println("Output: " + result);
    }
}