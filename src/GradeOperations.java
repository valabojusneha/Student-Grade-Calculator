// ==========================================
// INTERFACE
// ==========================================
// Interface defines what operations a grade
// calculator must provide.

public interface GradeOperations {

    double calculatePercentage(int[] marks);

    String calculateGrade(double percentage);
}