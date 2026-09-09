// ==========================================
// INTERFACE IMPLEMENTATION
// ==========================================

public class GradeCalculator implements GradeOperations {

    // ==========================================
    // CALCULATE TOTAL
    // ==========================================

    public int calculateTotal(int[] marks) {

        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }


    // ==========================================
    // CALCULATE PERCENTAGE
    // ==========================================

    @Override
    public double calculatePercentage(int[] marks) {

        if (marks.length == 0) {
            return 0;
        }

        int total = calculateTotal(marks);

        return (double) total / marks.length;
    }


    // ==========================================
    // CALCULATE GRADE
    // ==========================================

    @Override
    public String calculateGrade(double percentage) {

        if (percentage >= 90) {
            return "A+";
        }

        else if (percentage >= 80) {
            return "A";
        }

        else if (percentage >= 70) {
            return "B";
        }

        else if (percentage >= 60) {
            return "C";
        }

        else if (percentage >= 50) {
            return "D";
        }

        else {
            return "F";
        }
    }


    // ==========================================
    // SUBJECT PASS/FAIL
    // ==========================================

    public boolean isSubjectPassed(int mark) {

        return mark >= 40;
    }


    // ==========================================
    // OVERALL RESULT
    // ==========================================

    public String calculateResult(int[] marks) {

        for (int mark : marks) {

            if (mark < 40) {
                return "FAIL";
            }
        }

        return "PASS";
    }


    // ==========================================
    // METHOD OVERLOADING
    // ==========================================

    public String calculateGrade(int marks) {

        if (marks >= 90) {
            return "A+";
        }

        else if (marks >= 80) {
            return "A";
        }

        else if (marks >= 70) {
            return "B";
        }

        else if (marks >= 60) {
            return "C";
        }

        else if (marks >= 50) {
            return "D";
        }

        else {
            return "F";
        }
    }
}