import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Table {
    MyNumber[][] numbers = new MyNumber[5][5];

    public static LinkedList<Table> readTables(String filePath) {
        LinkedList<Table> tables = new LinkedList<>();
        try {
            Scanner scan = new Scanner(new File(filePath));
            scan.nextLine(); scan.nextLine();

            while (scan.hasNextLine()) {
                String s = "";
                for (int i = 0; i < 5; i++) {
                    s += scan.nextLine() + " ";
                }
                tables.add(new Table(s));
                if (scan.hasNext()) scan.nextLine();
            }
            return tables;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Table(String s) {
        Scanner scan = new Scanner(s);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int value = scan.nextInt();
                numbers[i][j] = new MyNumber(value, false);
            }
        }
        scan.close();
    }

    public void signNumber(int extractedNumber) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (numbers[i][j].getN() == extractedNumber) {
                    numbers[i][j].setB(true);
                }
            }
        }
    }

    public boolean checkTable() {
        boolean win = false;

        // check row
        for (int i = 0; i < 5; i++) {
            boolean keepGoing = true;
            for (int j = 0; j < 5 && keepGoing; j++) {
                keepGoing = numbers[i][j].getB();
            }
            if (keepGoing) {
                win = true;
                break;
            }
        }

        if (!win) {
            // check columns
            for (int i = 0; i < 5; i++) {
                boolean keepGoing = true;
                for (int j = 0; j < 5 && keepGoing; j++) {
                    keepGoing = numbers[j][i].getB();
                }
                if (keepGoing) {
                    win = true;
                    break;
                }
            }
        }

        return win;
    }

    public int sumUnsigned() {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!numbers[i][j].getB()) {
                    sum += numbers[i][j].getN();
                }
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                string += numbers[i][j] + " ";
            }
            string += "\n";
        }
        return string;
    }
    
}
