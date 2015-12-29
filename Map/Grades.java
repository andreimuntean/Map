import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

// Calculates the average grade of every student.
public class Grades
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String path = args.length > 0 ? args[0] : "grades.txt";
        int bucketCount = args.length > 1 ? Integer.parseInt(args[1]) : 100000;

        // Keeps track of students.
        HashSet<String> students = new HashSet<>();
        Map<String, Integer> gradeSums = new Map<>(bucketCount);
        Map<String, Integer> gradeCounts = new Map<>(bucketCount);
        Scanner input = new Scanner(new File(path));

        while (input.hasNextLine())
        {
            int grade = input.nextInt();
            String student = input.next();

            if (gradeSums.get(student) != null)
            {
                gradeSums.set(student, gradeSums.get(student) + grade);
                gradeCounts.set(student, gradeCounts.get(student) + 1);
            }
            else
            {
                gradeSums.set(student, grade);
                gradeCounts.set(student, 1);
                students.add(student);
            }
        }

        for (String student : students)
        {
            int sum = gradeSums.get(student);
            int count = gradeCounts.get(student);

            System.out.printf("%s: %f%n", student, sum / (double)count);
        }
    }
}