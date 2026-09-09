/* public class Student {

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
}*/




public class Student extends Person {

    // ==========================================
    // ENCAPSULATION
    // ==========================================
    // Private fields cannot be accessed directly
    // from Main.java.
    
    private String id;
    private String[] subjects;
    private int[] marks;
    private double percentage;
    private String grade;


    // ==========================================
    // CONSTRUCTOR
    // ==========================================
    
    public Student(
            String id,
            String name,
            String[] subjects,
            int[] marks,
            double percentage,
            String grade) {

        // Call parent class constructor
        super(name);

        this.id = id;
        this.subjects = subjects;
        this.marks = marks;
        this.percentage = percentage;
        this.grade = grade;
    }


    // ==========================================
    // COPY CONSTRUCTOR
    // ==========================================
    // Creates a new Student using an existing Student.
    
    public Student(Student other) {

        super(other.getName());

        this.id = other.id;

        // clone() creates separate arrays
        this.subjects = other.subjects.clone();
        this.marks = other.marks.clone();

        this.percentage = other.percentage;
        this.grade = other.grade;
    }


    // ==========================================
    // GETTERS
    // ==========================================

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public int[] getMarks() {
        return marks;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getGrade() {
        return grade;
    }


    // ==========================================
    // SETTERS
    // ==========================================

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    // ==========================================
    // METHOD OVERRIDING
    // ==========================================
    // Person has displayDetails().
    // Student provides its own implementation.
    
    @Override
    public void displayDetails() {

        System.out.println(
                "Student: " +
                id +
                " - " +
                name
        );
    }
}