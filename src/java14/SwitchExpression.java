package java14;

import java.util.Arrays;

public class SwitchExpression {

    static String getAmericanGrade(int score) {
        String grade = "";

        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        return grade;
    }

    // TODO implement
    // hint: make use of integer division, e.g. (int) 85/10 = 8
    static String getAmericanGradeLessVerbosely(int score) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(85/10);
        int[] scores = {95, 100, 12, 24, 54, 73, 60};

        Arrays.stream(scores)
                .boxed()
                .map(SwitchExpression::getAmericanGrade)
                .forEach(System.out::println);

        Arrays.stream(scores)
                .boxed()
                .map(SwitchExpression::getAmericanGradeLessVerbosely)
                .forEach(System.out::println);
    }

}
