import java.util.LinkedList;

public class Es2 {
    public static void main(String[] args) {
        boolean readFromSample = false;
        String filePath = readFromSample ? "sample.txt" : "numberDay4.txt";

        ExtractedNumbers ex = new ExtractedNumbers(ExtractedNumbers.readExtractedNumbers(filePath));
        LinkedList<Table> tables = Table.readTables(filePath);

        int remainingTables = tables.size();
        int i;
        boolean quit = false;
        for (i = 0; i < ex.extractedNumbers.size(); i++) {
            for (int j = 0; j < tables.size(); j++) {
                tables.get(j).signNumber(ex.extractedNumbers.get(i));
                if (tables.get(j).checkTable()) {
                    if (remainingTables > 1) {
                        remainingTables--;
                        tables.remove(j);
                        j--;
                    } else {
                        quit = true;
                        break;
                    }
                }
            }
            if (quit) break;
        }


        int sumUnsigned = tables.get(0).sumUnsigned();
        int result = sumUnsigned * ex.extractedNumbers.get(i);
        System.out.println(result);
    }

}
