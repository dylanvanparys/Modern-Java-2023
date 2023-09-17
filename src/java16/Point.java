package java16;

public record Point(int x, int y) {
    void test() {
        System.out.println("this is a point: " + this);
    }
}
