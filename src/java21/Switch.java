package java21;

public class Switch {
    public static void main(String[] args) {
        System.out.println(patternMatch(""));
        System.out.println(exhaustive(new Economics()));
        System.out.println(when("thisislonger"));
        System.out.println(nullCheck(null));
    }

    public static int patternMatch(Object obj) {
        return switch (obj) {
            case String s -> 1;
            case Integer x -> x + 3;
            default -> 2; // Does not compile without this default, as Object could be much more than String or Integer!
        };
    }

    public static int when(Object o) {
        return switch (o){
            case String s when s.length() > 4 -> 4;
            case String s -> s.length();
            case Integer x -> x+3;
            default -> 2;
        };
    }

    public static int exhaustive (Subject s) {
        return switch (s) {
            case Economics e -> 1;
            case Maths m -> 2;
        };
    }

    public static int nullCheck (Subject s) {
        return switch (s) {
            case Economics e -> 1;
            case Maths m -> 2;
            case null -> 0; // Null check
        };
    }
}

sealed interface Subject permits Economics, Maths {}
non-sealed class Economics implements Subject {}
record Maths(String teacher) implements Subject {}

