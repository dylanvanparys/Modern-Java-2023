package java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class PredicatesAndFiltering {
    static class FindingPrimes {
        static boolean isPrime(int n) {
            if (n <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }

        // TODO implement
        static Collection<Integer> getPrimes(int start, int end) {
            return Collections.emptySet();
        }

        public static void main(String[] args) {
            System.out.println(getPrimes(0, 1000));
        }
    }

    static class CombiningPredicates {
        static class Person {
            private String name;
            private int age;
            private double salary;

            public Person(String name, int age, double salary) {
                this.name = name;
                this.age = age;
                this.salary = salary;
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }

            public double getSalary() {
                return salary;
            }
        }

        // TODO implement
        static Predicate<Person> isAdult;
        static Predicate<Person> isRich;
        static Predicate<Person> isRichAdult;

        // TODO implement
        static Collection<Person> getRichAdults(Collection<Person> people) {
            return Collections.emptySet();
        }
        public static void main(String[] args) {
            List<Person> people = new ArrayList<>();
            people.add(new Person("Alice", 25, 60000.0));
            people.add(new Person("Bob", 30, 45000.0));
            people.add(new Person("Charlie", 18, 70000.0));
            people.add(new Person("David", 40, 80000.0));

            System.out.println(getRichAdults(people));
        }
    }
}
