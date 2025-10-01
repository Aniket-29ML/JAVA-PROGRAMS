/**
 * Calculator.java
 * This program implements a simple Calculator class that performs
 * basic arithmetic operations: addition, subtraction, multiplication, and division.
 */
public class Calculator {

    /**
     * Performs addition of two double numbers.
     * @param num1 The first number (augend).
     * @param num2 The second number (addend).
     * @return The sum of the two numbers.
     */
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    /**
     * Performs subtraction of two double numbers.
     * @param num1 The number to be subtracted from (minuend).
     * @param num2 The number to subtract (subtrahend).
     * @return The difference between the two numbers.
     */
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    /**
     * Performs multiplication of two double numbers.
     * @param num1 The first factor.
     * @param num2 The second factor.
     * @return The product of the two numbers.
     */
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    /**
     * Performs division of two double numbers.
     * It handles the case of division by zero gracefully.
     * @param num1 The dividend.
     * @param num2 The divisor.
     * @return The quotient of the two numbers, or Double.NaN if the divisor is zero.
     */
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            // Division by zero is mathematically undefined.
            // Returning Double.NaN (Not a Number) is a standard way to represent this in Java.
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return num1 / num2;
    }

    /**
     * Main method to demonstrate the Calculator functionality.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create an instance of the Calculator class
        Calculator myCalculator = new Calculator();

        // Define example numbers
        double a = 25.5;
        double b = 5.0;
        double c = 0.0;

        System.out.println("--- Basic Calculator Demonstration ---");
        System.out.println("First number (a): " + a);
        System.out.println("Second number (b): " + b);
        System.out.println("Zero (c): " + c);
        System.out.println("------------------------------------");

        // 1. Addition
        double sum = myCalculator.add(a, b);
        System.out.println(a + " + " + b + " = " + sum); // Expected: 30.5

        // 2. Subtraction
        double difference = myCalculator.subtract(a, b);
        System.out.println(a + " - " + b + " = " + difference); // Expected: 20.5

        // 3. Multiplication
        double product = myCalculator.multiply(a, b);
        System.out.println(a + " * " + b + " = " + product); // Expected: 127.5

        // 4. Division (Normal case)
        double quotient = myCalculator.divide(a, b);
        if (!Double.isNaN(quotient)) {
            System.out.println(a + " / " + b + " = " + quotient); // Expected: 5.1
        }

        System.out.println("------------------------------------");
        // 5. Division (Error case: Division by Zero)
        double zeroDivision = myCalculator.divide(a, c);
        if (Double.isNaN(zeroDivision)) {
            System.out.println("Result of " + a + " / " + c + " is handled as an error (NaN).");
        }
    }
}
