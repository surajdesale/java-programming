import java.util.*;

class Student {
    String name;
    int rollNo;
    String className;
    String subject;

    int[] cce = new int[5];

    double attendance;
    int attendanceMarks;

    int total;
    double percentage;
    String grade;
}

public class StudentCCEManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        // INPUT
        for (int i = 0; i < n; i++) {

            students[i] = new Student();

            System.out.println("\n========== Student " + (i + 1) + " ==========");

            System.out.print("Enter Name: ");
            students[i].name = sc.nextLine();

            System.out.print("Enter Roll No: ");
            students[i].rollNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Class: ");
            students[i].className = sc.nextLine();

            System.out.print("Enter Subject Name: ");
            students[i].subject = sc.nextLine();

            System.out.println("\nEnter 5 CCE Marks (Each Out of 8)");

            for (int j = 0; j < 5; j++) {
                System.out.print("CCE " + (j + 1) + ": ");
                students[i].cce[j] = sc.nextInt();
            }

            System.out.print("Enter Attendance Percentage: ");
            students[i].attendance = sc.nextDouble();

            // Attendance Marks
            if (students[i].attendance >= 80)
                students[i].attendanceMarks = 2;
            else if (students[i].attendance >= 75)
                students[i].attendanceMarks = 1;
            else
                students[i].attendanceMarks = 0;

            // Total
            students[i].total = students[i].attendanceMarks;

            for (int j = 0; j < 5; j++) {
                students[i].total += students[i].cce[j];
            }

            // Percentage
            students[i].percentage = (students[i].total * 100.0) / 42;

            // Grade
            if (students[i].percentage >= 90)
                students[i].grade = "A+";
            else if (students[i].percentage >= 80)
                students[i].grade = "A";
            else if (students[i].percentage >= 70)
                students[i].grade = "B";
            else if (students[i].percentage >= 60)
                students[i].grade = "C";
            else if (students[i].percentage >= 50)
                students[i].grade = "D";
            else
                students[i].grade = "F";

            sc.nextLine();
        }

        // Ranking
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (students[j].total > students[i].total) {

                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }

        // Rank List
        System.out.println("\n==================== STUDENT RANK LIST ====================");

        System.out.printf("%-5s %-8s %-15s %-12s %-12s %-8s %-10s %-8s\n",
                "Rank", "Roll", "Name", "Class", "Subject", "Total", "Grade", "Att");

        System.out.println("-------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {

            System.out.printf("%-5d %-8d %-15s %-12s %-12s %-8d %-10s %-8d\n",
                    i + 1,
                    students[i].rollNo,
                    students[i].name,
                    students[i].className,
                    students[i].subject,
                    students[i].total,
                    students[i].grade,
                    students[i].attendanceMarks);
        }

        // Topper Details
        System.out.println("\n==================== TOPPER DETAILS ====================");

        Student top = students[0];

        System.out.println("Name              : " + top.name);
        System.out.println("Roll No           : " + top.rollNo);
        System.out.println("Class             : " + top.className);
        System.out.println("Subject           : " + top.subject);

        System.out.println("\nCCE Marks");

        for (int i = 0; i < 5; i++) {
            System.out.println("CCE " + (i + 1) + " : " + top.cce[i]);
        }

        System.out.println("Attendance        : " + top.attendance + "%");
        System.out.println("Attendance Marks  : " + top.attendanceMarks);

        System.out.println("--------------------------------------");
        System.out.println("Total             : " + top.total + " / 42");
        System.out.printf("Percentage        : %.2f%%\n", top.percentage);
        System.out.println("Grade             : " + top.grade);

        sc.close();
    }
}