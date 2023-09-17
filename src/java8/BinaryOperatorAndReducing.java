package java8;

import java.util.List;

public class BinaryOperatorAndReducing {
    static class BaseStatsCalculation {
        static List<Integer> numbers = List.of(42, 17, 89, 53, 10, 76, 28, 65, 91, 34);

        static Integer getMaximum(List<Integer> numbers) {
            return null;
        }

        static Integer getMinimum(List<Integer> numbers) {
            return null;
        }

        static Integer getAverage(List<Integer> numbers) {
            if (numbers.isEmpty()) return null;
            return null;
        }

        public static void main(String[] args) {
            System.out.println(getMaximum(numbers));
            System.out.println(getMinimum(numbers));
            System.out.println(getAverage(numbers));
        }
    }
}
