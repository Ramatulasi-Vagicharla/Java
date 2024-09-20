

// This program demonstrates Object-Oriented Programming (OOP) concepts in Java
// with revised examples for a fresh perspective.

class Vehicle {
    // Fields (attributes)
    String type;
    int wheels;

    // Constructor: special method to initialize objects
    Vehicle(String type, int wheels) {
        this.type = type;
        this.wheels = wheels;
    }

    // Method (behavior)
    void displayDetails() {
        System.out.println("Vehicle: " + type + " with " + wheels + " wheels");
    }
}

// Encapsulation
class Student {
    // Private fields - can only be accessed within this class
    private String id;
    private double gpa;

    // Constructor
    public Student(String id, double gpa) {
        this.id = id;
        this.gpa = gpa;
    }

    // Public methods to access and modify the private fields
    public String getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public void updateGpa(double newGpa) {
        if (newGpa >= 0.0) {
            gpa = newGpa;
        }
    }
}

// Inheritance
class Bird {
    String species;

    Bird(String species) {
        this.species = species;
    }

    void fly() {
        System.out.println(species + " is flying.");
    }
}

class Sparrow extends Bird {
    Sparrow(String species) {
        super(species); // Call the superclass constructor
    }

    void chirp() {
        System.out.println(species + " is chirping.");
    }
}

// Polymorphism
class Fish extends Bird {
    Fish(String species) {
        super(species);
    }

    // Override the fly() method
    @Override
    void fly() {
        System.out.println(species + " cannot fly. It's a fish!");
    }

    void swim() {
        System.out.println(species + " is swimming.");
    }
}

// Abstraction
abstract class Appliance {
    abstract void turnOn();

    void description() {
        System.out.println("This is an appliance.");
    }
}

class WashingMachine extends Appliance {
    @Override
    void turnOn() {
        System.out.println("Washing machine is now running.");
    }
}

// Interfaces
interface Chargeable {
    void charge();
}

class ElectricCar extends Vehicle implements Chargeable {
    ElectricCar(String type, int wheels) {
        super(type, wheels);
    }

    @Override
    public void charge() {
        System.out.println("Charging the electric car.");
    }
}

// Main class to demonstrate all concepts
public class JavaOOPConcepts {
    public static void main(String[] args) {
        // 1. Classes and Objects
        System.out.println("1. Classes and Objects:");
        Vehicle bike = new Vehicle("Motorbike", 2);
        bike.displayDetails();

        // 2. Encapsulation
        System.out.println("\n2. Encapsulation:");
        Student student = new Student("S123", 3.5);
        student.updateGpa(3.8);
        System.out.println("Student ID: " + student.getId());
        System.out.println("Updated GPA: " + student.getGpa());

        // 3. Inheritance
        System.out.println("\n3. Inheritance:");
        Sparrow sparrow = new Sparrow("Sparrow");
        sparrow.fly();
        sparrow.chirp();

        // 4. Polymorphism
        System.out.println("\n4. Polymorphism:");
        Bird myBird = new Fish("Goldfish");
        myBird.fly(); // This will call the overridden method in Fish

        // 5. Abstraction
        System.out.println("\n5. Abstraction:");
        Appliance washer = new WashingMachine();
        washer.turnOn();
        washer.description();

        // 6. Interfaces
        System.out.println("\n6. Interfaces:");
        ElectricCar tesla = new ElectricCar("Tesla", 4);
        tesla.charge();
        tesla.displayDetails();
    }
}
