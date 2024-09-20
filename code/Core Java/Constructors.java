// Car class with parameterized constructors
class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private double price;

    // Parameterized constructor with all attributes
    public Car(String make, String model, int year, String color, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
    }

    // Parameterized constructor with essential attributes
    public Car(String make, String model, int year) {
        this(make, model, year, "Unknown", 0.0); // Calls the full constructor with default values
    }

    // Parameterized constructor with known make and model only
    public Car(String make, String model) {
        this(make, model, 2023, "Unknown", 0.0); // Calls the full constructor with default values
    }

    // Copy constructor
    public Car(Car otherCar) {
        this(otherCar.make, otherCar.model, otherCar.year, otherCar.color, otherCar.price);
    }

    @Override
    public String toString() {
        return "Car{" +
               "make='" + make + '\'' +
               ", model='" + model + '\'' +
               ", year=" + year +
               ", color='" + color + '\'' +
               ", price=" + price +
               '}';
    }
}

// Customer class with parameterized constructors
class Customer {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    // Parameterized constructor for new customer
    public Customer(String name, String email, String phoneNumber, String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Parameterized constructor with essential attributes
    public Customer(String name, String email) {
        this(name, email, "N/A", "N/A"); // Calls the full constructor with default values
    }

    // Parameterized constructor for known name and email only
    public Customer(String name) {
        this(name, "unknown@example.com", "N/A", "N/A"); // Calls the full constructor with default values
    }

    // Copy constructor
    public Customer(Customer otherCustomer) {
        this(otherCustomer.name, otherCustomer.email, otherCustomer.phoneNumber, otherCustomer.address);
    }

    @Override
    public String toString() {
        return "Customer{" +
               "name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               ", address='" + address + '\'' +
               '}';
    }
}

// Main class to demonstrate the use of constructors
public class Constructors {
    public static void main(String[] args) {
        // Car examples
        Car car1 = new Car("Toyota", "Camry", 2022, "Blue", 30000.0);
        Car car2 = new Car("Honda", "Civic", 2021);
        Car car3 = new Car("Ford", "Mustang");
        Car car4 = new Car(car1); // Using copy constructor

        System.out.println("Car Examples:");
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car4);

        // Customer examples
        Customer customer1 = new Customer("Alice Johnson", "alice.johnson@example.com", "555-1234", "123 Maple St");
        Customer customer2 = new Customer("Bob Smith", "bob.smith@example.com");
        Customer customer3 = new Customer("Charlie Brown");
        Customer customer4 = new Customer(customer1); // Using copy constructor

        System.out.println("\nCustomer Examples:");
        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
        System.out.println(customer4);
    }
}
