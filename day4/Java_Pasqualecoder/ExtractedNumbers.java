import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ExtractedNumbers {
    LinkedList<Integer> extractedNumbers = new LinkedList<>();

    public ExtractedNumbers(String s) {
        s = s.replace(',', ' ');
        Scanner scan = new Scanner(s);
        while (scan.hasNextInt()) {
            extractedNumbers.add(scan.nextInt());
        }
        scan.close();
    }

    public static String readExtractedNumbers(String filePath) {
        try {
            Scanner scan = new Scanner(new File(filePath));
            return scan.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    public int getExtractedNumber(int index) {
        return extractedNumbers.get(index);
    }

    @Override
    public String toString() {
        String s = "";
        for (Integer extractedNumber : extractedNumbers) s += extractedNumber + " ";
        return s;
    }
    
}
