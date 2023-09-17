package java17;

sealed class Shape permits Circle, Rectangle, Triangle {
    // Common code and attributes for all shapes
}

final class Circle extends Shape {
    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Additional methods and attributes specific to circles
}

// non-sealed because could be extended to Square for example
non-sealed class Rectangle extends Shape {
    final double width;
    final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Additional methods and attributes specific to rectangles
}

final class Triangle extends Shape {
    final double base;
    final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Additional methods and attributes specific to triangles
}

public class SealedClassHierarchy {
    public static void main(String[] args) {
        // TODO try changing this to null
        Shape shape = new Circle(5.0);

        // sneak peek of pattern matching for switch
        double area = switch (shape) {
            case null -> 0.0;
            case Circle c -> Math.PI * c.radius * c.radius;
            case Rectangle r -> r.width * r.height;
            case Triangle t -> 0.5 * t.base * t.height;
            default -> throw new IllegalStateException("This exception should never happen!"); // Default for unknown shapes
        };

        System.out.println("Area: " + area);
    }
}
