package Swapnil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Student Placement App");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("\n====== MENU ======");
            System.out.println("Press 1 to ADD a Student");
            System.out.println("Press 2 to DELETE a Student");
            System.out.println("Press 3 to DISPLAY Students");
            System.out.println("Press 4 to EXIT App");
            System.out.print("Enter your choice: ");

            int c = Integer.parseInt(br.readLine());

            if (c == 1) {
                // Add student
                System.out.println("Enter student name:");
                String name = br.readLine();

                System.out.println("Enter student phone:");
                String phone = br.readLine();

                System.out.println("Enter student city:");
                String city = br.readLine();

                Student st = new Student(name, phone, city);

                boolean answer = StudentDao.insertStudentToDB(st);

                if (answer) {
                    System.out.println("✅ Student added successfully!");
                } else {
                    System.out.println("❌ Something went wrong. Try again.");
                }

            } else if (c == 2) {
                // Delete student
                System.out.println("Enter student ID to delete:");
                int userId = Integer.parseInt(br.readLine());

                boolean answer = StudentDao.deleteStudent(userId);

                if (answer) {
                    System.out.println("✅ Student deleted successfully.");
                } else {
                    System.out.println("❌ Error deleting student.");
                }

            } else if (c == 3) {
                // Display students
                StudentDao.showAllStudents();

            } else if (c == 4) {
                // Exit
                System.out.println("👋 Thanks for using the Student Placement App!");
                break;

            } else {
                System.out.println("⚠️ Invalid choice. Please try again.");
            }
        }
    }
}
