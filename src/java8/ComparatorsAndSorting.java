package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorsAndSorting {
    static class TriangleArea {
        static class Triangle {
            private double side1;
            private double side2;
            private double side3;

            public Triangle(double side1, double side2, double side3) {
                this.side1 = side1;
                this.side2 = side2;
                this.side3 = side3;
            }

            // TODO implement
            public double calculateArea() {
                double area = -1.0;
                // Implement Heron's formula to calculate the area
                double s = (side1 + side2 + side3) / 2;
                return area;
            }

            public double getSide1() {
                return side1;
            }

            public double getSide2() {
                return side2;
            }

            public double getSide3() {
                return side3;
            }

            @Override
            public String toString() {
                return "Triangle [side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + "]";
            }
        }

        // TODO implement
        static Comparator<Triangle> triangleComparator = null;

        public static void main(String[] args) {
            Triangle triangle1 = new Triangle(3.0, 4.0, 5.0);   // A right triangle
            Triangle triangle2 = new Triangle(6.0, 8.0, 10.0);  // A right triangle (scaled up)
            Triangle triangle3 = new Triangle(5.0, 5.0, 5.0);   // An equilateral triangle
            Triangle triangle4 = new Triangle(7.0, 9.0, 12.0);  // A scalene triangle
            Triangle triangle5 = new Triangle(4.0, 4.0, 6.0);   // An isosceles triangle
            Triangle triangle6 = new Triangle(8.0, 15.0, 17.0); // A right triangle (Pythagorean triple)

            List<Triangle> triangles = new ArrayList<>();
            triangles.add(triangle1);
            triangles.add(triangle2);
            triangles.add(triangle3);
            triangles.add(triangle4);
            triangles.add(triangle5);
            triangles.add(triangle6);

            Collections.shuffle(triangles);

            var sortedTriangles = triangles.stream()
                    .sorted(triangleComparator.reversed())
                    .toList();

            System.out.println(sortedTriangles);
        }
    }


}
