package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionsAndMapping {
    static class RectangleArea {
        static class Rectangle {
            private double width;
            private double height;

            public Rectangle(double width, double height) {
                this.width = width;
                this.height = height;
            }

            public double getWidth() {
                return width;
            }

            public double getHeight() {
                return height;
            }

            @Override
            public String toString() {
                return "[" + width + ", " + height + "]";
            }
        }


        public static void main(String[] args) {
            List<Rectangle> rectangles = new ArrayList<>();
            rectangles.add(new Rectangle(4.0, 5.0));
            rectangles.add(new Rectangle(3.0, 6.0));
            rectangles.add(new Rectangle(2.5, 7.0));
            rectangles.add(new Rectangle(5.0, 5.5));

            // TODO implement
            Function<Rectangle, Double> calculateArea = r -> -1.0;

            // TODO implement
            List<Double> areas = null;


            // Print the original list of rectangles and the list of areas
            System.out.println("Original List of Rectangles: " + rectangles);
            System.out.println("Calculated Areas: " + areas);
        }
    }

    static class FlatteningMatrices {
        static Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // TODO implement using streams
        // hint: use .flatMap
        // use google if you have issues creating the stream
        static List<Integer> getFlattened(Integer[][] matrix) {
            return null;
        }

        public static void main(String[] args) {
            System.out.println("original: "+Arrays.deepToString(matrix));
            System.out.println("flattened: "+getFlattened(matrix));
        }
    }
}
