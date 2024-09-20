package main.java;
import java.util.Scanner;
public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
         // Getting user name input
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        // Getting user age input
        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume the newline character after age input
        // Getting user city input
        System.out.println("Enter your city: ");
        String city = sc.nextLine();
        // Conditional greeting based on age
        if (age < 18) {
            System.out.println("Hello, " + name + "! You're quite young at " + age + "!");
        } else {
            System.out.println("Hello, " + name + "! It's great to see someone aged " + age + " from " + city + " here.");
        }
        // Closing scanner
        sc.close();
    }
}
