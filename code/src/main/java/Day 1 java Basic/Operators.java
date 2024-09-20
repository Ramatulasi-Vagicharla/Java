package main.java;

public class Operators {
    public static void main(String[] args) {
        // Basic boolean variables
        boolean t = true;
        boolean f = false;

        System.out.println("1. Basic Logical Operations:");
        System.out.println("   AND: true && true = " + (true && true));
        System.out.println("   AND: true && false = " + (t && f));
        System.out.println("   AND: false && true = " + (f && t));
        System.out.println("   OR: true || false = " + (t || f));
        System.out.println("   NOT: !true = " + (!t));
        System.out.println("   NOT: !false = " + (!f));

        System.out.println("\n2. Short-circuit Evaluation:");
        System.out.println("   false && (10 > 5) = " + (f && (10 > 5))); // No further evaluation after false
        System.out.println("   true || (10 < 5) = " + (t || (10 < 5))); // No further evaluation after true

        System.out.println("\n3. Operator Precedence:");
        System.out.println("   true || false && true = " + (t || f && t)); // && has higher precedence
        System.out.println("   (true || false) && true = " + ((t || f) && t)); // Parentheses alter the order

        System.out.println("\n4. Combining with Comparison Operators:");
        int x = 8, y = 12;
        System.out.println("   (x < y) && (y > 5) = " + ((x < y) && (y > 5)));
        System.out.println("   (x > y) || (y == 12) = " + ((x > y) || (y == 12)));

        System.out.println("\n5. Complex Conditions:");
        boolean a = true, b = false, c = false;
        System.out.println("   (a && b) || (a && c) = " + ((a && b) || (a && c)));
        System.out.println("   a && (b || !c) = " + (a && (b || !c)));

        System.out.println("\n6. Bitwise vs. Logical Operators:");
        System.out.println("   true & false = " + (t & f)); // Bitwise AND
        System.out.println("   true | false = " + (t | f)); // Bitwise OR
        System.out.println("   true ^ true = " + (t ^ t));  // Bitwise XOR

        System.out.println("\n7. Short-circuit vs. Non-short-circuit:");
        int i = 0;
        boolean result1 = (f && (++i > 0)); // i is not incremented
        boolean result2 = (f & (++i > 0));  // i is incremented
        System.out.println("   Short-circuit AND result: " + result1 + ", i = " + i);
        System.out.println("   Non-short-circuit AND result: " + result2 + ", i = " + i);

        System.out.println("\n8. Logical Operators with Non-boolean Operands:");
        System.out.println("   (3 < 5) && (7 > 2) = " + ((3 < 5) && (7 > 2)));
        System.out.println("   ('x' > 'a') || ('d' < 'c') = " + (('x' > 'a') || ('d' < 'c')));

        System.out.println("\n9. Logical Operators in Control Structures:");
        if (t && f) {
            System.out.println("   This won't be printed.");
        } else if (t || f) {
            System.out.println("   This will be printed since true || false = true.");
        }
        
        int j = 0;
        while (j < 2 && t) {
            System.out.println("   j = " + j);
            j++;
        }

        System.out.println("\n10. Logical Operators with Method Calls:");
        System.out.println("   isPositive(10) && isEven(6) = " + (isPositive(10) && isEven(6)));
        System.out.println("   isPositive(-4) || isEven(5) = " + (isPositive(-4) || isEven(5)));

        System.out.println("\n11. Logical Operators with Null Checks:");
        String str = "hello";
        System.out.println("   (str != null) && (str.length() > 0) = " + ((str != null) && (str.length() > 0)));

        System.out.println("\n12. Using Logical Operators for Conditional Assignment:");
        int value = t ? 1 : 0;
        System.out.println("   value = " + value);

        System.out.println("\n13. Logical Operators in Lambda Expressions:");
        java.util.function.Predicate<Integer> isPositiveAndOdd = n -> n > 0 && n % 2 != 0;
        System.out.println("   Is 7 positive and odd? " + isPositiveAndOdd.test(7));
        System.out.println("   Is 4 positive and odd? " + isPositiveAndOdd.test(4));
    }
    
    // Method to check if a number is positive
    private static boolean isPositive(int n) {
        return n > 0;
    }

    // Method to check if a number is even
    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
