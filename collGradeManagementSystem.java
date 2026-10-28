import java.util.*;

class college{
    String name;
    int rollNo;
    int[] marks;
    int total;
    double average;
    String grade;

    college(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        calculateResult();
    }

    void calculateResult() {
        total = 0;
        for (int mark : marks) {
            total += mark;
        }

        average = (double) total / marks.length;

        if (average >= 90)
            grade = "A+";
        else if (average >= 80)
            grade = "A";
        else if (average >= 70)
            grade = "B";
        else if (average >= 60)
            grade = "C";
        else if (average >= 50)
            grade = "D";
        else
            grade = "F";
    }

    void display() {
        System.out.println("--------------------------------");
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Total   : " + total);
        System.out.println("Average : " + average);
        System.out.println("Grade   : " + grade);
    }
}

public class collGradeManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            sc.nextLine();

            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Roll No: ");
            int roll = sc.nextInt();

            int[] marks = new int[subjects];

            for (int j = 0; j < subjects; j++) {
                System.out.print("Enter marks of Subject " + (j + 1) + ": ");
                marks[j] = sc.nextInt();
            }

            students[i] = new Student(name, roll, marks);
        }

        // Ranking based on average marks
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (students[j].average > students[i].average) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }

        System.out.println("\n===== STUDENT RANK LIST =====");

        for (int i = 0; i < n; i++) {
            System.out.println("\nRank " + (i + 1));
            students[i].display();
        }

        sc.close();
    }
}