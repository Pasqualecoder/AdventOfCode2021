import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import static java.lang.Math.pow;

public class Es1 {

    public static void main(String[] args) {
        LinkedList<String> binaries = readFile();
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        int length = binaries.get(0).length();

        for (int i = 0; i < length; i++) {
            int zeros = 0, ones = 0;
            for (int j = 0; j < binaries.size(); j++) {
                if (binaries.get(j).charAt(i) == '0')
                    zeros++;
                else
                    ones++;
            }

            if (zeros > ones) {
                gamma.append("0");
                epsilon.append("1");
            } else {
                gamma.append("1");
                epsilon.append("0");
            }
        }
        
        System.out.println(binToDecimal(gamma.toString()) * binToDecimal(epsilon.toString()));
    }

    public static LinkedList<String> readFile() {
        LinkedList<String> binaries = new LinkedList<>();
        try {
            boolean readFromSample = false;
            String filePath = readFromSample ? "sample.txt" : "numberDay3.txt";

            File input = new File(filePath);
            Scanner scan = new Scanner(input);
            while (scan.hasNext()) {
                binaries.add(scan.nextLine());
            }

            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return binaries;
    }

    public static int binToDecimal(String bin) {
        int dec = 0;
        int exp = 0;
        for (int i = bin.length() - 1; i >= 0; i--) {
            dec += Integer.parseInt(String.valueOf(bin.charAt(i))) * pow(2, exp);
            exp++;
        }
        return dec;
    }

}
