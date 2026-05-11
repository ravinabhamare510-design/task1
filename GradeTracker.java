
import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        // Handle invalid input
        if (n <= 0) {
            System.out.println("No students entered.");
            sc.close();
            return;
        }

        // Input student data
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Marks: ");
            float marks = sc.nextFloat();
            sc.nextLine(); // clear buffer

            students.add(new Student(name, marks));
        }

        // Initialize values
        float total = 0;
        float highest = students.get(0).marks;
        float lowest = students.get(0).marks;

        // Calculate total, highest, lowest
        for (Student s : students) {
            total += s.marks;

            if (s.marks > highest) {
                highest = s.marks;
            }

            if (s.marks < lowest) {
                lowest = s.marks;
            }
        }

        float average = total / n;

        // Display result
        System.out.println("\n--- Student Report ---");
        System.out.println("Name\tMarks\tGrade");

              for (Student s : students) {
            System.out.println(s.name + "\t" + s.marks + "\t" + s.grade);
        }

        System.out.println("\nAverage Marks: " + average);
        System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);

        sc.close();
    }
}

// Student class
class Student {
    String name;
    float marks;
    char grade;

    // Constructor
    Student(String name, float marks) {
        this.name = name;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    // Grade calculation method
    char calculateGrade(float marks) {
        if (marks >= 90)
            return 'A';
        else if (marks >= 75)
            return 'B';
        else if (marks >= 60)
            return 'C';
        else if (marks >= 40)
            return 'D';
        else
            return 'F';
    }
}



