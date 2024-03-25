import java.util.Random;
public class GradebookDriver {
    public static void main(String[] args) {
        Random random = new Random();

        //constructor
        Gradebook testGrades = new Gradebook(10);

        for (int i = 0; i < 10; i++) {
            testGrades.updateGrade(i, random.nextInt(99) + 1);
        }

        //update grade
        testGrades.updateGrade(0, random.nextInt(99) + 1);

        //calculate average
        System.out.println("Average: " + testGrades.calculateAverage());

        //calculate max
        System.out.println("Max: " + testGrades.calculateMax());

        //apply curve
        testGrades.applyCurve();

        //calculate max after curve, should be 100;
        System.out.println("New Max: " + testGrades.calculateMax());

        //assign letter grades
        char[] letterGrades = testGrades.assignLetterGrade();
        for (char grade : letterGrades) {
            System.out.print(grade + " ");
        }
        System.out.println();

    }
}