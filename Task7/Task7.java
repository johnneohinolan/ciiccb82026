import java.util.Scanner;

public class Task7 {

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error: Division by zero is undefined.");
            return Double.NaN; // Returns Not-a-Number for division by zero
        }
        return num1 / num2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double firstNum = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double secondNum = scanner.nextDouble();

        System.out.println("\n--- Results ---");
        
        double sum = add(firstNum, secondNum);
        System.out.println("Addition: " + firstNum + " + " + secondNum + " = " + sum);

        double difference = subtract(firstNum, secondNum);
        System.out.println("Subtraction: " + firstNum + " - " + secondNum + " = " + difference);

        double product = multiply(firstNum, secondNum);
        System.out.println("Multiplication: " + firstNum + " * " + secondNum + " = " + product);

        double quotient = divide(firstNum, secondNum);
        if (!Double.isNaN(quotient)) {
            System.out.println("Division: " + firstNum + " / " + secondNum + " = " + quotient);
        }

        scanner.close();
    }
}