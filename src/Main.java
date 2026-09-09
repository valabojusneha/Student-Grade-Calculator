import java.util.*;
import java.io.*;

public class Main {

    // =====================================================
    // ARRAYLIST
    // =====================================================

    static ArrayList<Student> students =
            new ArrayList<>();


    // =====================================================
    // MAIN
    // =====================================================

    public static void main(String[] args) {

        load();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println(
                    "\n======================================="
            );

            System.out.println(
                    "     STUDENT GRADE CALCULATOR SYSTEM"
            );

            System.out.println(
                    "======================================="
            );

            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Rank List");
            System.out.println("6. Topper");
            System.out.println("7. Copy Student");
            System.out.println("8. Exit");

            System.out.print("\nEnter Choice: ");

            int ch = sc.nextInt();


            switch (ch) {

                case 1 -> add(sc);

                case 2 -> view();

                case 3 -> search(sc);

                case 4 -> delete(sc);

                case 5 -> rank();

                case 6 -> topper();

                case 7 -> copyStudent(sc);

                case 8 -> {

                    save();

                    System.out.println(
                            "\nThank you for using Student Grade Calculator!"
                    );

                    sc.close();

                    return;
                }

                default ->
                        System.out.println(
                                "Invalid Choice!"
                        );
            }
        }
    }


    // =====================================================
    // ADD STUDENT
    // =====================================================

    static void add(Scanner sc) {

        sc.nextLine();


        // =================================================
        // ID
        // =================================================

        System.out.print("Enter ID: ");

        String id = sc.nextLine().trim();


        // =================================================
        // DUPLICATE ID CHECK
        // =================================================

        for (Student s : students) {

            if (s.getId().equalsIgnoreCase(id)) {

                System.out.println(
                        "\nCheck Back!,tudent ID already exists!"
                );

                System.out.println(
                        "Please enter a different ID."
                );

                return;
            }
        }


        // =================================================
        // NAME
        // =================================================

        System.out.print("Enter Name: ");

        String name = sc.nextLine().trim();


        // =================================================
        // DUPLICATE NAME CHECK
        // =================================================

        for (Student s : students) {

            if (s.getName().equalsIgnoreCase(name)) {

                System.out.println(
                        "\nCheck Back!,Student name already exists!"
                );

                System.out.println(
                        "A student with this name is already registered."
                );

                return;
            }
        }


        // =================================================
        // NUMBER OF SUBJECTS
        // =================================================

        System.out.print(
                "Enter Number of Subjects: "
        );

        int n = sc.nextInt();


        if (n <= 0) {

            System.out.println(
                    "\n❌ Number of subjects must be greater than 0."
            );

            return;
        }


        if (n > 10) {

            System.out.println(
                    "\n❌ Maximum 10 subjects are allowed."
            );

            return;
        }


        String[] subjects =
                new String[n];

        int[] marks =
                new int[n];


        // =================================================
        // SUBJECT INPUT
        // =================================================

        for (int i = 0; i < n; i++) {

            sc.nextLine();


            System.out.print(
                    "Subject " +
                    (i + 1) +
                    " Name: "
            );

            subjects[i] =
                    sc.nextLine().trim();


            // =============================================
            // DUPLICATE SUBJECT CHECK
            // =============================================

            for (int j = 0; j < i; j++) {

                if (
                        subjects[i]
                                .equalsIgnoreCase(
                                        subjects[j]
                                )
                ) {

                    System.out.println(
                            "\nCheck Back!❌ Duplicate subject name!"
                    );

                    System.out.println(
                            "You already entered " +
                            subjects[i]
                    );

                    return;
                }
            }


            // =============================================
            // MARKS
            // =============================================

            System.out.print(
                    "Marks in " +
                    subjects[i] +
                    ": "
            );

            marks[i] =
                    sc.nextInt();


            // =============================================
            // MARK VALIDATION
            // =============================================

            if (marks[i] < 0 ||
                    marks[i] > 100) {

                System.out.println(
                        "\n❌ Invalid marks!"
                );

                System.out.println(
                        "Marks must be between 0 and 100."
                );

                return;
            }
        }


        // =================================================
        // GRADE CALCULATOR
        // =================================================

        GradeCalculator calculator =
                new GradeCalculator();


        double percentage =
                calculator.calculatePercentage(
                        marks
                );


        String grade =
                calculator.calculateGrade(
                        percentage
                );


        String result =
                calculator.calculateResult(
                        marks
                );


        int total =
                calculator.calculateTotal(
                        marks
                );


        // =================================================
        // CREATE STUDENT
        // =================================================

        Student student =
                new Student(
                        id,
                        name,
                        subjects,
                        marks,
                        percentage,
                        grade
                );


        students.add(student);


        save();


        // =================================================
        // DISPLAY RESULT IMMEDIATELY
        // =================================================

        System.out.println(
                "\n================================"
        );

        System.out.println(
                "       STUDENT RESULT"
        );

        System.out.println(
                "================================"
        );

        System.out.println(
                "ID          : " +
                id
        );

        System.out.println(
                "Name        : " +
                name
        );


        System.out.println(
                "\nSUBJECT DETAILS"
        );


        for (int i = 0; i < n; i++) {

            String subjectResult;

            if (
                    calculator.isSubjectPassed(
                            marks[i]
                    )
            ) {

                subjectResult = "PASS";

            } else {

                subjectResult = "FAIL";
            }


            System.out.println(
                    subjects[i] +
                    " -> " +
                    marks[i] +
                    " -> " +
                    subjectResult
            );
        }


        System.out.println(
                "\nTotal Marks : " +
                total
        );

        System.out.println(
                "Percentage  : " +
                String.format(
                        "%.2f",
                        percentage
                ) +
                "%"
        );

        System.out.println(
                "Grade       : " +
                grade
        );

        System.out.println(
                "Result      : " +
                result
        );


        System.out.println(
                "\nStudent Added Successfully!"
        );
    }


    // =====================================================
    // VIEW
    // =====================================================

    static void view() {

        if (students.isEmpty()) {

            System.out.println(
                    "\nNo Students Available!"
            );

            return;
        }


        for (Student s : students) {

            show(s);
        }
    }


    // =====================================================
    // SEARCH
    // =====================================================

    static void search(Scanner sc) {

        sc.nextLine();

        System.out.print(
                "Enter ID: "
        );

        String id =
                sc.nextLine().trim();


        for (Student s : students) {

            if (
                    s.getId()
                            .equalsIgnoreCase(id)
            ) {

                show(s);

                return;
            }
        }


        System.out.println(
                "\n❌ Student Not Found!"
        );
    }


    // =====================================================
    // DELETE
    // =====================================================

    static void delete(Scanner sc) {

        sc.nextLine();

        System.out.print(
                "Enter ID: "
        );

        String id =
                sc.nextLine().trim();


        boolean removed =
                students.removeIf(
                        s ->
                                s.getId()
                                        .equalsIgnoreCase(id)
                );


        if (removed) {

            save();

            System.out.println(
                    "\nStudent Deleted Successfully!"
            );

        } else {

            System.out.println(
                    "\n❌ Student Not Found!"
            );
        }
    }


    // =====================================================
    // RANK LIST
    // =====================================================

    static void rank() {

        if (students.isEmpty()) {

            System.out.println(
                    "\nNo Students Available!"
            );

            return;
        }


        students.sort(
                (a, b) ->
                        Double.compare(
                                b.getPercentage(),
                                a.getPercentage()
                        )
        );


        System.out.println(
                "\n========================================="
        );

        System.out.println(
                "              RANK LIST"
        );

        System.out.println(
                "========================================="
        );


        int rank = 1;


        for (Student s : students) {

            System.out.println(
                    rank++ +
                    ". " +
                    s.getName() +
                    " - " +
                    String.format(
                            "%.2f",
                            s.getPercentage()
                    ) +
                    "%"
            );
        }
    }


    // =====================================================
    // TOPPER
    // =====================================================

    static void topper() {

        if (students.isEmpty()) {

            System.out.println(
                    "\nNo Students Available!"
            );

            return;
        }


        Student top =
                Collections.max(
                        students,
                        Comparator.comparing(
                                Student::getPercentage
                        )
                );


        System.out.println(
                "\n================================"
        );

        System.out.println(
                "             TOPPER"
        );

        System.out.println(
                "================================"
        );


        System.out.println(
                "ID         : " +
                top.getId()
        );

        System.out.println(
                "Name       : " +
                top.getName()
        );

        System.out.println(
                "Percentage : " +
                String.format(
                        "%.2f",
                        top.getPercentage()
                ) +
                "%"
        );

        System.out.println(
                "Grade      : " +
                top.getGrade()
        );
    }


    // =====================================================
    // SHOW STUDENT
    // =====================================================

    static void show(Student s) {

        GradeCalculator calculator =
                new GradeCalculator();


        int[] marks =
                s.getMarks();


        String result =
                calculator.calculateResult(
                        marks
                );


        int total =
                calculator.calculateTotal(
                        marks
                );


        System.out.println(
                "\n================================"
        );

        System.out.println(
                "        STUDENT REPORT"
        );

        System.out.println(
                "================================"
        );


        System.out.println(
                "ID          : " +
                s.getId()
        );

        System.out.println(
                "Name        : " +
                s.getName()
        );


        System.out.println(
                "\nSUBJECT DETAILS"
        );


        String[] subjects =
                s.getSubjects();


        for (int i = 0;
             i < subjects.length;
             i++) {


            String subjectResult;


            if (
                    calculator.isSubjectPassed(
                            marks[i]
                    )
            ) {

                subjectResult = "PASS";

            } else {

                subjectResult = "FAIL";
            }


            System.out.println(
                    subjects[i] +
                    " -> " +
                    marks[i] +
                    " -> " +
                    subjectResult
            );
        }


        System.out.println(
                "\nTotal Marks : " +
                total
        );


        System.out.println(
                "Percentage  : " +
                String.format(
                        "%.2f",
                        s.getPercentage()
                ) +
                "%"
        );


        System.out.println(
                "Grade       : " +
                s.getGrade()
        );


        System.out.println(
                "Result      : " +
                result
        );
    }


    // =====================================================
    // COPY STUDENT
    // =====================================================

    static void copyStudent(Scanner sc) {

        sc.nextLine();

        System.out.print(
                "Enter Student ID to Copy: "
        );

        String id =
                sc.nextLine().trim();


        for (Student s : students) {

            if (
                    s.getId()
                            .equalsIgnoreCase(id)
            ) {


                Student copy =
                        new Student(s);


                String newId =
                        copy.getId() +
                        "_COPY";


                // =========================================
                // Make sure copied ID doesn't exist
                // =========================================

                for (Student existing : students) {

                    if (
                            existing.getId()
                                    .equalsIgnoreCase(
                                            newId
                                    )
                    ) {

                        System.out.println(
                                "\n❌ Copy already exists!"
                        );

                        return;
                    }
                }


                copy.setId(newId);


                students.add(copy);

                save();


                System.out.println(
                        "\nStudent Copied Successfully!"
                );


                show(copy);

                return;
            }
        }


        System.out.println(
                "\n❌ Student Not Found!"
        );
    }


    // =====================================================
    // SAVE
    // =====================================================

    static void save() {

        try (
                BufferedWriter bw =
                        new BufferedWriter(
                                new FileWriter(
                                        "students.txt"
                                )
                        )
        ) {


            for (Student s : students) {

                bw.write(
                        s.getId() +
                        "|" +
                        s.getName() +
                        "|" +
                        String.join(
                                "-",
                                s.getSubjects()
                        ) +
                        "|" +
                        joinMarks(
                                s.getMarks()
                        ) +
                        "|" +
                        s.getPercentage() +
                        "|" +
                        s.getGrade()
                );


                bw.newLine();
            }


        } catch (IOException e) {

            System.out.println(
                    "Save Error: " +
                    e.getMessage()
            );
        }
    }


    // =====================================================
    // JOIN MARKS
    // =====================================================

    static String joinMarks(int[] marks) {

        StringBuilder sb =
                new StringBuilder();


        for (int i = 0;
             i < marks.length;
             i++) {

            sb.append(marks[i]);


            if (
                    i < marks.length - 1
            ) {

                sb.append("-");
            }
        }


        return sb.toString();
    }


    // =====================================================
    // LOAD
    // =====================================================

    static void load() {

        File file =
                new File("students.txt");


        if (!file.exists()) {

            return;
        }


        try (
                BufferedReader br =
                        new BufferedReader(
                                new FileReader(file)
                        )
        ) {


            String line;


            while (
                    (line = br.readLine()) != null
            ) {


                String[] parts =
                        line.split("\\|");


                if (parts.length < 6) {

                    continue;
                }


                String[] subjects =
                        parts[2].split("-");


                String[] markStrings =
                        parts[3].split("-");


                int[] marks =
                        new int[markStrings.length];


                for (
                        int i = 0;
                        i < markStrings.length;
                        i++
                ) {

                    marks[i] =
                            Integer.parseInt(
                                    markStrings[i]
                            );
                }


                Student student =
                        new Student(
                                parts[0],
                                parts[1],
                                subjects,
                                marks,
                                Double.parseDouble(
                                        parts[4]
                                ),
                                parts[5]
                        );


                students.add(student);
            }


        } catch (Exception e) {

            System.out.println(
                    "Load Error: " +
                    e.getMessage()
            );
        }
    }
}