import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class ccwc {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java WordCount <option> <filename>");
            System.out.println("Options: -c (count bytes), -l (count lines), -m (count characters), -w (count words)");
            return;
        }

        String option = args[0];
        String filename = args[1];

        switch (option) {
            case "-c":
                countBytes(filename);
                break;
            case "-l":
                countLines(filename);
                break;
            case "-m":
                countCharacters(filename);
                break;
            case "-w":
                countWords(filename);
                break;
            default:
                System.out.println("Invalid option. Please use one of: -c, -l, -m, -w");
                break;
        }
    }

    public static void countBytes(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int byteCount = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                byteCount += line.getBytes().length;
            }

            bufferedReader.close();

            System.out.println("Byte count: " + byteCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void countLines(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int lineCount = 0;
            while (bufferedReader.readLine() != null) {
                lineCount++;
            }

            bufferedReader.close();

            System.out.println("Line count: " + lineCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void countCharacters(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int charCount = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                charCount += line.length();
            }

            bufferedReader.close();

            System.out.println("Character count: " + charCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void countWords(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int wordCount = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            bufferedReader.close();

            System.out.println("Word count: " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "ccwc []";
    }
}