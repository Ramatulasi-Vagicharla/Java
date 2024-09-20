import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JavaControlStatements {
    public static void main(String[] args) {
        conditionalStatements();
        loopingStatements();
        jumpStatements();
        exceptionHandling();
        assertions();
    }

    private static void conditionalStatements() {
        System.out.println("Conditional Statements");
        boolean hasVoterID = true;
        int age = 19;
        if (hasVoterID && age >= 18) {
            System.out.println("You are eligible to vote");
            if (age >= 18) {
                System.out.println("You can apply for a voter ID");
            } else {
                System.out.println("You are not eligible to apply for a voter ID");
            }
        } else {
            System.out.println("You are not eligible to vote");
        }

        char grade = 'A';
        switch (grade) {
            case 'A':
                System.out.println("Excellent performance!");
                break;
            case 'B':
                System.out.println("Good job!");
                break;
            case 'C':
                System.out.println("Satisfactory result.");
                break;
            case 'D':
                System.out.println("You need to improve.");
                break;
            case 'F':
                System.out.println("Failed. Please try again.");
                break;
            default:
                System.out.println("Invalid grade entered.");
        }
    }

    // 2. Looping Statements
    private static void loopingStatements() {
        System.out.println("\n--- Looping Statements ---");

        // 2.1 for loop - Print even numbers between 1 and 10
        System.out.println("For loop - Even numbers between 1 and 10:");
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Even Number: " + i);
        }

        // 2.2 Enhanced for loop (for-each) - Sum of array elements
        System.out.println("\nEnhanced for loop - Sum of array elements:");
        int[] numbers = {2, 4, 6, 8, 10};
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum of numbers: " + sum);

        // 2.3 while loop - Print square of numbers from 1 to 5
        System.out.println("\nWhile loop - Square of numbers from 1 to 5:");
        int count = 1;
        while (count <= 5) {
            System.out.println("Square of " + count + ": " + (count * count));
            count++;
        }

        // 2.4 do-while loop - Print numbers in reverse from 5 to 1
        System.out.println("\nDo-while loop - Numbers in reverse from 5 to 1:");
        int num = 5;
        do {
            System.out.println("Number: " + num);
            num--;
        } while (num >= 1);
    }

    // 3. Jump Statements
    private static void jumpStatements() {
        System.out.println("\n--- Jump Statements ---");

        // 3.1 break statement - Stop at first number divisible by 4
        System.out.println("Break statement - Stop at first number divisible by 4:");
        for (int i = 1; i <= 10; i++) {
            if (i % 4 == 0) {
                break;
            }
            System.out.println("Number: " + i);
        }

        // 3.2 continue statement - Skip odd numbers
        System.out.println("\nContinue statement - Skip odd numbers:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                continue;
            }
            System.out.println("Even Number: " + i);
        }

        // 3.3 return statement - Returning the product of two numbers
        System.out.println("\nReturn statement - Product of two numbers:");
        System.out.println("Product: " + multiply(4, 7));
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    // 4. Exception Handling
    private static void exceptionHandling() {
        System.out.println("\n--- Exception Handling ---");

        // 4.1 try-catch - Handling NumberFormatException
        System.out.println("Try-catch - Handling NumberFormatException:");
        
        try {
            Integer.parseInt("ABC"); // Invalid number format
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 4.2 try-catch-finally - Handling null pointer exception
        System.out.println("\nTry-catch-finally - Handling NullPointerException:");
        String str = null;
        try {
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("This block always executes.");
        }

        // 4.3 try-with-resources - Handling file not found
        System.out.println("\nTry-with-resources - File not found:");
        try (BufferedReader br = new BufferedReader(new FileReader("nonexistent.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // 5. Assertions
    private static void assertions() {
        System.out.println("\n--- Assertions ---");
        int price = -10;
        assert price >= 0 : "Price cannot be negative!";
        System.out.println("Price: " + price);
    }
}
