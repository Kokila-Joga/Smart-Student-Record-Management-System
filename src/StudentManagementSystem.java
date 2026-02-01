import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<Student>();
    static Scanner sc = new Scanner(System.in);

    static final String FACULTY_USER = "faculty";
    static final String FACULTY_PASS = "faculty123";

    static final String STUDENT_USER = "student";
    static final String STUDENT_PASS = "student123";

    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Student ID already exists");
                return;
            }
        }

        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, age, course, marks));
        System.out.println("Student added successfully");
    }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    public static void searchStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                s.display();
                return;
            }
        }

        System.out.println("Student not found");
    }

    public static void updateStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                sc.nextLine();

                System.out.print("Enter New Name: ");
                s.setName(sc.nextLine());

                System.out.print("Enter New Age: ");
                s.setAge(sc.nextInt());

                sc.nextLine();
                System.out.print("Enter New Course: ");
                s.setCourse(sc.nextLine());

                System.out.print("Enter New Marks: ");
                s.setMarks(sc.nextDouble());

                System.out.println("Student updated successfully");
                return;
            }
        }

        System.out.println("Student not found");
    }

    public static void deleteStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student deleted successfully");
                return;
            }
        }

        System.out.println("Student not found");
    }

    public static void facultyMenu() {
        while (true) {
            System.out.println("\nFaculty Menu");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Logout");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: return;
                default: System.out.println("Invalid choice");
            }
        }
    }

    public static void studentMenu() {
        while (true) {
            System.out.println("\nStudent Menu");
            System.out.println("1. View Students");
            System.out.println("2. Search Student");
            System.out.println("3. Logout");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: viewStudents(); break;
                case 2: searchStudent(); break;
                case 3: return;
                default: System.out.println("Invalid choice");
            }
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nLogin");
            System.out.print("Username: ");
            String user = sc.next();
            System.out.print("Password: ");
            String pass = sc.next();

            if (user.equals(FACULTY_USER) && pass.equals(FACULTY_PASS)) {
                System.out.println("Faculty login successful");
                facultyMenu();
            } 
            else if (user.equals(STUDENT_USER) && pass.equals(STUDENT_PASS)) {
                System.out.println("Student login successful");
                studentMenu();
            } 
            else {
                System.out.println("Invalid credentials");
            }
        }
    }
}
