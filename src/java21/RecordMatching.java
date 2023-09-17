public class RecordMatching {
    public static void main(String[] args) {
        System.out.println(recordMatch(new Consultant("Matthias", Language.JAVA)));
        System.out.println(recordMatch(new Consultant("Hannes", Language.DOTNET)));
        System.out.println(recordMatch(new Admin("Severine")));

        nesting(new Rectangle(new ColoredPoint(new Point(0, 0), Color.BLUE), new ColoredPoint(new Point(1, 1), Color.GREEN)));
    }

    private static String recordMatch (AxxesEmployee employee) {

        return switch (employee) {
            case Admin(var name) -> "%s is probably smart".formatted(name);
            case Consultant(var name, var l) when l == Language.JAVA -> "%s must be a genius".formatted(name);
            case Consultant(var s, var l) -> "Hmm... probably not so smart";

        };
    }

    private static void nesting(Rectangle r) {
        if (r instanceof Rectangle(ColoredPoint(Point p, Color c),
                                   ColoredPoint lr)) {
            System.out.println(c);
        }
    }
}

enum Language { JAVA, DOTNET}
sealed interface AxxesEmployee permits Admin, Consultant {}
record Admin (String name) implements AxxesEmployee {}
record Consultant (String name, Language lang)  implements AxxesEmployee {}


record Point(int x, int y) {}
enum Color { RED, GREEN, BLUE }
record ColoredPoint(Point p, Color c) {}
record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {}