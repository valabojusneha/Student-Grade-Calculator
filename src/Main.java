import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        load();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n==============================");
            System.out.println(" STUDENT MANAGEMENT SYSTEM ");
            System.out.println("==============================");

            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Rank List");
            System.out.println("6. Topper");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1 -> add(sc);
                case 2 -> view();
                case 3 -> search(sc);
                case 4 -> delete(sc);
                case 5 -> rank();
                case 6 -> topper();
                case 7 -> {
                    save();
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }

    // ================= ADD =================
    static void add(Scanner sc) {

        sc.nextLine();

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Number of Subjects: ");
        int n = sc.nextInt();

        String[] sub = new String[n];
        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {

            sc.nextLine();

            System.out.print("Subject: ");
            sub[i] = sc.nextLine();

            System.out.print("Marks: ");
            marks[i] = sc.nextInt();
        }

        double per = GradeCalculator.percentage(marks);
        String gr = GradeCalculator.grade(per);

        students.add(new Student(id, name, sub, marks, per, gr));

        save();

        System.out.println("Student Added Successfully!");
    }

    // ================= VIEW =================
    static void view() {

        for (Student s : students)
            show(s);
    }

    // ================= SEARCH =================
    static void search(Scanner sc) {

        sc.nextLine();

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        for (Student s : students) {

            if (s.id.equals(id)) {
                show(s);
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // ================= DELETE =================
    static void delete(Scanner sc) {

        sc.nextLine();

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        students.removeIf(s -> s.id.equals(id));

        save();

        System.out.println("Deleted Successfully!");
    }

    // ================= RANK LIST =================
    static void rank() {

        students.sort((a, b) ->
                Double.compare(b.percentage, a.percentage));

        int r = 1;

        System.out.println("\n===== RANK LIST =====");

        for (Student s : students) {

            System.out.println(
                    r++ + ". " +
                    s.name +
                    " - " +
                    String.format("%.2f", s.percentage));
        }
    }

    // ================= TOPPER =================
    static void topper() {

        if (students.isEmpty()) return;

        Student top = Collections.max(
                students,
                Comparator.comparing(s -> s.percentage));

        System.out.println("\n===== TOPPER =====");
        System.out.println("ID: " + top.id);
        System.out.println("Name: " + top.name);
        System.out.println("Percentage: " +
                String.format("%.2f", top.percentage));
    }

    // ================= SHOW =================
    static void show(Student s) {

        System.out.println("\n----------------------");
        System.out.println("ID: " + s.id);
        System.out.println("Name: " + s.name);

        System.out.println("Subjects:");

        for (int i = 0; i < s.subjects.length; i++) {

            System.out.println(
                    s.subjects[i] + " -> " + s.marks[i]);
        }

        System.out.println("Percentage: " +
                String.format("%.2f", s.percentage));

        System.out.println("Grade: " + s.grade);
    }

    // ================= SAVE =================
    static void save() {

        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter("students.txt"))) {

            for (Student s : students) {

                bw.write(
                        s.id + "|" +
                        s.name + "|" +
                        String.join("-", s.subjects) + "|" +
                        joinMarks(s.marks) + "|" +
                        s.percentage + "|" +
                        s.grade
                );

                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println("Save Error");
        }
    }

    static String joinMarks(int[] marks) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < marks.length; i++) {

            sb.append(marks[i]);

            if (i < marks.length - 1)
                sb.append("-");
        }

        return sb.toString();
    }

    // ================= LOAD =================
    static void load() {

        File file = new File("students.txt");

        if (!file.exists()) return;

        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] p = line.split("\\|");

                String[] sub = p[2].split("-");
                String[] mStr = p[3].split("-");

                int[] marks = new int[mStr.length];

                for (int i = 0; i < mStr.length; i++) {
                    marks[i] = Integer.parseInt(mStr[i]);
                }

                students.add(new Student(
                        p[0],
                        p[1],
                        sub,
                        marks,
                        Double.parseDouble(p[4]),
                        p[5]
                ));
            }

        } catch (Exception e) {
            System.out.println("Load Error");
        }
    }
}