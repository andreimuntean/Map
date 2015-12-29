import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

// java GradesTestGenerator grades.txt 100
public class GradesTestGenerator
{
    private static String getRandomString()
    {
        Random random = new Random();
        String letters = "abcdef";
        int letterCount = 1 + random.nextInt(5);
        StringBuilder randomString = new StringBuilder(letterCount);

        for (int letterIndex = 0; letterIndex < letterCount; ++letterIndex)
        {
            char letter = letters.charAt(random.nextInt(letters.length()));

            randomString.append(letter);
        }

        return randomString.toString();
    }

    private static int getRandomGrade()
    {
        Random random = new Random();

        return 1 + random.nextInt(10);
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        String path = args[0];
        int count = Integer.parseInt(args[1]);

        try (PrintWriter writer = new PrintWriter(new File(path)))
        {
            while (count-- > 0)
            {
                String name = getRandomString();
                int grade = getRandomGrade();

                writer.print(grade + " " + name);

                if (count > 0)
                {
                    writer.println();
                }
            }
        }
    }
}