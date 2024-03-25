public class Gradebook {
    private int[] studentGrades;
    public Gradebook(int arraySize) {
        studentGrades = new int[arraySize];
    }

    public void updateGrade(int id, int newGrade) {
        studentGrades[id] = newGrade;
    }

    public double calculateAverage() {
        double sum = 0.0;
        double counter = 0.0;
        for (int element : studentGrades) {
            sum += element;
            counter++;
        }
        return (double) (sum) / (double) (counter);
    }

    public int calculateMax() {
        int currentMax = -99;
        for (int grade : studentGrades) {
            if (grade > currentMax) {
                currentMax = grade;
            }
        }
        return currentMax;
    }

    public void applyCurve() {
        int highestGrade = calculateMax();
        int curve = 100 - highestGrade;
        for (int i = 0; i < studentGrades.length; i++) {
            studentGrades[i] += curve;
        }
    }

    public char[] assignLetterGrade() {
        char[] letterGrades = new char[studentGrades.length];
        for (int i = 0; i < letterGrades.length; i++) {
            if (studentGrades[i] >= 90 && studentGrades[i] <= 100) {
                letterGrades[i] = 'A';
            } else if (studentGrades[i] >= 80 && studentGrades[i] < 90) {
                letterGrades[i] = 'B';
            } else if (studentGrades[i] >= 70 && studentGrades[i] < 80) {
                letterGrades[i] = 'C';
            } else if (studentGrades[i] >= 60 && studentGrades[i] < 70) {
                letterGrades[i] = 'D';
            } else {
                letterGrades[i] = 'F';
            }
        }
        return letterGrades;
    }
}