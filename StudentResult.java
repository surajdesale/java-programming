import java.util.*;

class Student {
    String name;
    int[] marks;
    int total;
    double average;
    char grade;

    void calculate() {
        total = 0;
        for (int i = 0; i < marks.length; i++) {
            total += marks[i];
        }

        average = total / marks.length;

        if (average >= 90)
            grade = 'A';
        else if (average >= 75)
            grade = 'B';
        else if (average >= 60)
            grade = 'C';
        else if (average >= 40)
            grade = 'D';
        else
            grade = 'F';
    }
}

public class StudentResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        System.out.print("Enter number of subjects: ");
        int s = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            students[i] = new Student();

            sc.nextLine();
            System.out.print("\nEnter name: ");
            students[i].name = sc.nextLine();

            students[i].marks = new int[s];

            for (int j = 0; j < s; j++) {
                System.out.print("Enter marks of Subject " + (j + 1) + ": ");
                students[i].marks[j] = sc.nextInt();
            }

            students[i].calculate();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (students[j].average > students[i].average) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }

        System.out.println("\nRank\tName\tTotal\tAverage\tGrade");

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t" +
                    students[i].name + "\t" +
                    students[i].total + "\t" +
                    students[i].average + "\t" +
                    students[i].grade);
        }

    }
}