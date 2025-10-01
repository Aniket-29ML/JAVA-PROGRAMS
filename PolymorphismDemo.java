import java.lang.Math;

/**
 * Main class to demonstrate Method Overriding and Method Overloading (Polymorphism).
 *
 * Requirements fulfilled:
 * 1. Method Overriding: Circle and Rectangle override the area() method from Shape.
 * 2. Method Overloading: The Shape class has overloaded area methods (no parameters vs. one parameter).
 */
public class PolymorphismDemo {
    public static void main(String[] args) {
        // --- 1. Demonstration of Method Overriding (Runtime Polymorphism) ---

        System.out.println("--- Method Overriding Demonstration ---");
        
        // Polymorphic references: Shape reference pointing to Subclass objects
        Shape circle = new Circle(7.0);
        Shape rectangle = new Rectangle(10.0, 5.0);
        
        // At runtime, the JVM determines which area() method to call
        // based on the actual object type, not the reference type (Shape).
        System.out.print("Circle object (radius=7.0): ");
        circle.area();
        
        System.out.print("Rectangle object (10.0x5.0): ");
        rectangle.area();

        // Calling the base class method directly
        Shape genericShape = new Shape();
        System.out.print("Generic Shape object: ");
        genericShape.area();


        // --- 2. Demonstration of Method Overloading (Compile-Time Polymorphism) ---

        System.out.println("\n--- Method Overloading Demonstration ---");

        // The compiler determines which area method to call based on the arguments provided.
        Shape calculator = new Shape();

        // Call the overloaded area(double) method for square
        System.out.print("Shape area (side=8.0) using overloading: ");
        calculator.area(8.0); 

        // Overloading in subclasses is also possible, but for demonstration, 
        // we'll primarily use the overloaded area methods in the base Shape class.
    }
}

/**
 * The Base Class: Defines the standard area() method to be overridden.
 */
class Shape {
    /**
     * The primary area method for Method Overriding. 
     * Subclasses must override this to provide specific area calculation logic.
     */
    public void area() {
        System.out.println("This is the generic area calculation for a Shape. Specific shape area not defined.");
    }

    /**
     * An Overloaded area method to demonstrate Compile-Time Polymorphism.
     * Calculates the area of a square (side * side).
     * @param side The length of the side of the square.
     */
    public void area(double side) {
        double result = side * side;
        System.out.printf("Area of a Square: %.2f (Calculated via Overloading)\n", result);
    }
}

/**
 * Subclass Circle: Overrides the area() method from Shape.
 */
class Circle extends Shape {
    private double radius;
    private final double PI = 3.14159; // Using a fixed PI for simplicity

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Method Overriding: Provides the specific implementation for Circle's area.
     * Formula: PI * radius * radius
     */
    @Override
    public void area() {
        double result = PI * radius * radius;
        System.out.printf("Area of Circle: %.2f (Calculated via Overriding)\n", result);
    }
}

/**
 * Subclass Rectangle: Overrides the area() method from Shape.
 */
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Method Overriding: Provides the specific implementation for Rectangle's area.
     * Formula: length * width
     */
    @Override
    public void area() {
        double result = length * width;
        System.out.printf("Area of Rectangle: %.2f (Calculated via Overriding)\n", result);
    }
}