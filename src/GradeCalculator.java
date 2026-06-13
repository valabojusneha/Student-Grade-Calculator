/*public class GradeCalculator {

    public static int calculateTotal(int[] marks) {

        int total = 0;

        for (int m : marks) {
            total += m;
        }

        return total;
    }

    public static double calculatePercentage(int[] marks) {

        return (double) calculateTotal(marks) / marks.length;
    }

    public static String calculateGrade(double p) {

        if (p >= 90) return "A+";
        else if (p >= 80) return "A";
        else if (p >= 70) return "B";
        else if (p >= 60) return "C";
        else if (p >= 50) return "D";
        else return "F";
    }

    public static String getResult(int[] marks) {

        for (int m : marks) {
            if (m < 35) return "FAIL";
        }

        return "PASS";
    }
}*/

public class GradeCalculator {

    public static int total(int[] marks) {

        int sum = 0;

        for (int m : marks)
            sum += m;

        return sum;
    }

    public static double percentage(int[] marks) {

        return (double) total(marks) / marks.length;
    }

    public static String grade(double p) {

        if (p >= 90) return "A+";
        else if (p >= 80) return "A";
        else if (p >= 70) return "B";
        else if (p >= 60) return "C";
        else if (p >= 50) return "D";
        else return "F";
    }
}