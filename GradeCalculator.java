import java.util.Scanner;

public class GradeCalculator{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the marks obtained in each subject (out of 100): ");
        String[] subjectNames = {"Telugu", "Hindi", "English", "Maths", "Science","Social"};
        int[] marks = new int[subjectNames.length];
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Enter marks for " + subjectNames[i] + ": ");
            marks[i] = sc.nextInt();
            }
        int totalMarks = 0;
        for (int mark : marks)
        {
            totalMarks += mark;
        }
        double averagePercentage = (double) totalMarks / marks.length;
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        }
        else if (averagePercentage >= 80) 
        {
            grade = "B";
        } 
        else if (averagePercentage >= 70) 
        {
            grade = "C";
        } 
        else if (averagePercentage >= 60)
        {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("Student Grade Calculator with Subject Names\n");
        System.out.println("Subject\t\tMarks");
        for (int i = 0; i < subjectNames.length; i++) {
            System.out.println(subjectNames[i] + "\t\t" + marks[i]);
        }
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);
    }
}