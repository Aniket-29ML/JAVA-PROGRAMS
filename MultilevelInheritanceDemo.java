// Step 1: Define the Grandparent class
class Vehicle {
    String type = "General Vehicle";

    public void displayVehicleInfo() {
        System.out.println("Type: " + type);
        System.out.println("This is the base class for all vehicles.");
    }
}

// Step 2: Define the Parent class, which inherits from Vehicle
class Car extends Vehicle {
    String category = "Passenger Car";
    
    public Car() {
        // Set the type inherited from Vehicle to be more specific
        super.type = "Four-Wheeler"; 
    }

    public void displayCarInfo() {
        // Accesses members from the immediate parent (Vehicle)
        displayVehicleInfo(); 
        System.out.println("Category: " + category);
        System.out.println("It's used for transporting people.");
    }
}

// Step 3: Define the Child class, which inherits from Car (and indirectly from Vehicle)
class SportsCar extends Car {
    String feature = "High-Performance Engine";
    
    public SportsCar() {
        // Set the category inherited from Car to be more specific
        super.category = "High-Performance Sports Car";
    }

    public void displaySportsCarInfo() {
        // Accesses members from the immediate parent (Car) which, 
        // in turn, accesses members from its parent (Vehicle)
        displayCarInfo(); 
        System.out.println("Special Feature: " + feature);
        System.out.println("This car is designed for speed and agility.");
    }
}

// Main class to test the hierarchy
public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        // Create an object of the lowest-level class
        SportsCar myFerrari = new SportsCar();

        System.out.println("--- Demonstrating Multilevel Inheritance ---");
        
        // Calling a method from the SportsCar class, 
        // which calls methods up the inheritance chain (Car -> Vehicle)
        myFerrari.displaySportsCarInfo(); 
        
        System.out.println("\n--- The SportsCar object has access to all members of its ancestors. ---");
    }
}