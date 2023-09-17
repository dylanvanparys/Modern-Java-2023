package java16;

public class RecordExample {
    public static void main(String[] args) {
        // Creating a Point record instance
        Point point = new Point(3, 4);

        // Accessing record components
        int x = point.x(); // Accessing the x component
        int y = point.y(); // Accessing the y component

        // Printing the record components
        System.out.println("X coordinate: " + x);
        System.out.println("Y coordinate: " + y);

        // Printing the record
        System.out.println(point);
        point.test();
    }
}
