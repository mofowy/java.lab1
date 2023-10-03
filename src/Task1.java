import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter operation (+, -, *, /): ");
        String operator = scanner.next();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        int result = 0;

        try {
            switch (operator) {
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
                        throw new ArithmeticException("You can't divide by zero.");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Error operator statement.");
            }

            System.out.println("Result: " + result);
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
