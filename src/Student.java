public class Student {

    String id;
    String name;
    String[] subjects;
    int[] marks;
    double percentage;
    String grade;

    public Student(String id, String name,
                   String[] subjects,
                   int[] marks,
                   double percentage,
                   String grade) {

        this.id = id;
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
        this.percentage = percentage;
        this.grade = grade;
    }
}